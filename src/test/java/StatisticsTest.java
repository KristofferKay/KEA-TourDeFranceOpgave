import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
        assertEquals(expectedTeams, actualTeams);
    }

    @Test
    void get_Teams() throws FileNotFoundException {
        //arrange
        Statistics statistics = new Statistics("tdffinishers2024.csv");
        //act
        Set<String> actualTeams = statistics.getTeams();

        actualTeams.forEach(team -> System.out.println("'" + team + "'"));

        //assert
        //trimming the "\n");
        //got it from chatgpt, could not get it to work with the backspace
        assertTrue(
                actualTeams.stream()
                        .map(String::trim)
                        .anyMatch(team -> team.equalsIgnoreCase("LOTTO DSTNY")));
    }


    @Test
    void testSpecificTeamsWithMembers() throws FileNotFoundException {
        // Arrange
        Statistics statistics = new Statistics("tdffinishers2024.csv");

        // Act
        Map<String, String> teamsWithMembers = statistics.getTeamsWithMembers();

        // Assert: Check for specific entries
        assertTrue(teamsWithMembers.containsKey("TADEJ POGAČAR"));
        assertEquals("TADEJ POGAČAR", teamsWithMembers.get("UAE TEAM EMIRATES"));
    }


    @Test
    void getTeamMembers() throws FileNotFoundException {
        //arrange
        Statistics statistics = new Statistics("tdffinishers2024.csv");
        //act
        Set<String> actualMembers = statistics.getTeamMembers("UAE TEAM EMIRATES");

        assertTrue(
                actualMembers.stream()
                        .map(String::trim)
                        .anyMatch(team -> team.equalsIgnoreCase("TADEJ POGAČAR")));

    }
}