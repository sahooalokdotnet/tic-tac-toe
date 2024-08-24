package com.scalar.alok.oops.ttt.strategies.GameWinningStrategies;

import com.scalar.alok.oops.ttt.model.Board;
import com.scalar.alok.oops.ttt.model.CellState;
import com.scalar.alok.oops.ttt.model.Move;

public class ColWinningStrategies implements  WinningStrategies{
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        boolean winner = true;
        for(int i = 0; i < board.getSize(); i++)
        {
            if( board.getCells().get(i).get(col).getCellState() != CellState.FILLED
                    || board.getCells().get(i).get(col).getPlayer().getSymbol().getSymbol() != move.getPlayer().getSymbol().getSymbol())
            {
                winner = false;
                break;
            }
        }
        return winner;
    }
}
