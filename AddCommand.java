
public class AddCommand implements Command {

	@Override
	public void executeCommand(Query query) {
		RelationshipsUtility.addRelation(query.firstPerson,query.secondToFirstRel,query.secondPerson,query.firstToSecondRel,false);

	}
}
