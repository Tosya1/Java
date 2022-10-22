import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// 1. Пусть дан произвольный список целых чисел, удалить из него четные числа
// 2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и 
// среднее арифметическое из этого списка. (Collections.max())
// 3. *Реализовать алгоритм сортировки слиянием

public class practice3 {
    public static void main(String[] args) {
        // 1
        List<Integer> list1 = new ArrayList<>();
        list1 = getRandList(list1, 10, 30);
        System.out.println("Исходный список: " + list1);
        removeEven(list1);
        System.out.println("Список после удаления четных чисел: " + list1);
        // 2
        List<Integer> list2 = new ArrayList<>();
        list2 = getRandList(list2, 15, 50);
        int max = Collections.max(list2);
        int min = Collections.min(list2);
        int arMean = getArMean(list2);
        System.out.println("Исходный список: " + list2);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Среднее арифметическое: " + arMean);
        // 3
        List<Integer> list3 = new ArrayList<>();
        list3 = getRandList(list3, 7, 100);
        System.out.println("Исходный список: " + list3);
        System.out.println("Отсортированный список: " + sortByMerge(list3));

    }

    static List<Integer> getRandList(List<Integer> list, int n, int range) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            list.add(rand.nextInt(range));
        }
        return list;
    }

    static void removeEven(List<Integer> list) { // 1
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
    }

    static int getArMean(List<Integer> list) { // 2
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        int result = sum / list.size();
        return result;
    }

    static List<Integer> sortByMerge(List<Integer> list) { //3
        if (list.size() <= 1) {
            return list;
        } else {
            List<List<Integer>> divList = new ArrayList<>();
            int k = 0;
            while (k < list.size()) {
                divList.add(list.subList(k, k + 1));
                k++;
            }
            int n = 0;
            while (divList.size() > 1) {
                if (n < divList.size() - 1) {
                    List<Integer> left = divList.get(n);
                    List<Integer> right = divList.get(n + 1);
                    divList.set(n, merge(left, right));
                    divList.remove(n + 1);
                    n++;
                    if (n + 1 == divList.size() && divList.size() != 2) {
                        divList.add(divList.size() / 2, divList.get(n));
                        divList.remove(divList.size() - 1);
                        n = 0;
                    }
                } else {
                    n = 0;
                }
            }
            return divList.get(0);
        }
    }
    static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (j < left.size() && i < right.size()) {
            if (left.get(j) < right.get(i)) {
                res.add(left.get(j));
                j++;
            } else if (left.get(j) > right.get(i)) {
                res.add(right.get(i));
                i++;
            } else if ((left.get(j) == right.get(i))) {
                res.add(left.get(j));
                res.add(left.get(j));
                i++;
                j++;
            }
            while (j < left.size() && i >= right.size()) {
                res.add(left.get(j));
                j++;
            }
            while (j >= left.size() && i < right.size()) {
                res.add(right.get(i));
                i++;
            }
        }
        return res;
    }
}
