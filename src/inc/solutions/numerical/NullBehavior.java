package inc.solutions.numerical;

/**
 * This is the main behavior of any solver instance.
 * Why this is necessary? Because avoiding the null pointer exception.
 * @author Muaz Kurt
 * @version 1.0.0
 */
public class NullBehavior implements Matrix_Solve_Behavior
{
	/**
	 * Implements the method to do nothing and print an output message.
	 * @param input Don't care
	 * @param result Don't care
	 * @return A 1x1 vector that contains 0.
	 */
	@Override
	public double[] solve(double[][] input, double[] result)
	{
		System.err.println("Null behavior doesn't calculate anything. Please give a behavior.");
		return new double[0];
	}
}
