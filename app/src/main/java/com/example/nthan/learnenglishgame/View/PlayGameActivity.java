package com.example.nthan.learnenglishgame.View;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nthan.learnenglishgame.Model.Record;
import com.example.nthan.learnenglishgame.Presenter.RandomPresenter;
import com.example.nthan.learnenglishgame.R;

import java.util.Timer;
import java.util.TimerTask;

public class PlayGameActivity extends AppCompatActivity {

    public final  static int min = 0;
    public static int max = 0;

    public final static int QUESTION_NUMBER = 50;
    public final static int RANDOM_LEVEL_ONE = 300;
    public final static int RANDOM_LEVEL_TWO = 500;
    public final static int RANDOM_LEVEL_THREE = 800;
    public final static int RANDOM_LEVEL_FOUR = 1100;
    public final static int RANDOM_LEVEL_FIVE = 2000;
    public final static int RANDOM_LEVEL_SIX = 3000;
    public final static int CHECK_A = 2000;
    public final static int CHECK_B = 2001;
    public final static int CHECK_C = 2002;
    private RandomPresenter randomPresenter;
    private Toolbar toolbar;
    private TextView textViewTime;
    private TextView textViewWord;
    private TextView textViewResultA;
    private TextView textViewResultB;
    private TextView textViewResultC;
    private LinearLayout linearLayoutA;
    private LinearLayout linearLayoutB;
    private LinearLayout linearLayoutC;
    private ImageButton imageButtonA;
    private ImageButton imageButtonB;
    private ImageButton imageButtonC;
    private Button buttonSubmit;
    private MyTimer myTimerMain;
    private int countQuestion = 0;
    private int check = -1;
    private int resultMain = -2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);


        toolbar = (Toolbar)findViewById(R.id.toolbar_playgameactivity);
        setSupportActionBar(toolbar);
        textViewTime = (TextView)findViewById(R.id.textview_time);
        textViewWord = (TextView)findViewById(R.id.textview_word_question);
        textViewResultA = (TextView)findViewById(R.id.textview_result_a);
        textViewResultB = (TextView)findViewById(R.id.textview_result_b);
        textViewResultC = (TextView)findViewById(R.id.textview_result_c);
        linearLayoutA = (LinearLayout)findViewById(R.id.linear_check_a);
        linearLayoutB = (LinearLayout)findViewById(R.id.linear_check_b);
        linearLayoutC = (LinearLayout)findViewById(R.id.linear_check_c);
        imageButtonA = (ImageButton)findViewById(R.id.checkbox_choose_a);
        imageButtonB = (ImageButton)findViewById(R.id.checkbox_choose_b);
        imageButtonC = (ImageButton)findViewById(R.id.checkbox_choose_c);
        buttonSubmit = (Button)findViewById(R.id.button_submit);
        randomPresenter = new RandomPresenter(this);
        Bundle bundle = this.getIntent().getExtras();
        max = getLevelGame(bundle);
        playGame();

        linearLayoutA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAnswer();
                check = PlayGameActivity.CHECK_A;
                imageButtonA.setBackgroundResource(R.drawable.check);
            }
        });
        linearLayoutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAnswer();
                check = PlayGameActivity.CHECK_B;
                imageButtonB.setBackgroundResource(R.drawable.check);
            }
        });
        linearLayoutC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAnswer();
                check = PlayGameActivity.CHECK_C;
                imageButtonC.setBackgroundResource(R.drawable.check);
            }
        });

        imageButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAnswer();
                check = PlayGameActivity.CHECK_A;
                imageButtonA.setBackgroundResource(R.drawable.check);
            }
        });

        imageButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAnswer();
                check = PlayGameActivity.CHECK_B;
                imageButtonB.setBackgroundResource(R.drawable.check);
            }
        });

        imageButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAnswer();
                check = PlayGameActivity.CHECK_C;
                imageButtonC.setBackgroundResource(R.drawable.check);
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processResult(check, resultMain);
                myTimerMain.stop();;
            }
        });
    }

    public void processResult(int check, int result){
        if(check == result){
            displayDiaglogResultTrue();
        }
        else{
            displayDiaglogResultFalse();
        }
        resetAnswer();
    }

    public void displayDiaglogResultFalse(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("RESULT");
        alert.setMessage("You have answered wrong!!!");
        alert.setCancelable(false);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                playGame();
            }
        });
        final AlertDialog dig = alert.create();
        dig.show();
    }

    public void displayDiaglogResultTrue(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("RESULT");
        alert.setMessage("you answered correctly <3");
        alert.setCancelable(false);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                playGame();
            }
        });
        final AlertDialog dig = alert.create();
        dig.show();
    }

    public void resetAnswer(){
        imageButtonA.setBackgroundResource(R.drawable.uncheck);
        imageButtonB.setBackgroundResource(R.drawable.uncheck);
        imageButtonC.setBackgroundResource(R.drawable.uncheck);
    }

    public class MyTimer{
        int time = 20;
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                time--;
                if(time > 0){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            toolbar.setTitle("Question: " + String.valueOf(countQuestion));
                            textViewTime.setText(String.valueOf(time));
                        }
                    });
                }
                else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            processResult(check,resultMain);
                            stop();

                        }
                    });

                }
            }
        };

        public void start(){
            countQuestion++;
            timer.scheduleAtFixedRate(timerTask, 1000, 1000);

        }

        public void stop(){
            timer.cancel();
            timer.purge();
        }
    }

    public void playGame(){

        this.check = -1;
        this.resultMain = -2;
        MyTimer myTimer = new MyTimer();
        myTimer.start();
        myTimerMain = myTimer;

        String contentA = "";
        String contentB = "";
        String contentC = "";
        String resultStr = "";
        //Show word
        int index = randomPresenter.random(min, max);
        Record word = MainActivity.listData.get(index);
        textViewWord.setText(word.getWord() + " " + "/" + word.getArticulation() + "/");
        resultStr = word.getMeaning();

        //--------------------------------------------------------------------------------------

        // select value true
        int result = randomPresenter.random(min,3);
        //A select value = true
        if(result == 1){
            resultMain = CHECK_A;
            contentA = resultStr;

        }
        //------------------------------------------------------------------------------------------
        //A select value = false
        else{
            contentA = MainActivity.listData.get(randomPresenter.random(min, max)).getMeaning();
        }

        //B select value = true
        if(result == 2){
            resultMain = CHECK_B;
            contentB = resultStr;
        }
        else{
            contentB = MainActivity.listData.get(randomPresenter.random(min, max)).getMeaning();
        }
        //B select value = true
        if(result == 3){
            resultMain = CHECK_C;
            contentC = resultStr;
        }
        else{
            contentC = MainActivity.listData.get(randomPresenter.random(min, max)).getMeaning();
        }
        textViewResultA.setText(contentA);
        textViewResultB.setText(contentB);
        textViewResultC.setText(contentC);

        //------------------------------------------------------------------------------------------
    }

    public int getLevelGame(Bundle bundle){
        int level = bundle.getInt("level");

        int max = this.RANDOM_LEVEL_ONE;
        if(level == MainActivity.LEVEL_ONE){
            max = this.RANDOM_LEVEL_ONE;
        }
        else if( level ==MainActivity.LEVEL_TWO){
            max = this.RANDOM_LEVEL_TWO;
        }
        else if(level == MainActivity.LEVEL_THREE){
            max = this.RANDOM_LEVEL_THREE;
        }
        else if(level == MainActivity.LEVEL_FOUR){
            max = this.RANDOM_LEVEL_FOUR;
        }
        else if(level == MainActivity.LEVEL_FIVE){
            max = this.RANDOM_LEVEL_FIVE;
        }
        else if(level == MainActivity.LEVEL_SIX){
            max = this.RANDOM_LEVEL_SIX;
        }
        return max;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_playgameactivity, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
