package com.scalar.alok.oops.ttt.strategies.BotPlayingStrategies;

import com.scalar.alok.oops.ttt.model.Board;
import com.scalar.alok.oops.ttt.model.Move;

public interface DifficultyLevelPlayingStrategies {
    Move makeMove(Board board);
}
