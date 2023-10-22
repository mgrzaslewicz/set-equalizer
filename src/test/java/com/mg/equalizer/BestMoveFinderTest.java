package com.mg.equalizer;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class BestMoveFinderTest {

    @Test
    public void shouldFindBestMove() {
        // given
        var finder = BestMoveFinder.defaultFinder();
        var list1 = List.of(1, 2, 3); // sum = 6
        var list2 = List.of(4, 5, 6); // sum = 15
        var list3 = List.of(7, 8, 9); // sum = 24
        // when
        var bestMove = finder.findBestMove(List.of(list1, list2, list3)); // should give all sums equal to 15
        // then
        assertThat(bestMove).isNotNull();
        SoftAssertions.assertSoftly(it -> {
            it.assertThat(bestMove.move().getListFrom()).isEqualTo(list3);
            it.assertThat(bestMove.move().getListTo()).isEqualTo(list1);
            it.assertThat(bestMove.move().getIndexFrom()).isEqualTo(2);
        });
    }

}
