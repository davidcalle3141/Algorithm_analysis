package sorting_project;

import java.io.*;
import java.util.LinkedList;

public class Reader {
    private File dir;
    private File[] dirListing;
    private LinkedList<int[]> arrayList;

    //constructor initiates arrayList linked list
    Reader() {
        arrayList = new LinkedList<>();
    }

    //sets dirListing to the list of files in given filepath
    public void setDir(String directoryPath) {
        this.dir = new File(directoryPath);
        this.dirListing = dir.listFiles();
    }

    //returns a linked list with array nodes that contain the values
    // from the files in the directory
    private LinkedList<int[]> getArrayList() {
        if (dirListing != null) {
            for (File child : dirListing) {
                //adds a int[] node to arrayList

                arrayList.add(fileToArray(child));
            }
        }
        return arrayList;
    }

    /*private int[] fixArraySize(int[] txtArray) {
    return txtArray;}*/

    private int[] fileToArray(File child) {
        String fileName = child.getName();
        //assuming the filenames are always formatted the same we can get the max size of the array
        //for each file from its name
        int length = Integer.parseInt(fileName.substring(3, fileName.length() - 4));
        int[] txtArray = new int[length];
        int pos = 0;

        try {
            FileReader fReader = new FileReader(child);
            BufferedReader br = new BufferedReader(fReader);
            String line;
            while ((line = br.readLine()) != null) {
                txtArray[0] = Integer.parseInt(line);
                pos++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return txtArray;
    }


}
