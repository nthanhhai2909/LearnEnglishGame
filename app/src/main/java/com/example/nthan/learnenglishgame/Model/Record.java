package com.example.nthan.learnenglishgame.Model;

import java.util.List;

/**
 * Created by nthan on 10/31/2017.
 */

public class Record {
    private String category;
    private List<Meaning> meanings;
    public Record(String category, List<Meaning> meanings) {
        this.category = category;
        this.meanings = meanings;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

}
