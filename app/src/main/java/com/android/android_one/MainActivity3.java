package com.android.android_one;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 영상 --------------------------------

        vv = findViewById(R.id.vv);
        //video Uri
        Uri videoUri = Uri.parse("https://www.youtube.com/watch?v=0cwdiwp-pTs");


        Intent intent = getIntent();
        String status = intent.getStringExtra("status");


        switch (status){
            case "low":
            videoUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.thin);
            break;
            case "normal":
                //videoUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw);
                break;
            case "heavy":
                videoUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.fat);
                break;
            case "veryheavy":
                videoUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.biman);
                break;
        }







        //내 RES폴더안에 동영상이 있을경우.
       // videoUri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.thin);

        //비디오뷰의 재생, 일시정지 등을 할수있는 '컨트롤바'를 붙여주는 작업.
        vv.setVideoURI(videoUri);

        //동영상을 읽어오는데 시간이 걸리므로..
        //비디오 로딩준비가 끝났을때 실행하도록..
        //리스너 설정
        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //비디오 시작
                vv.start();
            }
        });

    }//onCreate ..

    //화면에 안보일때…
    @Override
    protected void onPause() {
        super.onPause();

        //비디오 일시 정지
        if(vv!=null && vv.isPlaying()) vv.pause();
    }
    //액티비티가 메모리에서 사라질때..
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //
        if(vv!=null) vv.stopPlayback();
    }
}