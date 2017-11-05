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
    public int[] mergeSort(int[]Array){
        int[] A = Array.clone();
        mSorter(A, 0, A.length-1);
        return A;
    }
    private void  mSorter(int[] A, int l, int r) {

        if(l<r){
            int m = (l+r)/2;
            mSorter(A, l, m);
            mSorter(A, m+1, r);
            merge (A, l, m, r);
        }

    }
    private void merge(int[] A,int l,int m,int r){

       int n1 = (m - l) +1;
       int n2 = r - m;

       int[] L = new int[n1];
       int[] R = new int[n2];

       for( int i = 0; i< n1; ++i){
           L[i] = A[l +i];
       }
       for(int j = 0; j< n2; ++j){
           R[j] = A[m + 1+ j];
       }

      int i = 0, j=0;
      int k =l;
      while (i< n1 && j<n2){
          if(L[i]<= R[j]){
              A[k]= L[i];
              i++;

        }
          else{
              A[k] = R[j];
              j++;
          }
          k++;
      }
        while (i < n1)
        {
            A[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            A[k] = R[j];
            j++;
            k++;
        }



    }
    public void heapSort(int[] array) {

    }
    public void quickSort(int[] array) {

    }
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