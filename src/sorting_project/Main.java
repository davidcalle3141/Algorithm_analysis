package sorting_project;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] array;
        Reader reader = new Reader("C:\\Users\\david calle\\IdeaProjects\\Algorithm_analysis\\textFiles\\unsortedTx");
        Sorter sorter = new Sorter();
        reader.createArrayList();

       array = sorter.mergeSort(reader.getArray(0));
       int t =5;

    }
}