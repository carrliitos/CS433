public class Fibo {
	public static void main(String[] args) {
		int n = 6;
		for(int i = 0; i <= n; i++) {
			System.out.println("i = " + i);
			int recursFib = recursiveFib(i);
			System.out.println("Recursive Fibonacci Value = " + recursFib);

			int memoFib = memoizeFib(i);
			System.out.println("Memoized Fibonacci Value = " + memoFib);

			int dynamoFib = dynamicFib(i);
			System.out.println("Dynamic Programming Fibonacci Value = " + dynamoFib);
		}
	}

	public static int recursiveFib(int n) {
		if(n <= 1) return 1;
		else return recursiveFib(n - 1) + recursiveFib(n - 2);
	}

	private static int memoizeFib(int n, int memo[]) {
		if(n <= 1) return 1;
		else if(memo[n] == -1) memo[n] = memoizeFib(n - 1, memo) + memoizeFib(n - 2, memo);
		return memo[n];
	}

	public static int memoizeFib(int n) {
		int F[] = new int[n + 1];
		for(int i = 0; i < F.length; i++) {
			F[i] = -1;
		}
		return memoizeFib(n, F);
	}

	public static int dynamicFib(int n) {
		if(n <= 1) return 1;
		int F[] = new int[n + 1];
		F[0] = 1;
		F[1] = 1;
		for(int i = 2; i <= n; i = i + 1) {
			F[i] = F[i - 1] + F[i - 2];
		}
		return F[n];
	}
}