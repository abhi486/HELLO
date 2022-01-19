import java.io.IOException;

public class PlacewitPractice{
    static int sum = 0;
    static int fun(int n) {
        if (n == 0 || n == 1 || n == 2) return n;

        for (int i = 1; i <= n; i++) {
            sum += i + fun(i-1);
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(fun(4));
    }
}

