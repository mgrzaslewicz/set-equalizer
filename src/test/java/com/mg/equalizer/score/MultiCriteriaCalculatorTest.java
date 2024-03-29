package com.mg.equalizer.score;

import com.mg.equalizer.list.SumCachingList;
import com.mg.equalizer.move.Move;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiCriteriaCalculatorTest {
    @Test
    public void shouldCalculateMove() {
        // given
        var listA = SumCachingList.of(3, 12, 5);
        var listB = SumCachingList.of(10, 1, 2, 5, 9);
        var move = new Move(listA, 0, listB);
        var calculator = new MultiCriteriaCalculator(List.of(new SizeCalculator(), new SumDifferenceCalculator()));
        // when
        var scoredMove = calculator.calculate(move);
        // then
        assertThat(scoredMove.distanceFromPerfect()).isEqualTo(17);
    }

    @Test
    public void shouldCalculateLists() {
        // given
        var listA = SumCachingList.of(3, 12, 5);
        var listB = SumCachingList.of(10, 1, 2, 5, 9);
        var calculator = new MultiCriteriaCalculator(List.of(new SizeCalculator(), new SumDifferenceCalculator()));
        // when
        var distance = calculator.calculateDistance(listA, listB);
        // then
        assertThat(distance).isEqualTo(9);
    }
}
