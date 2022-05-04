/* **************************************
 * 프로그램명: 실습 11-1 영화 포스터 보기
 * 작성자: 2020039035 김예원
 * 작성일: 2022. 5. 4.
 * 프로그램 설명:
 - 영화 포스터들을 볼 수 있는 프로그램
 - 그리드뷰 이용
 * **************************************/

package com.example.opp2022;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }
    public class MyGridAdapter extends BaseAdapter {
        Context context;

        public MyGridAdapter(Context c) {
            context = c; // context 변수를 다른 메소드에서 사용하기 위함
        }

        @Override
        public int getCount() { // 그리드뷰에 보여질 이미지의 개수를 반환하도록 수정
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        // 이미지 파일을 배열로 초기화
        Integer[] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov11, R.drawable.mov12, R.drawable.mov13, R.drawable.mov14, R.drawable.mov15, R.drawable.mov16, R.drawable.mov17, R.drawable.mov18, R.drawable.mov19, R.drawable.mov20,
                R.drawable.mov21, R.drawable.mov22, R.drawable.mov23, R.drawable.mov24, R.drawable.mov25};

        // 영화제목을 문자 배열로 초기화
        String[] posterTitle = {"써니","완득이","괴물","라디오스타","비열한거리","왕의남자","아일랜드","웰컴투동막골","헬보이","빽투더퓨처","여인의향기","쥬라기공원","포레스트검프","그라운드데이","혹성탈출-진화의시작",
                "아름다운비행","내이름은칸","해리포터","마더","킹콩을들다","쿵푸팬더2","짱구는못말려-미래의신부를구하라","아저씨","아바타","대부"};
        @Override
        public View getView(int position, View convertView, ViewGroup parent) { // 영화 포스터를 각 그리드뷰의 칸마다 이미지뷰를 생성해서 보여주게 함
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); // 그리드뷰 칸의 중앙에 배치
            imageView.setPadding(5,5,5,5);

            imageView.setImageResource(posterID[position]); // R.drawable.mov0x 이미지를 로드하여 출력
            //TODO 이미지를 클릭했을 때, 원래 이미지 크기가 보이도록 함
            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View)View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView)dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(posterTitle[pos]);
                    dlg.setIcon(R.drawable.movie_icon);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });
            return imageView;
        }
    }
}