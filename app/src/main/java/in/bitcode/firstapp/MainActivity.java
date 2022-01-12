package in.bitcode.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImgLogo;
    private EditText mEdtUsername, mEdtPassword;
    private Button mBtnLogin, mBtnForgotPassword;
    private TextView mTxtClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();



        /*mBtnLogin.setOnTouchListener( new BtnLoginTouchListener());
        mBtnLogin.setOnKeyListener(new BtnLoginKeyListener());*/

        //way 1
        //mBtnLogin.setOnClickListener(new BtnLoginClickListener());

        //way 2
        /*View.OnClickListener clickListener = new CommonClickListener();
        mBtnLogin.setOnClickListener(clickListener);
        mBtnForgotPassword.setOnClickListener(clickListener);
        mTxtClear.setOnClickListener(clickListener);*/

        //way 3
        /*mBtnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mEdtUsername.getText().toString().equals("bitcode") && mEdtPassword.getText().toString().equals("bitcode")) {
                            mImgLogo.setImageResource(R.drawable.tick);
                        }
                        else {
                            mImgLogo.setImageResource(R.drawable.cross);
                        }
                    }
                }
        );


        mBtnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        MainActivity.this,
                        "Password reset link sent to your email!",
                        Toast.LENGTH_LONG
                ).show();
            }
        });

        mTxtClear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mEdtUsername.setText("");
                        mEdtPassword.setText("");
                        mImgLogo.setImageResource(R.drawable.bitcode);
                    }
                }
        );*/

        //way4
        mBtnLogin.setOnClickListener(this);
        mBtnForgotPassword.setOnClickListener(this);
        mTxtClear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == mBtnLogin) {
            if(mEdtUsername.getText().toString().equals("bitcode") && mEdtPassword.getText().toString().equals("bitcode")) {
                mImgLogo.setImageResource(R.drawable.tick);
            }
            else {
                mImgLogo.setImageResource(R.drawable.cross);
            }
        }

        if(view.getId() == R.id.btnForgotPassword) {
            Toast.makeText(
                    MainActivity.this,
                    "Password reset link sent to your email!",
                    Toast.LENGTH_LONG
            ).show();
        }

        if(view == mTxtClear) {
            mEdtUsername.setText("");
            mEdtPassword.setText("");
            mImgLogo.setImageResource(R.drawable.bitcode);
        }
    }

    private void init() {
        mImgLogo = findViewById(R.id.imgLogo);
        mEdtUsername = findViewById(R.id.edtUsername);
        mEdtPassword = findViewById(R.id.edtPassword);
        mBtnLogin = findViewById(R.id.btnLogin);
        mBtnForgotPassword = findViewById(R.id.btnForgotPassword);
        mTxtClear = findViewById(R.id.txtClear);
    }


    private class CommonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            if(view == mBtnLogin) {
                if(mEdtUsername.getText().toString().equals("bitcode") && mEdtPassword.getText().toString().equals("bitcode")) {
                    mImgLogo.setImageResource(R.drawable.tick);
                }
                else {
                    mImgLogo.setImageResource(R.drawable.cross);
                }
            }

            if(view.getId() == R.id.btnForgotPassword) {
                Toast.makeText(
                        MainActivity.this,
                        "Password reset link sent to your email!",
                        Toast.LENGTH_LONG
                ).show();
            }

            if(view == mTxtClear) {
                mEdtUsername.setText("");
                mEdtPassword.setText("");
                mImgLogo.setImageResource(R.drawable.bitcode);
            }
        }
    }

    class BtnLoginKeyListener implements View.OnKeyListener {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            return false;
        }
    }

    class BtnLoginTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return false;
        }
    }

    class BtnLoginClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(mEdtUsername.getText().toString().equals("bitcode") && mEdtPassword.getText().toString().equals("bitcode")) {
                mImgLogo.setImageResource(R.drawable.tick);
            }
            else {
                mImgLogo.setImageResource(R.drawable.cross);
            }
        }
    }
}

