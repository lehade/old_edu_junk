package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 06.01.2019
 */

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void deleteByIdTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("test2", "testDescription", 123L);
        Item item2 = new Item("test1", "testDescription2", 1234L);
        Item item3 = new Item("test2", "testDescription3", 12345L);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        Item[] expected = new Item[2];
        expected[0] = item;
        expected[1] = item3;
        tracker.delete(item2.getId());
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void findAllTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("test2", "testDescription", 123L);
        Item item2 = new Item("test1", "testDescription2", 1234L);
        Item item3 = new Item("test2", "testDescription3", 12345L);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        Item[] expected = new Item[3];
        expected[0] = item;
        expected[1] = item2;
        expected[2] = item3;
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void findByIdTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item item2 = new Item("test2", "testDescription", 1234L);
        tracker.add(item2);
        Item expected = new Item("test2", "testDescription2", 1234L);
        expected.setId(item2.getId());
        assertThat(tracker.findById(item2.getId()).getName(), is("test2"));
    }

    @Test
    public void findByNameTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("test2", "testDescription", 123L);
        Item item2 = new Item("test1", "testDescription2", 1234L);
        Item item3 = new Item("test2", "testDescription3", 12345L);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        Item[] expected = new Item[2];
        expected[0] = item;
        expected[1] = item3;
        assertThat(tracker.findByName("test2"), is(expected));

    }
}