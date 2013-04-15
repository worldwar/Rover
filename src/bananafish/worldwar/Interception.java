package bananafish.worldwar;

import java.awt.datatransfer.StringSelection;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/14/13
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class Interception {
	public static Instruction get(char c) {
		switch (c)
		{
			case 'L':return Instruction.TURN_LEFT;
			case 'R':return Instruction.TURN_RIGHT;
			case 'M':return Instruction.GO_AHEAD;
		}
		return Instruction.NONSENCE;
	}

	public static Geometry geometry(String s) {
		String[] strings = s.split(" ");
		if(strings.length < 3)
			return null;
		int x = Integer.valueOf(strings[0]);
		int y = Integer.valueOf(strings[1]);
		Face face = face(strings[2].charAt(0));
		return new Geometry(x, y, face);
	}

	private static Face face(char c) {
		switch (c)
		{
			case 'E':return Face.EAST;
			case 'S':return Face.SOUTH;
			case 'W':return Face.WEST;
			case 'N':return Face.NORTH;
			default:return Face.EAST;
		}
	}
}
