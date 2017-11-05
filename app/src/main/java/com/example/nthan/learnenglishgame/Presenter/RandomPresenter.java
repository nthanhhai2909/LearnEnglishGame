package com.example.nthan.learnenglishgame.Presenter;

import android.content.Context;

import java.util.Random;

/**
 * Created by nthan on 11/4/2017.
 */

public class RandomPresenter {
    private Context context;

    public RandomPresenter(Context context) {
        this.context = context;
    }

    public int random(int min, int max){
        Random rand = new Random();
        int result = min + rand.nextInt(max - min + 1);
        return result;
    }


}
