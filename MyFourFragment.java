package com.hhzmy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.redbabydemo.R;
import com.hhzmy.customview.PhoneTextWatcher;
import com.hhzmy.redbabydemo.YanZhengActivity;

/**
 * Created by 贾焕雪 on 2016-11-07.
 */
public class MyFourFragment extends Fragment{


    private View view;
    private Button button_zhuce;
    private Button mBtnPassword;
    private EditText phone;
    private EditText password;
    private boolean mbDisplayFlg = false;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.myfour_fragment, container, false);
        button_zhuce = (Button) view.findViewById(R.id.mianfeizhuce);
        phone =(EditText) view.findViewById(R.id.phone);
        password= (EditText) view.findViewById(R.id.password);
        button_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), YanZhengActivity.class);
                startActivity(intent);
            }
        });
        mBtnPassword = (Button)view.findViewById(R.id.btnPassword);
        mBtnPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.d("AndroidTest", "mbDisplayFlg = " + mbDisplayFlg);
                if (!mbDisplayFlg) {
                    // display password text, for example "123456"
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // hide password, display "."
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                mbDisplayFlg = !mbDisplayFlg;
                password.postInvalidate();
            }
        });
        phone.addTextChangedListener(new PhoneTextWatcher(phone));
        return view;
    }

}
