package ru.netology.domain;

import lombok.EqualsAndHashCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@EqualsAndHashCode
public class StringExtension {
    public static final String REGEX_STRING = "\\.[a-zA-Z]+";
    public static final Pattern REGEX_PATTERN = Pattern.compile(REGEX_STRING);

    private String string;

    public StringExtension(String string) {
        setString(string);
    }

    public void setString(String string) {
        Matcher matcher = REGEX_PATTERN.matcher(string);
        if (!matcher.matches())
            throw new IllegalArgumentException("String of extension must satisfy regex: \"\\.[a-zA-Z]+\"");
        this.string = string.toLowerCase();
    }

    public String getString() {
        return string;
    }

    public String toString() {
        return string;
    }

}
