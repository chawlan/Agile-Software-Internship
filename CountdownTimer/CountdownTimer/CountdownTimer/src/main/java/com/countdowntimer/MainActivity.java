package com.countdowntimer;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.countdown.R;


public class MainActivity extends Activity implements View.OnClickListener {


    private CountDownTimer countDownTimer;

    private boolean timerStarted = false;

    private Button buttonStart;

    public TextView textView;

    public EditText editText;

    private long startTime = 0;

    private final long interval = 1 * 1000 * 60;


    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        buttonStart = (Button) this.findViewById(R.id.button);

        buttonStart.setOnClickListener(this);

        textView = (TextView) this.findViewById(R.id.textView);

        editText = (EditText) this.findViewById(R.id.editText);

        textView.setText(String.valueOf(startTime));

        buttonStart.hasFocus();

    }


    @Override

    public void onClick(View v) {

        if (!timerStarted) {

            startTime = Integer.parseInt(String.valueOf(editText.getText()));

            textView.setText(editText.getText() + String.valueOf(startTime));

            countDownTimer = new CountDownTimerActivity(startTime*1000*60, interval);

            countDownTimer.start();


            timerStarted = true;

            buttonStart.setText("STOP");

        } else {

            countDownTimer.cancel();

            timerStarted = false;

            buttonStart.setText("RESTART");

        }

    }


    public class CountDownTimerActivity extends CountDownTimer {

        public CountDownTimerActivity(long startTime, long interval) {

            super(startTime, interval);
        }


        @Override

        public void onFinish() {

            textView.setText("Time's up!");

        }


        @Override

        public void onTick(long millisUntilFinished) {

            textView.setText("" + (millisUntilFinished));

        }

    }


}

