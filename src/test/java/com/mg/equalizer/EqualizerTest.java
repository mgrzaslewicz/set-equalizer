package com.mg.equalizer;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class EqualizerTest {
    @Test
    public void shouldEqualize() {
        // given
        var equalizer = new Equalizer(new BestMoveFinder(new ImprovingMoveFinder()));
        var list1 = new ArrayList(List.of(1, 2, 3, 8)); // sum = 14
        var list2 = new ArrayList(List.of(4, 5, 6, 8)); // sum = 23
        var list3 = new ArrayList(List.of(7, 8, 9, 3, 4)); // sum = 31
        // when
        equalizer.equalize(List.of(list1, list2, list3));
        // then
        SoftAssertions.assertSoftly(it -> {
            it.assertThat(list1).containsExactly(2, 3, 8, 6, 3);
            it.assertThat(list2).containsExactly(4, 5, 8, 4, 1);
            it.assertThat(list3).containsExactly(7, 8, 9);
        });
    }

    @Test
    public void shouldGiveMoves() {
        // given
        var equalizer = new Equalizer(new BestMoveFinder(new ImprovingMoveFinder()));
        var list1 = new ArrayList(List.of(1, 2, 3, 8)) {
            @Override
            public String toString() {
                return "list1" + super.toString();
            }
        }; // sum = 14
        var list2 = new ArrayList(List.of(4, 5, 6, 8)) {
            @Override
            public String toString() {
                return "list2" + super.toString();
            }
        }; // sum = 23
        var list3 = new ArrayList(List.of(7, 8, 9, 3, 4)) {
            @Override
            public String toString() {
                return "list3:" + super.toString();
            }
        }; // sum = 31
        // when
        var moves = equalizer.equalize(List.of(list1, list2, list3));
        // then
        SoftAssertions.assertSoftly(it -> {
            it.assertThat(moves).containsExactly(
                    new Move(list3, 4, list2),
                    new Move(list2, 2, list1),
                    new Move(list3, 3, list2),
                    new Move(list2, 4, list1),
                    new Move(list1, 0, list2)
            );
        });

    }
}
