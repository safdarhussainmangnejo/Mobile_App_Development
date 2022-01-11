package com.example.myapplication;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Story implements Serializable {

    private String text;
    private List<String> placeholders;
    private int filledIn;
    private boolean htmlMode;

    {
        text ="";
        placeholders = new ArrayList<String>();
        filledIn=0;
        htmlMode=true;
        clear();
    }

    public Story(){
        //empty
    }

    public Story(Scanner stream){
        read(stream);
    }
    public Story(InputStream stream){ read(stream); }

    public void clear(){
        text="";
        placeholders.clear();
        filledIn=0;
    }

    /** replaces the next unfilled placeholder with the given word */
    public void FilledInPlaceholder(String word){
        if(!isFilledIn()){
            text = text.replace("<" + filledIn + ">", word);
            filledIn++;
        }
    }

    /** returns the next placeholder such as "adjective",
     *  or empty string if story is completely filled in already */
    public String getNextPlaceholder(){
        if(isFilledIn()){
            return "";
        }else{
            return placeholders.get(filledIn);
        }
    }
    /** returns total number of placeholders in the story */
    public int getPlaceholderCount(){
        return placeholders.size();
    }

    /** returns how many placeholders still need to be filled in */
    public int getPlaceholderRemainingCount(){
        return placeholders.size()-filledIn;
    }
    public boolean isFilledIn(){
        return filledIn >=placeholders.size();
    }

    public void read(InputStream stream) {
        read(new Scanner(stream));
    }

    public void read(Scanner input){
        while (input.hasNext()){
            String word = input.next();

            if(word.startsWith("<") && word.endsWith(">")){
                if(htmlMode){
                    text+= "<b><" + placeholders.size()+"></b>";
                }else{
                    text+= "<" + placeholders.size()+">";
                }
                String placeholder = word.substring(1,word.length()-1).replace("-"," ");
                placeholders.add(placeholder);
            }else{
                if(!text.isEmpty()){
                    text+=" ";
                }
                text+=word;
            }
        }
    }
    @Override
    public String toString(){ return  text;}
}