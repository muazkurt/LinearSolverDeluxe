import inc.solutions.numerical.Behavior.Gaussian_Solver_Behavior;
import inc.solutions.numerical.Behavior.Matrix_Inversion_Behavior;
import inc.solutions.numerical.LinearSolverDeluxe;

public class Main {
	// sample client
	public static void main(String[] args) {
		int n = 3;
		double[][] A = {
				{ 2, -1,  3 },
				{ 2, 2, 3 },
				{ -2, 3, 0 }
		};
		double[] b = { 5, 7, -3 };
		LinearSolverDeluxe test = new LinearSolverDeluxe(new Gaussian_Solver_Behavior());

		double[] x = test.solve(A,b);
		// print results
		for (int i = 0; i < n; i++) {
			System.out.println(x[i]);
		}
	}


}
