package com.mg.equalizer;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;


public class ApplicationIT {
    @Test
    public void shouldProcessCsvFile() throws IOException {
        // given
        final var actualOutput = "target/set-equalizer-output-" + Instant.now() + ".csv";
        var args = new String[]{"src/test/resources/set-equalizer-input.csv", actualOutput};
        // when
        Application.main(args);
        // then
        assertThat(new File(actualOutput)).hasSameTextualContentAs(new File("src/test/resources/set-equalizer-output.csv"));
    }
}
