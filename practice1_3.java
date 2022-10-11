// 3. Дан массив nums = [3,2,2,3] и число val = 3. Если в массиве есть числа, 
//равные заданному, нужно перенести эти элементы в конец массива. Таким образом,
// первые несколько (или все) элементов массива должны быть отличны от заданного,
// а остальные - равны ему.

import java.util.ArrayList;
import java.util.Arrays;

public class practice1_3 {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 3 };
        int val = 3;
        System.out.println(Arrays.toString(sortByVal(nums, val))); // 1 вариант

        ArrayList<Integer> nums2 = new ArrayList<>(); // 2 вариант
        nums2.add(3);
        nums2.add(2);
        nums2.add(2);
        nums2.add(3);
        System.out.println(sortByVal2(nums2, val));
    }

    static int[] sortByVal(int nums[], int val) { // 1 вариант
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            }
        }
        for (int j = nums.length - 1, i = 0; j >= count;) {
            int tmp = nums[j];
            if (nums[j] != val) {
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
            } else {
                j--;
            }
        }
        return nums;
    }

    static ArrayList<Integer> sortByVal2(ArrayList<Integer> nums2, int val) { // 2 вариант
        for (int i = 0; i < nums2.size(); i++) {
            if (nums2.get(i).equals(val)) {
                nums2.remove(i);
                nums2.add(nums2.size(), val);
            }
        }
        return nums2;
    }
}
