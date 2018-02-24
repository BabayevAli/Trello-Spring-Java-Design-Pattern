package com.example.BoardMVC;

import com.example.Randomizer;
import com.example.RowMVC.Row;
import com.example.RowMVC.RowService;

import java.util.ArrayList;
import java.util.List;

public class Board implements IBoard{


    RowService rowService;
    String HeadName;
    String ID;
    public Board(String HeadName) {
        this.rowService = new RowService();
        this.HeadName = HeadName;
        ID = Randomizer.GetRandomizer();
    }

    public String getHeadName() {
        return HeadName;
    }

    public void setHeadName(String headName) {
        HeadName = headName;
    }

    public String getID() {
        return ID;
    }

    public RowService getRowService() {
        return rowService;
    }

}
