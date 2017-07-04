package com.example.administrator.jkbd.activity;

import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.jkbd.R;
import com.example.administrator.jkbd.bean.Exam;
import com.example.administrator.jkbd.bean.ExaminInfo;
import com.example.administrator.jkbd.utils.ExamApplication;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Administrator on 2017/6/29.
 */

public class ExamActivity extends AppCompatActivity {
    TextView tvExamInfo,tvExamTitle,tvop01,tvop02,tvop03,tvop04;
    ImageView mImageView;
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam);
        initView();
        initDate();
        
    }
    private void initView() {
        tvExamInfo=(TextView)findViewById(R.id.tv_examinfo);
        tvExamTitle=(TextView)findViewById(R.id.tv_exam_title);
        tvop01=(TextView)findViewById(R.id.tv_op1);
        tvop02=(TextView)findViewById(R.id.tv_op2);
        tvop03=(TextView)findViewById(R.id.tv_op3);
        tvop04=(TextView)findViewById(R.id.tv_op4);
        mImageView=(ImageView) findViewById(R.id.im_exam_image);

    }
    private void initDate() {

    }

    private void showExam(List<Exam> examList) {
        Exam exam=examList.get(0);
        if (exam!=null){
            tvExamTitle.setText(exam.getQuestion());
            tvop01.setText(exam.getItem1());
            tvop02.setText(exam.getItem2());
            tvop03.setText(exam.getItem3());
            tvop04.setText(exam.getItem4());
            Picasso.with(ExamActivity.this)
                    .load(exam.getUrl())
                    .into(mImageView);
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
