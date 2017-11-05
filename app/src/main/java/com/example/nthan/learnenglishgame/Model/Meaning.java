package com.example.nthan.learnenglishgame.Model;

import java.util.List;

/**
 * Created by nthan on 10/31/2017.
 */

public class Meaning {
    private String meaning;
    private List<Synonym> synonyms;

    public Meaning(String meaning, List<Synonym> synonyms) {
        this.meaning = meaning;
        this.synonyms = synonyms;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public List<Synonym> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<Synonym> synonyms) {
        this.synonyms = synonyms;
    }
}
