package com.explain.media.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.explain.media.R;
import com.explain.media.activity.second.TranscodingActivity;
import com.explain.media.utils.FFmpegCmd;
import com.explain.media.utils.SDFileUtil;

/**
 * 音频处理
 */
public class AudioHandleActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_handle);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1://PCM合并
                FFmpegCmd.execute("sss", "gaa");
                break;
            case R.id.button2://音频编码
                FFmpegCmd.decode("/storage/emulated/0/qqmusic/song/周深 - 大鱼 [mqms2].mp3", "/storage/emulated/0/qqmusic/song/dayu.pcm");
                break;
            case R.id.button3://音频转码
                Intent intent3 = new Intent();
                intent3.setClass(this, TranscodingActivity.class);
                startActivity(intent3);
                break;
            case R.id.button4://音频剪切
                break;
            case R.id.button5://音频合并
                break;
            case R.id.button6://音频混合
                break;
            case R.id.button7://AudioTrack播放
                Intent intent7 = new Intent();
                intent7.setClass(this, AudioPlayActivity.class);
                intent7.putExtra("type", 0);
                startActivity(intent7);
                break;
            case R.id.button8://OpenSL播放
                Intent intent8 = new Intent();
                intent8.setClass(this, AudioPlayActivity.class);
                intent8.putExtra("type", 1);
                startActivity(intent8);
                break;
        }
    }
}
