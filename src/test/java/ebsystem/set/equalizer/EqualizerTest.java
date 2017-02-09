package ebsystem.set.equalizer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EqualizerTest {

    private final List<Integer> listA = Collections.unmodifiableList(Arrays.asList(3, 12, 5));
    private final List<Integer> listB = Collections.unmodifiableList(Arrays.asList(10, 1, 2, 5, 9));

    @Test
    public void testPerformMove() {
        BestMove bestMove = new BestMove(listA, 0, listB);

        BestMove.ListsAfterMove listsAfterMove = bestMove.perform();

        assertThat(listsAfterMove.getListFrom()).hasSize(listA.size() - 1).doesNotContain(3);
        assertThat(listsAfterMove.getListTo()).hasSize(listB.size() +1).containsAll(listB);
    }


}
