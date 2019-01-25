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
	public static RelationshipFactory rl = new RelationshipFactory();
	

	
	public static void main(String[] args) {
		
		Boolean quit = false;
		
		printMenu();
		try{
			while(!quit){
				System.out.println("Enter option:");
				int operation = sc.nextInt();
				sc.nextLine();
				switch(operation){
					case 1:
						System.out.println("Menu:");
						printMenu();
						break;
					case 2:
						rl.printFamilyMap();
						break;
					case 3:
						System.out.println("Enter query");
						proceedWithQuerry();
						break;
					case 4:
						System.out.println("Fill with test data");
						rl.populateFamilyTree();
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

	private static void proceedWithQuerry() {
		String query = sc.nextLine();
		QueryParser qp = new QueryParser();
		qp = qp.parse(query);
		if (qp.com.equals(Command.ADD)){
			rl.addRelation(qp.p1,qp.rel2,qp.p2,qp.rel1,0);
		} else if (qp.com.equals(Command.RETRIEVE)){
			rl.getSiblings(qp);
		} else{
			System.out.println("Process terminated");
		}
	}

	private static void printMenu() {
		System.out.println("1 - Print menu,"
				+ "\n2 - Print familyTree,"
				+ "\n3 - Enter query,"
				+ "\n4 - Inject test data.");
	}
}
