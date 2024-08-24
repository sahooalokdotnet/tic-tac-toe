package com.scalar.alok.oops.ttt.model;

import java.util.Scanner;

public class Player {
    private long id;
    private String name;
    private PlayerType playerType;
    private Symbol symbol;
    private Scanner scanner;

    public Player(long id, String name, PlayerType playerType, Symbol symbol) {
        this.id = id;
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;
        scanner = new Scanner(System.in);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Move move(Board board)
    {
        System.out.println("Please enter the row where you would like to move: ");
        int row = scanner.nextInt();
        System.out.println("Please enter the col where you would like to move: ");
        int col = scanner.nextInt();
        return  new Move(new Cell(row, col),this );
    }
}
