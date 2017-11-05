package com.example.nthan.learnenglishgame.View;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.nthan.learnenglishgame.Model.Dictionary;
import com.example.nthan.learnenglishgame.Model.Word;
import com.example.nthan.learnenglishgame.Presenter.DictionaryPresenter;
import com.example.nthan.learnenglishgame.Presenter.RandomPresenter;
import com.example.nthan.learnenglishgame.R;

import java.util.ArrayList;
import java.util.List;

public class PlayGameActivity extends AppCompatActivity {

    public final  static int min = 0;
    public static int max = 0;

    public final static int QUESTION_NUMBER = 50;
    public final static int RANDOM_LEVEL_ONE = 300;
    public final static int RANDOM_LEVEL_TWO = 500;
    public final static int RANDOM_LEVEL_THREE = 800;
    public final static int RANDOM_LEVEL_FOUR = 1100;
    public final static int RANDOM_LEVEL_FIVE = 2000;
    public final static int RANDOM_LEVEL_SIX = 3500;
    public final static int RANDOM_LEVEL_SEVEN = 6000;
    public final static int RANDOM_LEVEL_EIGHT = 10000;
    public final static int RANDOM_LEVEL_NINE = 10000;
    public final static int RANDOM_LEVEL_TEN = 15000;
    private RandomPresenter randomPresenter;
    private DictionaryPresenter dictionaryPresenter;
    private List<Word> listData;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        listData = new ArrayList<>();
        dictionaryPresenter = new DictionaryPresenter(this);

        toolbar = (Toolbar)findViewById(R.id.toolbar_playgameactivity);
        setSupportActionBar(toolbar);
        listData = dictionaryPresenter.loadData();
        randomPresenter = new RandomPresenter(this);
        Bundle bundle = this.getIntent().getExtras();
        max = getLevelGame(bundle);
    }

    public void playGame(){


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
        else if(level == MainActivity.LEVEL_SEVEN){
            max = this.RANDOM_LEVEL_SEVEN;
        }
        else if(level == MainActivity.LEVEL_EIGHT){
            max = this.RANDOM_LEVEL_EIGHT;
        }
        else if(level == MainActivity.LEVEL_NINE){
            max = this.RANDOM_LEVEL_NINE;
        }
        else if(level == MainActivity.LEVEL_TEN){
            max = this.RANDOM_LEVEL_TEN;
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
