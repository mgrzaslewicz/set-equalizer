package ebsystem.set.equalizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMove {
    private final List<Integer> listFrom;
    private final int indexFrom;
    private final List<Integer> listTo;
    private ListsAfterMove result;

    public BestMove(List<Integer> listFrom, int indexFrom, List<Integer> listTo) {
        this.listFrom = listFrom;
        this.indexFrom = indexFrom;
        this.listTo = listTo;
    }

    public int indexFrom() {
        return indexFrom;
    }

    public List<Integer> listFrom() {
        return listFrom;
    }

    public List<Integer> listTo() {
        return listTo;
    }

    public ListsAfterMove perform() {
        if (result == null) {
            calculateResultOnlyOnce();
        }
        return result;
    }

    private void calculateResultOnlyOnce() {
        List<Integer> listToAfterMove = new ArrayList<Integer>(listTo);
        List<Integer> listFromAfterMove = new ArrayList<Integer>(listFrom);

        listToAfterMove.add(listFrom.get(indexFrom));
        listFromAfterMove.remove(indexFrom);

        result = new ListsAfterMove(Collections.unmodifiableList(listFromAfterMove), Collections.unmodifiableList(listToAfterMove));
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
}
