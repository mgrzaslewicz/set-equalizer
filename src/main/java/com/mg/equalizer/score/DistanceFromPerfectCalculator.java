package com.mg.equalizer.score;

import com.mg.equalizer.list.SummingList;
import com.mg.equalizer.move.Move;
import com.mg.equalizer.move.ScoredMove;

import java.util.List;

public interface DistanceFromPerfectCalculator {
    int calculate(SummingList listA, SummingList listB);

    ScoredMove calculate(Move move);
}
