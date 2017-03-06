package ebsystem.set.equalizer;

import java.util.List;

public class BestMoveFinder {

    public Move findBetween(List<Integer> listA, List<Integer> listB) {
        assert listA.size() > 0;
        assert listB.size() > 0;

        Move bestMove = null;
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
        return bestMove;
    }

}
