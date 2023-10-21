package com.mg.equalizer;

import java.util.List;

public class SumDifferenceCalculator implements ScoreCalculator {
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

    @Override
    public ScoredMove calculate(Move move) {
        if (move == null) {
            throw new IllegalArgumentException("move cannot be null");
        }
        var sumAfterRemoving = move.getListFrom().stream().mapToInt(i -> i.intValue()).sum() - move.getListFrom().get(move.getIndexFrom());
        var sumAfterAdding = move.getListTo().stream().mapToInt(i -> i.intValue()).sum() + move.getListFrom().get(move.getIndexFrom());
        return ScoredMove.of(move, Math.abs(sumAfterAdding - sumAfterRemoving));
    }
}