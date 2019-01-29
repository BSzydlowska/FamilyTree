
public class ErrorCommand implements Command {

	@Override
	public void executeCommand(Query query) {
		System.out.println("Error while execution - command error.");

	}

}
