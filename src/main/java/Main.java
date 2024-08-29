import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TDFFileReader tdfFileReader = new TDFFileReader("tdffinishers2024.csv");
//        System.out.println(tdfFileReader.readFile());

        Statistics statistics = new Statistics("tdffinishers2024.csv");
        System.out.println("US1" + statistics.getTeams());
        System.out.println("US2" + statistics.getTeamsWithMembers());
        System.out.println("US3" + statistics.getTeamMembers("CARLOS RODRIGUEZ"));
    }
}
