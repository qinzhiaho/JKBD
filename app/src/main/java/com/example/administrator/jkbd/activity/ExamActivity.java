package com.example.administrator.jkbd.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.jkbd.R;
import com.example.administrator.jkbd.bean.ExaminInfo;
import com.example.administrator.jkbd.utils.ExamApplication;


/**
 * Created by Administrator on 2017/6/29.
 */

public class ExamActivity extends AppCompatActivity {
    TextView tvExamInfo;
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam);
        initView();
        initDate();
        
    }
    private void initView() {
        tvExamInfo=(TextView)findViewById(R.id.tv_examinfo);
    }
    private void initDate() {
        ExaminInfo examInfo=ExamApplication.getInstance().getmExamInfo();
        if(examInfo!=null){
            showData(examInfo);
        }
    }
    private void showData(ExaminInfo examInfo) {
        tvExamInfo.setText(examInfo.toString());
    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//    }
}
