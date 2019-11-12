package inc.solutions.numerical;

/**
 * This is a class that solves equations with its behavior.
 * @author Muaz Kurt
 * @version 1.0.0
 */
class Solver
{
	/**
	 * Behavior of the solver, solving depends on this.
	 */
	private Matrix_Solve_Behavior _bhv;

	/**
	 * Creates the class with the NullBehavior solving behavior.
	 */
	Solver()
	{
		_bhv = new NullBehavior();
	}

	/**
	 * Solves equations with its behavior's solving method.
	 * @param input MxM matrix of equations.
	 * @param output M matrix of results.
	 * @return result of the calculation.
	 */
	double[] solve(double[][] input, double[] output)
	{
		return _bhv.solve(input, output);
	}

	/**
	 * This method allows us to chance matrix solving behavior dynamically.
	 * @param _bhv the next behavior of the instance.
	 */
	void set_behavior(Matrix_Solve_Behavior _bhv)
	{
		this._bhv = _bhv;
	}
}
