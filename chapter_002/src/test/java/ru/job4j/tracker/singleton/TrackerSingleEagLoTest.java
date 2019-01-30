package ru.job4j.tracker.singleton;

import org.junit.Test;
import ru.job4j.tracker.singleton.TrackerSingleEagLo;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for singleton eager loading
 * @author Alexey Denisenko
 * @version 0.1
 * @since 30.01.2019
 */

public class TrackerSingleEagLoTest {

    @Test
    public void singletonTest() {
        TrackerSingleEagLo tracker = TrackerSingleEagLo.getInstance();
        TrackerSingleEagLo tracker2 = TrackerSingleEagLo.getInstance();
        assertThat(tracker, is(tracker2));
    }

}