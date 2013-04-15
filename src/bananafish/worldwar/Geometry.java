package bananafish.worldwar;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/14/13
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class Geometry {
	private int x;
	private int y;
	private Face face;


	public Geometry(int x, int y, Face face) {
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
}
