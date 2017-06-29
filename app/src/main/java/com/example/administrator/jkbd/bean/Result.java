package com.example.administrator.jkbd.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */

public class Result {

    /**
     * error_code : 0
     * reason : ok
     * result : [{"id":22,"question":"这个标志是何含义？","answer":"1","item1":"丁字交叉路口预告","item2":"道路分叉处预告","item3":"Y型交叉路口预告","item4":"十字交叉路口预告","explains":"你看它长的多像丁字。","url":"http://images.juheapi.com/jztk/c1c2subject1/22.jpg"}]
     */

    private int error_code;
    private String reason;
    private List<Exam> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<Exam> getResult() {
        return result;
    }

    public void setResult(List<Exam> result) {
        this.result = result;
    }
}
