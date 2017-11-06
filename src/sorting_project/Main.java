package sorting_project;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        int [] array;

        Reader reader = new Reader("textFiles/unsortedTx");
        Sorter sorter = new Sorter();
        Writer write = new Writer("textFiles/sortedTxt");
        reader.createArrayList();
       for(int i = 0; i< reader.getNumOfArrays();i++){
           //insertion sort
           array = sorter.insertSort(reader.getArray(i));
           write.createFileForArray(array,"InsertionSort",sorter.getinsertCount());
           //merge sort
           array = sorter.mergeSort(reader.getArray(i));
           write.createFileForArray(array,"MergeSort",sorter.getMergeCount());
           //heap sort
           array = sorter.heapSort(reader.getArray(i));
           write.createFileForArray(array,"HeapSort",sorter.getHeapCount());
           //quick Sort
           array = sorter.quickSort(reader.getArray(i));
           write.createFileForArray(array,"QuickSort",sorter.getQuickCount());


       }






    }
}