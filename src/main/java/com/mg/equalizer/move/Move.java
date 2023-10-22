package com.mg.equalizer.move;

import com.mg.equalizer.list.SummingList;


public class Move {
    private final SummingList listFrom;
    private final int indexFrom;
    private final SummingList listTo;

    public Move(SummingList listFrom, int indexFrom, SummingList listTo) {
        this.listFrom = listFrom;
        this.indexFrom = indexFrom;
        this.listTo = listTo;
    }

    public int getIndexFrom() {
        return indexFrom;
    }

    public SummingList getListFrom() {
        return listFrom;
    }

    public SummingList getListTo() {
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
