package com.example.TaskMVC;

import java.util.ArrayList;
import java.util.List;

public class TaskDao implements ICRUDTASK {
    List<Task> Tasks;
    static TaskDao instance = new TaskDao();
    public TaskDao() {
        Tasks = new ArrayList<>();
    }

    static TaskDao GetInstance(){
        return instance;
    }

    @Override
    public void Save(String Context) {
        Tasks.add(new Task(Context));
    }

    @Override
    public void DeleteById(String id) {
        Tasks.remove(id);
    }

    @Override
    public void Delete(Task task) {
        Tasks.remove(task);
    }

    @Override
    public void Update(String id, Task task) {
        for (Task item :Tasks) {
            if(id.equals(item.ID)){
                item = task;
            }
        }
    }

    @Override
    public Task Read(String id) {
        for (Task task : Tasks){
            if(id.equals(task.ID)){
                return task;
            }
        }
        return null;
    }

    @Override
    public Task Find(Task task) {
        for (Task item: Tasks){
            if(task.equals(item)){
                return item;
            }
        }
        return null;
    }

    @Override
    public Task FindById(String id) {
        for (Task item: Tasks){
            if(id.equals(item.ID)){
                return item;
            }
        }
        return null;
    }

    @Override
    public Task FindByDates() {
        return null;
    }

    @Override
    public List<Task> ShowAllTask() {
        return Tasks;
    }
}
