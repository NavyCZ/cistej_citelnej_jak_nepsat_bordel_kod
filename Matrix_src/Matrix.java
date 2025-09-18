public class Matrix implements IMatrix {
    private int[][] data;
    private int rows;
    private int cols;

    public Matrix(int[][] values) {
        this.rows = values.length;
        this.cols = values[0].length;
        this.data = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = values[i][j];
            }
        }
    }

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return cols;
    }

    @Override
    public int get(int row, int col) {
        return data[row][col];
    }

    @Override
    public IMatrix times(IMatrix other) {
        if (this.cols != other.getRows()) {
            throw new IllegalArgumentException("Tady někdo neumí matice.");
        }

        Matrix result = new Matrix(this.rows, other.getColumns());

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.getColumns(); j++) {
                int sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k] * other.get(k, j);
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    @Override
    public IMatrix times(int scalar) {
        Matrix result = new Matrix(this.rows, this.cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] * scalar;
            }
        }
        return result;
    }

    @Override
    public IMatrix add(IMatrix other) {
        if (this.rows != other.getRows() || this.cols != other.getColumns()) {
            throw new IllegalArgumentException("Nejde sčítat");
        }

        Matrix result = new Matrix(this.rows, this.cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.get(i, j);
            }
        }
        return result;
    }

    @Override
    public IMatrix transpose() {
        Matrix result = new Matrix(this.cols, this.rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[j][i] = this.data[i][j];
            }
        }
        return result;
    }

    @Override
    public boolean isSquare() {
        return rows == cols;
    }

    @Override
    public int getTrace() {
        if (!isSquare()) {
            throw new IllegalStateException("Nalezena chyba: mezi židlí a monitorem");
        }
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += data[i][i];
        }
        return sum;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
