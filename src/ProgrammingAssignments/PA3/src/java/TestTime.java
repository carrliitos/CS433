import java.util.Random;

public class TestTime {
	private static void loadTestMaxSumSubArray() throws Exception {
		System.out.println("*** Brute-Force vs Divide-and-Conquer vs Dynamic-Programming ***\n");
		for (int maxArrayLen = 1000; maxArrayLen <= 150000; maxArrayLen = (int) (maxArrayLen * 1.2)) {
			Random rand = new Random(System.currentTimeMillis());
			int A[] = new int[maxArrayLen];
			for (int i = 0; i < maxArrayLen; i++) {
				A[i] = 2500 - rand.nextInt(5000);
			}
			long startTime_BF, startTime_DC, startTime_DP;
			long timeDiff_BF, timeDiff_DC, timeDiff_DP;
			startTime_BF = System.currentTimeMillis();
			int[] answer_BF = MaxSubarraySum.bruteForce(A, maxArrayLen);
			timeDiff_BF = System.currentTimeMillis() - startTime_BF;

			startTime_DC = System.currentTimeMillis();
			int[] answer_DC = MaxSubarraySum.divideAndConquer(A, maxArrayLen);
			timeDiff_DC = System.currentTimeMillis() - startTime_DC;

			startTime_DP = System.currentTimeMillis();
			int[] answer_DP = MaxSubarraySum.dynamicProgram(A, maxArrayLen);
			timeDiff_DP = System.currentTimeMillis() - startTime_DP;

			if (answer_BF[0] != answer_DC[0] || answer_DC[0] != answer_DP[0])
				throw new Exception("Okay, we are screwed!");

			System.out.printf(
					"Length = %6d, Brute-Force Time = %4dms, Divide-and-Conquer = %2dms, Dynamic-Programming = %dms\n",
					maxArrayLen, timeDiff_BF, timeDiff_DC, timeDiff_DP);
		}
		
		System.out.println("\n*** Divide-and-Conquer vs Dynamic-Programming ***\n");
		for (int maxArrayLen = 150000; maxArrayLen <= 50000000; maxArrayLen = (int) (maxArrayLen * 1.2)) {
			Random rand = new Random(System.currentTimeMillis());
			int A[] = new int[maxArrayLen];
			for (int i = 0; i < maxArrayLen; i++) {
				A[i] = 2500 - rand.nextInt(5000);
			}
			long startTime_DC, startTime_DP;
			long timeDiff_DC, timeDiff_DP;

			startTime_DC = System.currentTimeMillis();
			int[] answer_DC = MaxSubarraySum.divideAndConquer(A, maxArrayLen);
			timeDiff_DC = System.currentTimeMillis() - startTime_DC;

			startTime_DP = System.currentTimeMillis();
			int[] answer_DP = MaxSubarraySum.dynamicProgram(A, maxArrayLen);
			timeDiff_DP = System.currentTimeMillis() - startTime_DP;

			if (answer_DC[0] != answer_DP[0])
				throw new Exception("Okay, we are screwed!");

			System.out.printf(
					"Length = %8d, Divide-and-Conquer = %4dms, Dynamic-Programming = %2dms\n",
					maxArrayLen, timeDiff_DC, timeDiff_DP);
		}
	}
	
	public static void main(String[] args) throws Exception {
		loadTestMaxSumSubArray();
	}
}
