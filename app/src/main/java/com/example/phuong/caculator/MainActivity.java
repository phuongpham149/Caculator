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
    private TextView mTvExpression;
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
    private String mExpress = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvExpression = (TextView) findViewById(R.id.tvExpress);
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
                if(!isCaculator()){
                    makeExpression(mBtnDot.getText().toString());
                }
            }
        });

        mBtnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isCaculator()) {
                    makeExpression(mBtnDivide.getText().toString());
                }
            }
        });

        mBtnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isCaculator()) {
                    makeExpression("*");
                }
            }
        });

        mBtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isCaculator()) {
                    makeExpression(mBtnSub.getText().toString());
                }
            }
        });

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isCaculator()) {
                    makeExpression(mBtnAdd.getText().toString());
                }
            }
        });

        mBtnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvExpression.setText("");
                mEdResult.setText("");
                mExpress = "";
            }
        });

        mBtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteLastCharacter();
            }
        });

        mBtnImplement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTvExpression.getText().toString().equals("")) {
                    mEdResult.setText("0.00");
                } else {
                    if (isCaculator()) {
                        deleteLastCharacter();
                        implementCaculator();
                    } else {
                        try {
                            implementCaculator();
                        } catch (Exception e) {
                            mTvExpression.setText("");
                            mEdResult.setText("Error");
                        }
                    }
                }

            }
        });
    }

    public void makeExpression(String number) {
        mExpress += number;
        mTvExpression.setText(mExpress);
    }

    public boolean isCaculator() {
        String last = String.valueOf(mExpress.charAt(mExpress.length() - 1));
        String check ="-+/*.";
        if (check.contains(last)) {
            return true;
        }
        return false;
    }

    public void deleteLastCharacter() {
        if (mTvExpression.length() >= 1) {
            mExpress = mExpress.substring(0, mTvExpression.length() - 1);
            mTvExpression.setText(mExpress);
        }
    }

    public void implementCaculator() {
        mEdResult.setText(String.valueOf(Caculator.computeMathExpression(mTvExpression.getText().toString())));
        mExpress = mEdResult.getText().toString();
    }
}
