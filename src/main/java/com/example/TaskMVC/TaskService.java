package com.example.TaskMVC;

import java.util.List;

public class TaskService implements ICRUDTASK {
    TaskDao taskDao;
    static TaskService TaskService = new TaskService();

    public TaskService(){
        taskDao = new TaskDao();
    }

    public static TaskService getTaskControllerInstance() {
        return TaskService;
    }


    @Override
    public void Save(String Context) {
        taskDao.Save(Context);
    }

    @Override
    public void DeleteById(String id) {
        taskDao.DeleteById(id);
    }

    @Override
    public void Delete(Task task) {
        taskDao.Delete(task);
    }

    @Override
    public void Update(String id, Task task) {
        taskDao.Update(id,task);
    }

    @Override
    public Task Read(String id) {
        return taskDao.Read(id);
    }

    @Override
    public Task Find(Task task) {
        return taskDao.Find(task);
    }

    @Override
    public Task FindById(String id) {
        return taskDao.FindById(id);
    }

    @Override
    public Task FindByDates() {
        return null;
    }

    @Override
    public List<Task> ShowAllTask() {
        return taskDao.ShowAllTask();
    }
}
