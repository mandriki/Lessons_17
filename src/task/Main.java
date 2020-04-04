package task;

import java.util.*;

public class Main {
    public static void main(String[] args) {
       /** 1.	Дан список целых чисел. Найти среднее всех нечётных чисел, делящихся на 5.*/
        List<Integer> list = Arrays.asList(7,9,5,1,2,2,2,2,15,25);
        double average = list.stream()
                .filter((i -> i % 5 == 0))
                .filter((i -> i % 2 != 0))
                .mapToInt(x -> x)
                .average()
                .getAsDouble();
        System.out.println("Среднее - "+average);
        /**2.	Дан список строк. Найти количество уникальных строк длиной более 8 символов.*/
        List<String> lest1 = Arrays.asList("34d4545342", "123456789", "123456789", "dfg", "dg", "FdgdfgdfFF", "fgfgdgfdfgdfg", "adas");
        long line = lest1.stream()
                .filter(s -> s.length() > 8)
                .distinct()
                .count();
        System.out.println("Колличество уникальных строк - " + line);
        /**3.	Дана Map<String, Integer>. Найти сумму всех значений, длина ключей которых меньше 7 символов.*/
        Map<String, Integer> map = new HashMap<>();
        map.put("fsf", 44);
        map.put("sfdfdf", 84);
        map.put("sf", 1);
        map.put("sdfsdfdsfds", 212);
        map.put("sdfsdfdsfsfsdf", 45);

        int sum = map.entrySet()
                .stream()
                .filter(e -> e.getKey().length() < 7)
                .mapToInt(s->s.getValue())
                .sum();
        System.out.println("Сумма значении - " + sum);
       /** 4.	Дан список целых чисел, вывести строку, представляющую собой конкатенацию строковых представлений этих чисел.
        Пример: список {5, 2, 4, 2, 1}
        Результирующая строка: "52421"*/
         String string = list.stream()
                 .map(e -> e.toString())
                 .reduce("", String::concat);
         System.out.println("list в строку - " + string);

       /** 5.	Дан класс Person с полями firstName, lastName, age.
        Вывести полное имя самого старшего человека, у которого длина этого имени не превышает 15 символов.*/
        List<Person> list2 = Arrays.asList(
                new Person("цу", "йцу", 10),
                new Person("уц", "йцу", 17),
                new Person("цу", "йцу", 20),
                new Person("уцgrggegergegeg", "йцу", 23),
                new Person("123456789456", "йцу", 30));

        Optional<Person> result = list2.stream()
                .filter(person -> person.getFirstName().length() < 15)
                .sorted((o1, o2) -> -o1.getAge().compareTo(o2.getAge()))
                .findFirst();
        System.out.println(result.get().toString());
    }
}

   /** 1.	Дан список целых чисел. Найти среднее всех нечётных чисел, делящихся на 5.

            2.	Дан список строк. Найти количество уникальных строк длиной более 8 символов.

            3.	Дана Map<String, Integer>. Найти сумму всех значений, длина ключей которых меньше 7 символов.

        4.	Дан список целых чисел, вывести строку, представляющую собой конкатенацию строковых представлений этих чисел.
        Пример: список {5, 2, 4, 2, 1}
        Результирующая строка: "52421"

        5.	Дан класс Person с полями firstName, lastName, age.
        Вывести полное имя самого старшего человека, у которого длина этого имени не превышает 15 символов.*/
