package com.example.nthan.learnenglishgame.Model;

import java.util.List;

/**
 * Created by nthan on 10/31/2017.
 */

public class Word {

    private String word;
    private String articulation;
    List<Record> records;

    public String getArticulation() {
        return articulation;
    }

    public Word(String word, String articulation,List<Record> records) {
        this.word = word;
        this.records = records;
        this.articulation = articulation;
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

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }


}
