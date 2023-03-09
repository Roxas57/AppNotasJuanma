package com.example.myapplication;

public class Note {
    int id;
    String title;
    String description;
    String date;
    String type;

    public Note(){
        this.id=0;
        this.title="";
        this.description="";
        this.date="";
        this.type="";
    }

    public Note (int id,String title, String description, String date, String type){
        this.id=id;
        this.title=title;
        this.description=description;
        this.date=date;
        this.type=type;
    }

    public Note (String title, String description, String date, String status){
        this.title=title;
        this.description=description;
        this.date=date;
        this.type=type;
    }

    public Note (int id, String title, String description){
        this.id=id;
        this.title=title;
        this.description=description;
    }


    public int getId(){return id;}

    public void setId(int id){this.id=id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String createdTime) {
        this.date = createdTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String status) {
        this.type = status;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdTime='" + date + '\'' +
                ", status='" + type + '\'' +
                '}';
    }
}
