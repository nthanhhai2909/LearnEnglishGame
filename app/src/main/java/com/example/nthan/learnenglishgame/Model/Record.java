package com.example.nthan.learnenglishgame.Model;

/**
 * Created by nthan on 11/17/2017.
 */

public class Record {
    private String word;
    private String category;
    private String articulation;
    private String meaning;

    public Record(String word, String category, String meaning, String articulation) {
        this.word = word;
        this.articulation = articulation;
        this.category = category;
        this.meaning = meaning;
    }

    public String getArticulation() {
        return articulation;
    }

    public void setArticulation(String articulation) {
        this.articulation = articulation;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
