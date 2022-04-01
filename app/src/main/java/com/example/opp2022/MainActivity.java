/* **************************************
 * 프로그램명: 연습문제 4-7
 * 작성자: 2020039035 김예원
 * 작성일: 2022. 04. 01.
 * 프로그램 설명: 체크박스를 선택할 때마다, 버튼의 속성이 설정되는 프로그램
 * ***************************************/

package com.example.opp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    CheckBox onOffEnable, onOffClickable, turn45do;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 4-7");

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
    }
}