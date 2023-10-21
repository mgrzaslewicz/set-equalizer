package ebsystem.set.equalizer;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class EqualizerTest {
    @Test
    public void shouldEqualize() {
        // given
        var equalizer = new Equalizer(new BestMoveFinder(new ImprovingMoveFinder()));
        var list1 = new ArrayList(List.of(1, 2, 3)); // sum = 6
        var list2 = new ArrayList(List.of(4, 5, 6)); // sum = 15
        var list3 = new ArrayList(List.of(7, 8, 9)); // sum = 24
        // when
        equalizer.equalize(List.of(list1, list2, list3));
        // then
        SoftAssertions.assertSoftly(it -> {
            it.assertThat(list1).containsExactly(1, 2, 3, 9);
            it.assertThat(list2).containsExactly(4, 5, 6);
            it.assertThat(list3).containsExactly(7, 8);
        });
    }
}
