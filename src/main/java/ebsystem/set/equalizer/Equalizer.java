package ebsystem.set.equalizer;

import java.util.List;

public class Equalizer {
    private final BestMoveFinder bestMoveFinder;

    public Equalizer(BestMoveFinder bestMoveFinder) {
        this.bestMoveFinder = bestMoveFinder;
    }

    public void equalize(List<List<Integer>> lists) {
        Move bestMove;
        while ((bestMove = bestMoveFinder.findBestMove(lists)) != null) {
            var listFrom = bestMove.getListFrom();
            var listTo = bestMove.getListTo();
            var indexFrom = bestMove.getIndexFrom();
            var element = listFrom.get(indexFrom);
            listFrom.remove(indexFrom);
            listTo.add(element);
        }
    }

}
