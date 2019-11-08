package inc.solutions.numerical;

class Solver
{
	private Matrix_Solve_Behavior _bhv;

	Solver()
	{
		_bhv = new NullBehavior();
	}

	double[] solve(double[][] input, double[] output)
	{
		return _bhv.solve(input, output);
	}

	void set_behavior(Matrix_Solve_Behavior _bhv)
	{
		this._bhv = _bhv;
	}
}
