package edu.sdccd.cisc191;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 */
public class IOLab
{
    public static String readTestResults(String s) {

        String lines ="";
        try {
            File testResult = new File("src/main/resources/"+s);
            Scanner scanner = new Scanner(testResult);
            while (scanner.hasNextLine()) {
                lines+=scanner.nextLine();
            }
            return lines;
        }
        catch (FileNotFoundException e) {
            return "";
        }
    }

    public static void appendTestResult(String s, String s1) {

        try {
            File resourceFile = new File("src/main/resources/" + s);
            PrintWriter out = new PrintWriter(new FileWriter(resourceFile, true), true);
            out.println(s1);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String readDateTime(String s) {

        try {
            URL link = new URL(s);

            Scanner download = new Scanner(link.openStream());
            String getInput = download.nextLine();
            int dateTime = getInput.indexOf("datetime");

            return getInput.substring(dateTime+11 , dateTime+43);
        }

        catch (MalformedURLException e) {
            System.out.println("Error: Not A Valid URL");
        }

        catch (FileNotFoundException e) {
            System.out.println("Error: File Not Found");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}