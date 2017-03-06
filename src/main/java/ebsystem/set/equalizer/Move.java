package ebsystem.set.equalizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Move {
    private final List<Integer> listFrom;
    private final int indexFrom;
    private final List<Integer> listTo;
    private Integer score;
    private ListsAfterMove listsAfterMove;

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

    public ListsAfterMove getListAfterMove() {
        if (listsAfterMove == null) {
            performMoveAndCalculateScore();
        }
        return listsAfterMove;
    }

    private void performMoveAndCalculateScore() {
        List<Integer> listToAfterMove = new ArrayList<>(listTo);
        List<Integer> listFromAfterMove = new ArrayList<>(listFrom);

        int sumDifferenceBeforeMove = getAbsSumDifference(listFrom, listTo);

        listToAfterMove.add(listFrom.get(indexFrom));
        listFromAfterMove.remove(indexFrom);

        score = getAbsSumDifference(listFromAfterMove, listToAfterMove) - sumDifferenceBeforeMove;

        listsAfterMove = new ListsAfterMove(Collections.unmodifiableList(listFromAfterMove), Collections.unmodifiableList(listToAfterMove));
    }

    private int getAbsSumDifference(List<Integer> listTo, List<Integer> listFrom) {
        return Math.abs(listTo.stream().mapToInt(i -> i.intValue()).sum() - listFrom.stream().mapToInt(i -> i.intValue()).sum());
    }

    public boolean isBetterThan(Move other) {
        return other == null || Math.abs(getScore()) < Math.abs(other.getScore());
    }

    public static class ListsAfterMove {
        private final List<Integer> listFrom;
        private final List<Integer> listTo;

        public ListsAfterMove(List<Integer> listFrom, List<Integer> listTo) {
            this.listFrom = listFrom;
            this.listTo = listTo;
        }

        public List<Integer> getListFrom() {
            return listFrom;
        }

        public List<Integer> getListTo() {
            return listTo;
        }
    }

    public int getScore() {
        if (score == null) {
            performMoveAndCalculateScore();
        }
        return score;
    }

}
