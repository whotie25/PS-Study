package PS_02_Math;

import java.util.*;

public class DivisorFinder {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) { 
                List<Integer> res = divisors(sc.nextInt());
                int size = res.size();
                
                for(int i = 0; i < size; i++) {
                    System.out.print(res.get(i)+" ");
                } System.out.println();
            }
        }
    }

    public static List<Integer> divisors(int a) {
        if(a <= 0) throw new IllegalArgumentException();
        
        List<Integer> res = new ArrayList<>(); res.add(1);
        if(a == 1) return res;
        if(a == 2 || a == 3) {
            res.add(a);
            return res;
        }

        int iter = (int)Math.sqrt(a);

        for(int i = 2; i < iter; i++) {
            if(a%i == 0) res.add(i);
        } int size = res.size()-1;

        if(iter*iter == a) res.add(iter);
        else {
            if(a%iter == 0) {
                res.add(iter);
                res.add(a/iter);
            }
        }

        for(int i = size; i >= 0; i--) {
            res.add(a/res.get(i));
        }

        return res;
    }
}