package com.mg.equalizer.score;

import com.mg.equalizer.list.SummingList;
import com.mg.equalizer.move.Move;
import com.mg.equalizer.move.ScoredMove;

public interface DistanceFromPerfectCalculator {
    int calculateDistance(SummingList listA, SummingList listB);

    ScoredMove calculate(Move move);
}
