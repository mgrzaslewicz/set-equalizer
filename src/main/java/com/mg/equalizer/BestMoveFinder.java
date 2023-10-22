package com.mg.equalizer;

import com.mg.equalizer.move.ScoredMove;

import java.util.List;

public class BestMoveFinder {
    private final ImprovingMoveFinder improvingMoveFinder;

    private BestMoveFinder(ImprovingMoveFinder improvingMoveFinder) {
        this.improvingMoveFinder = improvingMoveFinder;
    }

    public ScoredMove findBestMove(List<List<Integer>> lists) {
        ScoredMove bestMove = null;
        for (int listAIndex = 0; listAIndex < lists.size(); listAIndex++) {
            for (int listBIndex = 1; listBIndex < lists.size(); listBIndex++) {
                var listA = lists.get(listAIndex);
                var listB = lists.get(listBIndex);
                var move = improvingMoveFinder.findBetween(listA, listB);
                if (move != null) {
                    if (bestMove == null || move.isBetterThan(bestMove))
                        bestMove = move;
                }
            }
        }
        return bestMove;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static BestMoveFinder defaultFinder() {
        return newBuilder().build();
    }

    public static class Builder {
        private ImprovingMoveFinder improvingMoveFinder = ImprovingMoveFinder.defaultFinder();

        public Builder withImprovingMoveFinder(ImprovingMoveFinder improvingMoveFinder) {
            this.improvingMoveFinder = improvingMoveFinder;
            return this;
        }

        public BestMoveFinder build() {
            return new BestMoveFinder(improvingMoveFinder);
        }
    }
}
