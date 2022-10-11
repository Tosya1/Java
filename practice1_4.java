// 4. Вычислить n-ое треугольное число

public class practice1_4 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(getTrNum(n));
    }

    static int getTrNum(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num += i;
        }
        return num;
    }
}
