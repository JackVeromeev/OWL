package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ilyam on 18.12.2016.
 */
class Teams {

    static private final String teamsDB = "D:\\OWL\\Teams.txt";
    private ArrayList<Team> teamsList;

    private static Teams ourInstance = new Teams();
    public static Teams getInstance() { return ourInstance; }

    private void getFromDB() {
        try {
            BufferedReader fin = new BufferedReader(new FileReader(teamsDB));
            String line;
            teamsList.clear();
            while ((line = fin.readLine()) != null) {
                teamsList.add(new Team(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Teams() {
        teamsList = new ArrayList<>();
        getFromDB();
    }

    private String stringForAdding(String nm, String lead, String members) {
        return "\n" + nm + Team.DELIMITER + lead +
                Team.DELIMITER + members + Team.DELIMITER + Team.START_POINTS;
    }

    public void addTeam(String name, String lead, String members) throws IOException {
        FileWriter fw = new FileWriter(teamsDB, true);
        fw.write(stringForAdding(name, lead, members));
        teamsList.add(new Team(name, lead, members));
    }
}
