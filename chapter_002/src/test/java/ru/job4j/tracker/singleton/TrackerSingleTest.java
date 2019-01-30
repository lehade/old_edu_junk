package ru.job4j.tracker.singleton;

import org.junit.Test;
import ru.job4j.tracker.singleton.TrackerSingle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Private static final test class. Lazy loading.
 * @author Alexey Denisenko
 * @version 0.1
 * @since 30.01.2019
 */

public class TrackerSingleTest {

    @Test
    public void singletonTest() {
        TrackerSingle tracker = TrackerSingle.getInstance();
        TrackerSingle tracker2 = TrackerSingle.getInstance();
        assertThat(tracker, is(tracker2));
    }

}