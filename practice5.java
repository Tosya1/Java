import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

// 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 
// человек может иметь несколько телефонов.
// 2. Пусть дан список сотрудников:Иван Иванов, Светлана Петрова, Кристина Белова, 
// Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, 
// Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, 
// Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать программу, 
// которая найдет и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности. Для сортировки можно использовать 
// TreeMap, мы не успели, но я расписал пример использования и прикрепил к 
// материалам урока в файле TestTreeMap
// 3. *Реализовать алгоритм пирамидальной сортировки (HeapSort)

public class practice5 {
    public static void main(String[] args) {
        // 1
        TelBook tb = new TelBook();
        tb.add("Вася", "+125874693254", "+258741963123");
        System.out.println(tb.toString());

        // 2
        String[] str = new String[] { "Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова",
                "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов" };
        System.out.println(getSorted(str));
        // 3
        int arr[] = new int[] { 5, 10, 7, 2, 11, 1, 25, 6 };
        int n = arr.length;
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        heapSort(arr, n);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }

    static SortedSet<Map.Entry<String, Integer>> getSorted(String[] str) {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        for (int i = 0; i < str.length - 2; i++) {
            int count = 1;
            if (!map.containsKey(str[i].split(" ")[0])) {
                for (int j = i + 1; j < str.length; j++) {
                    if (str[i].split(" ")[0].equals(str[j].split(" ")[0])) {
                        count++;
                        map.put(str[i].split(" ")[0], count);
                    }
                }
            }
        }

        SortedSet<Map.Entry<String, Integer>> sorted = new TreeSet<Map.Entry<String, Integer>>(
                Comparator.<Map.Entry<String, Integer>, Integer>comparing(Map.Entry::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey));

        sorted.addAll(map.entrySet());
        return sorted;
    }

    static void heapSort(int arr[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            makeHeap(arr, i, n);
        }
        for (int i = n - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            makeHeap(arr, 0, i);
        }
    }

    static void makeHeap(int arr[], int i, int n) {
        int max = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[max]) {
            max = l;
        }
        if (r < n && arr[r] > arr[max]) {
            max = r;
        }
        if (max != i) {
            int tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
            makeHeap(arr, max, n);
        }
    }
}

