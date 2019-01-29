class MyLib {

  public List<Integer> findKClosestElements(List<Integer> arr, int k, int x) {
		int n = arr.size();
		if (x <= arr.get(0)) {
			return arr.subList(0, k);
		} else if (arr.get(n - 1) <= x) {
			return arr.subList(n - k, n);
		} else {
			int index = Collections.binarySearch(arr, x);
			if (index < 0)
				index = -index - 1;
			int low = Math.max(0, index - k - 1), high = Math.min(arr.size() - 1, index + k - 1);

			while (high - low > k - 1) {
				if (low < 0 || (x - arr.get(low)) <= (arr.get(high) - x))
					high--;
				else if (high > arr.size() - 1 || (x - arr.get(low)) > (arr.get(high) - x))
					low++;
				else
					System.out.println("unhandled case: " + low + " " + high);
			}
			return arr.subList(low, high + 1);
		}
	}
  
  public int binarySearch(int[] nums, int target) {
        int low = 0, hi = nums.length - 1;
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1; //hi = mid WRONG!
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
  public boolean twoDBinarySearch(int[][] matrix, int target) { 
		if (matrix.length == 0 || matrix[0].length == 0) 
			return false; 
		int row = matrix.length; 
		int col = matrix[0].length; 
		int i = 0;// left 
		int j = row * col - 1;// right 
		while (i <= j) { 
			int mid = i + (j - i)/2; 
			int r = mid / col; // helper function to map n-dimensional 
			// coordinate to 1D coordinate (vice versa) 
			int c = mid % col; 
			if (matrix[r][c] == target) 
				return true; 
			else if (matrix[r][c] > target) 
				j = mid - 1; 
			else 
				i = mid + 1; 
		} 
		return false; 
		}
	}
