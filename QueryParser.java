import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Command {ADD, RETRIEVE, ERROR}
enum Relation {MOTHER, FATHER, SON, DAUGHTER, BROTHER, SISTER, WIFE, HUSBAND, SIBLING};

public class QueryParser {
 
	/*
	  	Person=Bern Relation=Wife
		Mother=Julia Son=Boris
	*/
	
	Command com; 
	String p1;
	String p2;
	Relation rel1;
	Relation rel2;
	
	public QueryParser() {
	}

	public QueryParser(Command com, String p1, String p2, Relation rel1, Relation rel2) {
		this.com = com;
		this.p1 = p1;
		this.p2 = p2;
		this.rel1 = rel1;
		this.rel2 = rel2;
	}

	public QueryParser parse(String query) {
		List<String> list = Stream.of(query.split("[ =]+")).map(elem -> new String(elem)).collect(Collectors.toList());
		if (list.size()!=4) {
			System.out.println("Error while parsing to list");
			com = Command.ERROR;
		} else if (list.get(0).equals("Person")){
			com = Command.RETRIEVE;
			p1 = list.get(1);
			rel2 = adjustRelation(list.get(3));
		} else {
			com = Command.ADD;
			p1 = list.get(1);
			p2 = list.get(3);
			rel1 = adjustRelation(list.get(0));
			rel2 = adjustRelation(list.get(2));	
		}

	return new QueryParser(com,p1,p2,rel1,rel2);
	}
	
	private Relation adjustRelation(String rel){
		switch(rel){
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
