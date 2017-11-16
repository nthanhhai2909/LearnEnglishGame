package com.example.nthan.learnenglishgame.View;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.nthan.learnenglishgame.Model.Record;
import com.example.nthan.learnenglishgame.Presenter.DictionaryPresenter;
import com.example.nthan.learnenglishgame.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private Button btnNewGame;
    private Button btnSetting;
    private Button btnContinue;
    private EditText test;
    private DictionaryPresenter dictionaryPresenter;
    public static List<Record> listData;
    public final static int LEVEL_ONE = 1000;
    public final static int LEVEL_TWO = 1001;
    public final static int LEVEL_THREE = 1002;
    public final static int LEVEL_FOUR = 1003;
    public final static int LEVEL_FIVE = 1004;
    public final static int LEVEL_SIX = 1005;
    public static int levelGame = LEVEL_ONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------------------------------------------------------------------------------------
        toolbar = (Toolbar)findViewById(R.id.toolbar_mainactivity);
        setSupportActionBar(toolbar);
        listData = new ArrayList<>();
        dictionaryPresenter = new DictionaryPresenter(this);
        listData = dictionaryPresenter.loadData();
        btnNewGame = (Button)findViewById(R.id.button_newgame);
        btnSetting = (Button)findViewById(R.id.button_setting);
        btnContinue = (Button)findViewById(R.id.button_continue);
        // event click button chơi mới
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("level", levelGame);
                Intent intent = new Intent(getApplication(), PlayGameActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        // Event click button tiep tuc
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Event click button cai dat
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDiaglogSetting();
            }
        });

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
        getMenuInflater().inflate(R.menu.menu_toolbar_mainactivity, menu);



        return super.onCreateOptionsMenu(menu);
    }

    public void showAlertDiaglogSetting(){

        LayoutInflater layoutInflater = getLayoutInflater();
        View alertLayout = layoutInflater.inflate(R.layout.setting_layout, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Choose level");
        alert.setView(alertLayout);
        alert.setCancelable(false);

        final RadioGroup radioGroup = (RadioGroup)alertLayout.findViewById(R.id.radiobutton_sortby_diglog);

        final AlertDialog dig = alert.create();
        dig.show();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.select_level_1:
                        levelGame = MainActivity.LEVEL_ONE;
                        dig.hide();
                        break;
                    case R.id.select_level_2:
                        levelGame = MainActivity.LEVEL_TWO;
                        dig.hide();
                        break;
                    case R.id.select_level_3:
                        levelGame = MainActivity.LEVEL_THREE;
                        dig.hide();
                        break;
                    case R.id.select_level_4:
                        levelGame = MainActivity.LEVEL_FOUR;
                        dig.hide();
                        break;
                    case R.id.select_level_5:
                        levelGame = MainActivity.LEVEL_FIVE;
                        dig.hide();
                        break;
                    case R.id.select_level_6:
                        levelGame = MainActivity.LEVEL_SIX;
                        dig.hide();
                        break;
                }
            }
        });

}

}
