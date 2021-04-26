public class Converter {

    public int[] decToRGB(int h_val) {
        h_val=240-h_val;
        int c = 1; // S = V = 100%
        double h = h_val/60.0;
        double x = c * (1-Math.abs(h%2 -1));
        if(h_val<60)
            return new int[]{c*255,(int)(x*255),0};
        if(h_val<120)
            return new int[]{(int)(x*255),c*255,0};
        if(h_val<180)
            return new int[]{0,c*255,(int)(x*255)};
        if(h_val<240)
            return new int[]{0,(int)(x*255),c*255};
        if(h_val<300)
            return new int[]{(int)(x*255),0,c*255};
        return new int[]{c*255,0,(int)(x*255)};
    }

    private double[][] scaleDown(int[][] matrix) {
        int[] maxMin = getMaxMin(matrix);
        int max = maxMin[0];
        int min = maxMin[1];
        int i, j;
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] scaledMatrix = new double[rows][cols];
        double scale = max - min;
        for (i = 0; i < rows; i++)
            for (j = 0; j < cols; j++)
                scaledMatrix[i][j] = (matrix[i][j] - (double) min) / scale;

        return scaledMatrix;
    }
    public double[] getMaxMin(double[][] matrix)
    {
        double max = matrix[0][0];
        double min = matrix[0][0];
        int cols = matrix[0].length;
        for (double[] doubles : matrix)
            for (int j = 0; j < cols; j++) {
                if (doubles[j] > max)
                    max = doubles[j];
                if (doubles[j] < min)
                    min = doubles[j];
            }
        return new double[]{max,min};
    }
    public int[] getMaxMin(int[][] matrix)
    {
        int max = matrix[0][0];
        int min = matrix[0][0];
        int cols = matrix[0].length;
        for (int[] ints : matrix)
            for (int j = 0; j < cols; j++) {
                if (ints[j] > max)
                    max = ints[j];
                if (ints[j] < min)
                    min = ints[j];
            }
        return new int[]{max,min};
    }
    private double[][] scaleDown(double[][] matrix) {
        double[] maxMin=getMaxMin(matrix);
        double max = maxMin[0];
        double min = maxMin[1];
        int i, j;
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] scaledMatrix = new double[rows][cols];
        double scale = max - min;
        for (i = 0; i < rows; i++)
            for (j = 0; j < cols; j++)
                scaledMatrix[i][j] = (matrix[i][j] - min) / scale;

        return scaledMatrix;
    }

    private double[][] colorMatrix(double[][] matrix) {
        final int MAX_COLOR = 240; //HSV scale
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] coloredMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                coloredMatrix[i][j] = matrix[i][j] * MAX_COLOR;
        return coloredMatrix;
    }

    public int[][] getImageMatrix(int[][] matrix)
    {
        int rows=matrix.length;
        int cols=matrix[0].length;
        double[][] mat =  colorMatrix(scaleDown(matrix));
        int[][] imageMat = new int[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                imageMat[i][j]=(int)mat[i][j];
        return imageMat;

    }
    public int[][] getImageMatrix(double[][] matrix)
    {
        int rows=matrix.length;
        int cols=matrix[0].length;
        double[][] mat =  colorMatrix(scaleDown(matrix));
        int[][] imageMat = new int[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                imageMat[i][j]=(int)mat[i][j];
        return imageMat;

    }
}



