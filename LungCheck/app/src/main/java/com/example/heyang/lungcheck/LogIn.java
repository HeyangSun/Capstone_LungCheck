package com.example.heyang.lungcheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.heyang.lungcheck.R;

import com.example.heyang.lungcheck.util.DialogUtil;

public class LogIn extends Activity {
    // 定义界面中两个文本框
    EditText etEmail, etPass;
    // 定义界面中两个按钮
    Button bnLogin, bnSignup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEmail = (EditText) findViewById(R.id.LogInEmailAddress);
        etPass = (EditText) findViewById(R.id.LogInPassword);
        bnLogin = (Button) findViewById(R.id.LogInButton);
        bnSignup = (Button) findViewById(R.id.SignUpButton);
        bnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate())
                {
                    if (loginPro())
                    {
                        Intent intent = new Intent(LogIn.this
                                , InstructionsOne.class);
                        startActivity(intent);
                        finish();

                    } else {
                        DialogUtil.showDialog(LogIn.this
                                , "Wrong user name or password!", false);
                    }
                }
            }
        });
        //for the signup button
        bnSignup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(LogIn.this,SignUp.class);
                startActivity(intent2);
            }
        });
    }

    private boolean loginPro() {
        String username = etEmail.getText().toString();
        String pwd = etPass.getText().toString();

        try {
            if(username.equals("hysunchn@gmail.com"))
                if(pwd.equals("1111"))
                    return true;

        }
        catch (Exception e) {
            DialogUtil.showDialog(this
                    , "The server is not working. Please try again later!", false);
            e.printStackTrace();
        }

        return false;
    }

    private boolean validate() {
        String username = etEmail.getText().toString().trim();
        if (username.equals("")) {
            DialogUtil.showDialog(this, "Please fill in your user email address!", false);
            return false;
        }
        String pwd = etPass.getText().toString().trim();
        if (pwd.equals("")) {
            DialogUtil.showDialog(this, "Please fill in your password!", false);
            return false;
        }
        return true;
    }
}

/*    // 定义发送请求的方法
    private JSONObject query(String username, String password)
            throws Exception
    {
        // 使用Map封装请求参数
        Map<String, String> map = new HashMap<>();
        map.put("user", username);
        map.put("pass", password);
        // 定义发送请求的URL
        String url = HttpUtil.BASE_URL + "login.jsp";
        // 发送请求
        return new JSONObject(HttpUtil.postRequest(url, map));
    }
*/