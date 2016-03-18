package com.supinfo.calculettesoutien.ui.avtivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.supinfo.calculettesoutien.R;
import com.supinfo.calculettesoutien.model.Calcul;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnMultiply, mBtnDivide, mBtnMinus, mBtnPlus, mBtnClear, mBtnDelete, mBtnResult;
    private TextView mTxtWrite, mTxtResult;
    private View mRoot;

    private ArrayList<Calcul> mCalculs;

    private boolean mNeedToClear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRoot = View.inflate(this, R.layout.activity_main, null);
        setContentView(mRoot);

        mCalculs = new ArrayList<>();

        mTxtResult = (TextView) findViewById(R.id.main_textview_result);
        mTxtWrite = (TextView) findViewById(R.id.main_textview_write);

        mBtnMultiply = (Button) findViewById(R.id.main_btn_multiply);
        mBtnDivide = (Button) findViewById(R.id.main_btn_divide);
        mBtnMinus = (Button) findViewById(R.id.main_btn_minus);
        mBtnPlus = (Button) findViewById(R.id.main_btn_plus);
        mBtnClear = (Button) findViewById(R.id.main_btn_clear);
        mBtnDelete = (Button) findViewById(R.id.main_btn_delete);
        mBtnResult = (Button) findViewById(R.id.main_btn_result);

        mBtnMultiply.setOnClickListener(this);
        mBtnDivide.setOnClickListener(this);
        mBtnMinus.setOnClickListener(this);
        mBtnPlus.setOnClickListener(this);
        mBtnClear.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        mBtnResult.setOnClickListener(this);

        for (int i = 0; i < 10; i++) {
            mRoot.findViewWithTag(String.format("%d",i)).setOnClickListener(this);
        }
    }

    private void saveResult(String s) {
        mTxtResult.setText(s);
        Calcul calcul = new Calcul(s, s);

        mCalculs.add(calcul);
    }

    @Override
    public void onClick(View v) {
        if (mNeedToClear) {
            mTxtResult.setText("");
            mTxtWrite.setText("");
            mNeedToClear = false;
        }
        if (mTxtWrite != null && v.getTag() != null && !v.getTag().toString().isEmpty()) {
            char c = mTxtWrite.getText().length() > 0 ? mTxtWrite.getText().charAt(mTxtWrite.length() - 1) : ' ';
            char tag = v.getTag().toString().charAt(0);
            switch (c) {
                case '*':
                case '/':
                case '+':
                case '-':
                    if (!Character.isDigit(tag)) {
                        mTxtWrite.setText(mTxtWrite.getText().subSequence(0, mTxtWrite.length() - 1));
                        mTxtWrite.append(tag + "");
                    } else {
                        mTxtWrite.append(v.getTag().toString());
                    }
                    break;
                default:
                    if (!Character.isDigit(tag) && mTxtWrite.getText().length() > 0) {
                        mTxtWrite.append(v.getTag().toString());
                    } else if (Character.isDigit(tag)) {
                        mTxtWrite.append(v.getTag().toString());
                    }
            }
        }
        switch (v.getId()) {
            case R.id.main_btn_result:
                if (mTxtWrite != null && mTxtWrite.getText().length() > 0) {
                    saveResult(mTxtWrite.getText().toString());
                    mNeedToClear = true;
                }
        }
    }
}
