package MyBinarySearch;

import java.util.*;
import java.util.stream.Collectors;

class MyBinarySearch {
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

    /**
     * Search in sorted matrix, each row of the matrix is sorted in ascending order,
     * and the first element of the row is equals to or larger than the last element
     * of the previous row.
     *
     * Return the position if the target is found, otherwise return {-1, -1}.
     */
    public class SearchInSortedMatrixI {
        // Assumptions: matrix is not null, and has size N * M where N >= 0 and M >= 0.
        // return {-1, -1} if not found.
        // Method 1: find row first then find col.
        public int[] searchI(int[][] matrix, int target) {
            int[] result = new int[] { -1, -1 };
            if (matrix.length == 0 || matrix[0].length == 0) {
                return result;
            }
            // Find the possible row location for target.
            int row = findRow(matrix, 0, matrix.length - 1, target);
            if (row == -1) {
                return result;
            }
            // Find the possible col location in the row for target.
            int col = findCol(matrix[row], 0, matrix[row].length - 1, target);
            if (col == -1) {
                return result;
            }
            result[0] = row;
            result[1] = col;
            return result;
        }

        // Find the largest row with first element <= target.
        private int findRow(int[][] matrix, int up, int down, int target) {
            while (up <= down) {
                int mid = up + (down - up) / 2;
                if (matrix[mid][0] > target) {
                    down = mid - 1;
                } else {
                    up = mid + 1;
                }
            }
            return down;
        }

        // Classical binary search to find the col on the row.
        private int findCol(int[] array, int left, int right, int target) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (array[mid] == target) {
                    return mid;
                } else if (array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }

        // Method 2: convert the 2D array to 1D array and do binary search.
        public int[] search(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return new int[] { -1, -1 };
            }
            int rows = matrix.length;
            int cols = matrix[0].length;
            int left = 0;
            // convert the 2D array to 1D array with rows * cols elements.
            int right = rows * cols - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                // convert the position in 1D array back to row and col in 2D array.
                int row = mid / cols;
                int col = mid % cols;
                if (matrix[row][col] == target) {
                    return new int[] { row, col };
                } else if (matrix[row][col] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return new int[] { -1, -1 };
        }
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

    public List<Integer> findClosestElements(int[] ar, int k, int x) {
        List<Integer> arr = Arrays.stream(ar).boxed().collect(Collectors.toList());
        int n = arr.size();
        if (x <= arr.get(0)) {
            return arr.subList(0, k);
        } else if (arr.get(n - 1) <= x) {
            return arr.subList(n - k, n);
        } else {
            int index = Collections.binarySearch(arr, x);
            //index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.
            if (index < 0)
                index = -index - 1;
            int low = Math.max(0, index - k - 1), high = Math.min(arr.size() - 1, index + k - 1);

            while (high - low > k - 1) {
                if ((x - arr.get(low)) <= (arr.get(high) - x))
                    high--;
                else if ((x - arr.get(low)) > (arr.get(high) - x))
                    low++;
            }
            return arr.subList(low, high + 1);
        }
    }

    public int[] kClosest(int[] array, int target, int k) {
        if (array == null || array.length == 0) {
            return array;
        }
        if (k == 0) {
            return new int[0];
        }
        // left is the index of the largest smaller or equal element,
        // right = left + 1.
        // These two should be the closest to target.
        int left = largestSmallerEqual(array, target);
        int right = left + 1;
        int[] result = new int[k];
        // this is a typical merge operation.
        for (int i = 0; i < k; i++) {
// we can advance the left pointer when:
            // 1. right pointer is already out of bound.
            // 2. right pointer is not out of bound, left pointer is not out of
            //    bound, and array[left] is closer to target.
            if (right >= array.length || left >= 0
                    && target - array[left] <= array[right] - target) {
                result[i] = array[left--];
            } else {
                result[i] = array[right++];
            }
        }
        return result;
    }

    private int largestSmallerEqual(int[] array, int target) {
        // find the largest smaller or equal element's index in the array
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[right] <= target) {
            return right;
        }
        if (array[left] <= target) {
            return left;
        }
        // can not find...
        return -1;
    }

    /**
     * Binary search implementation on an dictionary with unknown size.
     * Assumption:
     * 1). The dictionary is an unknown sized sorted array, it only provides
     *     get(int index) functionality, if the index asked for is out of right
     *     bound, it will return null.
     * 2). The elements in the dictionary are all Integers.
     */
    public class UnknownSizeBinarySearch {
        public int search(Dict​ dictionary, int target) {
            if (dictionary == null) {
                return -1;
            }
            int left = 0;
            int right = 1;
            // find the right boundary for binary search.
            // extends until we are sure the target is within the [left, right] range.
            while (dictionary.get(right) != null && dictionary.get(right) < target) {
                // 1. move left to right
                // 2. double right index
                left = right;
                right = 2 * right;
            }
            return binarySearch(dictionary, target, left, right);
        }

        private int binarySearch(Dict​ dict, int target, int left, int right) {
            // classical binary search
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (dict.get(mid) == null || dict.get(mid) > target) {
                    right = mid - 1;
                } else if (dict.get(mid) < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }
}
