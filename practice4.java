import java.util.Iterator;
import java.util.LinkedList;

// 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который 
// вернет “перевернутый” список.
// 2. Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - 
// помещает элемент в конец очереди, dequeue() - возвращает первый элемент из 
// очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
// 3. Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. 
// Используйте итератор

public class practice4 {
    public static void main(String[] args) {
        // 1
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(25);
        list1.add(36);
        list1.add(49);
        System.out.println("Исходный список: " + list1);
        System.out.println("Перевернутый список: " + getRevList(list1));

        // 2
        MyQueue list2 = new MyQueue();
        list2.enqueue(33);
        list2.enqueue(44);
        list2.enqueue(55);
        System.out.println(list2.list);
        System.out.println("Удален первый элемент:  " + list2.dequeue());
        System.out.println("Первый элемент:  " + list2.first());

        // 3
        System.out.println("Сумма элементов списка: " + list1 + " = " + getSum(list1));
    }

    static LinkedList<Integer> getRevList(LinkedList<Integer> list) { // 1
        LinkedList<Integer> revList = new LinkedList<Integer>();
        for (int item : list) {
            revList.addFirst(item);
        }
        return revList;
    }

    static int getSum(LinkedList<Integer> list) { // 3
        Iterator<Integer> iterator = list.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }
}

class MyQueue { // 2
    LinkedList<Integer> list;

    public MyQueue() {
        list = new LinkedList<Integer>();
    }

    void enqueue(int el) {
        list.add(el);
    }

    int dequeue() {
        return list.poll();
    }

    int first() {
        return list.peek();
    }
}
