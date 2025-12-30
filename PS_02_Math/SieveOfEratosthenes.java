package PS_02_Math;

import java.io.*;
import java.util.BitSet;

public class SieveOfEratosthenes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int     n =     Integer.parseInt(br.readLine());    if(n<2) return;
        int     size =  (n-1)/2;
        BitSet  p =     new BitSet(size);

        for(int i = 0; (2*i + 3)*(2*i + 3) <= n; i++) {
            if(!p.get(i)) {
                int tmp = 2*i + 3;
                for(int j = i+tmp; j < size; j += tmp) {
                    p.set(j);
                }
            }
        }
        try {
            bw.write("2 ");
            for(int i = 0; i < size; i ++) {
                if(!p.get(i)) {bw.write(String.valueOf(2*i+3)); bw.write(" ");}
            }
            bw.flush(); bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}