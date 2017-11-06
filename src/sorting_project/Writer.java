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
    public void createFileForArray(int[]A, String sortType, int count) throws IOException {
        outFile = new File(dir +"/"+sortType+"Num"+A.length+".txt");
        if(!outFile.createNewFile()){

            System.out.println("file already exists please delete old Version");}
        writeToFile(A, outFile, count);
    }

    private void writeToFile(int[]A, File writeTo, int count){
        FileWriter fwriter = null;
        BufferedWriter writer = null;

        try{
            fwriter = new FileWriter(writeTo, true);
            writer = new BufferedWriter(fwriter);
            writer.write("Count is equal to : "+ count);
            writer.newLine();
            for (int child: A) {
                writer.write(Integer.toString(A[child-1])+ " ");


            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
