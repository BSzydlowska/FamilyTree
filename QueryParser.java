import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Relation {MOTHER, FATHER, SON, DAUGHTER, BROTHER, SISTER, WIFE, HUSBAND, SIBLING};

public class QueryParser {
 
	/*
	  	Person=Bern Relation=Wife
		Mother=Julia Son=Boris
	*/
	
	private QueryParser() {
	}

	public static Query parse(String statement) {
		
		Query query = new Query();
		List<String> list = Stream.of(statement.split("[ =]+")).map(elem -> new String(elem)).collect(Collectors.toList());
		if (list.size()!=4) {
			query.command = new ErrorCommand();
		} else if (list.get(0).equals("Person")){
			query.command = new RetrieveCommand();
			query.firstPerson = list.get(1);
			query.firstToSecondRel = adjustRelation(list.get(3));
		} else {
			query.command = new AddCommand();
			query.firstPerson = list.get(1);
			query.secondPerson = list.get(3);
			query.secondToFirstRel = adjustRelation(list.get(0));
			query.firstToSecondRel = adjustRelation(list.get(2));	
		}

	return query;
	}
	
	private static Relation adjustRelation(String relation){
		switch(relation){
			case "Mother":
				return Relation.MOTHER;
			case "Father":
				return Relation.FATHER;
			case "Husband":
				return Relation.HUSBAND;
			case "Wife":
				return Relation.WIFE;
			case "Son":
				return Relation.SON;
			case "Sons":
				return Relation.SON;
			case "Daughters":
				return Relation.DAUGHTER;
			case "Daughter":
				return Relation.DAUGHTER;
			case "Sisters":
				return Relation.SISTER;
			case "Sister":
				return Relation.SISTER;
			case "Brother":
				return Relation.BROTHER;
			case "Brothers":
				return Relation.BROTHER;
			default:
				return Relation.SIBLING;
			}
	}
}
