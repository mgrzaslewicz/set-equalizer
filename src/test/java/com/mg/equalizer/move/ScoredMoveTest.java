package com.mg.equalizer.move;

import com.mg.equalizer.move.Move;
import com.mg.equalizer.move.ScoredMove;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoredMoveTest {

    @Test
    public void shouldBeBetterMove() {
        // given
        var worseMove = new ScoredMove(new Move(List.of(), 0, List.of()), 2);
        var betterMove = new ScoredMove(new Move(List.of(), 0, List.of()), 1);
        // when
        var isBetter = betterMove.isBetterThan(worseMove);
        // then
        assertThat(isBetter).isTrue();
    }

    @Test
    public void shouldBeWorseMove() {
        // given
        var worseMove = new ScoredMove(new Move(List.of(), 0, List.of()), 2);
        var betterMove = new ScoredMove(new Move(List.of(), 0, List.of()), 1);
        // when
        var isBetter = worseMove.isBetterThan(betterMove);
        // then
        assertThat(isBetter).isFalse();
    }

    @Test
    public void shouldAcceptMove() {
        // given
        var listA = new ArrayList(List.of(1, 2, 3));
        var listB = new ArrayList(List.of(4, 5, 6));
        var move = new ScoredMove(new Move(listA, 0, listB), 1);
        // when
        move.accept();
        // then
        assertThat(listA).containsExactly(2, 3);
        assertThat(listB).containsExactly(4, 5, 6, 1);
    }

}
