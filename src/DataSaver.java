import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<String> records = new ArrayList<>();

        boolean moreRecords;

        do
        {
            String firstName = SafeInput.getNonZeroLenString(
                    in, "Enter First Name");

            String lastName = SafeInput.getNonZeroLenString(
                    in, "Enter Last Name");

            String idNumber = SafeInput.getRegExString(
                    in,
                    "Enter 6-digit ID Number",
                    "\\d{6}");

            String email = SafeInput.getNonZeroLenString(
                    in, "Enter Email");

            int yearBorn = SafeInput.getRangedInt(
                    in,
                    "Enter Year of Birth",
                    1900,
                    2026);

            String record =
                    firstName + ", " +
                            lastName + ", " +
                            idNumber + ", " +
                            email + ", " +
                            yearBorn;

            records.add(record);

            moreRecords = SafeInput.getYNConfirm(
                    in,
                    "Add another record?");
        }
        while(moreRecords);

        String fileName = SafeInput.getNonZeroLenString(
                in,
                "Enter output file name");

        fileName += ".csv";

        try
        {
            PrintWriter out = new PrintWriter(
                    new File("src/" + fileName));

            for(String record : records)
            {
                out.println(record);
            }

            out.close();

            System.out.println(
                    "File saved successfully as "
                            + fileName);
        }
        catch(Exception e)
        {
            System.out.println(
                    "Error saving file.");
        }
    }
}
