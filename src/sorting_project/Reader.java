package sorting_project;



import java.io.*;
import java.util.ArrayList;

public class Reader {
    private File dir;
    private File[] dirListing;
    private ArrayList < int[] > arrayList;


    //constructor initiates arrayList linked list
    Reader(String directoryPath) {
        this.dir = new File(directoryPath);
        this.dirListing = dir.listFiles();
        this.arrayList = new ArrayList < > ();


    }


    //returns a linked list with array nodes that contain the values
    // from the files in the directory
    public void createArrayList() {
        if (dirListing != null) {
            sortDir(dirListing);
            for (File child: dirListing) {
                //adds a int[] node to arrayList
                arrayList.add(fileToArray(child));
            }
        }
    }

    /*private int[] fixArraySize(int[] txtArray) {
    return txtArray;}*/

    private int[] fileToArray(File child) {
        String fileName = child.getName();
        //assuming the filenames are always formatted the same we can get the max            //size of the array
        //for each file from its name
        int length = Integer.parseInt(fileName.substring(3, fileName.length() - 4));
        int[] txtArray = new int[length];
        int pos = 0;

        try {
            FileReader fReader = new FileReader(child);
            BufferedReader br = new BufferedReader(fReader);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("")) continue;
                txtArray[pos] = Integer.parseInt(line);
                pos++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return txtArray;
    }

    public int[] getArray(int i) {

        return arrayList.get(i);
    }

    public int getNumOfArrays() {
        return arrayList.size();
    }
    //sorts directories by length helps keep things organized
    private void sortDir(File[] dirArray) {
        int i;
        File key;
        int j;
        for (j = 1; j < dirArray.length; j++) {
            key = dirArray[j];
            i = j - 1;
            while (i >= 0 && dirArray[i].length() > key.length()) {

                dirArray[i + 1] = dirArray[i];
                i = i - 1;
            }
            dirArray[i + 1] = key;
        }



    }
}