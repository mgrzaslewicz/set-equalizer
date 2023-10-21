package com.mg.equalizer;

import java.util.List;

/**
 *
 */
public interface ScoreCalculator {
    int calculate(List<Integer> listA, List<Integer> listB);

    ScoredMove calculate(Move move);
}
