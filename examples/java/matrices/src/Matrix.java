public class Matrix {
    private final double[][] values;

    public Matrix(double[][] values) {
        this.values = values;
    }

    public double sum() {
        var result = 0.0;
        for (double[] value : values) {
            result += addRow(value);
        }
        return result;
    }

    public double sumParallel() throws InterruptedException {
        var result = 0.0;
        MathThread<Double>[] threads = new MathThread[values.length];
        for (int i = 0; i < values.length; i++) {
            int finalI = i;
            var thread1 = new MathThread<>(() -> addRow(values[finalI]));
            thread1.start();
            threads[i] = thread1;
        }
        for (MathThread<Double> thread : threads) {
            thread.join();
            result += thread.getValue();
        }
        return result;
    }

    public Matrix addSerial(Matrix other) {
        double[][] result = new double[this.values.length][];
        for (int i = 0; i < this.values.length; ++i) {
            int cols = this.values[i].length;
            double[] row = new double[cols];

            for (int j = 0; j < cols; ++j) {
                row[j] = this.values[i][j] + other.values[i][j];
            }
            result[i] = row;
        }

        return new Matrix(result);
    }

    public Matrix addParallel(Matrix other) throws InterruptedException {
        double[][] result = new double[values.length][];
        MathThread<double[]>[] threads = new MathThread[values.length];
        for (int i = 0; i < values.length; i++) {
            int finali = i;
            var thread1 = new MathThread<>(() -> addRows(values[finali], other.values[finali]));
            thread1.start();
            threads[i] = thread1;
        }
        for (int k = 0; k < threads.length; k++) {
            threads[k].join();
            result[k] =  threads[k].getValue();
        }
        return new Matrix(result);

    }

    private double addRow(double[] value) {
        var result = 0.0;
        for (double v : value) {
            result += v;
        }
        return result;
    }


    private double[] addRows(double[] row1, double[] row2) {
        var result = new double[row1.length];
        for (int i = 0; i < row1.length; i++) {
            result[i] = row1[i] + row2[i];
        }
        return result;
    }


    @Override
    public String toString() {
        var result = new StringBuilder();
        for (double[] value : values) {
            for (double v : value) {
                result.append(v).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}