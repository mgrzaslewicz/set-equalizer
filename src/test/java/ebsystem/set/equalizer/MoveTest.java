package ebsystem.set.equalizer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveTest {

    @Test
    public void shouldMoveElementBetweenLists() {
        // given
        var listA = List.of(3, 12, 5);
        var listB = List.of(10, 1, 2, 5, 9);
        var move = new Move(listA, 0, listB);
        // when
        Move.ListsAfterMove listsAfterMove = move.getListAfterMove();
        // then
        assertThat(listsAfterMove.getListFrom()).containsExactly(10, 1, 2, 5, 9, 3);
    }

}
