package t_11_holdingYourObjects.ex16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {

    private static Set<String> vowelsSet = new HashSet<String>() {
        {
            add("a");
            add("e");
            add("i");
            add("o");
            add("u");
        }
    };

    public static void main(String[] args)
    {
        final File file = new File("D:\\text.txt");

        System.out.println(countVowels(new Scanner("JAVA")));
        System.out.println(getNumberVowelValue(file));
    }

    private static int getNumberVowelValue(File file)
    {
        int counter = 0;
        try (Scanner scanner = new Scanner(new InputStreamReader(new FileInputStream(file))))
        {
            counter = countVowels(scanner);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("File " + file.getName() + " not found.");
        }
        return counter;
    }

    /**
     * @param counter
     * @param scanner
     * @return
     */
    private static int countVowels(Scanner scanner)
    {
        scanner.useDelimiter("\\W+");
        int counter = 0;
        while (scanner.hasNext())
        {
            counter += vowelsSet.contains(scanner.next().toLowerCase()) ? 1 : 0;

        }
        return counter;
    }

}
