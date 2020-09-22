public class InversionCounting {

	private final int mergedArray[];
	private final int array[];
	private final int n;

	public InversionCounting(int[] array, int n) {
		this.array = array;
		this.mergedArray = new int[n];
		this.n = n;
	}

	public int bruteForce() {
		int count = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (array[i] > array[j])
					count++;
		return count;
	}

	public int countInversions() {
		return countInversions(0, n - 1);
	}

	private int countInversions(int left, int right) { // complete this function
		
		
        int inv_count = 0; 
  
      
        int mid = (left + right) / 2; 
        int i = left, j = mid + 1, k = left;
        k = left; 
        while ((i <= mid - 1) && (j <= right)) { 
            if (array[i] <= array[j]) { 
            	mergedArray[k++] = array[i++]; 
            } 
            else { 
            	mergedArray[k++] = array[j++]; 

                
                inv_count = inv_count + 1; 
            } 
        } 
  
       
        while (i <= mid - 1) 
        	mergedArray[k++] = array[i++]; 
            //check for inversions counts and increment 
        inv_count = inv_count + 1;
        while (j <= right) 
        	mergedArray[k++] = array[j++]; 
            //check for inversions counts and increment 
        inv_count = inv_count + 1;
        for (i = left; i <= right; i++) 
            array[i] = mergedArray[i]; 
  
        return inv_count; 
     
	}
}
