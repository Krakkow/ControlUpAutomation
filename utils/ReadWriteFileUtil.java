package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFileUtil {

    String fileName;
    String Category;
    String description;
    String title;
    String text;

    /**
     * Creating and writing to a file. The file is created in the dev environment.
     * @param myFilePath
     * @param fileName
     * @param description
     * @param category
     * @param title
     * @param Text
     * @return
     */
    public static boolean writeToFile(String myFilePath, String fileName, String description, String category, String title, String Text){
        try {
            File myFile = new File(myFilePath + fileName + ".txt");
            FileWriter fw = new FileWriter(myFilePath + fileName,true);
            fw.write("Description: "+ description + "\n" +
                    "Category: "+ category + "\n" +
                    "Title: "+ title + " \n" +
                    "Text: "+ Text );
            fw.close();
            System.out.println("Write To File Successful");
            return true;
        } catch (IOException e) {
            System.out.println("Unable To Write To File");
            return false;
        }
    }
}
