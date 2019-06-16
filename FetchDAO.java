/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieee.dao;

import com.ieee.pojo.Tweets;
import com.ieee.pojo.UserDetails;
import com.ieee.servlet.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Praveen
 */
public class FetchDAO {

    private static Connection con = null;
    private String fetch_users = "select * from  userdetails where id NOT IN (?)";
    private String fetch_user_det = "select * from  userdetails where id=?";
    private String check_follower = "select * from followers where followerId=? AND followedById=?";
    private String retrive_followerTweets = "SELECT tweetId,tweetMsg,NAME FROM tweets t,followers f,userdetails u WHERE t.tweetedById IN (SELECT f.followerId FROM followers WHERE  f.followedById =? ) AND u.id=f.followerId;";
    private String retrive_reTweets = "SELECT t.tweetId,t.tweetedById,t.tweetMsg,t.tweetDt,r.reTweetMsg,r.reTweetDt,u.name FROM tweets t,retweet r,userdetails u WHERE t.tweetId=? AND t.tweetId=r.tweetId AND u.id=t.tweetedById";
    private String retrive_reTweetsById = "SELECT u.name,r.reTweetMsg,reTweetDt FROM retweet r,userdetails u  WHERE r.tweetId=? AND r.reTweetedById=u.id";
    //private String cluster = "SELECT t.tweetMsg,rt.reTweetMsg FROM tweets t,retweet rt  WHERE  tweetDt BETWEEN ? AND ?;";
    private String cluster = "SELECT t.tweetMsg,rt.reTweetMsg FROM tweets t,retweet rt  WHERE t.tweetMsg LIKE ? OR rt.reTweetMsg LIKE ?  AND tweetDt BETWEEN ? AND ?;";

    static {
        con = DbConnection.getConnections();
    }

    public Set fetchUsers(int userId) {
        Set<UserDetails> set = new LinkedHashSet();
        try {
            PreparedStatement pstmt = con.prepareStatement(fetch_users);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UserDetails ud = new UserDetails();
                ud.setId(rs.getInt(1));
                ud.setName(rs.getString(2));
                ud.setMail(rs.getString(3));
                ud.setMobile(rs.getString(4));
                set.add(ud);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    public UserDetails fetchUserDet(String userId) {
        UserDetails ud = new UserDetails();
        try {
            PreparedStatement pstmt = con.prepareStatement(fetch_user_det);
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                ud.setId(rs.getInt(1));
                ud.setName(rs.getString(2));
                ud.setMail(rs.getString(3));
                ud.setMobile(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ud;
    }

    public String checkFollower(int followerId, int followedById) {
        String flag = "N";
        try {
            PreparedStatement pstmt = con.prepareStatement(check_follower);
            pstmt.setInt(1, followerId);
            pstmt.setInt(2, followedById);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                flag = "Y";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Set retriveFollowerTweets(int userId) {

        Set<Tweets> set = new HashSet();
        try {
            PreparedStatement pstmt = con.prepareStatement(retrive_followerTweets);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Tweets t = new Tweets();
                t.setTweetId(rs.getInt(1));
                t.setMsg(rs.getString(2));
                t.setTweetedBy(rs.getString(3));
                set.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;

    }

    public Set retriveReTweets(int tweetId) {

        Set<Tweets> set = new HashSet();
        try {
            PreparedStatement pstmt = con.prepareStatement(retrive_reTweetsById);
            pstmt.setInt(1, tweetId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Tweets t = new Tweets();
                t.setTweetedBy(rs.getString(1));
                t.setMsg(rs.getString(2));
                set.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;

    }

    public Map<String, List<String>> fetchTweetsForCluster(String search, String fdt, String tdt) {
        List<String> list_tweet = new ArrayList();
        List<String> list_retweet = new ArrayList();
        Map map = new HashMap();
        try {
            PreparedStatement pstmt = con.prepareStatement(cluster);
            pstmt.setString(1, "%" + search + "%");
            pstmt.setString(2, "%" + search + "%");
            pstmt.setString(3, fdt);
            pstmt.setString(4, tdt);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list_tweet.add(rs.getString(1));
                list_retweet.add(rs.getString(2));
            }
            map.put("list_tweet", list_tweet);
            map.put("list_retweet", list_retweet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
