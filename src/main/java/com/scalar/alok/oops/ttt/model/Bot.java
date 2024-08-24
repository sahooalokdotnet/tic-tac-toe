package com.scalar.alok.oops.ttt.model;

import com.scalar.alok.oops.ttt.factory.BotPlayingFactory;
import com.scalar.alok.oops.ttt.strategies.BotPlayingStrategies.DifficultyLevelPlayingStrategies;

public class Bot extends Player {
    private BotDifficultyLable difficultyLabel;
    private DifficultyLevelPlayingStrategies difficultyStrategy;

    public Bot(long id, String name,  Symbol symbol, BotDifficultyLable difficultyLabel) {
        super(id, name, PlayerType.BOT, symbol);
        this.difficultyLabel = difficultyLabel;
        difficultyStrategy = BotPlayingFactory.getBotPlayingStrategies(this.difficultyLabel);
    }
    public BotDifficultyLable getDifficultyLabel() {
        return difficultyLabel;
    }
    public void setDifficultyLabel(BotDifficultyLable difficultyLabel) {
        this.difficultyLabel = difficultyLabel;
    }

    @Override
    public Move move(Board board){
        //based on the difficulty level bot will play the game.
        Move move = difficultyStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }
}
