package test.bananafish.worldwar;

import bananafish.worldwar.Fetcher;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/14/13
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class FetcherTest {
	private Fetcher fetcher;

	@Test
	public void should_count_of_tasks_be_the_number_in_first_line()
	{
		fetcher = Fetcher.from("tasks.txt");
		Assert.assertEquals(fetcher.count(), fetcher.tasks().size());
	}
}
