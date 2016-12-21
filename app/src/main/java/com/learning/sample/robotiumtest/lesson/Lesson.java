package com.learning.sample.robotiumtest.lesson;

/**
 * Created by Duc on 12/20/2016.
 */

public class Lesson {
    String title;
    String content;

    public Lesson(){

    }

    public Lesson(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }
}
