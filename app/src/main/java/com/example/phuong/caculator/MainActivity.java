package com.example.phuong.caculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEdExpression;
    private EditText mEdResult;
    private TextView mBtnC;
    private TextView mBtnCE;
    private TextView mBtnDivide;
    private TextView mBtnMulti;
    private TextView mBtnSub;
    private TextView mBtnAdd;
    private TextView mBtn1;
    private TextView mBtn2;
    private TextView mBtn3;
    private TextView mBtn4;
    private TextView mBtn5;
    private TextView mBtn6;
    private TextView mBtn7;
    private TextView mBtn8;
    private TextView mBtn9;
    private TextView mBtn0;
    private TextView mBtnDot;
    private TextView mBtnPercent;
    private TextView mBtnImplement;
    private static String mExpress = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdExpression = (EditText) findViewById(R.id.edExpress);
        mEdResult = (EditText) findViewById(R.id.edResult);
        mBtn0 = (TextView) findViewById(R.id.btn0);
        mBtn1 = (TextView) findViewById(R.id.btn1);
        mBtn2 = (TextView) findViewById(R.id.btn2);
        mBtn3 = (TextView) findViewById(R.id.btn3);
        mBtn4 = (TextView) findViewById(R.id.btn4);
        mBtn5 = (TextView) findViewById(R.id.btn5);
        mBtn6 = (TextView) findViewById(R.id.btn6);
        mBtn7 = (TextView) findViewById(R.id.btn7);
        mBtn8 = (TextView) findViewById(R.id.btn8);
        mBtn9 = (TextView) findViewById(R.id.btn9);
        mBtnDot = (TextView) findViewById(R.id.btnDot);
        mBtnDivide = (TextView) findViewById(R.id.btnDivide);
        mBtnPercent = (TextView) findViewById(R.id.btnPercent);
        mBtnImplement = (TextView) findViewById(R.id.btnImplement);
        mBtnC = (TextView) findViewById(R.id.btnC);
        mBtnCE = (TextView) findViewById(R.id.btnCE);
        mBtnMulti = (TextView) findViewById(R.id.btnMutli);
        mBtnAdd = (TextView) findViewById(R.id.btnAdd);
        mBtnSub = (TextView) findViewById(R.id.btnSub);

        mBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression(mBtn0.getText().toString());
            }
        });

        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression(mBtn1.getText().toString());
            }
        });

        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression(mBtn2.getText().toString());
            }
        });

        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression(mBtn3.getText().toString());
            }
        });

        mBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression(mBtn4.getText().toString());
            }
        });

        mBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression(mBtn5.getText().toString());
            }
        });

        mBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression(mBtn6.getText().toString());
            }
        });

        mBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression(mBtn7.getText().toString());
            }
        });

        mBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression(mBtn8.getText().toString());
            }
        });

        mBtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression(mBtn9.getText().toString());
            }
        });

        mBtnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression(mBtnDot.getText().toString());
            }
        });

        mBtnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression(mBtnDivide.getText().toString());
            }
        });

        mBtnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression("*");
            }
        });

        mBtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression(mBtnSub.getText().toString());
            }
        });

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExpression(mBtnAdd.getText().toString());
            }
        });

        mBtnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEdExpression.setText("");
                mEdResult.setText("");
                mExpress = "";
            }
        });

        mBtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEdExpression.length() >= 1) {
                    mExpress = mExpress.substring(0, mEdExpression.length() - 1);
                    mEdExpression.setText(mExpress);
                }
            }
        });

        mEdExpression.setInputType(InputType.TYPE_NULL);
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            mEdExpression.setRawInputType(InputType.TYPE_CLASS_TEXT);
            mEdExpression.setTextIsSelectable(true);
        }

        mBtnImplement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEdResult.setText(String.valueOf(Caculator.computeMathExpression(mEdExpression.getText().toString())));
            }
        });
    }

    public void makeExpression(String number) {
        mExpress += number;
        mEdExpression.setText(mExpress);
    }
}
