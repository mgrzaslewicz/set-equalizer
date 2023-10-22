package com.mg.equalizer.score;

import com.mg.equalizer.list.SumCachingList;
import com.mg.equalizer.move.Move;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SizeCalculatorTest {

    @Test
    public void shouldCalculateMove() {
        // given
        var listA = SumCachingList.of(3, 12, 5);
        var listB = SumCachingList.of(10, 1, 2, 5, 9);
        var move = new Move(listA, 0, listB);
        var calculator = new SizeCalculator();
        // when
        var scoredMove = calculator.calculate(move);
        // then
        assertThat(scoredMove.score()).isEqualTo(4);
    }

    @Test
    public void shouldCalculateLists() {
        // given
        var listA = SumCachingList.of(3, 12, 5);
        var listB = SumCachingList.of(10, 1, 2, 5, 9);
        var calculator = new SizeCalculator();
        // when
        var distance = calculator.calculate(listA, listB);
        // then
        assertThat(distance).isEqualTo(2);
    }
}
