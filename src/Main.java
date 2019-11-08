import inc.solutions.numerical.Gaussian_Solver_Behavior;
import inc.solutions.numerical.LinearSolverDeluxe;
import inc.solutions.numerical.Matrix_Inversion_Behavior;

public class Main {
	// sample client
	public static void main(String[] args) {
		double[][] A = {
				{ 2, -1,  3 },
				{ 2, 2, 3 },
				{ -2, 3, 0 }
		};
		double[] b = { 5, 7, -3 };
		LinearSolverDeluxe test = new LinearSolverDeluxe(new Matrix_Inversion_Behavior());
		double[] x = test.solve(A,b);
		for (double x1 : x) System.out.println("| " + x1 + " |");
		System.out.println("--------------");

		test.change_solving_method(new Gaussian_Solver_Behavior());
		x = test.solve(A, b);
		for (double x1 : x) System.out.println("| " + x1 + " |");



		System.out.println("--------------");
		A = new double[][]{{5, 2}, {-3, 3}};
		b = new double[]{3, 15};
		test = new LinearSolverDeluxe(new Gaussian_Solver_Behavior());
		x = test.solve(A, b);
		// print results
		for (double x1 : x) System.out.println("| " + x1 + " |");
		System.out.println("--------------");
		test.change_solving_method(new Matrix_Inversion_Behavior());
		x = test.solve(A, b);
		// print results
		for (double x1 : x) System.out.println("| " + x1 + " |");
	}


}
