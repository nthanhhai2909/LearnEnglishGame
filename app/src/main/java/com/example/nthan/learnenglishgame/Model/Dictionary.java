package com.example.nthan.learnenglishgame.Model;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
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


    public List<Record> loadDatabase() {
        List<Record> list = new ArrayList<>();
        List<String> listDataInput = readFile();
        Log.e("size: ", String.valueOf(listDataInput.size()));
        list = handleDataInput(listDataInput);
        return list;
    }


    public List<Record>handleDataInput(List<String> listDataInput){
        List<Record> list = new ArrayList<>();
        String word = "";
        String category = "";
        String articulation = "";
        String meaning = "";
        for (String element: listDataInput) {
            if(element.length() > 0 && element.charAt(0)!= ' '){
                String[]temp = element.split("/", 2);
                if(temp.length > 1){
                    word = this.handleCategory(temp[0]).get(0);
                    category = this.handleCategory(temp[0]).get(1);
                    temp = temp[1].split("/");
                    if(temp.length > 1){
                        articulation = temp[0];
                        meaning = temp[1].trim();
                    }
                }
            }
            list.add(new Record(word, meaning, meaning, articulation));
        }
        return list;
    }

    public List<String> handleCategory(String input){
        // in add n. v. / sdsd//
        List<String> list = new ArrayList<>();
        String word = null;
        String category = null;
        int indexLast = input.lastIndexOf(".");
        int indexfirst = -1;
        if(indexLast != -1){
            for(int i = indexLast - 1; i > 0; i --){
                if(input.charAt(i) == '.'){
                    for(int j = i; j >= 0; j--){
                        if(input.charAt(j) == ' '){
                            indexfirst = j;
                        }
                    }
                }
            }
            if(indexfirst == -1){
                for(int i = indexLast; i >= 0; i--){
                    if(input.charAt(i) == ' '){
                        word = input.substring(0, i);
                        category = input.substring(i, indexLast);
                        break;
                    }
                }
            }
            else{
                word = input.substring(0, indexfirst);
                category = input.substring(indexfirst, indexLast);
            }
        }
        else{
            word = input;
            category = "";
        }

        list.add(word);
        list.add(category);
        return list;
    }
    public List<String> readFile(){
        List<String> list = new ArrayList<>();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try{
            inputStream = context.getAssets().open("3000_word_comom.txt");
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                list.add(line);
            }

        }catch (Exception e){e.printStackTrace();}
        finally {
            try{
                inputStream.close();
                inputStreamReader.close();
                bufferedReader.close();
            }catch (IOException e){e.printStackTrace();}
        }
        return list;
    }
}
