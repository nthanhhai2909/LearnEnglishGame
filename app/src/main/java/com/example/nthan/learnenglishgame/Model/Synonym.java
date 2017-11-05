package com.example.nthan.learnenglishgame.Model;

/**
 * Created by nthan on 10/31/2017.
 */

public class Synonym {
    private String word;
    private String meaning;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public Synonym(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }
}
