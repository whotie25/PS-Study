package BasicSortAlgorithm;

import java.io.*;
import java.util.*;

public class SortAlgorithmTest {
    public static void main(String[] args) throws IOException {
        BufferedReader      br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter      bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer     st;

        SortFunctions       sort = new SortFunctions();

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

        List<Integer> bubbleSorted      = sort.bubbleSort(list);
        List<Integer> selectionSorted   = sort.selectionSort(list);
        List<Integer> insertionSorted   = sort.insertionSort(list);

        // OUTPUT

        try {
            bw.write("Bubble Sort    : "); bw.write(bubbleSorted.toString()); bw.write("\n");
            bw.write("Selection Sort : "); bw.write(selectionSorted.toString()); bw.write("\n");
            bw.write("Insertion Sort : "); bw.write(insertionSorted.toString()); bw.write("\n\n");
            bw.write("Unsorted List  : "); bw.write(list.toString()); bw.write("\n\n");
            bw.flush(); bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}