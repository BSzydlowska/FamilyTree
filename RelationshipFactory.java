
import java.util.HashMap;
import java.util.Map;


public class RelationshipFactory {
	
	private static Map<String,HashMap<String,Relation>> familyMap = new HashMap<>();
	
	public RelationshipFactory() {
	}

	public void addRelation(String p1, Relation rel1, String p2, Relation rel2, int mode){
		
		HashMap<String, Relation> personalMap = new HashMap<>();
		
		if (familyMap.get(p1) == null){
			personalMap.put(p2, rel1);
			familyMap.put(p1, personalMap);
			System.out.println("Welcome to the family, " + p1 );
		} else {
			personalMap = familyMap.get(p1);
			if (personalMap.get(p2) == null){
				personalMap.put(p2, rel1);
			}
		}
		if (mode == 0){
			addRelation(p2, rel2, p1, rel1, 1);
		}
	}
	
	public void printFamilyMap(){
		
		System.out.println("Family Tree:\n");
		
		for (Map.Entry<String,HashMap<String,Relation>> entry : familyMap.entrySet()){
			System.out.println("Person: " + entry.getKey() + ":");
			entry.getValue().forEach((p,role) -> { System.out.println("\t\t\t" + p + " - " + role.toString());});
		}
	}

	public void getSiblings(QueryParser qp) {
		Boolean foundMember = false;
		if (familyMap.get(qp.p1) == null) System.out.println("Unregonised member of the family.");
		else { 
			System.out.println(qp.rel2 + ": ");
			for (Map.Entry<String,Relation> entry : familyMap.get(qp.p1).entrySet()){
				if (entry.getValue().equals(qp.rel2)){
					System.out.println("\t\t\t" + entry.getKey());
					foundMember = true;
				}
			}
			if (!foundMember) System.out.println("\tnot found."  );
		}
	}

	public void populateFamilyTree() {
		addRelation("Bern", Relation.WIFE, "Julia", Relation.HUSBAND, 0); 
		addRelation("Bern", Relation.SON, "Boris", Relation.FATHER, 0);
		addRelation("Bern", Relation.SON, "Adam", Relation.FATHER, 0);
		addRelation("Bern", Relation.DAUGHTER, "Zoe", Relation.FATHER, 0);
		addRelation("Julia", Relation.SON, "Adam", Relation.MOTHER, 0);
		addRelation("Julia", Relation.SON, "Boris", Relation.MOTHER, 0);
		addRelation("Julia", Relation.DAUGHTER, "Zoe", Relation.MOTHER, 0);
		addRelation("Julia", Relation.SISTER, "Alicia", Relation.SISTER, 0);
		addRelation("Bern", Relation.SIBLING, "Alicia", Relation.SIBLING, 0);
	}
}
