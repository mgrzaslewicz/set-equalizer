package com.mg.equalizer.score;

import com.mg.equalizer.list.SummingList;
import com.mg.equalizer.move.Move;
import com.mg.equalizer.move.ScoredMove;

public class SumDifferenceCalculator implements DistanceFromPerfectCalculator {
    @Override
    public int calculate(SummingList listA, SummingList listB) {
        if (listA == null) {
            throw new IllegalArgumentException("listA cannot be null");
        }
        if (listB == null) {
            throw new IllegalArgumentException("listB cannot be null");
        }
        return Math.abs(listA.sum() - listB.sum());
    }

    @Override
    public ScoredMove calculate(Move move) {
        if (move == null) {
            throw new IllegalArgumentException("move cannot be null");
        }
        var sumAfterRemoving = move.getListFrom().sum() - move.getListFrom().get(move.getIndexFrom());
        var sumAfterAdding = move.getListTo().sum() + move.getListFrom().get(move.getIndexFrom());
        return ScoredMove.of(move, Math.abs(sumAfterAdding - sumAfterRemoving));
    }
}
