package PS_02_Math;

import java.util.Scanner;

public class BabylonianMethod {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) { 
                double a = sc.nextDouble();
                System.out.printf("sqrt(%f) = %f\n", a, sqrt(a));
                System.out.printf("sqrt(%f)^2 = %f\n", sqrt(a), sqrt(a)*sqrt(a));
            }
        }
    }

    public static double abs(double x) {
        return (x<0)?-x:x;
    }

    public static double sqrt(double x0, double eps, int recLimit) {
        if(eps <= 0) throw new IllegalArgumentException();

        if(x0 < 0) return Double.NaN;
        if(x0 == 0) return 0;

        int i = 0;
        double xt = x0;
        while(abs(xt*xt - x0) > eps && i < recLimit) {
            xt = 0.5*(xt + x0/xt); i++;
        }
        return xt;
    }

    public static double sqrt(double x0, double eps) {
        return sqrt(x0, eps, 100);
    }

    public static double sqrt(double x0) {
        return sqrt(x0, 1e-10, 100);
    }
}
