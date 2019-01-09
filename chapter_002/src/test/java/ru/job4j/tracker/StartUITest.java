package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 08.01.2019
 */

public class StartUITest {

    private final Tracker tracker = new Tracker();

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void getById() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void getByName() {
        Item item = tracker.add(new Item("test name", "desc"));
        Item item1 = tracker.add(new Item("test name1", "desc"));
        Item item2 = tracker.add(new Item("test name", "desc2"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        Item[] expected = new Item[2];
        expected[0] = item;
        expected[1] = item2;
        assertThat(tracker.findByName("test name"), is(expected));
    }

    @Test
    public void deleteItem() {
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Item item3 = tracker.add(new Item("test name3", "desc3"));
        Input input = new StubInput(new String[]{"3", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        tracker.delete(item2.getId());
        Item[] expected = new Item[2];
        expected[0] = item;
        expected[1] = item3;
        assertThat(tracker.findAll(), is(expected));
    }

    private final StringBuilder menu = new StringBuilder()
            .append("Меню.")
            .append(System.lineSeparator())
            .append("0. Add new Item")
            .append(System.lineSeparator())
            .append("1. Show all items")
            .append(System.lineSeparator())
            .append("2. Edit item")
            .append(System.lineSeparator())
            .append("3. Delete item")
            .append(System.lineSeparator())
            .append("4. Find item by Id")
            .append(System.lineSeparator())
            .append("5. Find items by name")
            .append(System.lineSeparator())
            .append("6. Exit Program")
            .append(System.lineSeparator());

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Test
    public void showAll() {
        System.setOut(new PrintStream(out));
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Item item3 = tracker.add(new Item("test name3", "desc3"));
        Item item4 = tracker.add(new Item("test name4", "desc4"));
        Item item5 = tracker.add(new Item("test name5", "desc5"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Вывод всех заявок --------------")
                                .append(System.lineSeparator())
                                .append("Id: " + item.getId() + " Name: test name Description: desc")
                                .append(System.lineSeparator())
                                .append("Id: " + item2.getId() + " Name: test name2 Description: desc2")
                                .append(System.lineSeparator())
                                .append("Id: " + item3.getId() + " Name: test name3 Description: desc3")
                                .append(System.lineSeparator())
                                .append("Id: " + item4.getId() + " Name: test name4 Description: desc4")
                                .append(System.lineSeparator())
                                .append("Id: " + item5.getId() + " Name: test name5 Description: desc5")
                                .append(System.lineSeparator())
                                .append("------------ Конец --------------")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
        System.setOut(this.stdout);
    }
}