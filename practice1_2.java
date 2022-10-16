// 2. Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное
// количество подряд идущих 1
public class practice1_2 {
    public static void main(String[] args) {
        byte arr[] = { 1, 1, 0, 1, 1, 1 };
        System.out.println(maxSeq(arr));
    }

    static int maxSeq(byte arr[]) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] == 1) && i == arr.length - 1) {
                count += 1;
                if (count > max) {
                    max = count;
                }
            } else if (arr[i] == 1) {
                count += 1;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }
}
