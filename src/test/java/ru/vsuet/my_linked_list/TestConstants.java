package ru.vsuet.my_linked_list;

import java.util.List;

class TestConstants {
    private TestConstants() {
        super();
    }

    static final String FIRST = "FIRST";
    static final String SECOND = "SECOND";
    static final String THIRD = "THIRD";

    static final String FIRST_UPDATED = "FIRST_UPDATED";
    static final String SECOND_UPDATED = "SECOND_UPDATED";
    static final String THIRD_UPDATED = "THIRD_UPDATED";

    static final List<String> FIRST_DEEP_OBJECT = List.of(
            FIRST
    );

    static final List<String> SECOND_DEEP_OBJECT = List.of(
            SECOND
    );

    static final List<String> THIRD_DEEP_OBJECT = List.of(
            THIRD
    );

    static final List<String> FIRST_DEEP_OBJECT_UPDATED = List.of(
            FIRST_UPDATED
    );

    static final List<String> SECOND_DEEP_OBJECT_UPDATED = List.of(
            SECOND_UPDATED
    );

    static final List<String> THIRD_DEEP_OBJECT_UPDATED = List.of(
            THIRD_UPDATED
    );
}
