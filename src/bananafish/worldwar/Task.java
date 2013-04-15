package bananafish.worldwar;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/14/13
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Task {

	private String deployInstruction;
	private String actionInstruction;
	private Rover rover;

	public Rover getRover() {
		return rover;
	}

	public void setRover(Rover rover) {
		this.rover = rover;
	}

	public void setDeployInstruction(String instruction) {
		deployInstruction = instruction;
	}

	public String getDeployInstruction() {
		return deployInstruction;
	}

	public String getActionInstruction() {
		return actionInstruction;
	}

	public void setActionInstruction(String instruction) {
		actionInstruction = instruction;
	}
}
