// 4. Вычислить n-ое треугольное число

public class practice1_4 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(getTrNum(n));
    }

    static int getTrNum(int n) {
        int num = (int) (0.5*n*(n + 1));
        return num;
    }
}
