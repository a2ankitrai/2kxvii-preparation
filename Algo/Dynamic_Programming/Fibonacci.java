class Fibonacci {

	public static int traditionalFibonacci(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;

		else {
			return traditionalFibonacci(n - 1) + traditionalFibonacci(n - 2);
		}
	}


	public int fibonacciMemo(int n) {
		int[] memo  = new int[n + 1];

		for (int i = 0; i < memo.length ; i++ ) {
			memo[i] = -1;
		}

		return fibonacciMemoAux(n, memo);
	}

	public int fibonacciMemoAux(int n, int[] memo) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (memo[n] != -1) {
			return memo[n];
		} else {
			memo[n] = fibonacciMemoAux(n - 1, memo) + fibonacciMemoAux(n - 2, memo);
			return memo[n];
		}

	}

	int fibonacci(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;

		int[] memo  = new int[n];
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i < n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];

		}
		return memo[n - 1] + memo[n - 2];
	}

	public static void main(String[] args) {
		int n = 12;

		System.out.println(traditionalFibonacci(n));

		Fibonacci fib = new Fibonacci();

		System.out.println(fib.fibonacciMemo(n));
	}
}