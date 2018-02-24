package com.example.BoardMVC;

import java.util.List;

public class BoardService implements ICRUDBOARD {
    BoardDao boardDao;

    static BoardService boardService = new BoardService();

    static BoardService getBoardService(){
        return boardService;
    }

    public BoardService() {
        boardDao = new BoardDao();
    }

    @Override
    public void Save(String Context) {
        boardDao.Save(Context);
    }

    @Override
    public void Update(String Context, Board board) {
        boardDao.Update(Context,board);
    }

    @Override
    public void DeleteByID(String ID) {
        boardDao.DeleteByID(ID);
    }

    @Override
    public void Delete(Board board) {
        boardDao.Delete(board);
    }

    @Override
    public Board Find(Board board) {
        return boardDao.Find(board);
    }

    @Override
    public Board FindById(String ID) {
        return boardDao.FindById(ID);
    }

    @Override
    public List<Board> GetAllBoard() {
        return boardDao.GetAllBoard();
    }
}
