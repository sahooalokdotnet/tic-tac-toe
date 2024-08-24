package com.scalar.alok.oops.ttt.strategies.GameWinningStrategies;

import com.scalar.alok.oops.ttt.model.Board;
import com.scalar.alok.oops.ttt.model.Move;

public interface WinningStrategies {
    boolean checkWinner(Board board, Move move);
}
