package com.example.TaskMVC;

import java.util.List;

public interface ICRUDTASK {
    void Save(String Context);
    void DeleteById(String id);
    void Delete(Task task);
    void Update(String id,Task task);
    Task Read(String id);
    Task Find(Task task);
    Task FindById(String id);
    Task FindByDates();
    List<Task> ShowAllTask();
}
