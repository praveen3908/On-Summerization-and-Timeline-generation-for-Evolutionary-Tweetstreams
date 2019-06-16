/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieee.dao;

import com.ieee.servlet.DbConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Praveen
 */
public class InsertDAO {

    private static Connection con = null;
    private String insert_tweet = "INSERT INTO tweets(tweetedById,tweetMsg,tweetDt) VALUES(?,?,?)";
    private String insert_followers = "INSERT INTO followers(followerId,followedById) VALUES(?,?)";
    private String insert_reTweet = "INSERT INTO retweet(tweetId,reTweetMsg,reTweetDt,reTweetedById) VALUES(?,?,?,?)";

    static {
        con = DbConnection.getConnections();
    }

    public int insertTweets(int userId, String tweet) {
        int flag = 0;
        try {
            PreparedStatement pstmt = con.prepareStatement(insert_tweet);
            pstmt.setInt(1, userId);
            pstmt.setString(2, tweet);
            pstmt.setDate(3, new Date(System.currentTimeMillis()));
            flag = pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    public int insertFollowerDetails(int followerId, int followedById) {
        int flag = 0;
        try {
            PreparedStatement pstmt = con.prepareStatement(insert_followers);
            pstmt.setInt(1, followerId);
            pstmt.setInt(2, followedById);
            flag = pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    public int insertReTweets(int tweetId,String reTweetMsg,int reTweetedById) {
        int flag = 0;
        try {
            PreparedStatement pstmt = con.prepareStatement(insert_reTweet);
            pstmt.setInt(1, tweetId);
            pstmt.setString(2, reTweetMsg);
            pstmt.setDate(3, new Date(System.currentTimeMillis()));
            pstmt.setInt(4, reTweetedById);
            flag = pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }
}
