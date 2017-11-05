package sorting_project;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        int [] array;
        Reader reader = new Reader("C:\\Users\\david calle\\IdeaProjects\\Algorithm_analysis\\textFiles\\unsortedTx");
        Sorter sorter = new Sorter();
        Writer write = new Writer("C:\\Users\\david calle\\IdeaProjects\\Algorithm_analysis\\textFiles\\sortedTxt");
        reader.createArrayList();

       array = sorter.quickSort(reader.getArray(0));


       write.createFileForArray(array, "quickSort");
       int t =5;

    }
}