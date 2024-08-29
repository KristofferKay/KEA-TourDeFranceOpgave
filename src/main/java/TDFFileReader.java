import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TDFFileReader {
    private Scanner scanner;
    List<Cyclist> cyclists = new ArrayList<>();

    public List<Cyclist> getCyclists() {
        return cyclists;
    }

    public TDFFileReader(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        scanner = new Scanner(file);
    }

    public List<Cyclist> readFile() {
        while (scanner.hasNext()) {
            String csvLine = scanner.nextLine();
            String[] place = csvLine.split(";");
            String[] ryder = csvLine.split(";");
            String[] team = csvLine.split(";");
            String[] time = csvLine.split(";");
            String[] timeDiff = csvLine.split(";");

            String ryderName = ryder[1];
            String teamName = team[2];

            Cyclist cyclistObj = new Cyclist(ryderName,teamName);

            cyclists.add(cyclistObj);
        }
        return cyclists;
    }
}
