package com.example.BoardMVC;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    List<Board> boardList;

    static BoardDao boardDao = new BoardDao();

    static BoardDao getBoardService(){
        return boardDao;
    }


    public BoardDao() {
        boardList = new ArrayList<>();
    }

    public void Save(String Context){
        boardList.add(new Board(Context));
    }

    public void Update(String Context,Board board){
        for (Board boards:boardList
             ) {
            if(board.equals(boards)){
                boards.setHeadName(Context);
            }
        }
    }

    public void DeleteByID(String ID){
        for (Board boards:boardList)
        {
            if(ID.equals(boards.getID())){
                boardList.remove(boards);
            }
        }
    }

    public void Delete(Board board){
        for (Board boards:boardList)
        {
            if(board.equals(boards)){
                boardList.remove(boards);
            }
        }
    }

    public Board Find(Board board){
        for (Board boards:boardList)
        {
            if(board.equals(boards)){
                return boards;
            }
        }
        return null;
    }

    public Board FindById(String ID){
        for (Board boards:boardList){
            if(ID.equals(boards.getID())){
                return boards;
            }
        }
        return null;
    }

    public List<Board> GetAllBoard(){
        return boardList;
    }

}
