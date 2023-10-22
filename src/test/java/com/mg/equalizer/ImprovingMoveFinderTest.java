package com.mg.equalizer;


import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ImprovingMoveFinderTest {

    @Test
    public void shouldFindBestMoveBetweenTwoLists() {
        // given
        var listA = List.of(3, 12, 5);
        var listB = List.of(10, 1, 2, 5, 9);
        var finder = ImprovingMoveFinder.defaultFinder();
        // when
        var move = finder.findBetween(listA, listB);
        // then
        SoftAssertions.assertSoftly(it -> {
            it.assertThat(move.move().getListFrom()).isSameAs(listB);
            it.assertThat(move.move().getIndexFrom()).isEqualTo(2);
            it.assertThat(move.move().getListTo()).isSameAs(listA);
            it.assertThat(move.score()).isEqualTo(3);
        });
    }

    @Test
    public void shouldFindNoMove() {
        // given
        var listA = List.of(3, 12, 5);
        var listWithEqualSum = List.of(15, 5);
        var finder = ImprovingMoveFinder.defaultFinder();
        // when
        var move = finder.findBetween(listA, listWithEqualSum);
        // then
        assertThat(move).isNull();
    }

}
