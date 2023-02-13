import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class ReadFile {

    public static ArrayList<ArrayList<String>> addFile(String fileName) {

        File f = new File(fileName);
        ArrayList<ArrayList<String>> array = new ArrayList<>();

        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                String s = sc.nextLine();
                String[] split = s.split(" ");
                array.add(new ArrayList<String>(Arrays.asList(split)));
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return array;

    }


}
