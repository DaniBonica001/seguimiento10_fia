package ui;
import java.util.Scanner;
import model.Championship;
public class Main {
    //Atributes
	private Championship tournament;
	//Global variable
	public Scanner lector;
	//Methods
	public Main(){
		lector = new Scanner(System.in);
		createChampion();
	}

	public static void main(String[] args) {
		System.out.println("Iniciando la aplicacion");
		Main objMain = new Main();

		int allow=0;
		do{
			allow=objMain.showMenu();
			if (allow==1){
				objMain.addPilot();				
			}else if (allow==2){
				objMain.showAverageTimes();
			}			
		}while (allow!=0);

		System.out.println("¡Bye!");			
	}

	public int showMenu(){
		int allow=0;
		System.out.println("");
		System.out.println("Ingrese:"+
			"\n(1)Para ingresar un piloto"+
			"\n(2)Para ver el promedio del tiempo en las carreras de cada piloto"+
			"\n(0)Para sair");
		allow = lector.nextInt();lector.nextLine();
		return allow;
	}

	public void createChampion(){
		System.out.println("Ingrese el year del campeonato");
		int year = lector.nextInt();

		System.out.println("Ingrese la cantidad de grandes premios del campeonato");
		int races = lector.nextInt();lector.nextLine();		
			//no necesito runners, se puede crear un array con posiciones vacias

		tournament = new Championship (year,races);
	}
		
	public void addPilot(){
		System.out.println("Ingrese el nombre del piloto");
		String name= lector.nextLine();
		System.out.println("Ingrese la edad del piloto");
		int age = lector.nextInt(); lector.nextLine();
		System.out.println("Ingrese a que equipo pertenece:"+
			"\n(1)Scuderia ferrari"+
			"\n(2)McLaren f1 team"+
			"\n(3)Red bull racing"+
			"\n(4)Mercedes amg"+
			"\n(5)Racing point"+
			"\n(6)Alfa romeo"+
			"\n(7)Renault"+
			"\n(8)Williams");
		int team=lector.nextInt();lector.nextLine();
		int amount=tournament.getRaces();
		int []times= new int [amount];
		for (int i=0;i<times.length;i++){
			System.out.println("Ingrese el tiempo del "+(i+1)+" gran premio");
			times[i]=lector.nextInt();
		}
		String message;
		message=tournament.addPilot(name,age,team,times);
		System.out.println(message);
	}

	public void showAverageTimes(){
		System.out.println("De que piloto quiere conocer los tiempos");
		String name=lector.nextLine();
		System.out.println(tournament.showAverageTimes(name));
	}

}
