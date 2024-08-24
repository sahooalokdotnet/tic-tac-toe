package com.scalar.alok.oops.ttt.strategies.GameWinningStrategies;

import com.scalar.alok.oops.ttt.model.Board;
import com.scalar.alok.oops.ttt.model.CellState;
import com.scalar.alok.oops.ttt.model.Move;

public class DiagonalWinningStrategies implements WinningStrategies{
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        boolean winner = true;
        if(row == col) {
            for (int i = 0; i < board.getSize(); i++) {
                if( board.getCells().get(i).get(i).getCellState() != CellState.FILLED
                        || board.getCells().get(i).get(i).getPlayer().getSymbol().getSymbol() != move.getPlayer().getSymbol().getSymbol())
                {
                    winner = false;
                    break;
                }
            }
        }
        else {
            if (row + col == board.getSize() - 1) {
                for (int i = 0; i < board.getSize(); i++) {
                    int boardSize = board.getSize();
                    if (board.getCells().get(i).get(boardSize - i - 1).getCellState() != CellState.FILLED
                            || board.getCells().get(i).get(boardSize - i - 1).getPlayer().getSymbol().getSymbol()
                            != move.getPlayer().getSymbol().getSymbol()) {
                        winner = false;
                        break;
                    }
                }
            }
            else {
                winner = false;
            }
        }
        return winner;
    }
}
