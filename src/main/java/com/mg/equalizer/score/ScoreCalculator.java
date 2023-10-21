package com.mg.equalizer.score;

import com.mg.equalizer.move.Move;
import com.mg.equalizer.move.ScoredMove;

import java.util.List;

/**
 *
 */
public interface ScoreCalculator {
    int calculate(List<Integer> listA, List<Integer> listB);

    ScoredMove calculate(Move move);
}
