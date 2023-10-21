package com.mg.equalizer;

import java.util.List;

public class ImprovingMoveFinder {

    /**
     * @return null if no move can improve the difference between the two lists
     */
    public Move findBetween(List<Integer> listA, List<Integer> listB) {
        assert listA.size() > 0;
        assert listB.size() > 0;

        var currentDifference = Math.abs(listA.stream().mapToInt(i -> i.intValue()).sum() - listB.stream().mapToInt(i -> i.intValue()).sum());
        Move bestMove = new Move(listA, 0, listB);
        for (int listAIndex = 0; listAIndex < listA.size(); listAIndex++) {
            Move currentMove = new Move(listA, listAIndex, listB);
            if (currentMove.isBetterThan(bestMove)) {
                bestMove = currentMove;
            }
        }
        for (int listBIndex = 0; listBIndex < listB.size(); listBIndex++) {
            Move currentMove = new Move(listB, listBIndex, listA);
            if (currentMove.isBetterThan(bestMove)) {
                bestMove = currentMove;
            }
        }
        if (bestMove.getDifference() >= currentDifference) {
            return null;
        } else {
            return bestMove;
        }
    }

}
