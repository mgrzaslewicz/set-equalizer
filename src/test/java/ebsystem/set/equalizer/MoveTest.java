package ebsystem.set.equalizer;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveTest {

    private final List<Integer> listA = ImmutableList.of(3, 12, 5);
    private final List<Integer> listB = ImmutableList.of(10, 1, 2, 5, 9);
    private final List<Integer> expectedElementsAfterMove = ImmutableList.of(10, 1, 2, 5, 9, 3);

    private Move move;

    @Before
    public void setUp() {
        move = new Move(listA, 0, listB);
    }

    @Test
    public void shouldMoveElementBetweenLists() {
        Move.ListsAfterMove listsAfterMove = move.getListAfterMove();
        assertThat(listsAfterMove.getListFrom()).containsExactlyElementsOf(expectedElementsAfterMove);
    }

}
