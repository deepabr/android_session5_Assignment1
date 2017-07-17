package com.example.deepa.blinkinganimation;


import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
 import android.widget.Button;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /** Called when the activity is first created. */

    private static final String TAG = "AnimationStarter";
    ObjectAnimator textColorAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBlinkTextButton = (Button) findViewById(R.id.startBlinkTextButton);
        Button stopBlinkTextButton = (Button) findViewById(R.id.stopBlinkTextButton);
        final TextView blinkText = (TextView) findViewById(R.id.blinkTextView);

        startBlinkTextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               textColorAnim = ObjectAnimator.ofInt(blinkText, "textColor", Color.BLACK, Color.TRANSPARENT);
                textColorAnim.setDuration(1000);

                textColorAnim.setRepeatCount(ValueAnimator.INFINITE);
                textColorAnim.setRepeatMode(ValueAnimator.REVERSE);
                textColorAnim.start();
            }
        });

        stopBlinkTextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(textColorAnim != null) {
                    textColorAnim.cancel();
                    blinkText.setTextColor(Color.BLACK);
                }
            }
        });

    }
}