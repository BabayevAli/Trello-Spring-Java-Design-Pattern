package com.example;

import com.example.BoardMVC.Board;
import com.example.BoardMVC.BoardService;
import com.example.RowMVC.Row;
import com.example.TaskMVC.Task;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class Controller{
    BoardService boardService;
    static Controller controller = new Controller();

    public static Controller GetInstance(){
        return controller;

    }

    public Controller(){
        boardService = new BoardService();
    }

    public void BoardAdd(String Context){
       boardService.Save(Context);
    }

    public void BoardRow_Add(String IDboard,String Context){
        boardService.FindById(IDboard).getRowService().Save(Context);
    }

    public void BoardRowTask_Add(String IDboard,String IDRow,String Context){
        boardService.FindById(IDboard).getRowService().FindById(IDRow).getTasks().Save(Context);
    }

    public void Board_Remove(String IDboard){
        boardService.FindById(IDboard).getRowService().DeleteById(IDboard);
    }

    public void BoardRow_Remove(String IDboard,String IDRow){
        boardService.FindById(IDboard).getRowService().DeleteById(IDRow);
    }
    public void BoardRowTask_Remove(String IDboard,String IDRow,String IDTask){
        boardService.FindById(IDboard).getRowService().FindById(IDRow).getTasks().DeleteById(IDTask);
    }

    public Board Board_Find(String IDBoard){
        return boardService.FindById(IDBoard);
    }

    public Board Board_Find(int count){
        return boardService.GetAllBoard().get(count);
    }

    public Row BoardRow_Find(String IDboard,int count){
        return boardService.FindById(IDboard).getRowService().getRowList().get(count);
    }

    public Task BoardRow_Find(String IDboard,String IDrow,int count){
        return boardService.FindById(IDboard).getRowService().FindById(IDrow).getTasks().ShowAllTask().get(count);
    }


    public Row BoardRow_Find(String IDboard,String IDRow){
        return boardService.FindById(IDboard).getRowService().FindById(IDRow);
    }

    public Task BoardRowTask_Find(String IDboard,String IDRow,String IDTask){
        return boardService.FindById(IDboard).getRowService().FindById(IDRow).getTasks().FindById(IDTask);
    }

    public void Board_Update(String IDboard,String Context){
        boardService.Update(Context,Board_Find(IDboard));
    }

    public void BoardRow_Update(String IDboard,String IDRow,String Context){
        boardService.FindById(IDboard).getRowService().Update(BoardRow_Find(IDboard,IDRow),Context);
    }

    public void BoardRowTask_Update(String IDboard,String IDRow,String IDtask,String Context){
        boardService.FindById(IDboard).getRowService().FindById(IDRow).getTasks().FindById(IDtask).setTaskcontext(Context);
    }

    public List<Board> Board_GetAllList(){
        return boardService.GetAllBoard();
    }

    public String Board_GetAllListString(){
        String Boards = "";
        for (Board board:
             boardService.GetAllBoard()) {
            Boards+=board.getHeadName();
        }
        return Boards;
    }

    public String BoardRow_GetAllListString(String IDboard) throws JSONException {
        JSONObject jsonString = new JSONObject();
        int i  = 0 ;
        for (Row row:
            boardService.FindById(IDboard).getRowService().getRowList()) {
            i++;
            JSONObject jsonObject = new JSONObject();
            int k = 0;
            for (Task b: boardService.FindById(IDboard).getRowService().Find(row).getTasks().ShowAllTask()) {
                k++;
                jsonObject.put("Row"+String.valueOf(k),b.getTaskcontext());
            }
            jsonString.put(row.getHeadName(), jsonObject);
        }
        return jsonString.toString();
    }

    public String GetIDBoard(String HeadName){
        for (Board board:
             boardService.GetAllBoard()) {
            if(HeadName.equals(board.getHeadName())){
                return board.getID();
            }
        }
        return null;
    }

    public List<Row> BoardRow_GetAllList(String IDBoard){
        return boardService.FindById(IDBoard).getRowService().getRowList();
    }

    public List<Task> BoardRowTask_GetAllList(String IDboard,String IDRow){
        return boardService.FindById(IDboard).getRowService().FindById(IDRow).getTasks().ShowAllTask();
    }

}
