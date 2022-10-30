import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и 
// методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) 
// фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно 
// хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - 
// сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.

public class practice6 {
    public static void main(String[] args) {
        Notebook n1 = new Notebook(1520001452, "Asus", "Black", "Windows", 150_000);
        Notebook n2 = new Notebook(1587624125, "HP", "Grey", "Linux", 170_000);
        Notebook n3 = new Notebook(1851724512, "Acer", "Black", "Linux", 70_000);
        Notebook n4 = new Notebook(1578125422, "Asus", "Grey", "Windows", 120_000);
        Notebook n5 = new Notebook(1587624125, "HP", "Black", "Windows", 170_000);
        Notebook n6 = new Notebook(1587624125, "Acer", "White", "MacOS", 90_000);
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(n1);
        notebooks.add(n2);
        notebooks.add(n3);
        notebooks.add(n4);
        notebooks.add(n5);
        notebooks.add(n6);
        System.out.println(notebooks);
        Map<Integer, String> inVals = getInputVals();
        Set<Notebook> res = filter(notebooks, inVals);
        printRes(res);
    }

    static Map<Integer, String> getInputVals() {
        Map<Integer, String> filters = new HashMap<>();
        filters.put(1, "Brand");
        filters.put(2, "Color");
        filters.put(3, "OS");
        filters.put(4, "Price");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите цифру(ы), соответствующую(ие) необходимому критерию:");
        printInFls(filters);
        System.out.println("При выборе нескольких критериев, укажите значения через ',' без пробела: ");
        String[] inputFilters = (in.nextLine().split(","));
        System.out.print("Введите минимальные значения для указанных критериев: ");
        printMinVals(filters, inputFilters);
        System.out.println("\nДля нескольких критериев, укажите значения через ',' без пробела: ");
        String[] minVals = in.nextLine().split(",");
        in.close();
        Map<Integer, String> inputVals = new HashMap<>();
        for (int i = 0; i < inputFilters.length; i++) {
            inputVals.put(Integer.valueOf(inputFilters[i]), minVals[i]);
        }
        return inputVals;
    }

    static Set<Notebook> filter(Set<Notebook> notebooks, Map<Integer, String> inVals) {
        Set<Notebook> res = new HashSet<>(notebooks);
        Set<Notebook> tmp = new HashSet<>();
        for (Map.Entry<Integer, String> el : inVals.entrySet()) {
            for (Notebook item : res) {
                if (el.getKey() == 1 && item.getBrand().equalsIgnoreCase(el.getValue())) {
                    tmp.add(item);
                } else if (el.getKey() == 2 && item.getColor().equalsIgnoreCase(el.getValue())) {
                    tmp.add(item);
                } else if (el.getKey() == 3 && item.getOs().equalsIgnoreCase(el.getValue())) {
                    tmp.add(item);
                } else if (el.getKey() == 4 && item.getPrice() >= (Integer.valueOf(el.getValue()))) {
                    tmp.add(item);
                }
            }
            res = new HashSet<>(tmp);
            tmp.clear();
        }
        return res;
    }

    static void printInFls(Map<Integer, String> filters) {
        for (Map.Entry<Integer, String> item : filters.entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }
    }

    static void printMinVals(Map<Integer, String> filters, String[] inputFilters) {
        for (int i = 0; i < inputFilters.length; i++) {
            for (Map.Entry<Integer, String> item : filters.entrySet()) {
                if (Integer.valueOf(inputFilters[i]) == item.getKey())
                    System.out.print(item.getValue() + " ");
            }
        }
    }

    static void printRes(Set<Notebook> res) {
        if (res.isEmpty()) {
            System.out.println("К сожалению, да данный момент у нас нет товаров, которые соответствуют Вашему запросу");
        } else {
            System.out.println("Товары, которые соответствуют Вашему запросу: ");
            for (Notebook item : res) {
                System.out.println(item);
            }
        }
    }
}