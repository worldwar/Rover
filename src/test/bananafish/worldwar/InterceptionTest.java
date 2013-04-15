package test.bananafish.worldwar;

import bananafish.worldwar.Instruction;
import bananafish.worldwar.Interception;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/14/13
 * Time: 10:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class InterceptionTest {
	@Test
	public void should_char_L_be_intercepted_as_turn_left()
	{
		Assert.assertEquals(Instruction.TURN_LEFT, Interception.get('L'));
	}

	@Test
	public void should_char_R_be_intercepted_as_turn_right()
	{
		Assert.assertEquals(Instruction.TURN_RIGHT, Interception.get('R'));
	}

	@Test
	public void should_char_M_be_intercepted_as_go_ahead()
	{
		Assert.assertEquals(Instruction.GO_AHEAD, Interception.get('M'));
	}
}
