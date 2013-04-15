package test.bananafish.worldwar;

import bananafish.worldwar.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/14/13
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class StationTest {
	private Station station;
	private Rover rover;

	@Before
	public void setUp() throws Exception {
		rover = new Rover();
		station = new Station();
	}

	@Test
	public void should_rover_turn_left_after_station_emit_turn_left_instruction_to_it()
	{

		Face preFace = rover.face();
		station.emit(rover, Instruction.TURN_LEFT);
		Assert.assertEquals(Face.leftOf(preFace), rover.face());
	}

	@Test
	public void should_rover_turn_right_after_station_emit_turn_right_instruction_to_it()
	{
		Face preFace = rover.face();
		station.emit(rover, Instruction.TURN_RIGHT);
		Assert.assertEquals(Face.rightOf(preFace), rover.face());
	}

	@Test
	public void should_rover_be_deployed_after_station_emit_deploy_instruction_to_it()
	{
		station.deploy(rover, "1 2 W");
		Assert.assertEquals(1, rover.x());
		Assert.assertEquals(2, rover.y());
		Assert.assertEquals(Face.WEST, rover.face());
	}

	@Test
	public void should_geometry_of_rover_change_after_station_transmit_instruction_to_it()
	{
		station.deploy(rover, "5 3 E");
		station.transmit(rover, "LLMMLMRMMRM");
		Assert.assertEquals(1, rover.x());
		Assert.assertEquals(3, rover.y());
		Assert.assertEquals(Face.NORTH, rover.face());
	}

	@Test
	public void should_rover_arrive_at_target_when_station_perform_task()
	{
		Task task = new Task();
		task.setRover(new Rover());
		task.setDeployInstruction("5 3 E");
		task.setActionInstruction("LLMMLMRMMRM");
		station.perform(task);
		Assert.assertEquals(1, task.getRover().x());
		Assert.assertEquals(3, task.getRover().y());
		Assert.assertEquals(Face.NORTH, task.getRover().face());
	}

	@Test
	public void should_rovers_arrive_at_targets_when_station_perform_tasks()
	{

		Task task = new Task();
		task.setRover(new Rover());
		task.setDeployInstruction("5 3 E");
		task.setActionInstruction("LLMMLMRMMRM");

		Task task2 = new Task();
		task2.setRover(new Rover());
		task2.setDeployInstruction("2 3 N");
		task2.setActionInstruction("MRRMMLLMMRM");

		List<Task> tasks = new ArrayList<Task>();
		tasks.add(task);
		tasks.add(task2);
		station.perform(tasks);


		Assert.assertEquals(1, task.getRover().x());
		Assert.assertEquals(3, task.getRover().y());
		Assert.assertEquals(Face.NORTH, task.getRover().face());


		Assert.assertEquals(3, task2.getRover().x());
		Assert.assertEquals(4, task2.getRover().y());
		Assert.assertEquals(Face.EAST, task2.getRover().face());
	}

	@Test
	public void should_rovers_arrive_at_targets_when_station_perform_tasks_from_inputstream()
	{
//		List<Task> tasks = Fetcher.from("tasks.txt").tasks();
		List<Task> tasks = Fetcher.from(System.in).tasks();
		station.perform(tasks);

		Task task = tasks.get(0);

		Assert.assertEquals(1, task.getRover().x());
		Assert.assertEquals(3, task.getRover().y());
		Assert.assertEquals(Face.NORTH, task.getRover().face());


		Task task2 = tasks.get(1);
		Assert.assertEquals(3, task2.getRover().x());
		Assert.assertEquals(4, task2.getRover().y());
		Assert.assertEquals(Face.EAST, task2.getRover().face());

	}
}
