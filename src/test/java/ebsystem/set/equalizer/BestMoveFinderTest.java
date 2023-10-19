package ebsystem.set.equalizer;


import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class BestMoveFinderTest {

    @Test
    public void shouldFindBestMoveBetweenTwoLists() {
        // given
        var listA = List.of(3, 12, 5);
        var listB = List.of(10, 1, 2, 5, 9);
        var bestMoveFinder = new BestMoveFinder();
        // when
        var bestMove = bestMoveFinder.findBetween(listA, listB);
        // then
        SoftAssertions.assertSoftly(it -> {
            it.assertThat(bestMove.getListFrom()).isSameAs(listB);
            it.assertThat(bestMove.getIndexFrom()).isEqualTo(2);
            it.assertThat(bestMove.getListTo()).isSameAs(listA);
            it.assertThat(bestMove.getDifference()).isEqualTo(3);
        });
    }

    @Test
    public void shouldFindNoMoveAtAll() {
        // given
        var listA = List.of(3, 12, 5);
        var listWithEqualSum = List.of(15, 5);
        var bestMoveFinder = new BestMoveFinder();
        // when
        var bestMove = bestMoveFinder.findBetween(listA, listWithEqualSum);
        // then
        assertThat(bestMove).isNull();
    }

}
