
public class RetrieveCommand implements Command {

	@Override
	public void executeCommand(Query query) {
		RelationshipsUtility.getSiblings(query);

	}
}
