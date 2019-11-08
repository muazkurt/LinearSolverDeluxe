package inc.solutions.numerical;

public class LinearSolverDeluxe {
    private Solver solver;

    public LinearSolverDeluxe(Matrix_Solve_Behavior behavior)
    {
        solver = new Solver();
        solver.set_behavior(behavior);
    }

    public void change_solving_method(Matrix_Solve_Behavior next_behavior)
    {
        solver.set_behavior(next_behavior);
    }

    public double[] solve(double[][] input, double[] result)
    {
        return solver.solve(input, result);
    }

}
