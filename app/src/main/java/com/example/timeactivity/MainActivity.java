package com.example.timeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int time=0;
    int setTime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startButton;
        EditText timeText;
        TextView textView;
        startButton = findViewById(R.id.startButton);
        timeText = findViewById(R.id.timeText);
        textView = findViewById(R.id.textView);
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timeText.getText().length()>0){
                    time = Integer.parseInt(String.valueOf(timeText.getText()));
                    setTime=time*10000;
                    CountDownTimer countDownTimer=new CountDownTimer(setTime,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            if(time<0){
                                textView.setText("끝났습니다");
                            }
                            else {
                                textView.setText(String.valueOf(time));
                            }
                            time--;
                        }

                        @Override
                        public void onFinish() {

                        }
                    };
                    countDownTimer.start();
                }
                else{
                    Toast myToast = Toast.makeText(getApplicationContext(),"값을 입력해주세요`", Toast.LENGTH_SHORT);
                    myToast.show();
                }

            }

        };
        startButton.setOnClickListener(onClickListener);

    }
}