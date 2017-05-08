package com.example.heyang.lungcheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.Handler;
import com.example.heyang.lungcheck.util.RecordingToWav;
import java.util.Timer;
import java.util.TimerTask;


public class RecordingPage5 extends Activity
{
    private Button recording,NextLocation;
    private ProgressBar progressbar=null;
    private RecordingToWav mRecorder;
    private static final java.lang.String mRecordFilePath=Environment.getExternalStorageDirectory()+"/L5.wav";

    int hasData=0;
    int status=0;

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg)
        {
            if (msg.what == 0x111)
            {
                progressbar.setProgress(status);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording_page5);
        recording = (Button) findViewById(R.id.recording);
        NextLocation = (Button) findViewById(R.id.NextLocation);
        progressbar = (ProgressBar) findViewById(R.id.ProgressBar);
        mRecorder=RecordingToWav.getInstance();
        mRecorder.setOutputFile(mRecordFilePath);
        recording.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread()
                {
                    public void run()
                    {
                        if(status==0 && RecordingToWav.State.INITIALIZING == mRecorder.getState())  {
                            mRecorder.prepare();
                            mRecorder.start();
                        }
                        while (status < 100)
                        {
                            status=doWork();
                            mHandler.sendEmptyMessage(0x111);
                        }
                        if(status==100) {
                            mRecorder.stop();
                            mRecorder.reset();
                        }
                    }
                }.start();
            }
        });
        NextLocation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecordingPage5.this
                        , RecordingPage6.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public int doWork()
    {
        hasData+=10;
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return hasData;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mRecorder) {
            mRecorder.release();
        }
    }
}
