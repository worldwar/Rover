package test.bananafish.worldwar;

import bananafish.worldwar.Face;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/14/13
 * Time: 12:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class FaceTest {
	@Test
	public void should_left_of_east_be_north()
	{
		Assert.assertEquals(Face.NORTH, Face.leftOf(Face.EAST));
	}

	@Test
	public void should_right_of_south_be_west()
	{
		Assert.assertEquals(Face.WEST, Face.rightOf(Face.SOUTH));
	}
}