package com.mg.equalizer;

import com.mg.equalizer.move.ScoredMove;

import java.util.ArrayList;
import java.util.List;

public class Equalizer {
    private final BestMoveFinder bestMoveFinder;

    public Equalizer(BestMoveFinder bestMoveFinder) {
        this.bestMoveFinder = bestMoveFinder;
    }

    public List<ScoredMove> equalize(List<List<Integer>> lists) {
        var result = new ArrayList<ScoredMove>();
        ScoredMove bestMove;
        while ((bestMove = bestMoveFinder.findBestMove(lists)) != null) {
            bestMove.accept();
            result.add(bestMove);
        }
        return result;
    }

}
