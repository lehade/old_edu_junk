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
    private UserAction[] actions = new UserAction[6];

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
        this.actions[3] = new delete();
        this.actions[4] = new findById();
        this.actions[5] = new findByName();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);

    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");

        }

        public String info() {
            return String.format("%s. %s", this.key(), "Добавить заявку");
        }
    }

    private static class ShowItems implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Вывод всех заявок --------------");
            for (Item items : tracker.findAll()) {
                System.out.println(String.format("%s. %s. %s", items.getId(), items.getName(), items.getDescription()));
                System.out.println("------------ Конец --------------");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Показать все заявки");
        }
    }

    private static class EditItem implements UserAction {
        public int key() {
            return 2;
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

        public String info() {
            return String.format("%s. %s", this.key(), "Редактирование заявки");
        }
    }

    private static class delete implements UserAction {
        public int key() {
            return 3;
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

        public String info() {
            return String.format("%s. %s", this.key(), "Удаление заявки");
        }
    }

    private static class findById implements UserAction {
        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по id --------------");
            String id = input.ask("Введите id заявки :");
            Item item = tracker.findById(id);
            System.out.println(String.format("%s. %s. %s", item.getId(), item.getName(), item.getDescription()));
            System.out.println("------------ Конец --------------");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Поиск по Id заявки");
        }
    }

    private static class findByName implements UserAction {
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            for (Item item : tracker.findByName(name)) {
                System.out.println(String.format("%s. %s. %s", item.getId(), item.getName(), item.getDescription()));
            }
            System.out.println("------------ Конец --------------");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Поиск по имени заявки");
        }
    }

}