package model;
public class Pilot {		
	//Atributes
	private String name;
	private int age;
	private Team team;
	private int [] scores;
	//Methods
	public Pilot (String pName,int pAge, Team pTeam,int[]pScores){
		name=pName;
		age=pAge;
		team=pTeam;
		scores= pScores;
	}   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }
    
    public double calculateAverage(int races){
        double average;
        int total=0;       
        for (int i=0;i<scores.length;i++){              
            total=total+scores[i];           
        }
        average= total/races;
    return average;
    }
	
}
