package ru.netology.manager;

import ru.netology.domain.StringExtension;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileOpenManager {
    private final Map<StringExtension, String> map = new HashMap<>();

    public boolean tieNewApp(StringExtension extension, String app) {
        if (map.containsKey(extension))
            return false;
        map.put(extension, app);
        return true;
    }

    public String get(StringExtension extension) {
        return map.get(extension);
    }

    public boolean untieApp(StringExtension extension) {
        if (!map.containsKey(extension))
            return false;
        map.remove(extension);
        return true;
    }

    public Set<StringExtension> getAllTiedExtensions() {
        return map.keySet();
    }

    public Set<String> getAllTiedApps() {
        return new HashSet<>(map.values());
    }
}
