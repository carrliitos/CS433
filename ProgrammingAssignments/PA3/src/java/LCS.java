public class LCS {
	public static String compute(final String x, final String y) {
		int lenx = x.length();
		int leny = y.length();
		int length[][] = new int[lenx + 1][leny + 1];
		char direction[][] = new char[lenx + 1][leny + 1];

		for(int i = 0; i <= lenx; i++) {
			length[i][0] = 0;
			direction[i][0] = '\0';
		}

		for(int j = 0; j <= leny; j++) {
			length[0][j] = 0;
			direction[0][j] = '\0';
		}

		for(int i = 1; i <= lenx; i++) {
			for(int j = 1; j<= leny; j++) {
				if(x.charAt(i - 1) == y.charAt(j - 1)) {
					length[i][j] = length[i - 1][j - 1] + 1;
					direction[i][j] = 'D';
				}else if(length[i - 1][j] > length[i][j-1]) {
					length[i][j] = length[i - 1][j];
					direction[i][j] = 'U';
				}else {
					length[i][j] = length[i][j - 1];
					direction[i][j] = 'L';
				}
			}
		}

		String answer = "";
		while(direction[lenx][leny] != '\0') {
			if(direction[lenx][leny] == 'D') {
				answer += x.charAt(lenx - 1);
				lenx--;
				leny--;
			}else if(direction[lenx][leny] == 'U') lenx--;
			else leny--;
		}

		return new StringBuilder(answer).reverse().toString()
	}
}
