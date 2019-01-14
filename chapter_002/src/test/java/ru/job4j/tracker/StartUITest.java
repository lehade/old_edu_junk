package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
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
        Item item = tracker.add(new Item("test name2", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void getById() {
        Item item = tracker.add(new Item("test name3", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name3"));
    }

    @Test
    public void getByName() {
        Item item = tracker.add(new Item("test", "desc"));
        Item item1 = tracker.add(new Item("test name1", "desc"));
        Item item2 = tracker.add(new Item("test", "desc2"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        Item[] expected = new Item[2];
        expected[0] = item;
        expected[1] = item2;
        assertThat(tracker.findByName("test"), is(expected));
    }

    /**
     * Общие объекты для тестов.
     */
    private Item item = tracker.add(new Item("test name", "desc"));
    private Item item2 = tracker.add(new Item("test name2", "desc2"));
    private Item item3 = tracker.add(new Item("test name3", "desc3"));
    private Item item4 = tracker.add(new Item("test name4", "desc4"));
    private Item item5 = tracker.add(new Item("test name5", "desc5"));

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
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
    }

    @Test
    public void editItemErr() {
        Input input = new StubInput(new String[]{"2", "666", "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Редактирование заявки --------------")
                                .append(System.lineSeparator())
                                .append("------------ Ошибка выполнения --------------")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    @Test
    public void deleteItemTest() {
        Input input = new StubInput(new String[]{"3", item.getId(), "3", item2.getId(), "3", item3.getId(), "3", item4.getId(), "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Удаление заявки --------------")
                                .append(System.lineSeparator())
                                .append("------------ Готово --------------")
                                .append(System.lineSeparator())
                                .append(menu)
                                .append("------------ Удаление заявки --------------")
                                .append(System.lineSeparator())
                                .append("------------ Готово --------------")
                                .append(System.lineSeparator())
                                .append(menu)
                                .append("------------ Удаление заявки --------------")
                                .append(System.lineSeparator())
                                .append("------------ Готово --------------")
                                .append(System.lineSeparator())
                                .append(menu)
                                .append("------------ Удаление заявки --------------")
                                .append(System.lineSeparator())
                                .append("------------ Готово --------------")
                                .append(System.lineSeparator())
                                .append(menu)
                                .append("------------ Вывод всех заявок --------------")
                                .append(System.lineSeparator())
                                .append("Id: " + item5.getId() + " Name: test name5 Description: desc5")
                                .append(System.lineSeparator())
                                .append("------------ Конец --------------")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }
}