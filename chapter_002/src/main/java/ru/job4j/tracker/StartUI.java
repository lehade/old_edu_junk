package ru.job4j.tracker;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 07.01.2019
 */

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для вывода всех заявок.
     */
    private static final String SHOWALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String FINDBYID = "4";
    /**
     * Константа меню для поиска заявки по названия.
     */
    private static final String FINDBYNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.findAll();
            } else if (EDIT.equals(answer)) {
                this.edit();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDBYID.equals(answer)) {
                this.findById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void findAll() {
        System.out.println("------------ Вывод всех заявок --------------");
        for (Item items : this.tracker.findAll()) {
            System.out.println("Id: " + items.getId() + " Name: " + items.getName() + " Description: " + items.getDescription());
        }
        System.out.println("------------ Конец --------------");
    }

    private void edit() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.replace(id, item);
        System.out.println("------------ Готово --------------");
    }

    private void delete() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        this.tracker.delete(id);
        System.out.println("------------ Готово --------------");
    }

    private void findById() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        System.out.println("Id: " + item.getId() + " Name: " + item.getName() + " Description: " + item.getDescription());
        System.out.println("------------ Конец --------------");
    }

    private void findByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        for (Item items : this.tracker.findByName(name)) {
            System.out.println("Id: " + items.getId() + " Name: " + items.getName() + " Description: " + items.getDescription());
        }
        System.out.println("------------ Конец --------------");
    }

    private void showMenu() {
        System.out.println("Меню." + "\n" + "0. Add new Item" + "\n" + "1. Show all items" + "\n" + "2. Edit item" + "\n" + "3. Delete item" + "\n" + "4. Find item by Id" + "\n" + "5. Find items by name" + "\n" + "6. Exit Program");
    }

    /**
     * Запускт программы.
     *
     * @param args ввод данных
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}