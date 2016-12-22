package sample;

import java.io.*;

/**
 * Created by ilyam on 16.12.2016.
 */
class User {

    private static final String userDB = "D:\\OWL\\Users.txt";

    private String stringForAdding(String login, String pass) {
        return "\nL: " + login + "; P: " + pass + ";";
    }

    private String stringForSearch(String login, String pass) {
        return "L: " + login + "; P: " + pass + ";";
    }

    private boolean getFromDB(String prim) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader(userDB));
        String line;
        boolean flag = false;
        while ((line = fin.readLine()) != null && !flag) {
            if (line.equals(prim))
                flag = true;
        }
        fin.close();
        return flag;
    }

    public void addUser(String login, String pass) throws IOException{
        FileWriter fw = new FileWriter(userDB, true);
        fw.write(stringForAdding(login, pass));
        fw.close();
    }

    public boolean getUser(String login, String pass) throws IOException {
        return getFromDB(stringForSearch(login, pass));
    }

}
