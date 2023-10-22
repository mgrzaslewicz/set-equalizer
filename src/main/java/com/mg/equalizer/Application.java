package com.mg.equalizer;

import com.mg.equalizer.list.SumCachingList;
import org.slf4j.Logger;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

public class Application {

    private static Logger logger = getLogger(Application.class);

    private static List<List<Integer>> loadCsv(String csvFile) throws IOException {
        List<List<Integer>> csvData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<Integer> row = parseLine(line);
                csvData.add(row);
            }
        }
        return csvData;
    }

    private static List<Integer> parseLine(String line) {
        String[] parts = line.split(",");
        return Arrays.stream(parts)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void saveCsv(List<List<Integer>> data, String csvFile) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            for (List<Integer> row : data) {
                String line = row.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(","));
                bw.write(line);
                bw.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        var inputCsv = args[0];
        var outputCsv = args[1];

        var lists = loadCsv(inputCsv);

        logger.info("Lists count: {}", lists.size());
        logger.info("Starting equalization...");

        var start = System.currentTimeMillis();
        var equalizer = new Equalizer(BestMoveFinder.defaultFinder());
        var moves = equalizer.equalize(lists.stream().map(SumCachingList::new).collect(Collectors.toList()));
        var end = System.currentTimeMillis();

        logger.info("Equalization finished in {}", Duration.ofMillis(end - start));
        logger.info("Moves count: {}", moves.size());
        saveCsv(lists, outputCsv);
    }
}
