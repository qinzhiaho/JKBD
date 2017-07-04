package com.example.administrator.jkbd.utils;

import android.app.Application;
import android.util.Log;

import com.example.administrator.jkbd.bean.Exam;
import com.example.administrator.jkbd.bean.ExaminInfo;
import com.example.administrator.jkbd.bean.Result;
import com.example.administrator.jkbd.biz.ExamBiz;
import com.example.administrator.jkbd.biz.IExamBiz;

import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */

public class ExamApplication extends Application {
    ExaminInfo mExamInfo;
    List<Exam>mExamList;
    private static ExamApplication instance;
    IExamBiz biz;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        biz=new ExamBiz();
        initDate();
    }
    public static ExamApplication getInstance(){
        return instance;
    }
    private void initDate() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                biz.beginExam();
            }
        }).start();

    }

    public ExaminInfo getmExamInfo() {
        return mExamInfo;
    }

    public void setmExamInfo(ExaminInfo mExamInfo) {
        this.mExamInfo = mExamInfo;
    }

    public List<Exam> getmExamList() {
        return mExamList;
    }

    public void setmExamList(List<Exam> mExamList) {
        this.mExamList = mExamList;
    }
}
