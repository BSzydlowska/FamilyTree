
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class RelationshipsUtility {
	
	public static Scanner sc= new Scanner(System.in);
	private static Map<String,HashMap<String,Relation>> familyMap = new HashMap<>();
	
	public RelationshipsUtility() {
	}
	
	public static void addRelation(String firstPerson, Relation secondToFirstRel, String secondPerson, Relation firstToSecondRel, Boolean isMirrorRel){
		
		// Function adds to familyTree relation A -> B (isMirrorRel = false)
		// 	automatically adds B -> A relation (isMirrorRel = true) 	 
		
		HashMap<String, Relation> personalMap = new HashMap<>();
		
		if (familyMap.get(firstPerson) == null){
			personalMap.put(secondPerson, secondToFirstRel);
			familyMap.put(firstPerson, personalMap);
			System.out.println("Welcome to the family, " + firstPerson );
		} else {
			personalMap = familyMap.get(firstPerson);
			if (personalMap.get(secondPerson) == null){
				personalMap.put(secondPerson, secondToFirstRel);
			}
		}
		if (!isMirrorRel){
			addRelation(secondPerson, firstToSecondRel, firstPerson, secondToFirstRel, true);
		}
	}
	
	public void printFamilyMap(){
		System.out.println("Family Tree:\n");
		
		for (Map.Entry<String,HashMap<String,Relation>> entry : familyMap.entrySet()){
			System.out.println("Person: " + entry.getKey() + ":");
			entry.getValue().forEach((p,role) -> { System.out.println("\t\t\t" + p + " - " + role.toString());});
		}
	}

	public static void getSiblings(Query query) {
		Boolean foundMember = false;
		if (familyMap.get(query.firstPerson) == null) System.out.println("Unregonised member of the family.");
		else { 
			System.out.println(query.firstToSecondRel + ": ");
			for (Map.Entry<String,Relation> entry : familyMap.get(query.firstPerson).entrySet()){
				if (entry.getValue().equals(query.secondToFirstRel)){
					System.out.println("\t\t\t" + entry.getKey());
					foundMember = true;
				}
			}
			if (!foundMember) System.out.println("\tnot found."  );
		}
	}
	
	public void proceedWithQuerry() {
		String statement = sc.nextLine();
		Query query = QueryParser.parse(statement);
		query.command.executeCommand(query);
	}

	public void populateFamilyTree() {
		addRelation("Bern", Relation.WIFE, "Julia", Relation.HUSBAND, false); 
		addRelation("Bern", Relation.SON, "Boris", Relation.FATHER, false);
		addRelation("Bern", Relation.SON, "Adam", Relation.FATHER, false);
		addRelation("Bern", Relation.DAUGHTER, "Zoe", Relation.FATHER, false);
		addRelation("Julia", Relation.SON, "Adam", Relation.MOTHER, false);
		addRelation("Julia", Relation.SON, "Boris", Relation.MOTHER, false);
		addRelation("Julia", Relation.DAUGHTER, "Zoe", Relation.MOTHER, false);
		addRelation("Julia", Relation.SISTER, "Alicia", Relation.SISTER, false);
		addRelation("Bern", Relation.SIBLING, "Alicia", Relation.SIBLING, false);
	}
}
