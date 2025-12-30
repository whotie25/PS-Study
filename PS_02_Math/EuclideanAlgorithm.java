package PS_02_Math;

import java.util.Scanner;

public class EuclideanAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int i = 0;
            while(i == 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                System.out.printf("gcd(%d, %d) = %d\n", a, b, gcd(a, b));
            }

            sc.close();   
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int gcd(int a, int b) {
        a = abs(a); b = abs(b);

        int r;
        while(b != 0) {
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int abs(int a) {
        return a<0?-a:a;
    }
}
