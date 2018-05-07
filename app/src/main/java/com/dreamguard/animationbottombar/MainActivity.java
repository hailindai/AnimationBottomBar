package com.dreamguard.animationbottombar;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView bottomVideo;
    private ImageView bottomGame;
    private ImageView bottomSearch;
    private ImageView bottomMy;
    private ImageView bottomVR;

    private TextView show;

    private AnimationDrawable videoAnimationDrawable;
    private AnimationDrawable gameAnimationDrawable;
    private AnimationDrawable searchAnimationDrawable;
    private AnimationDrawable myAnimationDrawable;

    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        switchItem(0);

    }

    public void initView() {

        show = (TextView)findViewById(R.id.show);
        bottomVideo = (ImageView) findViewById(R.id.bottom_video);
        bottomGame = (ImageView) findViewById(R.id.bottom_game);
        bottomSearch = (ImageView) findViewById(R.id.bottom_search);
        bottomMy = (ImageView) findViewById(R.id.bottom_my);
        bottomVR = (ImageView) findViewById(R.id.bottom_vr);

        bottomVideo.setOnClickListener(this);
        bottomGame.setOnClickListener(this);
        bottomSearch.setOnClickListener(this);
        bottomMy.setOnClickListener(this);
        bottomVR.setOnClickListener(this);

        videoAnimationDrawable = (AnimationDrawable) getResources().getDrawable(
                R.drawable.frame_anim_video);
        gameAnimationDrawable = (AnimationDrawable) getResources().getDrawable(
                R.drawable.frame_anim_game);
        searchAnimationDrawable = (AnimationDrawable) getResources().getDrawable(
                R.drawable.frame_anim_search);
        myAnimationDrawable = (AnimationDrawable) getResources().getDrawable(
                R.drawable.frame_anim_my);
    }

    public void switchItem(int index) {
        switch (index) {
            case 0:
                show.setText("video");

                bottomVideo.setImageDrawable(videoAnimationDrawable);
                videoAnimationDrawable.start();
                bottomGame.setImageDrawable(gameAnimationDrawable.getFrame(0));
                bottomSearch.setImageDrawable(searchAnimationDrawable.getFrame(0));
                bottomMy.setImageDrawable(myAnimationDrawable.getFrame(0));
                break;
            case 1:
                show.setText("game");

                bottomGame.setImageDrawable(gameAnimationDrawable);
                gameAnimationDrawable.start();
                bottomVideo.setImageDrawable(videoAnimationDrawable.getFrame(0));
                bottomSearch.setImageDrawable(searchAnimationDrawable.getFrame(0));
                bottomMy.setImageDrawable(myAnimationDrawable.getFrame(0));

                break;
            case 2:
                show.setText("search");

                bottomSearch.setImageDrawable(searchAnimationDrawable);
                searchAnimationDrawable.start();
                bottomVideo.setImageDrawable(videoAnimationDrawable.getFrame(0));
                bottomGame.setImageDrawable(gameAnimationDrawable.getFrame(0));
                bottomMy.setImageDrawable(myAnimationDrawable.getFrame(0));

                break;
            case 3:
                show.setText("my");

                bottomMy.setImageDrawable(myAnimationDrawable);
                myAnimationDrawable.start();
                bottomVideo.setImageDrawable(videoAnimationDrawable.getFrame(0));
                bottomGame.setImageDrawable(gameAnimationDrawable.getFrame(0));
                bottomSearch.setImageDrawable(searchAnimationDrawable.getFrame(0));

                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bottom_video:
                switchItem(0);
                break;
            case R.id.bottom_game:
                switchItem(1);
                break;
            case R.id.bottom_search:
                switchItem(2);
                break;
            case R.id.bottom_my:
                switchItem(3);
                break;
            case R.id.bottom_vr:
                show.setText("vr");
                break;
        }
    }

}
