package com.scalar.alok.oops.ttt.controller;

import com.scalar.alok.oops.ttt.exceptions.DuplicateSymbolFoundException;
import com.scalar.alok.oops.ttt.exceptions.InvalidMoveException;
import com.scalar.alok.oops.ttt.exceptions.InvalidPlayerCountException;
import com.scalar.alok.oops.ttt.model.Game;
import com.scalar.alok.oops.ttt.model.GameState;
import com.scalar.alok.oops.ttt.model.Player;
import com.scalar.alok.oops.ttt.strategies.GameWinningStrategies.WinningStrategies;

import java.util.List;

public class GameController {
    public Game startGame(int diamention, List<Player> players,
                          List<WinningStrategies> winningStrategiesList) throws InvalidPlayerCountException, DuplicateSymbolFoundException {
       return Game.newBuilder()
                .sedimentation(3)
                .setPlayers(players)
                .setWinningStrategies(winningStrategiesList)
                .build();
    }
    public Player getWinner(Game game) {
        return game.getWinner();
    }
    public GameState checkGameState(Game game) {
            return game.getGameState();
    }
    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove(game);
    }
    public void PrintTheBoard(Game game) {
        game.printBoard();
    }

}
