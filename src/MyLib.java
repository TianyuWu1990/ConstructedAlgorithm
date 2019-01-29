import java.util.Collections;
import java.util.List;

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

    public boolean twoDimensionBinarySearch(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;// left
        int j = row * col - 1;// right
        while (i <= j) {
            int mid = i + (j - i) / 2;
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

    int ClosestToTargetBinarySearch(int[] a, int left, int right, int target) {
        int mid;
        // if left ​neighbors​ right -> terminate
        while (left < right - 1) {
            mid = left + (right - left) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                // left = mid + 1 (Wrong???)
                left = mid;
            } else {
                // right = mid - 1 (Wrong)
                right = mid;
            }
        }
        // Post-processing
        // ​// check a[left]against target first
        if (Math.abs(a[left] - target) <= Math.abs(a[right] - target))
            return left;
        else
            return right;
    }


    /*
    当L和R 相邻的时候，跳出while 循环，再判断L和R究竟哪个是最终答案 (= post-processing)。
     */
    int FirstTargetBinarySearch(int[] a, int left, int right, int target) {
        int mid;
        //if left ​neighbors​ right → terminate
        while (left < right - 1){
            mid = left + (right - left) / 2;
            if (a[mid] == target) {
                 //  right = mid - 1 (wrong)
                right = mid; //​left​ = mid; if find last occurrence of target
                // do not stop here, keep checking to left
            } else if (a[mid] < target) {
                // left = mid + 1 (correct)
                left= mid;
            } else {
                // right = mid - 1 (correct)
                right = mid;
            }
        }
        // Post processing
        // check a[left] against target first
        if (a[left] == target)
        return left;
        // then check a[right] against target
        if (a[right] == target)
            return right;
        return -1;
    }


}
