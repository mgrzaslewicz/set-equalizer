package com.mg.equalizer.score;

import com.mg.equalizer.move.Move;
import com.mg.equalizer.move.ScoredMove;

import java.util.List;

public class SizeCalculator implements DistanceFromPerfectCalculator {
    @Override
    public int calculate(List<Integer> listA, List<Integer> listB) {
        return Math.abs(listA.size() - listB.size());
    }

    @Override
    public ScoredMove calculate(Move move) {
        var score = Math.abs(move.getListFrom().size() - 2 - (move.getListTo().size()));
        return ScoredMove.of(move, score);
    }
}
