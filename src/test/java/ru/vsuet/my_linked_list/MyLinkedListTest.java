package ru.vsuet.my_linked_list;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    Currently tests only MyLinkedList<String> class
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyLinkedListTest {
    @DisplayName("Empty list")
    static class EmptyListTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
        }

        @Test
        public void isEmpty_True() {
            assertTrue(myLinkedList.isEmpty());
        }

        @Test
        public void size_Zero() {
            assertEquals(0, myLinkedList.size());
        }

        @Test
        public void getLast_Null() {
            assertNull(myLinkedList.getLast());
        }

        @Test
        public void getZero_Null() {
            assertNull(myLinkedList.get(0));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(1));
        }
    }

    @DisplayName("Add one element")
    static class AddOneElementTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(TestConstants.FIRST);
        }

        @Test
        public void isEmpty_False() {
            assertFalse(myLinkedList.isEmpty());
        }

        @Test
        public void size_One() {
            assertEquals(1, myLinkedList.size());
        }

        @Test
        public void getLast_FIRST() {
            assertEquals(TestConstants.FIRST, myLinkedList.getLast());
        }

        @Test
        public void getZero_FIRST() {
            assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(1));
        }
    }

    @DisplayName("Add one element at zero index")
    static class AddOneElementAtZeroIndexTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(0, TestConstants.FIRST);
        }

        @Test
        public void isEmpty_False() {
            assertFalse(myLinkedList.isEmpty());
        }

        @Test
        public void size_One() {
            assertEquals(1, myLinkedList.size());
        }

        @Test
        public void getLast_FIRST() {
            assertEquals(TestConstants.FIRST, myLinkedList.getLast());
        }

        @Test
        public void getZero_FIRST() {
            assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(1));
        }
    }

    @DisplayName("Add one element at out of bounds index")
    static class AddOneElementAtOutOfBoundsIndexTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(1, TestConstants.FIRST);
        }

        @Test
        public void isEmpty_True() {
            assertTrue(myLinkedList.isEmpty());
        }

        @Test
        public void size_Zero() {
            assertEquals(0, myLinkedList.size());
        }

        @Test
        public void getLast_Null() {
            assertNull(myLinkedList.getLast());
        }

        @Test
        public void getZero_Null() {
            assertNull(myLinkedList.get(0));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(1));
        }
    }

    @DisplayName("Update non-existent element")
    static class UpdateNonExistentElementTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.update(0, TestConstants.FIRST_UPDATED);
        }

        @Test
        public void isEmpty_True() {
            assertTrue(myLinkedList.isEmpty());
        }

        @Test
        public void size_Zero() {
            assertEquals(0, myLinkedList.size());
        }

        @Test
        public void getLast_Null() {
            assertNull(myLinkedList.getLast());
        }

        @Test
        public void getZero_Null() {
            assertNull(myLinkedList.get(0));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(1));
        }
    }

    @DisplayName("Update one element")
    static class UpdateOneElementTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(0, TestConstants.FIRST);
            myLinkedList.update(0, TestConstants.FIRST_UPDATED);
        }

        @Test
        public void isEmpty_False() {
            assertFalse(myLinkedList.isEmpty());
        }

        @Test
        public void size_One() {
            assertEquals(1, myLinkedList.size());
        }

        @Test
        public void getLast_FIRST_UPDATED() {
            assertEquals(TestConstants.FIRST_UPDATED, myLinkedList.getLast());
        }

        @Test
        public void getZero_FIRST_UPDATED() {
            assertEquals(TestConstants.FIRST_UPDATED, myLinkedList.get(0));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(1));
        }
    }

    @DisplayName("Remove non-existent element")
    static class RemoveNonExistentElementTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.remove(TestConstants.FIRST);
        }

        @Test
        public void isEmpty_True() {
            assertTrue(myLinkedList.isEmpty());
        }

        @Test
        public void size_Zero() {
            assertEquals(0, myLinkedList.size());
        }

        @Test
        public void getLast_Null() {
            assertNull(myLinkedList.getLast());
        }

        @Test
        public void getZero_Null() {
            assertNull(myLinkedList.get(0));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(1));
        }
    }

    @DisplayName("Remove non-existent element by index")
    static class RemoveNonExistentElementByIndexTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.remove(0);
        }

        @Test
        public void isEmpty_True() {
            assertTrue(myLinkedList.isEmpty());
        }

        @Test
        public void size_Zero() {
            assertEquals(0, myLinkedList.size());
        }

        @Test
        public void getLast_Null() {
            assertNull(myLinkedList.getLast());
        }

        @Test
        public void getZero_Null() {
            assertNull(myLinkedList.get(0));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(1));
        }
    }

    @DisplayName("Remove one element")
    static class RemoveOneElementTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(0, TestConstants.FIRST);
            myLinkedList.remove(TestConstants.FIRST);
        }

        @Test
        public void isEmpty_True() {
            assertTrue(myLinkedList.isEmpty());
        }

        @Test
        public void size_Zero() {
            assertEquals(0, myLinkedList.size());
        }

        @Test
        public void getLast_Null() {
            assertNull(myLinkedList.getLast());
        }

        @Test
        public void getZero_Null() {
            assertNull(myLinkedList.get(0));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(1));
        }
    }

    @DisplayName("Remove by index one element")
    static class RemoveByIndexOneElementTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(0, TestConstants.FIRST);
            myLinkedList.remove(0);
        }

        @Test
        public void isEmpty_True() {
            assertTrue(myLinkedList.isEmpty());
        }

        @Test
        public void size_Zero() {
            assertEquals(0, myLinkedList.size());
        }

        @Test
        public void getLast_Null() {
            assertNull(myLinkedList.getLast());
        }

        @Test
        public void getZero_Null() {
            assertNull(myLinkedList.get(0));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(1));
        }
    }

    @DisplayName("Add two elements")
    static class AddTwoElementsTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(TestConstants.FIRST);
            myLinkedList.add(TestConstants.SECOND);
        }

        @Test
        public void isEmpty_False() {
            assertFalse(myLinkedList.isEmpty());
        }

        @Test
        public void size_Two() {
            assertEquals(2, myLinkedList.size());
        }

        @Test
        public void getLast_SECOND() {
            assertEquals(TestConstants.SECOND, myLinkedList.getLast());
        }

        @Test
        public void getZero_FIRST() {
            assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        }

        @Test
        public void getOne_SECOND() {
            assertEquals(TestConstants.SECOND, myLinkedList.get(1));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(2));
        }
    }

    @DisplayName("Add two elements by indices")
    static class AddTwoElementsByIndicesTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(0, TestConstants.FIRST);
            myLinkedList.add(1, TestConstants.SECOND);
        }

        @Test
        public void isEmpty_False() {
            assertFalse(myLinkedList.isEmpty());
        }

        @Test
        public void size_Two() {
            assertEquals(2, myLinkedList.size());
        }

        @Test
        public void getLast_SECOND() {
            assertEquals(TestConstants.SECOND, myLinkedList.getLast());
        }

        @Test
        public void getZero_FIRST() {
            assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        }

        @Test
        public void getOne_SECOND() {
            assertEquals(TestConstants.SECOND, myLinkedList.get(1));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(2));
        }
    }

    @DisplayName("Add elements out of bounds")
    static class AddElementsOutOfBindsTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(1, TestConstants.FIRST);
            myLinkedList.add(-1, TestConstants.SECOND);
        }

        @Test
        public void isEmpty_True() {
            assertTrue(myLinkedList.isEmpty());
        }

        @Test
        public void size_Zero() {
            assertEquals(0, myLinkedList.size());
        }

        @Test
        public void getLast_Null() {
            assertNull(myLinkedList.getLast());
        }

        @Test
        public void getZero_Null() {
            assertNull(myLinkedList.get(0));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(1));
        }
    }

    @DisplayName("Add three elements")
    static class AddThreeElementsTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(TestConstants.FIRST);
            myLinkedList.add(TestConstants.SECOND);
            myLinkedList.add(TestConstants.THIRD);
        }

        @Test
        public void isEmpty_False() {
            assertFalse(myLinkedList.isEmpty());
        }

        @Test
        public void size_Three() {
            assertEquals(3, myLinkedList.size());
        }

        @Test
        public void getLast_THIRD() {
            assertEquals(TestConstants.THIRD, myLinkedList.getLast());
        }

        @Test
        public void getZero_FIRST() {
            assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        }

        @Test
        public void getOne_SECOND() {
            assertEquals(TestConstants.SECOND, myLinkedList.get(1));
        }

        @Test
        public void getTwo_THIRD() {
            assertEquals(TestConstants.THIRD, myLinkedList.get(2));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(3));
        }
    }

    @DisplayName("Add three elements by indices")
    static class AddThreeElementsByIndicesTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(0, TestConstants.FIRST);
            myLinkedList.add(1, TestConstants.SECOND);
            myLinkedList.add(2, TestConstants.THIRD);
        }

        @Test
        public void isEmpty_False() {
            assertFalse(myLinkedList.isEmpty());
        }

        @Test
        public void size_Three() {
            assertEquals(3, myLinkedList.size());
        }

        @Test
        public void getLast_THIRD() {
            assertEquals(TestConstants.THIRD, myLinkedList.getLast());
        }

        @Test
        public void getZero_FIRST() {
            assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        }

        @Test
        public void getOne_SECOND() {
            assertEquals(TestConstants.SECOND, myLinkedList.get(1));
        }

        @Test
        public void getTwo_THIRD() {
            assertEquals(TestConstants.THIRD, myLinkedList.get(2));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(3));
        }
    }

    @DisplayName("Update elements out of three")
    static class UpdateElementsOutOfThreeTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(0, TestConstants.FIRST);
            myLinkedList.add(1, TestConstants.SECOND);
            myLinkedList.add(2, TestConstants.THIRD);

            myLinkedList.update(0, TestConstants.FIRST_UPDATED);
            myLinkedList.update(1, TestConstants.SECOND_UPDATED);
            myLinkedList.update(2, TestConstants.THIRD_UPDATED);
        }

        @Test
        public void isEmpty_False() {
            assertFalse(myLinkedList.isEmpty());
        }

        @Test
        public void size_Three() {
            assertEquals(3, myLinkedList.size());
        }

        @Test
        public void getLast_THIRD_UPDATED() {
            assertEquals(TestConstants.THIRD_UPDATED, myLinkedList.getLast());
        }

        @Test
        public void getZero_FIRST_UPDATED() {
            assertEquals(TestConstants.FIRST_UPDATED, myLinkedList.get(0));
        }

        @Test
        public void getOne_SECOND_UPDATED() {
            assertEquals(TestConstants.SECOND_UPDATED, myLinkedList.get(1));
        }

        @Test
        public void getTwo_THIRD_UPDATED() {
            assertEquals(TestConstants.THIRD_UPDATED, myLinkedList.get(2));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(3));
        }
    }

    @DisplayName("Remove second element out of three")
    static class RemoveSecondElementOutOfThreeTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(0, TestConstants.FIRST);
            myLinkedList.add(1, TestConstants.SECOND);
            myLinkedList.add(2, TestConstants.THIRD);

            myLinkedList.remove(TestConstants.SECOND);
        }

        @Test
        public void isEmpty_False() {
            assertFalse(myLinkedList.isEmpty());
        }

        @Test
        public void size_Two() {
            assertEquals(2, myLinkedList.size());
        }

        @Test
        public void getLast_THIRD() {
            assertEquals(TestConstants.THIRD, myLinkedList.getLast());
        }

        @Test
        public void getZero_FIRST() {
            assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        }

        @Test
        public void getOne_THIRD() {
            assertEquals(TestConstants.THIRD, myLinkedList.get(1));
        }

        @Test
        public void getTwo_Null() {
            assertNull(myLinkedList.get(2));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(3));
        }
    }

    @DisplayName("Remove second element out of three by index")
    static class RemoveSecondElementOutOfThreeByIndexTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(0, TestConstants.FIRST);
            myLinkedList.add(1, TestConstants.SECOND);
            myLinkedList.add(2, TestConstants.THIRD);

            myLinkedList.remove(1);
        }

        @Test
        public void isEmpty_False() {
            assertFalse(myLinkedList.isEmpty());
        }

        @Test
        public void size_Two() {
            assertEquals(2, myLinkedList.size());
        }

        @Test
        public void getLast_THIRD() {
            assertEquals(TestConstants.THIRD, myLinkedList.getLast());
        }

        @Test
        public void getZero_FIRST() {
            assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        }

        @Test
        public void getOne_THIRD() {
            assertEquals(TestConstants.THIRD, myLinkedList.get(1));
        }

        @Test
        public void getTwo_Null() {
            assertNull(myLinkedList.get(2));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(3));
        }
    }

    @DisplayName("Remove last element out of three")
    static class RemoveLastElementOutOfThreeTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(0, TestConstants.FIRST);
            myLinkedList.add(1, TestConstants.SECOND);
            myLinkedList.add(2, TestConstants.THIRD);

            myLinkedList.remove(TestConstants.THIRD);
        }

        @Test
        public void isEmpty_False() {
            assertFalse(myLinkedList.isEmpty());
        }

        @Test
        public void size_Two() {
            assertEquals(2, myLinkedList.size());
        }

        @Test
        public void getLast_SECOND() {
            assertEquals(TestConstants.SECOND, myLinkedList.getLast());
        }

        @Test
        public void getZero_FIRST() {
            assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        }

        @Test
        public void getOne_SECOND() {
            assertEquals(TestConstants.SECOND, myLinkedList.get(1));
        }

        @Test
        public void getTwo_Null() {
            assertNull(myLinkedList.get(2));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(3));
        }
    }

    @DisplayName("Remove last element out of three by index")
    static class RemoveLastElementOutOfThreeByIndexTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = new MyLinkedList<>();
            myLinkedList.add(0, TestConstants.FIRST);
            myLinkedList.add(1, TestConstants.SECOND);
            myLinkedList.add(2, TestConstants.THIRD);

            myLinkedList.remove(2);
        }

        @Test
        public void isEmpty_False() {
            assertFalse(myLinkedList.isEmpty());
        }

        @Test
        public void size_Two() {
            assertEquals(2, myLinkedList.size());
        }

        @Test
        public void getLast_SECOND() {
            assertEquals(TestConstants.SECOND, myLinkedList.getLast());
        }

        @Test
        public void getZero_FIRST() {
            assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        }

        @Test
        public void getOne_SECOND() {
            assertEquals(TestConstants.SECOND, myLinkedList.get(1));
        }

        @Test
        public void getTwo_Null() {
            assertNull(myLinkedList.get(2));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(3));
        }
    }

    @DisplayName("Create list of three elements")
    static class CreateListOfThreeElementsTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = MyLinkedList.of(
                    TestConstants.FIRST,
                    TestConstants.SECOND,
                    TestConstants.THIRD
            );
        }

        @Test
        public void isEmpty_False() {
            assertFalse(myLinkedList.isEmpty());
        }

        @Test
        public void size_Three() {
            assertEquals(3, myLinkedList.size());
        }

        @Test
        public void getLast_THIRD() {
            assertEquals(TestConstants.THIRD, myLinkedList.getLast());
        }

        @Test
        public void getZero_FIRST() {
            assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        }

        @Test
        public void getOne_SECOND() {
            assertEquals(TestConstants.SECOND, myLinkedList.get(1));
        }

        @Test
        public void getTwo_THIRD() {
            assertEquals(TestConstants.THIRD, myLinkedList.get(2));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(3));
        }
    }

    @DisplayName("Create list of no elements")
    static class CreateListOfNoElementsTestCase {
        private MyLinkedList<String> myLinkedList;

        @BeforeEach
        public void setUp() {
            myLinkedList = MyLinkedList.of();
        }

        @Test
        public void isEmpty_True() {
            assertTrue(myLinkedList.isEmpty());
        }

        @Test
        public void size_Zero() {
            assertEquals(0, myLinkedList.size());
        }

        @Test
        public void getLast_Null() {
            assertNull(myLinkedList.getLast());
        }

        @Test
        public void getZero_Null() {
            assertNull(myLinkedList.get(0));
        }

        @Test
        public void getNegative_Null() {
            assertNull(myLinkedList.get(-1));
        }

        @Test
        public void getOutOfBounds_Null() {
            assertNull(myLinkedList.get(1));
        }
    }
}
