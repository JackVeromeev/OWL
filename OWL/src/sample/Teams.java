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

    private String stringForWriting(Team tm) {
        return "\n" + tm.getName() + Team.DELIMITER + tm.getLead() + Team.DELIMITER +
                tm.getMembers() + Team.DELIMITER + tm.getPoints();
    }

    public void addTeam(String name, String lead, String members) throws IOException {
        FileWriter fw = new FileWriter(teamsDB, true);
        fw.write(stringForAdding(name, lead, members));
        teamsList.add(new Team(name, lead, members));
    }

    public Team getTeam(String nm) {
        for (int i = 0; i < teamsList.size(); i++) {
            if (teamsList.get(i).getName().equals(nm))
                return new Team(teamsList.get(i));
        }
        return null;
    }

    public void saveDB() throws IOException {
        FileWriter fw = new FileWriter(teamsDB, false);
        for (int i = 0; i < teamsList.size(); i++) {
            fw.write(stringForWriting(teamsList.get(i)));
        }
    }
}