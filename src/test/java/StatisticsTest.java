import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {


    @Test
    void getTeams() throws FileNotFoundException {
        //arrange
        Statistics statistics = new Statistics("tdffinishers2024.csv");
        TDFFileReader tdfFileReader = new TDFFileReader("tdffinishers2024.csv");

        Set<String> expectedTeams = new HashSet<>(statistics.getTeams());
        //act
        Set<String> actualTeams = statistics.getTeams();

        //assert
        assertEquals(expectedTeams,actualTeams);
    }

    @Test
    void getSpecific_Team() throws FileNotFoundException {
        //arrange
        Statistics statistics = new Statistics("tdffinishers2024.csv");
        //act
        Set<String> actualTeams = statistics.getTeams();

        actualTeams.forEach(team -> System.out.println("'" + team + "'"));

        //assert
        //trimming the "\n");
        assertTrue(
                actualTeams.stream()
                        .map(String::trim)
                        .anyMatch(team -> team.equalsIgnoreCase("LOTTO DSTNY")));
    }

    @Test
    void getTeamsWithMembers() {

    }

    @Test
    void getTeamMembers() {
    }
}