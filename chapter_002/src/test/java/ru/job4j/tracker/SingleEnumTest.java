package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.singleton.TrackerSingleEnum;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 29.01.2019
 */

public class SingleEnumTest {

    TrackerSingleEnum tracker = TrackerSingleEnum.INSTANCE;

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void singletonTest() {
        TrackerSingleEnum tracker2 = TrackerSingleEnum.INSTANCE;
        assertThat(tracker, is(tracker2));
    }
}