package sample;

/**
 * Created by ilyam on 21.12.2016.
 */
class Team {

    static final String DELIMITER = "^";
    static final int START_POINTS = 0;

    private String name;
    private String leader;
    private String members;
    private int points;

    public void setName(String nm) { this.name = nm; }
    public void setLead(String nm) { this.leader = nm; }
    public void setMembers(String nms) { this.members = nms; }
    public void setPoints(int pnts) { this.points = pnts; }

    public String getName() { return this.name; }
    public String getLead() { return this.leader; }
    public String getMembers() { return this.members; }
    public int getPoints() { return this.points; }

    public Team(String line) {
        String[] fields;
        fields = line.split(DELIMITER);
        setName(fields[0]);
        setLead(fields[1]);
        setMembers(this.members = fields[2]);
        setPoints(Integer.parseInt(fields[3]));
    }

    public Team(String nm, String lead, String members) {
        setName(nm);
        setLead(lead);
        setMembers(members);
        setPoints(START_POINTS);
    }
}