import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInspector
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new File("src"));

        int result = chooser.showOpenDialog(null);

        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = chooser.getSelectedFile();

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            System.out.println("Contents of File:\n");

            try
            {
                Scanner fileScanner = new Scanner(selectedFile);

                while(fileScanner.hasNextLine())
                {
                    String line = fileScanner.nextLine();

                    System.out.println(line);

                    lineCount++;

                    charCount += line.length();

                    if(!line.trim().isEmpty())
                    {
                        String[] words = line.trim().split("\\s+");
                        wordCount += words.length;
                    }
                }

                fileScanner.close();

                System.out.println("\n====================");
                System.out.println("FILE SUMMARY REPORT");
                System.out.println("====================");

                System.out.println("File Name: "
                        + selectedFile.getName());

                System.out.println("Number of Lines: "
                        + lineCount);

                System.out.println("Number of Words: "
                        + wordCount);

                System.out.println("Number of Characters: "
                        + charCount);
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found.");
            }
        }
    }
}
