/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieee.pojo;

/**
 *
 * @author Praveen
 */
public class Tweets {
    private int tweetId;
    private String tweetedBy;
    private String msg;
   
    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    public String getTweetedBy() {
        return tweetedBy;
    }

    public void setTweetedBy(String tweetedBy) {
        this.tweetedBy = tweetedBy;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
