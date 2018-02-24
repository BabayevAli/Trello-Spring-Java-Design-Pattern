package com.example.BoardMVC;

import java.util.List;

public interface ICRUDBOARD {
    public void Save(String Context);
    public void Update(String Context,Board board);
    public void DeleteByID(String ID);
    public void Delete(Board board);
    public Board Find(Board board);
    public Board FindById(String ID);
    public List<Board> GetAllBoard();
}
