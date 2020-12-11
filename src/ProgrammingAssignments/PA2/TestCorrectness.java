import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;

public class TestCorrectness {

	private static void testStringSorter() throws NumberFormatException, IOException {
		System.out.println("****************** Sorting Strings ******************\n");
		String[] strings = { "abc", "xyzw", "xyzab", "abcdx", "wxcdx", "abcxy", "aac", "wxcdx", "abcx", "abc" };
		System.out.println("Original order of strings: " + Arrays.toString(strings));
		StringSorter.radixSort(strings, strings.length);
		System.out.println("Radix-sorted order of strings: " + Arrays.toString(strings));
	}

	private static void testAVLCorrectness() throws Exception {
		System.out.println("\n****************** AVL ******************\n");
		int testArray[] = { 3, 34, 4, 12, 5, 2, 10, 17, 20, 25, 36, 40, 48, 54, 6, 8, 1, 50, 52, 49 };
		System.out.println("Numbers in BST: " + Arrays.toString(testArray));
		System.out.println();
		AVLApplications avl = new AVLApplications(testArray);
		Arrays.sort(testArray);
		System.out.println("Rank of 0 is " + avl.rank(0));
		for (int key : testArray)
			System.out.println("Rank of " + key + " is " + avl.rank(key));
		System.out.println("Rank of 60 is " + avl.rank(60));
		System.out.println();
		for (int k = 1; k <= testArray.length; k++)
			System.out.println("kth smallest number for k = " + k + " is " + avl.select(k));

		int L[] = { 15, 5, 5, 10, 55, 54, 54, 34, 37, 38, 47, 48, 10, 22, -8, 10, 39, 25, -8 };
		int R[] = { 14, 9, 10, 10, 57, 57, 54, 34, 47, 39, 47, 48, 54, 40, 88, 26, 57, 41, -4 };
		for (int i = 0; i < L.length; i++) {
			System.out.println();
			int l = L[i], r = R[i];
			System.out.print("Sorted Range Reporting for [" + l + ", " + r + "] = " + avl.sortedRangeReporting(l, r));
		}
		System.out.println();
	}

	private static int log2(int n) {
		if (n <= 2)
			return 1;
		int x = 1;
		int count = 0;
		while (x < n) {
			x = x * 2;
			count++;
		}
		return count;
	}

	static void printStatistics(HuffmanEncoder huffObj) {
		int msgLength = 0;
		int sigma = huffObj.getSigma();
		int[] frequencies = huffObj.getFrequencies();
		char[] alphabet = huffObj.getAlphabet();
		for (int i = 0; i < sigma; i++)
			msgLength += frequencies[i];
		System.out.println("ASCII encoding needs " + msgLength * 8 + " bits.");
		System.out.println(
				"Fixed length encoding needs " + (msgLength * log2(sigma) + sigma * (8 + log2(sigma))) + " bits.");
		System.out
				.println("Huffman encoding needs " + (huffObj.getTableSize() + huffObj.getEncodingLength()) + " bits.");
		System.out.print("Huffman Encoding: ");
		char c;
		for (int i = 0; i < sigma - 1; i++) {
			c = alphabet[i];
			System.out.print(c + "(" + huffObj.getEncoding(c) + "); ");
		}
		c = alphabet[sigma - 1];
		System.out.print(c + "(" + huffObj.getEncoding(c) + ")");
	}

	private static HuffmanEncoder testHuffmanEncoderHelper(int n, int sigma, double[] probabilities) {
		int freq[] = new int[sigma];
		char alphabet[] = new char[sigma];
		for (int i = 0; i < sigma; i++) {
			freq[i] = (int) (n * probabilities[i]);
			alphabet[i] = (char) (i + 65);
		}
		System.out.println("alphabet: " + Arrays.toString(alphabet));
		System.out.println("frequencies: " + Arrays.toString(freq));
		System.out.println();
		HuffmanEncoder huffObj = new HuffmanEncoder(alphabet, freq, sigma);
		printStatistics(huffObj);
		System.out.println("\n");
		return huffObj;
	}

	private static void testHuffmanEncoder() {

		System.out.println("\n****************** Huffman Encoding ******************\n");
		int sigma = 8;
		int n = 3280;
		double[] probabilities = { 0.06, 0.2, 0.15, 0.3, 0.05, 0.02, 0.08, 0.14 };
		testHuffmanEncoderHelper(n, sigma, probabilities);

		sigma = 6;
		n = 2000;
		probabilities = new double[] { 0.04, 0.07, 0.14, 0.2, 0.24, 0.31 };
		testHuffmanEncoderHelper(n, sigma, probabilities);
		
		sigma = 8;
		n = 200000;
		probabilities = new double[] { 0.04, 0.07, 0.12, 0.2, 0.18, 0.26, 0.11, 0.02 };
		testHuffmanEncoderHelper(n, sigma, probabilities);
		
		sigma = 8;
		n = 200000;
		probabilities = new double[] { 0.125, 0.125, 0.125, 0.125, 0.125, 0.125, 0.125, 0.125 };
		testHuffmanEncoderHelper(n, sigma, probabilities);
	}

	private static void testHuffmanDecoder() {
		System.out.println("****************** Huffman Decoding ******************\n");
		String msg = "BCCABBDDAECCBBAEDDCC";
		char alphabet[] = { 'A', 'B', 'C', 'D', 'E' };
		System.out.println("Original Message: " + msg + "\n");
		double probabilities[] = { 0.15, 0.25, 0.3, 0.2, 0.1 };
		int sigma = alphabet.length;
		HuffmanEncoder huffObj = testHuffmanEncoderHelper(20, sigma, probabilities);
		String encodedMsg = "";
		for (int i = 0; i < msg.length(); i++)
			encodedMsg += huffObj.getEncoding(msg.charAt(i));
		System.out.println("Encoded Message: " + encodedMsg);
		Hashtable<String, Character> encodingToChar = new Hashtable<String, Character>();
		for (int i = 0; i < sigma; i++)
			encodingToChar.put(huffObj.getEncoding(alphabet[i]), alphabet[i]);
		String decodedMsg = HuffmanDecoder.decode(encodedMsg, encodingToChar);
		System.out.println("Decoded Message: " + decodedMsg);
	}

	public static void main(String args[]) throws Exception {
		testStringSorter();
		testAVLCorrectness();
		testHuffmanEncoder();
		testHuffmanDecoder();
	}
}