package ImprovedSortAlgorithm;

import java.io.*;
import java.util.*;

public class MergeSort {
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
        List<Integer> sorted = mergeSort(list);

        // OUTPUT
        try {
            bw.write("Sorted List   : "); bw.write(sorted.toString()); bw.write("\n\n");
            bw.flush(); bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // MERGE SORT FUNCTION
    private static List<Integer> mergeSort(List<Integer> list) {
        if(list.size() <= 1) return list;

        int mid = list.size()/2;
        List<Integer> left  = new ArrayList<>(list.subList(0, mid));
        List<Integer> right = new ArrayList<>(list.subList(mid, list.size()));

        return merge(mergeSort(left), mergeSort(right));
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
         List<Integer> result = new ArrayList<>();
         int i = 0, j = 0;

         while(i < left.size() && j < right.size()) {
            if(left.get(i) <= right.get(j)) {
                result.add(left.get(i)); i++;
            } else {
                result.add(right.get(j)); j++;
            }
         }

         while(i < left.size()) {
            result.add(left.get(i)); i++;
         }
         while(j < right.size()) {
            result.add(right.get(j)); j++;
         }

         return result;
    }
}
