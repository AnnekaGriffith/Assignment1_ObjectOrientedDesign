/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationmatrix;

/**
 *
 * @author ozzma
 */
public class JavaApplicationMatrix {
    public static void JavaApplicationMatrix(int [][] A)
    {
        for (int i = 0; i<5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (j == 0 || i == 0 || i ==4 || j==4)
                {
                    A[i][j] =1;
                }
                else 
                {
                    A[i][j] = 0;
                    
                }
            }
        }
        for (int i = 0; i<5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                System.out.print(A[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] A = new int [5][5];
        JavaApplicationMatrix(A);
        }
    
}
