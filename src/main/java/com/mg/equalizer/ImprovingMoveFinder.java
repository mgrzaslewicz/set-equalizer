package com.mg.equalizer;

import com.mg.equalizer.move.Move;
import com.mg.equalizer.move.ScoredMove;
import com.mg.equalizer.score.DistanceFromPerfectCalculator;
import com.mg.equalizer.score.SumDifferenceCalculator;

import java.util.List;

public class ImprovingMoveFinder {
    private final DistanceFromPerfectCalculator distanceFromPerfectCalculator;

    private ImprovingMoveFinder(DistanceFromPerfectCalculator distanceFromPerfectCalculator) {
        this.distanceFromPerfectCalculator = distanceFromPerfectCalculator;
    }


    /**
     * @return null if no move can improve the difference between the two lists
     */
    public ScoredMove findBetween(List<Integer> listA, List<Integer> listB) {
        assert listA.size() > 0;
        assert listB.size() > 0;

        var currentScore = distanceFromPerfectCalculator.calculate(listA, listB);
        var initialMove = new Move(listA, 0, listB);
        ScoredMove bestMove = distanceFromPerfectCalculator.calculate(initialMove);
        for (int listAIndex = 0; listAIndex < listA.size(); listAIndex++) {
            Move currentMove = new Move(listA, listAIndex, listB);
            var currentMoveScored = distanceFromPerfectCalculator.calculate(currentMove);
            if (currentMoveScored.isBetterThan(bestMove)) {
                bestMove = currentMoveScored;
            }
        }
        for (int listBIndex = 0; listBIndex < listB.size(); listBIndex++) {
            Move currentMove = new Move(listB, listBIndex, listA);
            var currentMoveScored = distanceFromPerfectCalculator.calculate(currentMove);
            if (currentMoveScored.isBetterThan(bestMove)) {
                bestMove = currentMoveScored;
            }
        }
        if (bestMove.score() >= currentScore) {
            return null;
        } else {
            return bestMove;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private DistanceFromPerfectCalculator distanceFromPerfectCalculator = new SumDifferenceCalculator();

        public Builder withScoreCalculator(DistanceFromPerfectCalculator distanceFromPerfectCalculator) {
            this.distanceFromPerfectCalculator = distanceFromPerfectCalculator;
            return this;
        }

        public ImprovingMoveFinder build() {
            return new ImprovingMoveFinder(distanceFromPerfectCalculator);
        }
    }

}
