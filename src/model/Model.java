package model;

public class Model {
    private boolean[][] points;

    private double minX;
    private double maxX;
    private int nX;
    private double stepX;

    private double minY;
    private double maxY;
    private int nY;
    private double stepY;


    public Model(double minX, double maxX, int nX, double minY, double maxY, int nY) {
        this.minX = minX;
        this.maxX = maxX;
        this.nX = nX;
        stepX = (maxX - minX) / ((double)nX - 1);

        this.minY = minY;
        this.maxY = maxY;
        this.nY = nY;
        stepY = (maxY - minY) / ((double)nY - 1);

        points = new boolean[nY][nX];
        fillSet();
    }

    private void fillSet() {
        for (int y = 0; y < points.length; y++) {
            for (int x = 0; x < points[0].length; x++) {
                if (isStable(new Complex(minX + stepX * x, minY + stepY * y))) {
                    points[y][x] = true;
                }
                if (minY + stepY * y > maxY) {
                    System.out.println("Hmmm");
                }
            }
        }
    }

    private boolean isStable(Complex c) {
        double tolerance = 5;
        Complex testCase = new Complex(0, 0);
        for (int i = 0; i < 100; i++) {
            testCase = testCase.square().add(c);
        }
        Complex diff = testCase.sub(testCase.square().add(c));
        return diff.abs() < tolerance;
    }

    public boolean[][] getPoints() {
        return points;
    }

    public double getMinX() {
        return minX;
    }

    public double getMaxX() {
        return maxX;
    }

    public int getnX() {
        return nX;
    }

    public double getStepX() {
        return stepX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxY() {
        return maxY;
    }

    public int getnY() {
        return nY;
    }

    public double getStepY() {
        return stepY;
    }
}
