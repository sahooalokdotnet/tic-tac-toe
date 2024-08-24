package com.scalar.alok.oops.ttt.factory;

import com.scalar.alok.oops.ttt.model.BotDifficultyLable;
import com.scalar.alok.oops.ttt.strategies.BotPlayingStrategies.DifficultyLevelPlayingStrategies;
import com.scalar.alok.oops.ttt.strategies.BotPlayingStrategies.EasyStrategies;
import com.scalar.alok.oops.ttt.strategies.BotPlayingStrategies.HardStrategies;
import com.scalar.alok.oops.ttt.strategies.BotPlayingStrategies.MediumStrategies;

public class BotPlayingFactory {
    public static DifficultyLevelPlayingStrategies getBotPlayingStrategies(BotDifficultyLable botDifficulty) {
        if(botDifficulty.equals(BotDifficultyLable.EASY))
        {
            return new EasyStrategies();
        }
        else if(botDifficulty.equals(BotDifficultyLable.HARD))
        {
            return new HardStrategies();
        }
        else {
            return new MediumStrategies();
        }
    }
}
