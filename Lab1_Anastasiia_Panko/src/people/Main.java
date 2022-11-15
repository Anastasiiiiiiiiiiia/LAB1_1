package people;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");

        // Введення інформації про людину
        System.out.println("Введіть кількість людей => ");
        int n = sc.nextInt();    //	кількість людей
        People people[] = new People[n];
        System.out.println("Введіть інформацію про людей: ");
        for (int i = 0; i < people.length; i++) {
            sc.nextLine();    //	очищення буфера
            people[i] = new People();
            System.out.print("\nІм'я " + (i + 1) + "-ої людини => ");
            people[i].name = sc.nextLine();
            System.out.print("Прізвище " + (i + 1) + "-ої людини => ");
            people[i].surname = sc.nextLine();
            System.out.print("Рік народження " + (i + 1) + "-ої людини => ");
            people[i].year = sc.nextInt();
            System.out.print("Місяць народження " + (i + 1) + "-ої людини => ");
            people[i].month = sc.nextInt();
        }

        // Виведення отриманої інформації
        System.out.println("\nІнформація про людей:");
        for (int i = 0; i < people.length; i++) {
            System.out.println("" + people[i].name + " " + people[i].surname + "\t" +
                    "- рік народження " + people[i].year +
                    ", місяць народження " + people[i].month);
        }

        // Найстаріша людина
        int nommin = 0;    //номер елемента для людини з мінімальним роком народження (початкове значення)
        double min = people[nommin].year; //мінімальний рік народження (початкове значення)
        for (int i = 0; i < people.length; i++)
            if (people[i].year < min) {
                min = people[i].year;
                nommin = i;
            }
        System.out.println("\nНайстаріша людина: ");
        System.out.println("" + people[nommin].name + " " + people[nommin].surname + "\t" +
                "- рік народження " + people[nommin].year +
                ", місяць народження " + people[nommin].month);

        // Людина з віком старше за середній
        int s = 0;    //сумарний вік
        int y = 2022; //поточний рік
        for (int i = 0; i < people.length; i++)
            s = s + (y - people[i].year);
        double sr = s / people.length;
        // середній вік
        System.out.println("\nСередній вік =" + sr);
        System.out.println("\nЛюдина з віком старше за середній");
        for (int i = 0; i < people.length; i++) {
            if ((y - people[i].year) > sr)
                System.out.println("" + people[i].name + " " + people[i].surname + "\t" +
                        "- рік народження " + people[i].year +
                        ", місяць народження " + people[i].month);
        }

        // Пошук за прізвищем
        sc.nextLine();             // очищення буфера
        System.out.println("\nВведіть прізвище шуканої людини=>");
        String surname = sc.nextLine();
        int nom = -1; //−1 – виконавець з шуканим прізвищем відсутній

        for (int i = 0; i < people.length; i++)
            if (surname.equalsIgnoreCase(people[i].surname))
                nom = i;

        if (nom!=-1){
            System.out.println("Така людина є у списку. Це " + people[nom].name + " " + people[nom].surname + "\t" +
                    "- рік народження " + people[nom].year +
                    ", місяць народження " + people[nom].month);
        }
        else System.out.println("Такої людини немає у списку.");

        People[] peopleAsc = people.clone();
        // Сортування масиву за прізвищем в алфавітному порядку
        Arrays.sort(peopleAsc, Comparator.comparing(singers -> singers.surname));
        System.out.println("\nСортування масиву за прізвищем в алфавітному порядку: ");
        for (int i = 0; i < peopleAsc.length; i++) {
            System.out.println(peopleAsc[i].surname + " " + peopleAsc[i].name + "\tрейтинг виконавця " + peopleAsc[i].year +
                    "\tкількість випущенних альбомів " + peopleAsc[i].month);
        }
        // Сортування за прізвищем в зворотному порядку
        People[] peopleDesc = people.clone();
        Arrays.sort(peopleDesc, (singers, t1) -> t1.surname.compareToIgnoreCase(singers.surname));
        System.out.println("\nСортування за прізвищем в зворотньому порядку: ");
        for (int i = 0; i < peopleDesc.length; i++) {
            System.out.println(people[i].surname + " " + people[i].name + "\t" +
                    "- рік народження " + people[i].year +
                    ", місяць народження " + people[i].month);
        }

        // Редагування та виведення інформації про людину редагування
        for (int i = 0; i < people.length; i++)
            System.out.printf("\n%d) %s ", i + 1, people[i].surname);
        System.out.println("\nВведіть людину (індекс) для редагування:");
        int selectedIndex = sc.nextInt() - 1;
        System.out.println("1) Ім'я");
        System.out.println("2) Прізвище");
        System.out.println("3) Рік народження");
        System.out.println("4) Місяць народження");
        System.out.print("Введіть бажане поле (індекс) для редагування:");
        int selectedFieldIndex = sc.nextInt();
        People peopleObject = people[selectedIndex];
        switch (selectedFieldIndex) {
            case 1: {
                System.out.println("Ім'я: " + peopleObject.name);
                System.out.println();
                System.out.print("Введіть нове ім'я: ");
                peopleObject.name = sc.next().trim();
                break;
            }
            case 2: {
                System.out.println("Прізвище: " + peopleObject.surname);
                System.out.println();
                System.out.print("Введіть нове прізвище: ");
                peopleObject.name = sc.next().trim();
                break;
            }
            case 3: {
                System.out.println("Рік народження: " + peopleObject.year);
                System.out.println();
                System.out.print("Введіть новий рік народження: ");
                peopleObject.year = sc.nextInt();
                break;
            }
            case 4: {
                System.out.println("Місяць народження: " + peopleObject.month);
                System.out.println();
                System.out.print("Введіть новий місяць народження: ");
                peopleObject.month = sc.nextInt();
                break;
            }
        }
        people[selectedIndex] = peopleObject;
        System.out.println(" " + peopleObject.name + " " + peopleObject.surname + " - рік народження "
                + peopleObject.year + ", місяць народження " + peopleObject.month);
    }
}