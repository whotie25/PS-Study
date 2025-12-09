package ImprovedSortAlgorithm.HeapSort;

public class MaxHeap {
    private int[]   heap;
    //private int     capacity;
    private int     size;

    public MaxHeap(int[] array, int size/*, int capacity*/) {
        this.heap = array;
        //this.capacity = capacity;
        this.size = size;

        buildHeap();
    }

    public MaxHeap() {
        this(null, 0/*, 0*/);
    }

    public int[] heapSort() {
        int tmp = size;

        buildHeap();
        for(int end = size-1; end > 0; end--) {
            swap(0, end);
            size--;
            siftDown(0);
        }

        size = tmp;
        
        return heap;
    }

    public int heapSize() {
        return size;
    }

    public boolean isLeaf(int pos) {
        return(pos >= size / 2) && (pos < size);
    }

    public int leftChild(int pos) {
        //if(pos >= size / 2) return -1;

        return pos*2 + 1;
    }

    public int rightChild(int pos) {
        //if(pos >= (size-1) / 2) return -1;

        return pos*2 + 2;
    }

    public int parent(int pos) {
        if(pos <= 0) return -1;

        return (pos-1)/2;
    }

    private void buildHeap() {
        for(int i = size/2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    private void siftDown(int pos) {
        while(!isLeaf(pos)) {
            int max = leftChild(pos);
            int rc = rightChild(pos);
            
            if(rc < size && heap[rc] > heap[max]) max = rc;
            if(heap[pos] >= heap[max]) return;

            swap(pos, max);
            pos = max;
        }
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
