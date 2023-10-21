package ebsystem.set.equalizer;

import java.util.List;

public class BestMoveFinder {
    private final ImprovingMoveFinder improvingMoveFinder;

    public BestMoveFinder(ImprovingMoveFinder improvingMoveFinder) {
        this.improvingMoveFinder = improvingMoveFinder;
    }

    public Move findBestMove(List<List<Integer>> lists) {
        Move bestMove = null;
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
    
}
