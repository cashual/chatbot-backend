package com.ing.cashual.chatboting.util.collectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FileCollectorBuilder {

    private List<String> utterActionResponses;

    private Map<String,List<String>> utteranceMap = new HashMap<>();

    public void add(String line) {
        if(line.startsWith("*")) {
            String utterActionName = line.substring(line.indexOf("*") + 1).trim();
            utterActionResponses = new ArrayList<>();
            utteranceMap.put(utterActionName, utterActionResponses);
        }
        else {
            if(utterActionResponses != null)
                utterActionResponses.add(line.substring(line.indexOf("-") + 1).trim());
        }
    }

    public Map<String,List<String>> get() {
        return utteranceMap;
    }

    public FileCollectorBuilder addAll(FileCollectorBuilder fileCollectorBuilder) {
        utteranceMap.putAll(fileCollectorBuilder.get());
        return this;
    }

}
