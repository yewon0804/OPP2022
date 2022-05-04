/* **************************************
 * 프로그램명: 실습 10-3 로그캣을 이용하여 액티비티 생명주기 확인하기
 * 작성자: 2020039035 김예원
 * 작성일: 2022. 5. 4.
 * 프로그램 설명:
 - <전화걸기>를 클릭해서 다른 액티비티가 나타난 후
 - 키패드의 돌아가기 버튼을 눌러서 메인 액티비티로 돌아간 후
 - <끝내기>를 클릭해서 메인 액티비티를 마친 후 [Logcat]에서 확인
 * ***************************************/

package com.example.opp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("로그캣 예제");

        // onCreate()에 대한 log 설정
        android.util.Log.i("액티비티 테스트", "onCreate()");

        // 버튼 변수 선언
        Button btnDial, btnFinish;

        // 버튼 객체 접근하기
        btnDial = (Button) findViewById(R.id.btnDial);
        btnFinish = (Button) findViewById(R.id.btnFinish);


        // 전화걸기 버튼 클릭
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:01085479094");
                Intent telIntent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(telIntent);
            }
        });

        // 끝내기 버튼 클릭
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    // onDestroy()에 대한 log 설정
    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.util.Log.i("액티비티 테스트", "onDestroy()");
    }

    // onPause()에 대한 log 설정
    @Override
    protected void onPause() {
        super.onPause();
        android.util.Log.i("액티비티 테스트", "onPause()");
    }

    // onRestart()에 대한 log 설정
    @Override
    protected void onRestart() {
        super.onRestart();
        android.util.Log.i("액티비티 테스트", "onRestart()");
    }

    // onStart()에 대한 log 설정
    @Override
    protected void onStart() {
        super.onStart();
        android.util.Log.i("액티비티 테스트", "onStart()");
    }

    // onStop()에 대한 log 설정
    @Override
    protected void onStop() {
        super.onStop();
        android.util.Log.i("액티비티 테스트", "onStop()");
    }
}