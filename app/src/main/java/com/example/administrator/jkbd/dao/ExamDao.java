package com.example.administrator.jkbd.dao;

import android.util.Log;

import com.example.administrator.jkbd.bean.Exam;
import com.example.administrator.jkbd.bean.ExaminInfo;
import com.example.administrator.jkbd.bean.Result;
import com.example.administrator.jkbd.utils.ExamApplication;
import com.example.administrator.jkbd.utils.OkHttpUtils;
import com.example.administrator.jkbd.utils.ResultUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */

public class ExamDao implements IExamDao{
    @Override
    public void loadExamInfo() {
        OkHttpUtils<ExaminInfo> utils=new OkHttpUtils<>(ExamApplication.getInstance());
        Log.e("tag","utils="+utils);
        String  url="http://101.251.196.90:8080/JztkServer/examInfo";
        utils.url(url)
                .targetClass(ExaminInfo.class)
                .execute(new OkHttpUtils.OnCompleteListener<ExaminInfo>() {
                    @Override
                    public void onSuccess(ExaminInfo result) {
                        Log.e("main","result"+result);
                        ExamApplication.getInstance().setmExamInfo(result);
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("main","error"+error);
                    }
                });
    }

    @Override
    public void loadQuestionList() {
        OkHttpUtils<String> utils1=new OkHttpUtils<String>(ExamApplication.getInstance());
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
                                ExamApplication.getInstance().setmExamList(list);
                            }
                        }
                    }
                    @Override
                    public void onError(String error) {
                        Log.e("main","error="+error);
                    }
                });
    }
}
