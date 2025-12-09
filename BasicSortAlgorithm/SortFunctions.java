package BasicSortAlgorithm;

import java.util.*;

public class SortFunctions {
    private void swap(ArrayList<Integer> list, int i ,int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {
        ArrayList<Integer> result = (ArrayList<Integer>)list.clone();

        int size = result.size();
        for(int i = 0; i < size-1; i++) {
            for(int j = 0; j < size-i-1; j++) {
                if(result.get(j) > result.get(j+1)) {
                    swap(result, j, j+1);
                }
            }
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Integer> selectionSort(ArrayList<Integer> list) {
        ArrayList<Integer> result = (ArrayList<Integer>)list.clone();

        int size = result.size();
        for(int i = 0; i < size-1; i++) {
            int min = i;
            for(int j = i+1; j < size; j++) {
                if(result.get(j) < result.get(min)) {
                    min = j;
                }
            }
            swap(result, i, min);
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
        ArrayList<Integer> result = (ArrayList<Integer>)list.clone();

        int size = result.size();
        for(int i = 1; i < size; i++) {
            for(int j = i; j > 0 && result.get(j) < result.get(j-1); j--) {
                swap(result, j, j-1);
            }
        }

        return result;
    }
}
