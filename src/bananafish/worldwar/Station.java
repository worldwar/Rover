package bananafish.worldwar;

import java.util.List;

import static bananafish.worldwar.Interception.geometry;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/14/13
 * Time: 10:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class Station {
	public void emit(Rover rover, Instruction instruction) {
		switch (instruction) {
			case TURN_LEFT:rover.turnLeft();
				break;
			case TURN_RIGHT:rover.turnRight();
				break;
			case GO_AHEAD:rover.goAhead();
				break;
		}
	}

	public void deploy(Rover rover, String s) {
		Geometry geometry = geometry(s);
		rover.deploy(geometry.x(), geometry.y(), geometry.face());
	}

	public void transmit(Rover rover, String instructions) {
		for(char instruction : instructions.toCharArray())
		{
			emit(rover, instruction);
		}
	}

	private void emit(Rover rover, char instruction) {
		emit(rover, Interception.get(instruction));
	}

	public void perform(Task task) {
		deploy(task.getRover(), task.getDeployInstruction());
		transmit(task.getRover(), task.getActionInstruction());
	}

	public void perform(List<Task> tasks) {
		for(Task task : tasks)
		{
			perform(task);
		}
	}

	public void start(String filename)
	{
		Fetcher fetcher =Fetcher.from(filename);
		perform(fetcher.tasks());
		for (Task task : fetcher.tasks())
		{
			System.out.println(task.getRover());
		}
	}
}
