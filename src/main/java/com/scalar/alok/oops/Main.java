package com.scalar.alok.oops;

import com.scalar.alok.oops.ttt.controller.GameController;
import com.scalar.alok.oops.ttt.exceptions.DuplicateSymbolFoundException;
import com.scalar.alok.oops.ttt.exceptions.InvalidMoveException;
import com.scalar.alok.oops.ttt.exceptions.InvalidPlayerCountException;
import com.scalar.alok.oops.ttt.model.*;
import com.scalar.alok.oops.ttt.strategies.GameWinningStrategies.ColWinningStrategies;
import com.scalar.alok.oops.ttt.strategies.GameWinningStrategies.DiagonalWinningStrategies;
import com.scalar.alok.oops.ttt.strategies.GameWinningStrategies.RowWinningStrategies;
import com.scalar.alok.oops.ttt.strategies.GameWinningStrategies.WinningStrategies;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidPlayerCountException, DuplicateSymbolFoundException, InvalidMoveException {
        System.out.println("Hello world!");

        List<Player> players = List.of(
                new Player(1l, "Alok", PlayerType.HUMAN, new Symbol('X')),
                new Bot(2l, "Scalar", new Symbol('O'), BotDifficultyLable.EASY)
                );
        List<WinningStrategies> strategies = List.of(
                new RowWinningStrategies(),
                new ColWinningStrategies(),
                new DiagonalWinningStrategies()
        );
        GameController gameController = new GameController();
        Game game = gameController.startGame(2, players, strategies);
        while(game.getGameState().equals(GameState.IN_PROGRESS)) {
            //print the board
            gameController.PrintTheBoard(game);
            gameController.makeMove(game);
        }
        gameController.PrintTheBoard(game);
        System.out.println("Game state is "+ game.getGameState().toString() +" Winner is " +game.getWinner().getName().toString());
    }
}