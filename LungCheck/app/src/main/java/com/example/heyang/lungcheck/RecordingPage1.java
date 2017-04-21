package com.example.heyang.lungcheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.os.Message;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.Handler;
import com.example.heyang.lungcheck.util.RecordingToWav;
import java.util.Timer;
import java.util.TimerTask;


public class RecordingPage1 extends Activity
        implements OnClickListener
{
    int i=0;
    private Button recording,NextLocation;
    private ProgressBar progressBar=null;
    private RecordingToWav mRecorder;
    private static final java.lang.String mRecordFilePath=Environment.getExternalStorageDirectory()+"/L1.wav";

    Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x123:
                    recording.setClickable(false);
                    i+=10;
                    progressBar.setProgress(i);
                    if(i!=100){
                        handler.sendEmptyMessageDelayed(0x123,1000);
                        recording.setText(i+'%');
                    }else if(i==100){
                        recording.setText("Completed");
                        handler.sendEmptyMessageDelayed(0x111,1000);
                    }
                    break;
                case 0x111:
                    recording.setClickable(true);
                    recording.setBackgroundResource(R.drawable.button_selector);
                    handler.sendEmptyMessageDelayed(0x110,1000);
                    break;
                case 0x110:
                    progressBar.setProgress(0);
                    break;
            }
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording_page1);
        recording = (Button) findViewById(R.id.recording);
        NextLocation = (Button) findViewById(R.id.NextLocation);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        mRecorder=RecordingToWav.getInstance();
        mRecorder.setOutputFile(mRecordFilePath);
        recording.setOnClickListener(this);
        NextLocation.setOnClickListener(this);
    }

    @Override
    public void onClick(View source) {
        switch (source.getId()) {
            case R.id.recording:
                i=0;
                Timer timer = new Timer();
                if (RecordingToWav.State.INITIALIZING == mRecorder.getState()) {
                    mRecorder.prepare();
                    mRecorder.start();
                    handler.sendEmptyMessage(0x123);
                }
                break;
            case R.id.NextLocation:
                NextLocation.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(RecordingPage1.this
                                , DetailedInstructionsOne.class);
                        startActivity(intent);
                        finish();
                    }
                });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mRecorder) {
            mRecorder.release();
        }
    }
}
