package bananafish.worldwar;

import java.net.NoRouteToHostException;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/13/13
 * Time: 11:55 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Face {
    EAST, NORTH, WEST, SOUTH;

	public static Face leftOf(Face face) {
		switch (face) {
			case EAST:return NORTH;
			case NORTH:return WEST;
			case WEST:return SOUTH;
			case SOUTH:return EAST;
			default:return EAST;
		}
	}

	public static Face rightOf(Face face) {
		switch (face) {
			case EAST:return SOUTH;
			case NORTH:return EAST;
			case WEST:return NORTH;
			case SOUTH:return WEST;
			default:return EAST;
		}
	}

	public String toString()
	{
		switch (this) {

			case EAST:return "E";
			case NORTH:return "N";
			case WEST:return "W";
			case SOUTH:return "S";
			default:return "";
		}
	}
}
