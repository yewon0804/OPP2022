/* **************************************
 * 프로그램명: 실습 8-1 간단 일기장 앱 만들기
 * 작성자: 2020039035 김예원
 * 작성일: 2022. 04. 27.
 * 프로그램 설명:
 - 날짜를 골라 해당 날짜에 일기를 쓰는 프로그램
 * ***************************************/

package com.example.opp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    EditText editDiary;
    Button btnWrite;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 일기장");
        dp = (DatePicker)findViewById(R.id.datePicker1);
        editDiary = (EditText)findViewById(R.id.edtDiary);
        btnWrite = (Button)findViewById(R.id.btnWrite);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_" + Integer.toString(monthOfYear + 1) + "_" + Integer.toString(dayOfMonth) + ".txt";
                // month는 0부터 시작이 되어서 우리가 10을 선택해도 9가 되기때문에 1을 더해줬다
                String str = readDiary(fileName); // 현재 날짜의 파일을 읽어오는 메소드
                editDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = editDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),fileName+" 이 저장됨", Toast.LENGTH_SHORT).show();
                    readDiary(fileName);
                } catch (IOException e) {

                }
            }
        });
    }

    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inputStream;
        try {
            inputStream = openFileInput(fName);
            byte[] txt = new byte[500];
            inputStream.read(txt);
            inputStream.close();
            diaryStr = (new String(txt)).trim();
            btnWrite.setText("수정하기");
        } catch (IOException e) {
            editDiary.setHint("일기 없음");
            btnWrite.setText("새로 저장");
        }
        return diaryStr;
    }
}