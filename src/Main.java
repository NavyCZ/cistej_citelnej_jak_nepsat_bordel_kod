public class Main {
    public static void main(String[] args) {
        int[][] valuesA = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] valuesB = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        Matrix mA = new Matrix(valuesA);
        Matrix mB = new Matrix(valuesB);


        System.out.println("Matrix A: ");
        mA.print();

        System.out.println("Matrix B: ");
        mB.print();

        System.out.println("A x B: ");
        Matrix smth = (Matrix) mA.times(mB);
        smth.print();

        System.out.println("Transpose A: ");
        Matrix transpose = (Matrix) mA.transpose();
        transpose.print();

        System.out.println("Is A square? "+ mA.isSquare());

        int[][] valuesC = {
                {1,2},
                {3,4}
        };

        Matrix mC = new Matrix(valuesC);
        System.out.println("Trace C: ");
        System.out.println(mC.getTrace());
    }
}