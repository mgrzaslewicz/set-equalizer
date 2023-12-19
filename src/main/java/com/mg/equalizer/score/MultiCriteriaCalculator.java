package com.mg.equalizer.score;

import com.mg.equalizer.list.SummingList;
import com.mg.equalizer.move.Move;
import com.mg.equalizer.move.ScoredMove;

import java.util.List;

public class MultiCriteriaCalculator implements DistanceFromPerfectCalculator {
    private final List<DistanceFromPerfectCalculator> calculators;

    public MultiCriteriaCalculator(List<DistanceFromPerfectCalculator> calculators) {
        this.calculators = calculators;
    }

    @Override
    public int calculateDistance(SummingList listA, SummingList listB) {
        int sum = 0;
        for (var calculator : calculators) {
            sum += calculator.calculateDistance(listA, listB);
        }
        return sum;
    }

    @Override
    public ScoredMove calculate(Move move) {
        var sum = 0;
        for (var calculator : calculators) {
            sum += calculator.calculate(move).distanceFromPerfect();
        }
        return ScoredMove.of(move, sum);
    }
}
