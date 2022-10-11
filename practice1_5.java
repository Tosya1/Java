// +Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть 
//заменены знаком вопроса, например 2? + ?5 = 69. Требуется восстановить 
//выражение до верного равенства. Предложить хотя бы одно решение или сообщить,
//что его нет.

import java.util.Collections;

public class practice1_5 {
    public static void main(String[] args) {
        String a = "2?";
        String b = "?5";
        String sum = "69";
        resNums(a, b, sum);
    }

    static void resNums(String a, String b, String sum) {
        if (sum.length() > a.length() && sum.length() > b.length()) {
            a = "0" + a;
            b = "0" + b;
        } else if (sum.length() > a.length()) {
            int n = sum.length() - a.length();
            a = String.join("", Collections.nCopies(n, "0")) + a;
        } else if (sum.length() > b.length()) {
            int n = sum.length() - b.length();
            b = String.join("", Collections.nCopies(n, "0")) + b;
        }
        String[] aArr = a.split("");
        String[] bArr = b.split("");
        String[] sumArr = sum.split("");
        System.out.println(aArr);
        System.out.println(bArr);
        for (int i = aArr.length - 1; i >= 0; i--) {
            if ((aArr[i].indexOf('?') != -1) && (bArr[i].indexOf('?') == -1)) {
                if ((Integer.valueOf(sumArr[i]) - Integer.valueOf(bArr[i])) < 0) {
                    aArr[i] = Integer.toString(Integer.valueOf(sumArr[i]) + 10 - Integer.valueOf(bArr[i]));
                    sumArr[i + 1] = Integer.toString(Integer.valueOf(sumArr[i + 1]) - 1);
                } else {
                    aArr[i] = Integer.toString(Integer.valueOf(sumArr[i]) - Integer.valueOf(bArr[i]));
                }
            } else if ((bArr[i].indexOf('?') != -1) && (aArr[i].indexOf('?') == -1)) {
                if ((Integer.valueOf(sumArr[i]) - Integer.valueOf(aArr[i])) < 0) {
                    bArr[i] = Integer.toString(Integer.valueOf(sumArr[i]) + 10 - Integer.valueOf(aArr[i]));
                    sumArr[i + 1] = Integer.toString(Integer.valueOf(sumArr[i + 1]) - 1);
                } else {
                    bArr[i] = Integer.toString(Integer.valueOf(sumArr[i]) - Integer.valueOf(aArr[i]));
                }
            } else if ((bArr[i].indexOf('?') != -1) && (aArr[i].indexOf('?') != -1)) {
                bArr[i] = Integer.toString((int) (Math.random() * Integer.valueOf(sumArr[i])));
                aArr[i] = Integer.toString(Integer.valueOf(sumArr[i]) - Integer.valueOf(bArr[i]));
            }
        }
        int aRes = Integer.valueOf(String.join("", aArr));
        int bRes = Integer.valueOf(String.join("", bArr));
        if ((Integer.valueOf(sum) - bRes - aRes) == 0) {
            System.out.printf("q = %d, w = %d, e = %s", aRes, bRes, sum);
        } else {
            System.out.println("Решений нет.");
        }
    }
}
