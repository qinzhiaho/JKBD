package com.example.administrator.jkbd.utils;

import android.app.Application;
import android.util.Log;

import com.example.administrator.jkbd.bean.Exam;
import com.example.administrator.jkbd.bean.ExaminInfo;
import com.example.administrator.jkbd.bean.Result;

import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */

public class ExamApplication extends Application {
    ExaminInfo mExamInfo;
    List<Exam>mExamList;
    private static ExamApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        
        initDate();
    }
    public static ExamApplication getInstance(){
        return instance;
    }
    private void initDate() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpUtils<ExaminInfo> utils=new OkHttpUtils<>(instance);
                Log.e("tag","utils="+utils);
                String  url="http://101.251.196.90:8080/JztkServer/examInfo";
                utils.url(url)
                        .targetClass(ExaminInfo.class)
                        .execute(new OkHttpUtils.OnCompleteListener<ExaminInfo>() {
                            @Override
                            public void onSuccess(ExaminInfo result) {
                                Log.e("main","result"+result);
                            }

                            @Override
                            public void onError(String error) {
                                Log.e("main","error"+error);
                            }
                        });
                OkHttpUtils<String> utils1=new OkHttpUtils<String>(instance);
                String url2="http://101.251.196.90:8080/JztkServer/getQuestions?testType=rand";
                utils1.url(url2)
                        .targetClass(String.class)
                        .execute(new OkHttpUtils.OnCompleteListener<String>() {
                            @Override
                            public void onSuccess(String jsonStr) {
                               Result result= ResultUtils.getListResultFromJson(jsonStr);
                                if (result!=null&&result.getError_code()==0){
                                    List<Exam> list=result.getResult();
                                    if (list!=null&&list.size()>0){
                                        mExamList=list;
                                    }
                                }
                            }
                            @Override
                            public void onError(String error) {
                                Log.e("main","error="+error);
                            }
                        });
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
