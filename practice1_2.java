// 2. Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное
// количество подряд идущих 1

import java.util.Collections;
import java.util.ArrayList;

public class practice1_2 {
    public static void main(String[] args) {
        byte arr[] = { 1, 1, 0, 1, 1, 1 };
        System.out.println(maxSeq(arr));
    }

    static int maxSeq(byte arr[]) {
        ArrayList<Integer> seqList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] == 1) && i == arr.length - 1) {
                count += 1;
                seqList.add(count);
            } else if (arr[i] == 1) {
                count += 1;
            } else {
                seqList.add(count);
                count = 0;
            }
        }
        int max = Collections.max(seqList);
        return max;
    }

}
