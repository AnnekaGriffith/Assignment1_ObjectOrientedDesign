/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixoperation;

/**
 *
 * @author Anneka Bath
 */
//******************************************************************************
//MatrixMultiplication Class: takes in Array A1 and Array A2 and multiplies them 
//together. example: (3x2) * (2x2) = (3x2)
//
//                  3 2       77 43     317 229
//                  4 28  *   43 50  =  1512 1572
//                  6 86                4160 4558 
//******************************************************************************
public class MatrixMultiplication {


    //**************************************************************************
    // Checks to see if the two matrixes can be multiplied. If the two matrixes 
    // can be multiplied, the arrays are sent to the multiply method as well 
    // as a constructed 'ans' array that has the row lenght (A1rows) of A1 and 
    //the column length (A2columns) of A2. A1's columns length must match A2's 
    //row length.
    //**************************************************************************
    
    public void multiCheck(int A1 [][],int A2[][],int A1rows,int A2rows,int A1columns,int A2columns)
    {
        if (A1columns == A2rows )
        {
            int [][] ans = new int[A1.length][A2[0].length];
            multiply(A1,A2,ans);
            
        }
        else
        {
            System.out.println("Can't be Multiplied!");
        }
    }
    //**************************************************************************
    //multiply:Recieves A1, A2, and ans arrays. The method walks through the 
    //lenght or rows in A1, then it walks through the columns lenght of A2, then
    //walks through the simalar length the A1 and A2. In the inner most for loop 
    //redefines ans as the dot product of A1 and A2. Once ans has recieved all 
    //its values the ans array is printed out formatted. 
    //**************************************************************************
    public void multiply (int A1 [][],int A2[][], int ans [][])
    {   

        for(int i =0;i<A1.length;i++)
        {
            for(int j=0;j<A2[0].length;j++)
            {
                for (int k=0; k<A1[0].length;k++)
                {
                    ans[i][j] = ans[i][j] + (A1[i][k] * A2[k][j]);
                }
            }    
        }
        System.out.println("Your two Matrixes Multiplied is: ");

        
        for (int i=0;i<ans.length;i++)
        {
            for(int j =0;j<ans[0].length;j++)
            {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    
}
