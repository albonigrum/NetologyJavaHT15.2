package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.domain.StringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FileOpenManagerTest {
    FileOpenManager fileOpenManager = new FileOpenManager();

    @Nested
    public class Empty {
        @Test
        void shouldNotUntieApp() {
            assertFalse(fileOpenManager.untieApp(new StringExtension(".html")));
        }

        @Test
        void shouldNotGet() {
            assertNull(fileOpenManager.get(new StringExtension(".html")));
        }

        @Test
        void shouldReturnEmptySets() {
            assertEquals(Collections.emptySet(), fileOpenManager.getAllTiedExtensions());
            assertEquals(Collections.emptySet(), fileOpenManager.getAllTiedApps());
        }
    }

    @Nested
    public class SingleItem {
        @BeforeEach
        void setUp() {
            fileOpenManager.tieNewApp(new StringExtension(".html"), "Browser");
        }

        @Test
        void shouldUntieApp() {
            assertTrue(fileOpenManager.untieApp(new StringExtension(".html")));
        }

        @Test
        void shouldGet() {
            assertEquals("Browser", fileOpenManager.get(new StringExtension(".html")));
        }

        @Test
        void shouldReturnSingleItemSets() {
            assertEquals(Collections.singleton(new StringExtension(".html")), fileOpenManager.getAllTiedExtensions());
            assertEquals(Collections.singleton("Browser"), fileOpenManager.getAllTiedApps());
        }
    }

    @Nested
    public class MultipleItems {
        @BeforeEach
        void setUp() {
            fileOpenManager.tieNewApp(new StringExtension(".html"), "Browser");
            fileOpenManager.tieNewApp(new StringExtension(".JPG"), "Paint");
            fileOpenManager.tieNewApp(new StringExtension(".doc"), "Microsoft Word");
            fileOpenManager.tieNewApp(new StringExtension(".docx"), "Microsoft Word");
            fileOpenManager.tieNewApp(new StringExtension(".txt"), "Microsoft Word");
        }

        @Test
        void shouldNotAddExistedElem() {
            assertFalse(fileOpenManager.tieNewApp(new StringExtension(".html"), "Browser2"));
        }

        @Test
        void shouldGetAllTiedExtensions() {
            Set<StringExtension> expected = new HashSet<>(Arrays.asList(
                    new StringExtension(".html"),
                    new StringExtension(".JPG"),
                    new StringExtension(".doc"),
                    new StringExtension(".docx"),
                    new StringExtension(".txt")
            ));

            Set<StringExtension> actual = fileOpenManager.getAllTiedExtensions();

            assertEquals(expected, actual);
        }

        @Test
        void shouldGetAllTiedApps() {
            Set<String> expected = new HashSet<>(Arrays.asList("Browser", "Paint", "Microsoft Word"));

            Set<String> actual = fileOpenManager.getAllTiedApps();

            assertEquals(expected, actual);
        }
    }



}