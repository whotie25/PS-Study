package PS_02_Math;

import java.util.Scanner;

public class PrimeFactorization {
    public static void main(String[] args) {
        int i = 0x7FFF_FFFF;

        try (Scanner sc = new Scanner(System.in)) {
            while(i > 0) {
                int num = sc.nextInt();
                System.out.println(primeFactorize(num)+"");
                i--;
            }
        }
    }

    public static String primeFactorize(int num) {
        if(num < 0) return null;
        if(num < 2) return String.valueOf(num);

        int sqrtNum = (int)Math.sqrt(num);

        String res = "";

        for(int i = 2; i <= sqrtNum; i++) {
            int tmp = 0;
            while(num%i == 0 && num != 0) {
                tmp++; num /= i;
            }

            if(tmp == 1) res += String.format("%d * ", i);
            else if(tmp > 1) res += String.format("%d^%d * ", i, tmp);
        }

        if(num != 1) return res + num;
        else return res.substring(0, res.length()-3);
    }
}
