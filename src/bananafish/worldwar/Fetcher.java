package bananafish.worldwar;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/14/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class Fetcher {

	private static BufferedReader reader;
	private final List<Task> tasks;
	private final int count;

	public Fetcher(int count, List<Task> tasks) {
		this.count = count;
		this.tasks = tasks;

	}

	public static Fetcher from(String filename) {
		initialize(filename);
		return from(reader);
	}

	public static Fetcher from(InputStream stream)
	{
		initialize(stream);
		return from(reader);
	}

	private static Fetcher from(BufferedReader reader)
	{
		try {
			String first = reader.readLine();
			int count = Integer.parseInt(first);
			List<Task> tasks = new ArrayList<Task>();
			for(int i = 0; i < count; ++i)
			{
				Task task = new Task();
				task.setRover(new Rover());
				tasks.add(task);
			}
			for(Task task : tasks)
			{
				task.setDeployInstruction(reader.readLine());
			}

			for(Task task : tasks)
			{
				task.setActionInstruction(reader.readLine());
			}

			return new Fetcher(count, tasks);
		} catch (IOException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
			return null;
		}

	}

	private static void initialize(String filename) {
		try {
			reader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}

	private static void initialize(InputStream stream)
	{
		reader = new BufferedReader(new InputStreamReader(stream));
	}

	public int count() {
		return count;
	}

	public List<Task> tasks() {
		return tasks;
	}
}
