package com.mg.equalizer.move;

public record ScoredMove(Move move, int distanceFromPerfect) {
    public static ScoredMove of(Move move, int score) {
        return new ScoredMove(move, score);
    }

    public boolean isBetterThan(ScoredMove other) {
        if (other == null) {
            throw new IllegalArgumentException("Other move cannot be null");
        }
        return this.distanceFromPerfect < other.distanceFromPerfect;
    }

    public void accept() {
        var element = move.getListFrom().get(move.getIndexFrom());
        move.getListFrom().remove(move.getIndexFrom());
        move.getListTo().add(element);
    }

}
