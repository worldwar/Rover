package bananafish.worldwar;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/7/13
 * Time: 10:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Rover {
    private int x;
    private int y;
    private Face face;

    public Rover()
    {
		deploy(0, 0, Face.EAST);
    }

    public void deploy(int x, int y, Face face) {
		this.x = x;
		this.y = y;
		this.face = face;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Face face() {
        return face;
    }

	public void turnLeft() {
		face = Face.leftOf(face);
	}

	public void turnRight() {
		face = Face.rightOf(face);
	}

	public void goAhead() {
		switch (face) {
			case EAST:++x;
				break;
			case NORTH:++y;
				break;
			case WEST:--x;
				break;
			case SOUTH:--y;
				break;
		}
	}

	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append(x);
		result.append(" ");
		result.append(y);
		result.append(" ");
		result.append(face);
		return result.toString();
	}
}
