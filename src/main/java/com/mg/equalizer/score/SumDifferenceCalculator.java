package com.mg.equalizer.score;

import com.mg.equalizer.move.Move;
import com.mg.equalizer.move.ScoredMove;

import java.util.List;

public class SumDifferenceCalculator implements DistanceFromPerfectCalculator {
    @Override
    public int calculate(List<Integer> listA, List<Integer> listB) {
        if (listA == null) {
            throw new IllegalArgumentException("listA cannot be null");
        }
        if (listB == null) {
            throw new IllegalArgumentException("listB cannot be null");
        }
        return Math.abs(listA.stream().mapToInt(i -> i.intValue()).sum() - listB.stream().mapToInt(i -> i.intValue()).sum());
    }

    private int sum(List<Integer> list) {
        int result = 0;
        for (var i : list) {
            result += i;
        }
        return result;
    }

    @Override
    public ScoredMove calculate(Move move) {
        if (move == null) {
            throw new IllegalArgumentException("move cannot be null");
        }
        var sumAfterRemoving = sum(move.getListFrom()) - move.getListFrom().get(move.getIndexFrom());
        var sumAfterAdding = sum(move.getListTo()) + move.getListFrom().get(move.getIndexFrom());
        return ScoredMove.of(move, Math.abs(sumAfterAdding - sumAfterRemoving));
    }
}
