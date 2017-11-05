package sorting_project;

public class Sorter {
    private int insertCount;
    private int mergeCount;
    private int heapCount;
    private int quickCount;

    Sorter() {
        this.insertCount = 0;
        this.mergeCount = 0;
        this.heapCount = 0;
        this.quickCount = 0;
    }

    //insertion Sort
    public int[] insertSort(int[] A) {
        int[] array = A.clone();
        int i, key, j;
        for (j = 1; j < array.length; j++) {
            key = array[j];
            i = j - 1;
            while (i >= 0 && array[i] > key) {
                insertCount++;
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;


        }


        return array;
    }
    //end of insertion Sort

    //Merge Sort
    public int[] mergeSort(int[] Array) {
        int[] A = Array.clone();
        mSorter(A, 0, A.length - 1);
        return A;
    }
    private void mSorter(int[] A, int l, int r) {

        if (l < r) {
            int m = (l + r) / 2;
            mSorter(A, l, m);
            mSorter(A, m + 1, r);
            mSortMerger(A, l, m, r);
        }

    }
    private void mSortMerger(int[] A, int l, int m, int r) {

        int n1 = (m - l) + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = A[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = A[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            mergeCount++;
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;

            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }



    }
    //end of mSortMerger sort

    //heap sort
    public int[] heapSort(int[] array) {
     int[]A = array.clone();
     Hsort(A);

     return A;
    }
    private void Hsort(int[] A){
        int length = A.length;

        Build_Max_Heap(A, length);
        for(int i = length-1; i>0; i--){
            int temp = A[0];
            A[0] = A[i];
            A[i]= temp;
            Max_Heapify(A, 1, i);
        }
    }

    private void Build_Max_Heap(int[] A, int heapSize){
        if(heapSize> A.length) heapSize = A.length;

        for(int i = heapSize/2; i> 0 ; i--){
            Max_Heapify(A, i, heapSize);
        }

    }

    private void Max_Heapify(int[]A, int index, int heapSize){
        int l = index*2;
        int r = l+1;
        int largest;
        if(l <= heapSize && A[l-1]> A[index-1]){
            largest = l;
        }else {
            largest = index;
        }

        if(r <= heapSize && A[r-1]> A[largest - 1]){
            largest = r;
        }
        if( r<= heapSize && A[r-1]> A[largest-1]){
            largest = r;
        }

        if(largest != index){
            int temp = A[index - 1];
            A[index -1] = A[largest -1];
            A[largest-1]= temp;
            heapCount++;
            Max_Heapify(A, largest, heapSize);
        }

    }
    //end of heap sort

    //Quick Sort
    public int[] quickSort(int[] array) {
    int[] A = array.clone();
    Qsort(A, 0, A.length-1);
    return A;
    }
    private  void Qsort(int[] A, int l, int h){
        if(l<h){
            int p = Partition(A, l, h);
            Qsort(A,l,p-1);
            Qsort(A, p+1, h);
        }

    }
    private int Partition(int[] A,int l,int h ){
        int p = A[h];
        int i= (l-1);
        for(int j = l; j< h; j++){
            quickCount++;
            if(A[j]<= p){
                i++;
                int temp = A[i];
                A[i]= A[j];
                A[j]= temp;

            }

        }
        int temp = A[i+1];
        A[i+1]= A[h];
        A[h]= temp;
        return i+1;
    }
    //end of Quick Sort
    public int getinsertCount() {
        return insertCount;
    }
    public int getMergeCount() {
        return mergeCount;
    }
    public int getHeapCount() {
        return heapCount;
    }
    public int getQuickCount() {
        return quickCount;
    }
}