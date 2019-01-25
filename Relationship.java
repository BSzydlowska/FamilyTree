import java.util.HashMap;

public class Relationship {
	private static Relationship relationship = null;
	
	static HashMap<Relation, Relation> relationsMapForM;
	static HashMap<Relation, Relation> relationsMapForF;
	
	private Relationship() {
		
		relationsMapForF.put(Relation.MOTHER, Relation.DAUGHTER);
		relationsMapForF.put(Relation.HUSBAND, Relation.WIFE);
		
		relationsMapForM.put(Relation.MOTHER, Relation.SON);
		relationsMapForM.put(Relation.WIFE, Relation.HUSBAND);
	}
	
	public Relationship setRelationsMaps(){
		if (relationship == null){
			relationship = new Relationship();
		}
		return relationship;
	}
	
//	public static Relation getOpositeRelation(Relation rel, Gender gen){
//		if (gen == Gender.F){
//			return relationsMapForF.get(rel);
//		}
//		return relationsMapForM.get(rel);
//	}
}