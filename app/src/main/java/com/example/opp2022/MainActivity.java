/* **************************************
 * 프로그램명: naive app
 * 작성자: 2020039035 김예원
 * 작성일: 2022. 03. 27.
 * 프로그램 설명: EditText, Button, RadioGroup,
          RadioButton, ImageView 위젯으로
          앱의 기본적인 레이아웃을 갖춘 프로그램.
 * ***************************************/

package com.example.opp2022;

/* **************************************
 * 프로그램명: naive app
 * 작성자: 2020039035 김예원
 * 작성일: 2022. 03. 27.
 * 프로그램 설명: EditText, Button, RadioGroup,
          RadioButton, ImageView 위젯으로
          앱의 기본적인 레이아웃을 갖춘 프로그램.
 * ***************************************/

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mEt;
    Button printToast, goToURL, btnOK;
    RadioGroup whatVer;
    RadioButton rdoQ, rdoR;
    ImageView imageQ, imageR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("오픈전문 3주차");

        mEt = (EditText) findViewById(R.id.google);
        printToast = (Button) findViewById(R.id.button);
        goToURL = (Button) findViewById(R.id.button2);
        whatVer = (RadioGroup) findViewById(R.id.QorR);
        rdoQ = (RadioButton) findViewById(R.id.rdoQ);
        rdoR = (RadioButton) findViewById(R.id.rdoR);
        imageQ = (ImageView) findViewById(R.id.imageQ);
        imageR = (ImageView) findViewById(R.id.imageR);

        printToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = mEt.getText().toString();
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
        goToURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                String url = mEt.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        whatVer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rdoQ.isChecked()==true){
                    imageQ.setVisibility(View.VISIBLE);
                    imageR.setVisibility(View.INVISIBLE);
                }
                else if(rdoR.isChecked()==true){
                    imageQ.setVisibility(View.INVISIBLE);
                    imageR.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}