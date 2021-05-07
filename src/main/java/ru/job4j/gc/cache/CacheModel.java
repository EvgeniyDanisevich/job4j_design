package ru.job4j.gc.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class CacheModel {
    private final Map<String, SoftReference<String>> data = new HashMap<>();

    public CacheModel(List<String> files) {
        files.forEach(s -> this.data.put(s, null));
    }

    public String get(String key) {
        String text = data.get(key) == null ? null : data.get(key).get();
        if (text == null) {
            StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
            download(stringJoiner, key);
            text = stringJoiner.toString();
        }
        return text;
    }

    private void download(StringJoiner stringJoiner, String key) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(key))) {
            bufferedReader.lines().forEach(stringJoiner::add);
            SoftReference<String> softReference = new SoftReference<>(stringJoiner.toString());
            data.put(key, softReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}