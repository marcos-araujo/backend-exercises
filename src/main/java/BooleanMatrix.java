public class BooleanMatrix {

    /*
    Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1
    (or true) then make all the cells of ith row and jth column as 1.
     */

    public static void main(String[] args) {

        bruteForce(new int[][] {
                {1, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 0}
        });

        arrays(new int[][] {
                {1, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 0}
        });
    }

    private static void arrays(int[][] entry) {
        int[] rows = new int[entry.length];
        int[] columns = new int[entry[0].length];

        for (int x = 0; x < rows.length; x++)
            for (int y = 0; y < columns.length; y++)
                if (entry[x][y] == 1) {
                    rows[x] = 1;
                    columns[y] = 1;
                }

        for (int x = 0; x < rows.length; x++)
            for (int y = 0; y < columns.length; y++) {
                if (rows[x] == 1 || columns[y] == 1)
                    entry[x][y] = 1;
            }

        printMatrix(entry);
    }

    private static void bruteForce(int[][] entry) {
        int rows = entry.length;
        int cols = entry[0].length;

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (entry[x][y] == 1) {
                    markRows(entry, x, y);
                    markColumns(entry, x, y);
                }
            }
        }

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (entry[x][y] == -1)
                    entry[x][y] = 1;
            }
        }

        printMatrix(entry);
    }

    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    private static void markRows(int[][] entry, int row, int column) {
        int ind = row - 1;
        while (ind >= 0) {
            if (entry[ind][column] == 0)
                entry[ind][column] = -1;
            ind--;
        }

        ind = row + 1;
        while (ind < entry.length) {
            if (entry[ind][column] == 0)
                entry[ind][column] = -1;
            ind++;
        }
    }

    private static void markColumns(int[][] entry, int row, int column) {
        int ind = column - 1;
        while (ind >= 0) {
            if (entry[row][ind] == 0)
                entry[row][ind] = -1;
            ind--;
        }

        ind = column + 1;
        while (ind < entry[0].length) {
            if (entry[row][ind] == 0)
                entry[row][ind] = -1;
            ind++;
        }
    }

}
