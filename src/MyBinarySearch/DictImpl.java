package MyBinarySearch;

import java.util.Arrays;

class DictImpl implements Dict​ {
    private int[] array;

    public DictImpl(int[] array) {
        this.array = array;
    }

    // If the index is out of bound, null will be returned.
    @Override
    public Integer get(int index) {
        if (array == null || index >= array.length) {
            return null;
        }
        return array[index];
    }

    // For pretty printout.
    @Override
    public String toString() {
        if (array == null) {
            return String.valueOf(null);
        }
        if (array.length <= 10) {
            return Arrays.toString(array);
        }
        // Truncate output if array is too large.
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 5; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append("......, ");
        for (int i = array.length - 4; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
