package sorting_project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    File outFile;
    private String dir;
    Writer(String directory){
        this.dir = directory;


    }
    public void createFileForArray(int[]A, String sortType) throws IOException {
        outFile = new File(dir +"/"+sortType+"Num"+A.length+".txt");
        if(!outFile.createNewFile()){

            System.out.println("file overwritten");}
        writeToFile(A, outFile);
    }

    private void writeToFile(int[]A, File writeTo){
        FileWriter fwriter = null;
        BufferedWriter writer = null;

        try{
            fwriter = new FileWriter(writeTo, false);
            writer = new BufferedWriter(fwriter);

            for (int child: A) {
                writer.write(Integer.toString(A[child-1]));
                writer.newLine();

            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
