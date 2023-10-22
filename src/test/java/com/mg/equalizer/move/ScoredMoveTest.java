package com.mg.equalizer.move;

import com.mg.equalizer.list.SumCachingList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.mg.equalizer.list.SumCachingList.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

public class ScoredMoveTest {

    @Test
    public void shouldBeBetterMove() {
        // given
        var worseMove = new ScoredMove(new Move(emptyList(), 0, emptyList()), 2);
        var betterMove = new ScoredMove(new Move(emptyList(), 0, emptyList()), 1);
        // when
        var isBetter = betterMove.isBetterThan(worseMove);
        // then
        assertThat(isBetter).isTrue();
    }

    @Test
    public void shouldBeWorseMove() {
        // given
        var worseMove = new ScoredMove(new Move(emptyList(), 0, emptyList()), 2);
        var betterMove = new ScoredMove(new Move(emptyList(), 0, emptyList()), 1);
        // when
        var isBetter = worseMove.isBetterThan(betterMove);
        // then
        assertThat(isBetter).isFalse();
    }

    @Test
    public void shouldAcceptMove() {
        // given
        var listA = SumCachingList.of(new ArrayList<>(List.of(1, 2, 3)));
        var listB = SumCachingList.of(new ArrayList<>(List.of(4, 5, 6)));
        var move = new ScoredMove(new Move(listA, 0, listB), 1);
        // when
        move.accept();
        // then
        assertThat(listA).containsExactly(2, 3);
        assertThat(listB).containsExactly(4, 5, 6, 1);
    }

}
