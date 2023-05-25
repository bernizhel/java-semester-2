package ru.vsuet.homework_hashtable;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.vsuet.homework_hashtable.exceptions.NoSuchKeyException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HashtableTest {
    @ParameterizedTest
    @ArgumentsSource(HashtableProvider.class)
    public void create_EmptyHashtable_beEmpty(IHashtable<String, String> hashtable) {
        assertEquals(0, hashtable.size());
        assertThrows(NoSuchKeyException.class, () -> hashtable.get(TestConstants.FIRST_ENTRY[0]));
    }

    @ParameterizedTest
    @ArgumentsSource(HashtableProvider.class)
    public void addOne_empty_containOne(IHashtable<String, String> hashtable) {
        hashtable.put(TestConstants.FIRST_ENTRY[0], TestConstants.FIRST_ENTRY[1]);

        assertEquals(1, hashtable.size());
        assertEquals(TestConstants.FIRST_ENTRY[1], hashtable.get(TestConstants.FIRST_ENTRY[0]));
    }

    @ParameterizedTest
    @ArgumentsSource(HashtableProvider.class)
    public void addTwo_empty_containTwo(IHashtable<String, String> hashtable) {
        hashtable.put(TestConstants.FIRST_ENTRY[0], TestConstants.FIRST_ENTRY[1]);
        hashtable.put(TestConstants.SECOND_ENTRY[0], TestConstants.SECOND_ENTRY[1]);

        assertEquals(2, hashtable.size());
        assertEquals(TestConstants.FIRST_ENTRY[1], hashtable.get(TestConstants.FIRST_ENTRY[0]));
        assertEquals(TestConstants.SECOND_ENTRY[1], hashtable.get(TestConstants.SECOND_ENTRY[0]));
    }

    @ParameterizedTest
    @ArgumentsSource(HashtableProvider.class)
    public void removeOne_addThree_containTwo(IHashtable<String, String> hashtable) {
        hashtable.put(TestConstants.FIRST_ENTRY[0], TestConstants.FIRST_ENTRY[1]);
        hashtable.put(TestConstants.SECOND_ENTRY[0], TestConstants.SECOND_ENTRY[1]);
        hashtable.put(TestConstants.THIRD_ENTRY[0], TestConstants.THIRD_ENTRY[1]);
        hashtable.remove(TestConstants.SECOND_ENTRY[0]);

        assertEquals(2, hashtable.size());
        assertEquals(TestConstants.FIRST_ENTRY[1], hashtable.get(TestConstants.FIRST_ENTRY[0]));
        assertEquals(TestConstants.THIRD_ENTRY[1], hashtable.get(TestConstants.THIRD_ENTRY[0]));
        assertThrows(NoSuchKeyException.class, () -> hashtable.get(TestConstants.SECOND_ENTRY[0]));
    }

    @ParameterizedTest
    @ArgumentsSource(HashtableProvider.class)
    public void addMany_empty_containMany(IHashtable<String, String> hashtable) {
        hashtable.put("a", "1");
        hashtable.put("b", "2");
        hashtable.put("c", "3");
        hashtable.put("d", "4");
        hashtable.put("e", "5");
        hashtable.put("f", "6");
        hashtable.put("g", "7");
        hashtable.put("h", "8");
        hashtable.put("k", "9");
        hashtable.put("l", "10");
        hashtable.put("m", "11");
        hashtable.put("n", "12");
        hashtable.put("o", "13");

        assertEquals(13, hashtable.size());
        assertEquals("1", hashtable.get("a"));
        assertEquals("6", hashtable.get("f"));
        assertEquals("13", hashtable.get("o"));
    }
}
