package com.scalar.alok.oops.ttt.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> cells;

    public Board(int size) {
        this.size = size;
        cells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.cells.add(new ArrayList<>());

        for (int j = 0; j < size; j++) {
            this.cells.get(i).add(new Cell(i, j));
        }
    }

    }
    public void printBoard()
    {
        for(List<Cell> row : cells) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    System.out.print("|  |");
                } else {
                    System.out.print("|" + cell.getPlayer().getSymbol().getSymbol().toString() + "|");
                }
            }
            System.out.println();
        }

    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }



    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
