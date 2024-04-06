import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Main {

    final static String[] COMMANDS = {"добавить новое животное",
            "посмотреть список животных",
            "удалить животного",
            "обучить животное",
            "посмотреть команды животного"};

    final static String[] ANIMALS = {"собака", "кот", "хомяк", "лошадь", "верблюд", "осёл"};

    public static void main(String[] args) throws DataFormatException {
        ArrayList<Animal> listAnimal = new ArrayList<>();

        try (Counter counter = new Counter()) {
            while (true) {
                System.out.println("Спиок доступных команд: ");
                for (int i = 0; i < COMMANDS.length; i++) {
                    System.out.println(i + 1 + " - " + COMMANDS[i]);
                }
                int commandNum = inputNum("Выберите цифру команды: ", COMMANDS.length);
                if (commandNum == -1) break;
                else if (commandNum == 0) continue;
//            System.out.println("Вызвана команда " + COMMANDS[commandNum - 1]); //for debug
                if (commandNum == 1) {
                    System.out.println("Список доступных видов животных: ");
                    for (int i = 0; i < ANIMALS.length; i++) {
                        System.out.println(i + 1 + " - " + ANIMALS[i]);
                    }
                    int animalNum = inputNum("Выберите вид вашего животного: ", ANIMALS.length);
                    if (animalNum < 1) continue;
                    String animalName = input("Введите кличку вашего животного: ");
                    boolean inputDate = input("Ввести дату рождения вручную? (Y)").equals("y");
                    Date date = null;
                    if (inputDate) date = parseDate(input("Введите дату рождения (yyyy-mm-dd): "));
                    switch (animalNum) {
                        case 1 -> listAnimal.add(new Dogs(animalName, date));
                        case 2 -> listAnimal.add(new Cats(animalName, date));
                        case 3 -> listAnimal.add(new Hamster(animalName, date));
                        case 4 -> listAnimal.add(new Horse(animalName, date));
                        case 5 -> listAnimal.add(new Camel(animalName, date));
                        case 6 -> listAnimal.add(new Donkey(animalName, date));
                    }
                    System.out.println("Добавлено животное!");
                    counter.add();
                }
                else if (commandNum == 2) {
                    if (listAnimal.isEmpty()){
                        System.out.println("Список пока пуст, добавьте животное.");
                    } else {
                        int i = 1;
                        for (Animal animal : listAnimal) {
                            System.out.println(i + " - " + animal);
                            i++;
                        }
                    }
                }
                else if (commandNum == 3) {
                    int animalNum = inputNum("Введите номер животного для удаления: ", listAnimal.size());
                    if (animalNum < 1) {
                        System.out.println("Ошибка удаления!");
                    } else {
                        listAnimal.remove(animalNum - 1);
                        System.out.println("Животное удалено!");
                        counter.remove();
                    }
                }
                else if (commandNum == 4) {
                    int animalNum = inputNum("Введите номер животного для обучения: ", listAnimal.size());
                    if (animalNum < 1) {
                        System.out.println("Такого животного нет!");
                    } else {
                        int i = 1;
                        for (Commands command : Commands.values()) {
                            System.out.println(i + " - " + command);
                            i++;
                        }
                        int animalCommandNum = inputNum("Введите номер команды для обучения: ", Commands.values().length);
                        if (animalCommandNum < 1) {
                            System.out.println("Такой команды нет!");
                        } else {
                            listAnimal.get(animalNum - 1).learnCommand(Commands.values()[animalCommandNum - 1]);
                            System.out.println("Животное обучено!");
                        }
                    }
                }
                else if (commandNum == 5) {
                    int animalNum = inputNum("Введите номер животного для просмотра его команд: ", listAnimal.size());
                    if (animalNum < 1) {
                        System.out.println("Такого животного нет!");
                    } else {
                        System.out.println(listAnimal.get(animalNum - 1).getCommands());
                    }
                }
            }
            System.out.println("Успешное завершение!");
            System.out.println("Было добавлено " + counter.getCount() + " животных");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }


    public static String input(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.next().trim().toLowerCase();
    }

//    -1 - close session
//    0 - miss step
//    1-maxNum - number of command
    public static int inputNum(String message, int maxNum) {

        String input = input(message);
        if (Objects.equals(input, "q") || Objects.equals(input, "quit")) return -1;

        int num;
        try {
            num = Integer.parseInt(input);
        } catch (Exception ex) {
            return 0;
        }
        if (num > maxNum || num < 1) {
            System.out.println("Такого выбора нет!");
            return 0;
        }

        return num;
    }
    
    public static Date parseDate(String someStr) {
        Date date;
        try {
            String[] input = someStr.split("-");
            int[] result = new int[input.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = Integer.parseInt(input[i]);
            }
            date = new Date(result[0] - 1900, result[1] - 1, result[2]);
        } catch (Exception ex) {
            System.out.println("Неверный формат ввода даты. Установлена текущая дата!");
            return null;
        }
        return date;
    }
}