package com.ing.cashual.chatboting.util;

import com.ing.cashual.chatboting.util.collectors.FileCollector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FileUtils {

    public static Map<String,List<String>> getUtterActionMap(Path path) throws IOException {

        final Map<String, List<String>> utterActionMap = Files.lines(path)
                .map(line -> line.trim())
                .filter(line -> !line.isEmpty() && !line.startsWith("#"))
                .collect(new FileCollector());

        return utterActionMap;
    }


}
