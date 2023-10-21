package com.mg.equalizer;

import java.util.List;

public class ImprovingMoveFinder {
    private final ScoreCalculator scoreCalculator;

    private ImprovingMoveFinder(ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }


    /**
     * @return null if no move can improve the difference between the two lists
     */
    public ScoredMove findBetween(List<Integer> listA, List<Integer> listB) {
        assert listA.size() > 0;
        assert listB.size() > 0;

        var currentScore = scoreCalculator.calculate(listA, listB);
        var initialMove = new Move(listA, 0, listB);
        ScoredMove bestMove = scoreCalculator.calculate(initialMove);
        for (int listAIndex = 0; listAIndex < listA.size(); listAIndex++) {
            Move currentMove = new Move(listA, listAIndex, listB);
            var currentMoveScored = scoreCalculator.calculate(currentMove);
            if (currentMoveScored.isBetterThan(bestMove)) {
                bestMove = currentMoveScored;
            }
        }
        for (int listBIndex = 0; listBIndex < listB.size(); listBIndex++) {
            Move currentMove = new Move(listB, listBIndex, listA);
            var currentMoveScored = scoreCalculator.calculate(currentMove);
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
        private ScoreCalculator scoreCalculator = new SumDifferenceCalculator();

        public Builder withScoreCalculator(ScoreCalculator scoreCalculator) {
            this.scoreCalculator = scoreCalculator;
            return this;
        }

        public ImprovingMoveFinder build() {
            return new ImprovingMoveFinder(scoreCalculator);
        }
    }

}
