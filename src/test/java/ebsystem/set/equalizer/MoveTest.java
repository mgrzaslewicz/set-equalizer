package ebsystem.set.equalizer;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveTest {

    private final List<Integer> listA = Collections.unmodifiableList(Arrays.asList(3, 12, 5));
    private final List<Integer> listB = Collections.unmodifiableList(Arrays.asList(10, 1, 2, 5, 9));
    private static final int EXPECTED_DIFFERENCE_BETWEEN_SUM_AFTER_MOVE = 6;

    private Move move;

    @Before
    public void setUp() {
        move = new Move(listA, 0, listB);
    }

    @Test
    public void shouldMoveElementBetweenLists() {
        Move.ListsAfterMove listsAfterMove = move.getListAfterMove();

        assertThat(listsAfterMove.getListFrom()).hasSize(listA.size() - 1).doesNotContain(3);
        assertThat(listsAfterMove.getListTo()).hasSize(listB.size() + 1).containsAll(listB).contains(3);
    }

    @Test
    public void shouldCalculateMoveScore() {
        assertThat(move.getScore()).isEqualTo(EXPECTED_DIFFERENCE_BETWEEN_SUM_AFTER_MOVE);
    }

}
