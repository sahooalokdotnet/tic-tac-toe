package com.scalar.alok.oops.ttt.strategies.BotPlayingStrategies;

import com.scalar.alok.oops.ttt.model.Board;
import com.scalar.alok.oops.ttt.model.Cell;
import com.scalar.alok.oops.ttt.model.CellState;
import com.scalar.alok.oops.ttt.model.Move;

import java.util.List;

public class EasyStrategies implements DifficultyLevelPlayingStrategies{
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> listCell : board.getCells())
        {
            for (Cell cell: listCell)
            {
                if(cell.getCellState().equals(CellState.EMPTY))
                {
                    return new Move(cell, null);
                }
            }
        }
        return null;
    }
}
