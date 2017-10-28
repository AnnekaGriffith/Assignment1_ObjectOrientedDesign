/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixoperation;

/**
 *
 * @author Anneka Bath
 * 
 */
//******************************************************************************
//MatrixAddition Class: takes in Array A1 and Array A2 and adds them 
//together. example: (3x2) + (3x2) = (3x2)
//
//                  3 2       77 43     80 45
//                  4 28  +   43 50  =  47 78
//                  6 86      2  3      8  89 
//******************************************************************************
public class MatrixAddition {
    //**************************************************************************
    // Checks to see if the two matrixes can be added. If the two matrixes 
    // can be added, the arrays are sent to the add method as well 
    // as a constructed 'ans' array that has the row lenght (A1.length) of A1 
    //and the column length (A1.column). A2 and A1 must have the same amount of 
    //columns and rows to be added  
    //**************************************************************************
    public void addCheck(int A1 [][],int A2[][],int A1rows,int A2rows,int A1columns,int A2columns)
    {
        if (A1rows == A2rows && A1columns == A2columns)
        {
            int [][] ans = new int[A1.length][A1[0].length];
            add(A1,A2,ans);
        }
        else
        {
            System.out.println("Can't be Added!");
        }
    }
    //**************************************************************************
    //add:Recieves A1, A2, and ans arrays. The method walks through the length 
    //or rows in A1, then it walks through the columns length of A1 because A2 
    //and A1 must be the same sized arrays. Ans is redefined as A1 + A2 for the 
    //same position values. Once ans has recieved all its values the ans array 
    //is printed out formatted.
    //**************************************************************************
    private void add(int A1 [][],int A2[][], int ans[][])
    {
        for(int i =0;i<A1.length;i++)
        {
            for(int j=0;j<A1[0].length;j++)
            {
                ans[i][j] = A1[i][j] + A2[i][j]; 
            }
        }
        System.out.println("Your two Matrixes Added is: ");
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
