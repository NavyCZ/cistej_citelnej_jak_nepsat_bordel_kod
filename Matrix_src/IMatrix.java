public interface IMatrix {
    IMatrix times(IMatrix matrix);
    IMatrix times(int scalar);
    IMatrix add(IMatrix matrix);
    IMatrix transpose();
    boolean isSquare();
    int getTrace();
    int getRows();
    int getColumns();
    int get(int row, int col);
}
