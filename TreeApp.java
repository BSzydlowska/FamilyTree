import java.util.Scanner;

/*
 * 	Input:
    Person=Alex Relation=Brothers
	Expected Output
    Brothers=John,Joe

	Input:
    Husband=Bern Wife=Julia
	Expected Output
    Welcome to the family, Julia 
 *  
 */

public class TreeApp {

	public static Scanner sc= new Scanner(System.in);
	public static RelationshipsUtility ru = new RelationshipsUtility();
	
	public static void main(String[] args) {
		
		Boolean quit = false;
		
		printMenu();
		try{
			while(!quit){
				System.out.println("Enter option (1-4):");
				int operation = sc.nextInt();
				sc.nextLine();
				switch(operation){
					case 1:
						System.out.println("Menu:");
						printMenu();
						break;
					case 2:
						ru.printFamilyMap();
						break;
					case 3:
						System.out.println("Enter query");
						ru.proceedWithQuerry();
						break;
					case 4:
						System.out.println("Fill with test data");
						ru.populateFamilyTree();
						break;
					default:
						System.out.println("QUIT");
						quit = true;
						break;
				}
			}
		}
		catch(Exception e){
			System.out.println("Error while getting option - quit");
		}
	}

	private static void printMenu() {
		System.out.println("1 - Print options,"
				+ "\n2 - Print familyTree,"
				+ "\n3 - Enter query,"
				+ "\n\t Example:"
				+ "\n\t    Person=Bern Relation=Wife"
				+ "\n\t    Mother=Julia Son=Boris"
				+ "\n4 - Inject test data.");
	}
}