package inc.solutions.numerical;

import inc.solutions.numerical.Behavior.Matrix_Solve_Behavior;

public class LinearSolverDeluxe {
    private Matrix_Solve_Behavior _behavior;

    public LinearSolverDeluxe(Matrix_Solve_Behavior behavior)
    {
        _behavior = behavior;
    }

    public void set_behavior(Matrix_Solve_Behavior next_behavior)
    {
        _behavior = next_behavior;
    }

    public double[] solve(double[][] input, double[] result)
    {
        return _behavior.solve(input, result);
    }
}
