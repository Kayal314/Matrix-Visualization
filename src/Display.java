
import javax.swing.*;
import java.awt.*;

public class Display extends Converter {
    private JPanel panel;
    private JFrame frame;
    private final int[][] matrix;
    private JLabel[][] cells;
    double max;
    double min;
    Display(int[][] matrix)
    {
        this.matrix = getImageMatrix(matrix);
        int[] maxMin = getMaxMin(matrix);
        max = maxMin[0];
        min = maxMin[1];
    }
    Display(double[][] matrix)
    {
        this.matrix = getImageMatrix(matrix);
        double[] maxMin=getMaxMin(matrix);
        max = maxMin[0];
        min = maxMin[1];
    }
    private void initializeFigure()
    {
        frame = new JFrame("Matrix Visualization");
        frame.setSize(1150,950);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        panel=new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        cells=new JLabel[matrix.length][matrix[0].length];
    }
    private void visualizeMatrix()
    {
        int start = 50;
        int rows=matrix.length;
        int cols=matrix[0].length;
        int width = 800/cols;
        int height = 800/rows;
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
            {
                int x = start + width*j;
                int y = start + height*i;
                int colorWeight = matrix[i][j];
                int[] RGB=decToRGB(colorWeight);
                cells[i][j] = new JLabel();
                cells[i][j].setBackground(new Color(RGB[0],RGB[1],RGB[2]));
                cells[i][j].setBounds(x,y,width,height);
                cells[i][j].setOpaque(true);
                panel.add(cells[i][j]);
            }
    }
    public void show()
    {
        initializeFigure();
        visualizeMatrix();
        frame.setVisible(false);
        frame.setVisible(true);
    }
    public void colorBar(int numOfBars)
    {
        JLabel[] bars=new JLabel[numOfBars];
        int color=16777200;
        int colorChange=16777000/numOfBars;
        int i;
        for(i=0;i<numOfBars;i++)
        {
            bars[i]=new JLabel();
            bars[i].setOpaque(true);
            int height = 800/numOfBars;
            bars[i].setBounds(950,50+height*i,80,height);
            int[] RGB=decToRGB(color-=colorChange);
            bars[i].setBackground(new Color(RGB[0],RGB[1],RGB[2]));
            panel.add(bars[i]);
        }
        JLabel[] values=new JLabel[5];
        double change = (max-min)/4.0;
        for(i=0;i<5;i++)
        {
            values[i]=new JLabel(String.valueOf(max-i*change));
            values[i].setBounds(1050,48+i*200,100,10);
            panel.add(values[i]);
        }

    }
    public void displayMatrix()
    {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(ints[j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr=new int[40][40];
        for(int i=0;i<40;i++)
            for(int j=0;j<40;j++)
                arr[i][j]=i*i+j*j;
        Display d=new Display(arr);
        d.show();
        d.colorBar(100);

    }

}