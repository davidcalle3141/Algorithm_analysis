package sorting_project;

public class Sorter {
   private int insertCount;
   private int mergeCount;
   private int heapCount;
   private int quickCount;

   Sorter(){
       this.insertCount = 0;
       this.mergeCount = 0;
       this. heapCount = 0;
       this. quickCount = 0;
   }
    public void insertSort(int[] array){
       for(int j = 1; j< array.length; j++){
           int key = array[j];
           int i = j-1;
           while(i>0 && array[i]> key){
               insertCount++;
               array[i+1]= array[i];
               i = i-1;
               array[i+1]= key;

               }
       }


    }
    public void mergeSort(int[] array){

    }
    public void heapSort(int [] array){

    }
    public void quickSort(int[] array){

    }
    public int getinsertCount(){
        return insertCount;
    }
    public int getMergeCount(){
        return mergeCount;
    }
    public int getHeapCount(){
        return heapCount;
    }
    public int getQuickCount(){
        return quickCount;
    }
}
