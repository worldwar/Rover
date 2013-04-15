package test.bananafish.worldwar;

import bananafish.worldwar.Face;
import bananafish.worldwar.Rover;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/7/13
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoverTest {

	private int deployX;
	private int deployY;
	private Face deployFace;
	private Rover rover;

	@Before
	public void setUp()
	{
		deployX = 1;
		deployY = 2;
		deployFace = Face.EAST;
		rover = new Rover();
	}

    @Test
    public void the_rover_could_be_deployed()
    {
		rover.deploy(deployX, deployY, deployFace);
        Assert.assertEquals(1, rover.x());
        Assert.assertEquals(2, rover.y());
        Assert.assertEquals(Face.EAST, rover.face());
    }

	@Test
	public  void should_the_face_of_rover_be_east_after_it_turn_left_whose_face_was_south_when_deployed()
	{
		rover.deploy(deployX, deployY, Face.SOUTH);
		rover.turnLeft();
		Assert.assertEquals(Face.EAST, rover.face());
	}

	@Test
	public  void should_the_face_of_rover_be_east_after_it_turn_right_whose_face_was_north()
	{
		rover.deploy(deployX, deployY, Face.NORTH);
		rover.turnRight();
		Assert.assertEquals(Face.EAST, rover.face());
	}

	@Test
	public void should_location_of_rover_change_when_it_goes_ahead()
	{
		rover.deploy(deployX, deployY, Face.WEST);
		rover.goAhead();
		Assert.assertEquals(deployX - 1, rover.x());
		Assert.assertEquals(deployY, rover.y());
		Assert.assertEquals(Face.WEST, rover.face());

	}

	@Test
	public void should_location_of_rover_has_been_set()
	{
		Rover rover = new Rover();
		Assert.assertNotNull(rover.face());
	}
}
