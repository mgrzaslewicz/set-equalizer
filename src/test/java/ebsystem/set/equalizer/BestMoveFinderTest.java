package ebsystem.set.equalizer;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BestMoveFinderTest {
    private final List<Integer> listA = ImmutableList.of(3, 12, 5);
    private final List<Integer> listB = ImmutableList.of(10, 1, 2, 5, 9);
    private final BestMoveFinder bestMoveFinder = new BestMoveFinder();

    @Test
    public void shouldFindBestMoveBetweenTwoLists() {
        Move bestMove = bestMoveFinder.findBetween(listA, listB);

        assertThat(bestMove.getListFrom()).isEqualTo(listB);
        assertThat(bestMove.getScore()).isEqualTo(1);
    }

}
