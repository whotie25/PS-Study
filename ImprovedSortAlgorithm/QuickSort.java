package ImprovedSortAlgorithm;

import java.io.*;
import java.util.*;

public class QuickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader      br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter      bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer     st;

        ArrayList<Integer>  list = new ArrayList<>();

        // INPUT
        try {
            bw.write("정수 배열을 공백으로 구분하여 입력하십시오. : ");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        st = new StringTokenizer(br.readLine());
        int size = st.countTokens();
        for(int i = 0; i < size; i++) {
            list.add((int)Integer.parseInt(st.nextToken()));
        }

        try {
            bw.write("\nUnsorted List  : "); bw.write(list.toString()); bw.write("\n\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // SORT
        @SuppressWarnings("unchecked")
        List<Integer> sorted = (ArrayList<Integer>)list.clone();
        quickSort(sorted, 0, sorted.size()-1);
        
        // OUTPUT
        try {
            bw.write("Sorted List   : "); bw.write(sorted.toString()); bw.write("\n\n");
            bw.flush(); bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void quickSort(List<Integer> list, int p, int r) {
        if(p < r) {
            int q = partition(list, p, r);
            
            quickSort(list, p, q-1);
            quickSort(list, q+1, r);
        }
    }

    private static int partition(List<Integer> list, int p, int r) {
        int pivot = list.get(r), i = p-1;

        for(int j = p; j < r; j++) {
            if(list.get(j) <= pivot) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i+1, r);

        return i+1;
    }

    private static void swap(List<Integer> list, int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
