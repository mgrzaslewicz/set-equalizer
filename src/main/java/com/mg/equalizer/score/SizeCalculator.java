package com.mg.equalizer.score;

import com.mg.equalizer.list.SummingList;
import com.mg.equalizer.move.Move;
import com.mg.equalizer.move.ScoredMove;

public class SizeCalculator implements DistanceFromPerfectCalculator {
    @Override
    public int calculateDistance(SummingList listA, SummingList listB) {
        return Math.abs(listA.size() - listB.size());
    }

    @Override
    public ScoredMove calculate(Move move) {
        var score = Math.abs(move.getListFrom().size() - 2 - (move.getListTo().size()));
        return ScoredMove.of(move, score);
    }
}
