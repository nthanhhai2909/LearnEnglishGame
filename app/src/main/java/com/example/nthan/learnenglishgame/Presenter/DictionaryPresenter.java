package com.example.nthan.learnenglishgame.Presenter;

import android.content.Context;

import com.example.nthan.learnenglishgame.Model.Dictionary;
import com.example.nthan.learnenglishgame.Model.Word;

import java.util.List;

/**
 * Created by nthan on 10/31/2017.
 */

public class DictionaryPresenter {

    private Context context;
    private Dictionary dictionary;

    public List<Word> loadData(){
        return dictionary.loadDatabase();
    }

    public DictionaryPresenter(Context context) {
        this.context = context;
        this.dictionary = new Dictionary(context);
    }

}
