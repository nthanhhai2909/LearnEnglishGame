package com.example.nthan.learnenglishgame.Model;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nthan on 10/31/2017.
 */

public class Dictionary {
    private Context context;
    public Dictionary(Context context) {
        this.context = context;
    }

    public List<Word> loadDatabase(){
        List<Word> list = new ArrayList<>();
        String line = "";
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try{
            inputStream = context.getAssets().open("data.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF8"));

            if(inputStream != null){
                List<String> listRawData = new ArrayList<>();
                String temp = "";
                while ((line = bufferedReader.readLine()) != null){
                    if(line.length() > 0){
                        if(line.charAt(0) == '@'){
                            listRawData.add(temp);
                            temp = "";
                            temp += line;
                        }

                        else{
                            temp += line;
                        }
                    }
                }
                listRawData.remove(0);
                list = handlingWord(listRawData);
            }
        }
        catch (IOException e){e.printStackTrace();}

        finally {
            try{
                inputStream.close();
                bufferedReader.close();
            }
            catch (Exception e){e.printStackTrace();}

        }
        return list;
    }

    public List<Word> handlingWord(List<String> listRawData){

        List<Word>listWord = new ArrayList<>();
        if(!listRawData.isEmpty())
        {
            for(int i = 0; i < listRawData.size(); i++){
                String[] temp = listRawData.get(i).split("\\*");
                String[] tempW = temp[0].split("(?=/)", 2);
                String word = tempW[0].replaceAll("@", "");
                String articulation = "";
                if(tempW.length > 1){
                    articulation = tempW[1];
                }
                List<Record> listRecord = new ArrayList<>();
                List<Meaning> listMeaning = new ArrayList<>();
                List<Synonym> listSynonym = new ArrayList<>();

                for(int j = 1; j < temp.length; j++){

                    String[] records = temp[j].split("(?=-)");
                    String category = records[0];
                    for(int k = 1; k < records.length; k++){
                        String[] meanings = records[k].split("=");
                        String meaning = meanings[0];
                        Log.e("mean", meaning);
                        if(meanings.length > 1){
                            for(int l = 1; l < meanings.length; l++){
                                String[] synonyms = meanings[l].split("\\+", 2);
                                if(synonyms.length > 1){
                                    listSynonym.add(new Synonym(synonyms[0], synonyms[1]));
                                }


                            }
                        }
                        listMeaning.add(new Meaning(meaning, listSynonym));

                    }
                    listRecord.add(new Record(category, listMeaning));
                }
                Log.e("size", String.valueOf(listMeaning.size()));
                listWord.add(new Word(word,articulation,listRecord));
            }
        }

        return  listWord;
    }
}
