package model;
public class Championship {
    //Constants
	public static final int MAX_RUNNERS=15;
	//Atributes
	private int year;
	private int races;
	//Relations 
	public Pilot [] pilots;
	//Methods
	public Championship (int fYear, int fRaces){
		//int runners no pasa por parametro
		year=fYear;
		races=fRaces;
		pilots = new Pilot [MAX_RUNNERS]; //el limite seria MAX_RUNNERS
	}

	//Setter and getters
	public void setYear(int year){
		this.year=year;
	}
	public int getYear(){
		return year;
	}
	public void setRaces(int races){
		this.races=races;
	}
	public int getRaces(){
		return races;
	}
	
	public String addPilot(String name,int age,int team,int []times){
		String message="";            
		String m="se encontro el equipo";
		boolean exit=false;
		Pilot findP = findPilot(name);
		if (findP!=null){
			message="Error. El piloto ya ha sido creado";                
		}else {
			for (int i=0;i<pilots.length && !exit;i++){
				if (pilots[i]==null){
					if (team==1){
						pilots[i]= new Pilot (name,age,Team.SCUDERIA_FERRARI,times);		    			
					}else if (team==2){
						pilots[i]= new Pilot (name,age,Team.MCLAREN_F1_TEAM,times);						
					}else if (team==3){
						pilots[i]= new Pilot (name,age,Team.REDBULL_RACING,times);						
					}else if (team==4){
						pilots[i]= new Pilot (name,age,Team.MERCEDES_AMG,times);						
					}else if (team==5){
						pilots[i]= new Pilot (name,age,Team.RACING_POINT,times);
					}else if (team==6){
						pilots[i]= new Pilot (name,age,Team.ALFA_ROMEO,times);
					}else if (team==7){
						pilots[i]= new Pilot (name,age,Team.RENAULT,times);
					}else if (team==8){
						pilots[i]= new Pilot (name,age,Team.WILLIAMS,times);
					}else{
						m="Error.No se encontro el equipo";
					}		
					
					exit=true;
					message="Se ha registrado el piloto";
				}
			}
			if (exit==false){
				message="Error. El arreglo de pilotos esta lleno";
			}
		}
		return message+" & "+m;
		
	}
	
	public Pilot findPilot(String name){
		Pilot obPilot=null;
		boolean find=false;
		for (int i=0;i<pilots.length && !find;i++){
			if (pilots[i]!=null && pilots[i].getName().equalsIgnoreCase(name)){
				obPilot=pilots[i];
				find=true;
			}
		}
		return obPilot;   
	}
	
	
	public String showAverageTimes(String name){
		Pilot findPilot = findPilot(name);
		String message="";
		int segundos,min,horas,seg;	
		double midpoint;
		if (findPilot==null){
		message="Error. No se encontro el piloto";		
		}else{
			midpoint= findPilot.calculateAverage(races);
			if(midpoint<=60){
				message="El promedio del piloto "+findPilot.getName()+" es de "+midpoint+" segundos";
			}else{
				segundos=(int)midpoint%60;
				seg=(int)midpoint/60;
				min=(int)seg%60;
				horas=(int)seg/60;
				message="El promedio del piloto "+findPilot.getName()+" es de "+horas+" horas "+min+" minutos "+segundos+" segundos";
			}

		}		
	return message;
	}

	
}
