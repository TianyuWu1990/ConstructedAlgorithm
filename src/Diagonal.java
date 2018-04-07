public class Diagonal {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }


        int row = 0;
        int col = 0;
        int d = 1;

        int n = matrix.length;
        int m = matrix[0].length;
        int[] res = new int[n*m];

        for (int i = 0; i < n * m; i++) {
            System.out.println(i);
            res[i] = matrix[row][col];
            row -= d;
            col += d;


            if (row < 0) {
                if (col > m){
                    row += 2;
                    col -= 1;
                    d = -d;
                } else {
                    row += 1;
                    d = -d;
                }
            } else

            if (row > n) {
                if (col < 0) {
                    row -= 1;
                    col += 2;
                    d = -d;
                } else {
                    row -= 1;
                    col += 2;
                    d = -d;
                }
            } else

            if (col < 0) {
                col += 1;
                d = -d;
            } else
            if (col > m) {
                d = -d;
                row += 2;
                col -= 1;
            }
            System.out.println("row: " + row);
            System.out.println("col: " + col);

        }
        return res;
    }
}
