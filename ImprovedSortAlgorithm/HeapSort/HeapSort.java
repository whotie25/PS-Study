package ImprovedSortAlgorithm.HeapSort;

import java.io.*;
import java.util.*;

public class HeapSort {
    public static void main(String[] args) throws IOException {
        BufferedReader      br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter      bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer     st;

        // INPUT
        try {
            bw.write("정수 배열을 공백으로 구분하여 입력하십시오. : ");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        st = new StringTokenizer(br.readLine());
        int     size    = st.countTokens();
        int[]   array   = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = (int)Integer.parseInt(st.nextToken());
        }

        try {
            bw.write("\nUnsorted List  : "); bw.write(Arrays.toString(array)); bw.write("\n\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // SORT
        MaxHeap heap = new MaxHeap(array, size);
        int[] sorted = Arrays.copyOf(heap.heapSort(), size);

        // OUTPUT
        try {
            bw.write("Sorted List   : "); bw.write(Arrays.toString(sorted)); bw.write("\n\n");
            bw.flush(); bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
