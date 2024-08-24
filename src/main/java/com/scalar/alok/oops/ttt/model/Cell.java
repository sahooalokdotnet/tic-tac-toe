package com.scalar.alok.oops.ttt.model;

public class Cell {
    private int row;
    private int column;
    private CellState cellState;
    private Player player;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.cellState = CellState.EMPTY;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

}
