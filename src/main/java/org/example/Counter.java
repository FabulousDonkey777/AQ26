package org.example;

import java.util.HashMap;
import java.util.Map;

public class Counter {
    private String[] words;

    public Counter(String[] words) {
        this.words = words;
    }

    public Map<String, Integer> countWords() {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }
}