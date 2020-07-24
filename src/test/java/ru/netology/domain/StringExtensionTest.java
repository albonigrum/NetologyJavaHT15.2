package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringExtensionTest {

    @Test
    void shouldConstruct() {
        StringExtension stringExtension = new StringExtension(".HTML");

        assertEquals(".html", stringExtension.getString());
    }

    @Test
    void shouldNoConstruct() {
        assertThrows(IllegalArgumentException.class, () -> new StringExtension("HTML"));
        assertThrows(IllegalArgumentException.class, () -> new StringExtension(".HTML5"));
        assertThrows(IllegalArgumentException.class, () -> new StringExtension(".5HTML"));
        assertThrows(IllegalArgumentException.class, () -> new StringExtension("..HTML"));
        assertThrows(IllegalArgumentException.class, () -> new StringExtension(".HTML."));
        assertThrows(IllegalArgumentException.class, () -> new StringExtension(".ФTML"));
        assertThrows(IllegalArgumentException.class, () -> new StringExtension("\\.HTML"));
        assertThrows(IllegalArgumentException.class, () -> new StringExtension(".HTML\n"));

    }
}