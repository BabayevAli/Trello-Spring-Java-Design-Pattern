package com.example.RowMVC;

import com.example.Randomizer;
import com.example.TaskMVC.TaskService;

public class Row implements IRow {

    String HeadName;
    String Id;


    TaskService tasks;
    public Row(String RowName){
        tasks = new TaskService();
        HeadName = RowName;
        Id = Randomizer.GetRandomizer();
    }

    public String getHeadName() {
        return HeadName;
    }


    public void setHeadName(String headName) {
        HeadName = headName;
    }


    public String getId() {
        return Id;
    }
    public TaskService getTasks() {
        return tasks;
    }


    public void setId(String id) {
        Id = id;
    }

}
