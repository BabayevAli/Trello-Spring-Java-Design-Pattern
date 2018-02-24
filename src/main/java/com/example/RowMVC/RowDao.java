package com.example.RowMVC;

import java.util.ArrayList;
import java.util.List;

public class RowDao implements ICRUDROW {
    List<Row> rowList;

    static RowDao rowDao = new RowDao();

    static RowDao getBoardService(){
        return rowDao;
    }

    public RowDao() {
        this.rowList = new ArrayList<>();
    }

    @Override
    public void Save(String Context){
        rowList.add(new Row(Context));
    }

    @Override
    public void DeleteById(String id){
        for (Row row:
             rowList) {
            if(id.equals(row.getId())){
                rowList.remove(row);
            }
        }
    }

    @Override
    public void DeleteByRow(Row row){
        for (Row item:rowList
             ) {
            if(row.equals(item)){
                rowList.remove(item);
            }
        }
    }

    @Override
    public Row Find(Row row){
        for (Row item:
             rowList) {
            if(row.equals(item)){
                return row;
            }
        }
        return null;
    }

    @Override
    public List<Row> getRowList() {
        return rowList;
    }

    @Override
    public void Update(Row row,String Context){
        for (Row rows:
             rowList) {
            if(row.equals(rows)){
                row.setHeadName(Context);
            }
        }
    }
}
