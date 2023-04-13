package ru.vsuet.my_linked_list;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyLinkedListTest {
    private MyLinkedList<String> myLinkedList;

    @BeforeEach
    public void setUp() {
        myLinkedList = new MyLinkedList<>();
    }

    @Test
    public void getState_whenEmpty_ShouldBeOk() {
        assertTrue(myLinkedList.isEmpty());
        assertEquals(0, myLinkedList.size());
        assertNull(myLinkedList.getLast());
        assertNull(myLinkedList.get(0));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(1));
    }

    @Test
    public void getState_whenAddOne_ShouldBeOk() {
        myLinkedList.add(TestConstants.FIRST);

        assertFalse(myLinkedList.isEmpty());
        assertEquals(1, myLinkedList.size());
        assertEquals(TestConstants.FIRST, myLinkedList.getLast());
        assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(1));
    }

    @Test
    public void getState_whenAddOneAtZero_ShouldBeOk() {
        myLinkedList.add(0, TestConstants.FIRST);

        assertFalse(myLinkedList.isEmpty());
        assertEquals(1, myLinkedList.size());
        assertEquals(TestConstants.FIRST, myLinkedList.getLast());
        assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(1));
    }

    @Test
    public void getState_whenAddOneAtOutOfBounds_ShouldBeOk() {
        myLinkedList.add(1, TestConstants.FIRST);

        assertTrue(myLinkedList.isEmpty());
        assertEquals(0, myLinkedList.size());
        assertNull(myLinkedList.getLast());
        assertNull(myLinkedList.get(0));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(1));
    }

    @Test
    public void getState_whenUpdatedNonExistent_ShouldBeOk() {
        myLinkedList.update(0, TestConstants.FIRST_UPDATED);

        assertTrue(myLinkedList.isEmpty());
        assertEquals(0, myLinkedList.size());
        assertNull(myLinkedList.getLast());
        assertNull(myLinkedList.get(0));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(1));
    }

    @Test
    public void getState_whenAddAndUpdateOne_ShouldBeOk() {
        myLinkedList.add(0, TestConstants.FIRST);
        myLinkedList.update(0, TestConstants.FIRST_UPDATED);

        assertFalse(myLinkedList.isEmpty());
        assertEquals(1, myLinkedList.size());
        assertEquals(TestConstants.FIRST_UPDATED, myLinkedList.getLast());
        assertEquals(TestConstants.FIRST_UPDATED, myLinkedList.get(0));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(1));
    }

    @Test
    public void getState_whenRemoveNonExistent_ShouldBeOk() {
        myLinkedList.remove(TestConstants.FIRST);

        assertTrue(myLinkedList.isEmpty());
        assertEquals(0, myLinkedList.size());
        assertNull(myLinkedList.getLast());
        assertNull(myLinkedList.get(0));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(1));
    }

    @Test
    public void getState_whenRemoveByIndexNonExistent_ShouldBeOk() {
        myLinkedList.remove(0);

        assertTrue(myLinkedList.isEmpty());
        assertEquals(0, myLinkedList.size());
        assertNull(myLinkedList.getLast());
        assertNull(myLinkedList.get(0));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(1));
    }

    @Test
    public void getState_whenAddAndRemoveOne_ShouldBeOk() {
        myLinkedList.add(0, TestConstants.FIRST);
        myLinkedList.remove(TestConstants.FIRST);

        assertTrue(myLinkedList.isEmpty());
        assertEquals(0, myLinkedList.size());
        assertNull(myLinkedList.getLast());
        assertNull(myLinkedList.get(0));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(1));
    }

    @Test
    public void getState_whenAddAndRemoveByIndexOne_ShouldBeOk() {
        myLinkedList.add(0, TestConstants.FIRST);
        myLinkedList.remove(0);

        assertTrue(myLinkedList.isEmpty());
        assertEquals(0, myLinkedList.size());
        assertNull(myLinkedList.getLast());
        assertNull(myLinkedList.get(0));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(1));
    }

    @Test
    public void getState_whenAddTwo_ShouldBeOk() {
        myLinkedList.add(TestConstants.FIRST);
        myLinkedList.add(TestConstants.SECOND);

        assertFalse(myLinkedList.isEmpty());
        assertEquals(2, myLinkedList.size());
        assertEquals(TestConstants.SECOND, myLinkedList.getLast());
        assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        assertEquals(TestConstants.SECOND, myLinkedList.get(1));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(2));
    }

    @Test
    public void getState_whenAddByIndexTwo_ShouldBeOk() {
        myLinkedList.add(0, TestConstants.FIRST);
        myLinkedList.add(1, TestConstants.SECOND);

        assertFalse(myLinkedList.isEmpty());
        assertEquals(2, myLinkedList.size());
        assertEquals(TestConstants.SECOND, myLinkedList.getLast());
        assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        assertEquals(TestConstants.SECOND, myLinkedList.get(1));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(2));
    }

    @Test
    public void getState_whenAddTwoOutOfBounds_ShouldBeOk() {
        myLinkedList.add(1, TestConstants.FIRST);
        myLinkedList.add(-1, TestConstants.SECOND);

        assertTrue(myLinkedList.isEmpty());
        assertEquals(0, myLinkedList.size());
        assertNull(myLinkedList.getLast());
        assertNull(myLinkedList.get(0));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(1));
    }

    @Test
    public void getState_whenAddThree_ShouldBeOk() {
        myLinkedList.add(TestConstants.FIRST);
        myLinkedList.add(TestConstants.SECOND);
        myLinkedList.add(TestConstants.THIRD);

        assertFalse(myLinkedList.isEmpty());
        assertEquals(3, myLinkedList.size());
        assertEquals(TestConstants.THIRD, myLinkedList.getLast());
        assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        assertEquals(TestConstants.SECOND, myLinkedList.get(1));
        assertEquals(TestConstants.THIRD, myLinkedList.get(1));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(3));
    }

    @Test
    public void getState_whenAddByIndexThree_ShouldBeOk() {
        myLinkedList.add(0, TestConstants.FIRST);
        myLinkedList.add(1, TestConstants.SECOND);
        myLinkedList.add(2, TestConstants.THIRD);

        assertFalse(myLinkedList.isEmpty());
        assertEquals(3, myLinkedList.size());
        assertEquals(TestConstants.THIRD, myLinkedList.getLast());
        assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        assertEquals(TestConstants.SECOND, myLinkedList.get(1));
        assertEquals(TestConstants.THIRD, myLinkedList.get(1));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(3));
    }

    @Test
    public void getState_whenAddAndUpdateThree_ShouldBeOk() {
        myLinkedList.add(0, TestConstants.FIRST);
        myLinkedList.add(1, TestConstants.SECOND);
        myLinkedList.add(2, TestConstants.THIRD);
        myLinkedList.update(0, TestConstants.FIRST_UPDATED);
        myLinkedList.update(1, TestConstants.SECOND_UPDATED);
        myLinkedList.update(2, TestConstants.THIRD_UPDATED);

        assertFalse(myLinkedList.isEmpty());
        assertEquals(3, myLinkedList.size());
        assertEquals(TestConstants.THIRD_UPDATED, myLinkedList.getLast());
        assertEquals(TestConstants.FIRST_UPDATED, myLinkedList.get(0));
        assertEquals(TestConstants.SECOND_UPDATED, myLinkedList.get(1));
        assertEquals(TestConstants.THIRD_UPDATED, myLinkedList.get(1));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(3));
    }

    @Test
    public void getState_whenAddThreeRemoveSecond_ShouldBeOk() {
        myLinkedList.add(0, TestConstants.FIRST);
        myLinkedList.add(1, TestConstants.SECOND);
        myLinkedList.add(2, TestConstants.THIRD);
        myLinkedList.remove(TestConstants.SECOND);

        assertFalse(myLinkedList.isEmpty());
        assertEquals(2, myLinkedList.size());
        assertEquals(TestConstants.THIRD, myLinkedList.getLast());
        assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        assertEquals(TestConstants.THIRD, myLinkedList.get(1));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(2));
    }

    @Test
    public void getState_whenAddThreeRemoveByIndexSecond_ShouldBeOk() {
        myLinkedList.add(0, TestConstants.FIRST);
        myLinkedList.add(1, TestConstants.SECOND);
        myLinkedList.add(2, TestConstants.THIRD);
        myLinkedList.remove(1);

        assertFalse(myLinkedList.isEmpty());
        assertEquals(2, myLinkedList.size());
        assertEquals(TestConstants.THIRD, myLinkedList.getLast());
        assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        assertEquals(TestConstants.THIRD, myLinkedList.get(1));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(2));
    }

    @Test
    public void getState_whenAddThreeRemoveThird_ShouldBeOk() {
        myLinkedList.add(0, TestConstants.FIRST);
        myLinkedList.add(1, TestConstants.SECOND);
        myLinkedList.add(2, TestConstants.THIRD);
        myLinkedList.remove(TestConstants.THIRD);

        assertFalse(myLinkedList.isEmpty());
        assertEquals(2, myLinkedList.size());
        assertEquals(TestConstants.SECOND, myLinkedList.getLast());
        assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        assertEquals(TestConstants.SECOND, myLinkedList.get(1));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(2));
    }

    @Test
    public void getState_whenAddThreeRemoveByIndexThird_ShouldBeOk() {
        myLinkedList.add(0, TestConstants.FIRST);
        myLinkedList.add(1, TestConstants.SECOND);
        myLinkedList.add(2, TestConstants.THIRD);
        myLinkedList.remove(2);

        assertFalse(myLinkedList.isEmpty());
        assertEquals(2, myLinkedList.size());
        assertEquals(TestConstants.SECOND, myLinkedList.getLast());
        assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        assertEquals(TestConstants.SECOND, myLinkedList.get(1));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(2));
    }

    @Test
    public void createList_whenGiveThree_ShouldBeOk() {
        myLinkedList = MyLinkedList.of(
                TestConstants.FIRST,
                TestConstants.SECOND,
                TestConstants.THIRD
        );

        assertFalse(myLinkedList.isEmpty());
        assertEquals(3, myLinkedList.size());
        assertEquals(TestConstants.THIRD, myLinkedList.getLast());
        assertEquals(TestConstants.FIRST, myLinkedList.get(0));
        assertEquals(TestConstants.SECOND, myLinkedList.get(1));
        assertEquals(TestConstants.THIRD, myLinkedList.get(1));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(3));
    }

    @Test
    public void createList_whenGiveNothing_ShouldBeOk() {
        myLinkedList = MyLinkedList.of();

        assertTrue(myLinkedList.isEmpty());
        assertEquals(0, myLinkedList.size());
        assertNull(myLinkedList.getLast());
        assertNull(myLinkedList.get(0));
        assertNull(myLinkedList.get(-1));
        assertNull(myLinkedList.get(1));
    }
}
