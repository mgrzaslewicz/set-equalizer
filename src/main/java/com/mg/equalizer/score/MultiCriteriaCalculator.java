package com.mg.equalizer.score;

import com.mg.equalizer.move.Move;
import com.mg.equalizer.move.ScoredMove;

import java.util.List;

public class MultiCriteriaCalculator implements DistanceFromPerfectCalculator {
    private final List<DistanceFromPerfectCalculator> calculators;

    public MultiCriteriaCalculator(List<DistanceFromPerfectCalculator> calculators) {
        this.calculators = calculators;
    }

    @Override
    public int calculate(List<Integer> listA, List<Integer> listB) {
        return calculators.stream().mapToInt(c -> c.calculate(listA, listB)).sum();
    }

    @Override
    public ScoredMove calculate(Move move) {
        var scoreSum = calculators.stream().mapToInt(c -> c.calculate(move).score()).sum();
        return ScoredMove.of(move, scoreSum);
    }
}
