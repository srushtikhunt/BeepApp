package com.example.androidtonegenerator;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button btnGenTone0;
    ToggleButton tgbtnGenTone1;

    ToneGenerator toneGenerator1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGenTone0 = (Button)findViewById(R.id.gentone0);
        tgbtnGenTone1 = (ToggleButton)findViewById(R.id.gentone1);

        btnGenTone0.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                int streamType = AudioManager.STREAM_MUSIC;
                int volume = 50;
                ToneGenerator toneGenerator = new ToneGenerator(streamType, volume);
                int toneType = ToneGenerator.TONE_DTMF_0;
                int durationMs = 500;
                toneGenerator.startTone(toneType, durationMs);
            }});

        toneGenerator1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 50);

        tgbtnGenTone1.setOnCheckedChangeListener(new OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if(isChecked){
                    toneGenerator1.startTone(ToneGenerator.TONE_DTMF_1);
                }else{
                    toneGenerator1.stopTone();
                }
            }});
    }

}