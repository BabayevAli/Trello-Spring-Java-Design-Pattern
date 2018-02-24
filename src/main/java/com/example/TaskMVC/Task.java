package com.example.TaskMVC;

import com.example.Randomizer;

public class Task implements ITask {
    //Members
    String TaskContext;
    String ID;
    //////////
    public Task(String taskcontext){
        this.TaskContext = taskcontext;
        ID = Randomizer.GetRandomizer();
    }

    public Task setTaskcontext(String taskcontext) {
        this.TaskContext = taskcontext;
        return this;
    }
    public String getTaskcontext() {
        return TaskContext;
    }

}
