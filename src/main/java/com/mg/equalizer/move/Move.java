package com.mg.equalizer.move;

import java.util.List;

public class Move {
    private final List<Integer> listFrom;
    private final int indexFrom;
    private final List<Integer> listTo;

    public Move(List<Integer> listFrom, int indexFrom, List<Integer> listTo) {
        this.listFrom = listFrom;
        this.indexFrom = indexFrom;
        this.listTo = listTo;
    }

    public int getIndexFrom() {
        return indexFrom;
    }

    public List<Integer> getListFrom() {
        return listFrom;
    }

    public List<Integer> getListTo() {
        return listTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Move move = (Move) o;

        if (indexFrom != move.indexFrom) return false;
        if (!listFrom.equals(move.listFrom)) return false;
        return listTo.equals(move.listTo);
    }

    @Override
    public int hashCode() {
        int result = listFrom.hashCode();
        result = 31 * result + indexFrom;
        result = 31 * result + listTo.hashCode();
        return result;
    }
}
