package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.Singleton.TrackerSingleEnum;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SingleEnumTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        //Tracker tracker = new Tracker();
        TrackerSingleEnum tracker = TrackerSingleEnum.INSTANCE;
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

}