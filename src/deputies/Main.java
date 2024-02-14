package deputies;

import faction.Faction;
import supremeCouncil.Parliament;

import java.util.Scanner;

public class Main {

    public static void list(){
        System.out.println("1. Дадати франкцію");
        System.out.println("2. Видалити франкцію");
        System.out.println("3. Вивести всі франкції");
        System.out.println("4. Очисти конкретну франкцію");
        System.out.println("5. Вивести конкретну франкцію");
        System.out.println("6. Додати депутата в франкцію");
        System.out.println("7. Видалити депутата франкції");
        System.out.println("8. Вивести список хабарників");
        System.out.println("9. Вивести найбільшого харабарника");
    }

    public static void main(String[] args){
        Parliament parliament = Parliament.parliament;
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run){
            list();

            System.out.println("Оберіть дію");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Введіть ім'я");
                    String name = scanner.next();
                    parliament.add(name);
                    break;
                }
                case 2: {
                    System.out.println("Введіть ім'я франкції яку хочете видалити");
                    String name = scanner.next();
                    parliament.remove(name);
                    break;
                }
                case 3: {
                    parliament.output();
                    break;
                }
                case 4: {
                    System.out.println("Введіть ім'я франкції яку хочете очистити");
                    String name = scanner.next();
                    parliament.clear(name);
                    break;
                }
                case 5 : {
                    System.out.println("Введіть ім'я франкції яку хочете вивести");
                    String name = scanner.next();
                    parliament.specificOutput(String.valueOf(name));
                    break;

                }
                case 6 :{
                        System.out.println("Ведіть ім'я франкцію в яку хочете додати депутата");
                        String name = scanner.next();
                        Faction f = parliament.getFraction(name);
                        System.out.println("Ведіть дані:" + "\n" + " Ім'я: ");
                        String firstName = scanner.next();
                        System.out.println("Призвіще: ");
                        String lastName = scanner.next();
                        System.out.println("Вага: ");
                        int weight = scanner.nextInt();
                        System.out.println("Ріст: ");
                        int height = scanner.nextInt();
                        System.out.println("Хабар(оберіть 1.Правда або 2. Неправда): ");
                        int bride = scanner.nextInt();
                        System.out.println("Введіть суму хабаря");
                        int amount = scanner.nextInt();
                        f.add(firstName, lastName, weight, height, bride, amount);
                    break;
                }
                case 7 :{
                    Faction faction = new Faction();
                    faction.output();
                    System.out.println("Ведіть ім'я франкції в якій хочете видалити депутата");
                    String name = scanner.next();
                    System.out.println("Всі депутати в цій франкції:");
                    faction.output();
                    Faction f = parliament.getFraction(name);
                    System.out.println("Ведіть дані:" + "\n" + " Ім'я: ");
                    String firstName = scanner.next();
                    System.out.println("Призвіще: ");
                    String lastName = scanner.next();
                    f.remove(firstName, lastName);
                    break;
                }
                case 8 :{
                    System.out.println("Ведіть ім'я франкції в якій хочете вивести список хабарників");
                    String name = scanner.next();
                    Faction f = parliament.getFraction(name);
                    f.outputAllTrueBride();
                    break;
                }
                case 9 :{
                    System.out.println("Ведіть ім'я франкції в якій хочете дізнатися найбільшого хабарника");
                    String name = scanner.next();
                    Faction f = parliament.getFraction(name);
                    f.outputBiggestBride();
                    break;
                }
                case 10 :{
                    Faction f = new Faction();
                    f.output();
                  //  parliament.getBiggestAmount();
                    break;
                }
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Ви ввели неправильне число");
            }

        }
        scanner.close();
    }

}