package com.hhzmy.redbabydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.redbabydemo.R;

public class ShezhiActivity extends AppCompatActivity {

    private TextView textView_duanxin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shezhi);
        Intent intent = getIntent();
        String phonenum = intent.getStringExtra("phnoenum");
        textView_duanxin = (TextView) findViewById(R.id.textView_duanxin);
        textView_duanxin.setText("短信验证码已发送至   "+phonenum);
    }
}
