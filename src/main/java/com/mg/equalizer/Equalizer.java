package com.mg.equalizer;

import java.util.List;

public class Equalizer {
    private final BestMoveFinder bestMoveFinder;

    public Equalizer(BestMoveFinder bestMoveFinder) {
        this.bestMoveFinder = bestMoveFinder;
    }

    public void equalize(List<List<Integer>> lists) {
        Move bestMove;
        while ((bestMove = bestMoveFinder.findBestMove(lists)) != null) {
            bestMove.accept();
        }
    }

}
