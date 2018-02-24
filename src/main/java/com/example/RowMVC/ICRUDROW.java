package com.example.RowMVC;

import java.util.List;

public interface ICRUDROW {
    void Save(String Context);
    void DeleteById(String id);
    void DeleteByRow(Row row);
    Row Find(Row row);
    List<Row> getRowList() ;
    void Update(Row row,String Context);
}
