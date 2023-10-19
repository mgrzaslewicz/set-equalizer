package ebsystem.set.equalizer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveTest {

    @Test
    public void shouldCalculateDifference() {
        // given
        var listA = List.of(3, 12, 5);
        var listB = List.of(10, 1, 2, 5, 9);
        var move = new Move(listA, 0, listB);
        // when
        var difference = move.getDifference();
        // then
        assertThat(difference).isEqualTo(13);
    }

    @Test
    public void shouldCalculateDifference2() {
        // given
        var listA = List.of(3, 12, 5);
        var listB = List.of(10, 1, 2, 5, 9);
        var move = new Move(listB, 2, listA);
        // when
        var difference = move.getDifference();
        // then
        assertThat(difference).isEqualTo(3);
    }

    @Test
    public void shouldBeBetterMove() {
        // given
        var listA = List.of(3, 12, 5);
        var listB = List.of(10, 1, 2, 5, 9);
        var worseMove = new Move(listA, 0, listB);
        var betterMove = new Move(listB, 2, listA);
        // when
        var isBetter = betterMove.isBetterThan(worseMove);
        // then
        assertThat(isBetter).isTrue();
    }

    @Test
    public void shouldBeWorseMove() {
        // given
        var listA = List.of(3, 12, 5);
        var listB = List.of(10, 1, 2, 5, 9);
        var worseMove = new Move(listA, 0, listB);
        var betterMove = new Move(listB, 2, listA);
        // when
        var isWorse = worseMove.isBetterThan(betterMove);
        // then
        assertThat(isWorse).isFalse();
    }

}
