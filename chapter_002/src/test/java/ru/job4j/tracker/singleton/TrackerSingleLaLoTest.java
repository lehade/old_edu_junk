package ru.job4j.tracker.singleton;

import org.junit.Test;
import ru.job4j.tracker.singleton.TrackerSingleLaLo;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for singleton lazy loading
 * @author Alexey Denisenko
 * @version 0.1
 * @since 30.01.2019
 */

public class TrackerSingleLaLoTest {

    @Test
    public void singletonTest() {
        TrackerSingleLaLo tracker = TrackerSingleLaLo.getInstance();
        TrackerSingleLaLo tracker2 = TrackerSingleLaLo.getInstance();
        assertThat(tracker, is(tracker2));
    }

}