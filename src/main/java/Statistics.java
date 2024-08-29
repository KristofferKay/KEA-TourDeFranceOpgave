import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {
    private List<Cyclist> cyclist;

    public Statistics(String fileName) throws FileNotFoundException {
        TDFFileReader fileReader = new TDFFileReader(fileName);
        cyclist = fileReader.readFile();
    }

    //TODO Unit test US1
    public Set<String> getTeams(){
        Set<String> cyclistSet = new HashSet<>();
        for (Cyclist c : cyclist){
            cyclistSet.add(c.getTeam() + "\n");
        }
        return cyclistSet;
    }

    public Map<String, String> getTeamsWithMembers(){
        String name = "";
        String teamName = "";
        Map<String, String> tempMap = new HashMap<>();
        for (Cyclist c : cyclist){
            name = c.getName();
            teamName = c.getTeam();
        }

        tempMap.put(teamName, name);

        return tempMap;
    }

    public List<Cyclist> getTeamMembers(String team){
        List<Cyclist> tempList = new ArrayList<>();
        for (Cyclist c : cyclist){
            if (c.getName().equals(team)){
                tempList.add(c);
            }
        }
        return tempList;
    }

}
