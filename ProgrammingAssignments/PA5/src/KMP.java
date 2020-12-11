import java.util.ArrayList;
import java.util.Arrays;

public class KMP {

	public static ArrayList<Integer> runKMP(final String text, final String pattern) {
		ArrayList<Integer> occ = new ArrayList<Integer>();
		int F[] = computeFailure(pattern);
		int txtLen = text.length();
		int patLen = pattern.length();
		int t = 0, p = 0;
		
		while(t < txtLen) {
			if(pattern.charAt(p) == text.charAt(t)) {
				if(p == patLen - 1) {
					occ.add(t - p);
					p = F[p];
				}else {
					p++;
				}
				
				t++;
			}else {
				if(p != 0) {
					p = F[p - 1];
				}else {
					t++;
				}
			}
		}

		return occ;
	}

	private static int[] computeFailure(final String pattern) {
		int patLen = pattern.length();
		int F[] = new int[patLen];
		int pref = 0;
		int suff = 1;
		F[0] = 0;

		while(suff != patLen) {
			if(pattern.charAt(suff) == pattern.charAt(pref)) {
				pref++;
				F[suff] = pref;
				suff++;
			}else if(pref == 0) {
				F[suff] = 0;
				suff++;
			}else {
				pref = F[pref - 1];
			}
		}

		return F;
	}
}
