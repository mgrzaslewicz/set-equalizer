package com.mg.equalizer.score;

import com.mg.equalizer.move.Move;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SumDifferenceCalculatorTest {
    @Test
    public void shouldCalculateMove() {
        // given
        var listA = List.of(3, 12, 5);
        var listB = List.of(10, 1, 2, 5, 9);
        var move = new Move(listA, 0, listB);
        var calculator = new SumDifferenceCalculator();
        // when
        var scoredMove = calculator.calculate(move);
        // then
        assertThat(scoredMove.score()).isEqualTo(13);
    }

    @Test
    public void shouldCalculateMove2() {
        // given
        var listA = List.of(3, 12, 5);
        var listB = List.of(10, 1, 2, 5, 9);
        var move = new Move(listB, 2, listA);
        var calculator = new SumDifferenceCalculator();
        // when
        var scoredMove = calculator.calculate(move);
        // then
        assertThat(scoredMove.score()).isEqualTo(3);
    }

    @Test
    public void shouldCalculateLists() {
        // given
        var listA = List.of(3, 12, 5);
        var listB = List.of(10, 1, 2, 5, 9);
        var calculator = new SumDifferenceCalculator();
        // when
        var distance = calculator.calculate(listA, listB);
        // then
        assertThat(distance).isEqualTo(7);
    }
}
