package com.example.opp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 4-7
    CheckBox onOffEnable, onOffClickable, turn45do;
    Button button1;

    // 4-8
    EditText returnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("4주차 과제");

        /* **************************************
         * 프로그램명: 연습문제 4-7
         * 작성자: 2020039035 김예원
         * 작성일: 2022. 04. 01.
         * 프로그램 설명: 체크박스를 선택할 때마다, 버튼의 속성이 설정되는 프로그램
         * ***************************************/

        onOffEnable = (CheckBox) findViewById(R.id.onOffEnable);
        onOffClickable = (CheckBox) findViewById(R.id.onOffClickable);
        turn45do = (CheckBox) findViewById(R.id.turn45do);
        button1 = (Button) findViewById(R.id.button1);

        onOffEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (onOffEnable.isChecked()) {
                    button1.setEnabled(true);
                }
                else {
                    button1.setEnabled(false);
                }
            }
        });
        onOffClickable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (onOffClickable.isChecked()) {
                    button1.setClickable(true);
                }
                else {
                    button1.setClickable(false);
                }
            }
        });
        turn45do.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (turn45do.isChecked()) {
                    button1.setRotation(45);
                }
                else {
                    button1.setRotation(0);
                }
            }
        });

        /* **************************************
         * 프로그램명: 연습문제 4-8
         * 작성자: 2020039035 김예원
         * 작성일: 2022. 04. 01.
         * 프로그램 설명: 에디트텍스트에 키가 눌릴 때마다, 바뀐 글자가 Toast 메시지로 나오는 프로젝트
         * ***************************************/

        returnToast = (EditText) findViewById(R.id.returnToast);

        returnToast.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                Toast.makeText(getApplicationContext(), returnToast.getText(), Toast.LENGTH_LONG).show();
                return false;
            }
        });

    }
}