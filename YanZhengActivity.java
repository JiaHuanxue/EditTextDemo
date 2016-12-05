package com.hhzmy.redbabydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.redbabydemo.R;
import com.hhzmy.customview.PhoneTextWatcher;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YanZhengActivity extends AppCompatActivity {

    String phonenum = "";
    String temp="";
    private EditText phone;
    private CheckBox checkBox;
    LinkedList<Boolean> linkedList = new LinkedList<Boolean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yan_zheng);
        phone = (EditText) findViewById(R.id.pohne);
        phone.addTextChangedListener(new PhoneTextWatcher(phone));
        checkBox = (CheckBox) findViewById(R.id.checkbox1);
    }

    public  void xiayibu(View view) {
        phonenum=phone.getText().toString().trim();
      if (!isPhoneNumberValid(phonenum)){
            Toast.makeText(YanZhengActivity.this, "电话格式不正确,请检查！", Toast.LENGTH_SHORT).show();
        } else if(phonenum.length()==0){
            Toast.makeText(YanZhengActivity.this, "请输入电话号码！", Toast.LENGTH_SHORT).show();
        }else if(!checkBox.isChecked()){
          Toast.makeText(YanZhengActivity.this, "需要同意", Toast.LENGTH_SHORT).show();
      }else {
          Intent intent = new Intent(YanZhengActivity.this,ShezhiActivity.class);
          SmsManager smsmanger=SmsManager.getDefault();
          for(int i=0;i<5;i++){//产生一个五位数的激活码
              int k=(int) (Math.random()*10);
              temp+=k;
          }
          intent.putExtra("phnoenum",phonenum);
          startActivity(intent);
      }
    }

    /*检查字符串是否为电话号码的方法,并回传true or false的判断值*/
    public static boolean isPhoneNumberValid(String mobiles){
        Matcher m = null;
        if(mobiles.trim().length()>0){
            Pattern p = Pattern.compile("[1][34578]\\d{9}");
            m= p.matcher(mobiles);
        }
        else{
            return false;
        }
        return m.matches();
    }
}
