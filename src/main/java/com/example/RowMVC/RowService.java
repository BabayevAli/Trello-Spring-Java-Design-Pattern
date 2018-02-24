package com.example.RowMVC;

import java.util.List;

public class RowService implements ICRUDROW{
    RowDao rowDao;
    static RowService RowServiceInstance = new RowService();


    public RowService() {
        this.rowDao = new RowDao();
    }

    public static RowService getInstance(){
        return RowServiceInstance;
    }

    @Override
    public void Save(String Context) {
        rowDao.Save(Context);
    }

    @Override
    public void DeleteById(String id) {
        rowDao.DeleteById(id);
    }

    @Override
    public void DeleteByRow(Row row) {
        rowDao.DeleteByRow(row);
    }

    @Override
    public Row Find(Row row) {
        return rowDao.Find(row);
    }

    public Row FindById(String ID){
        for (Row row:
             rowDao.getRowList()) {
            return row;
        }
        return null;
    }

    @Override
    public List<Row> getRowList() {
        return rowDao.getRowList();
    }

    @Override
    public void Update(Row row, String Context) {
        rowDao.Update(row,Context);
    }
}
