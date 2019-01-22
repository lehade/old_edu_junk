package ru.job4j.tracker;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 10.01.2019
 */


public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private UserAction[] actions = new UserAction[7];

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new Delete();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
        this.actions[6] = new Exit();
    }

    public int[] getLength() {
        int[] length = new int[this.actions.length];
        for (int index = 0; index < length.length; index++) {
            length[index] = index;
        }
        return length;
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        System.out.println("Меню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class Exit extends BaseAction {
        public Exit() {
            super(6, "Выход");
        }
        public void execute(Input input, Tracker tracker) {

        }

    }

    private class AddItem extends BaseAction {
        public AddItem() {
            super(0, "Добавить заявку");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");
        }

    }

    private static class ShowItems extends BaseAction {
        public ShowItems() {
            super(1, "Показать все заявки");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Вывод всех заявок --------------");
            for (Item items : tracker.findAll()) {
                System.out.println(
                        String.format("%s: %s %s: %s %s: %s", "Id", items.getId(),
                                "Name", items.getName(), "Description", items.getDescription()));
            }
            System.out.println("------------ Конец --------------");
        }
    }

    private static class EditItem extends BaseAction {
        public EditItem() {
            super(2, "Редактирование заявки");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Введите id заявки :");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("------------ Готово --------------");
            } else {
                System.out.println("------------ Ошибка выполнения --------------");
            }
        }
    }

    private static class Delete extends BaseAction {
        public Delete() {
            super(3, "Удаление заявки");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки :");
            if (tracker.delete(id)) {
                System.out.println("------------ Готово --------------");
            } else {
                System.out.println("------------ Ошибка выполнения --------------");
            }
        }
    }

    private static class FindById extends BaseAction {
        public FindById() {
            super(4, "Поиск по Id заявки");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по id --------------");
            String id = input.ask("Введите id заявки :");
            Item item = tracker.findById(id);
            System.out.println(String.format("%s. %s. %s", item.getId(), item.getName(), item.getDescription()));
            System.out.println("------------ Конец --------------");
        }
    }

    private static class FindByName extends BaseAction {
        public FindByName() {
            super(5, "Поиск по имени заявки");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            for (Item item : tracker.findByName(name)) {
                System.out.println(String.format("%s. %s. %s", item.getId(), item.getName(), item.getDescription()));
            }
            System.out.println("------------ Конец --------------");
        }
    }

}