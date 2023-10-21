package ebsystem.set.equalizer;

import java.util.List;

public class Move {
    private final List<Integer> listFrom;
    private final int indexFrom;
    private final List<Integer> listTo;
    private final String asString;

    public Move(List<Integer> listFrom, int indexFrom, List<Integer> listTo) {
        this.listFrom = listFrom;
        this.indexFrom = indexFrom;
        this.listTo = listTo;
        this.asString = String.format("Move %s from %s to %s", listFrom.get(indexFrom), listFrom, listTo);
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

    public boolean isBetterThan(Move other) {
        if (other == null) {
            throw new IllegalArgumentException("Other move cannot be null");
        }
        return getDifference() < other.getDifference();
    }

    /**
     * @return minimum is 0, so the lower the better
     */
    public int getDifference() {
        var sumAfterRemoving = listFrom.stream().mapToInt(i -> i.intValue()).sum() - listFrom.get(indexFrom);
        var sumAfterAdding = listTo.stream().mapToInt(i -> i.intValue()).sum() + listFrom.get(indexFrom);
        return Math.abs(sumAfterAdding - sumAfterRemoving);
    }

    @Override
    public String toString() {
        return asString;
    }

    public void accept() {
        var element = listFrom.get(indexFrom);
        listFrom.remove(indexFrom);
        listTo.add(element);
    }
}
