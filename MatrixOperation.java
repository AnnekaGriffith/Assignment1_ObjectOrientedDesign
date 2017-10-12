/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixoperation;
import static java.sql.DriverManager.println;
import java.util.Scanner;
import java.util.Random;
/**
 * Matrix Operations: general NxM matrix where generic matric class accepts 
 * user input and generates a random matrix.
 *                      
 * ex: 2x2 matrix: A = (23 54) where A[i][j] is a random number between (0,99) 
 *                     (98 97)
 * then design matrix to do:
 *  Matrix Addition  (2x2, 3x5)
 *  Matrix Multiplication (2x2, 3x5)
 *
 * @author Anneka Bath
 * * date 10/23/17
 */
public class MatrixOperation {
    
    /**
     * @param args the command line arguments
     */
    // 
    private int [][] A;
    private int m,n;
    private boolean pass = false;
    private String userInput;
    
    public void setPass (boolean pass)
    {
        this.pass = pass;
    }
    public void setM (int m)
    {
        this.m = m;
    }
    public void setN (int n)
    {
        this.n = n;
    }
    public void setA (int A[][])
    {
        this.A = A;
    }
    public int[][] getA ()
    {
        return A;
    }
    public boolean getPass()
    {
        return pass;
    }
    public int getM ()
    {
        return m;
    }
    public int getN()
    {
        return n;
    }
    
    public void findN(boolean pass)
    {   int nRows;     
        String userInputN = null;
        while(pass == false)
        {
            System.out.println("rows: ");
            Scanner row = new Scanner(System.in);
            userInputN = row.next();
            validEntry(userInputN);  
        } 
        nRows = setNum(userInputN);
        setN(nRows);
    }
    
    public void findM(boolean pass)
    {
        int mColumns;
        String userInputM = null;
        while(pass == false)
        {
            System.out.println("columns: ");
            Scanner column = new Scanner(System.in);
            userInputM = column.next();
            validEntry(userInputM);  
        } 
        mColumns = setNum(userInputM);
        setM(mColumns);
    }
    
    public int setNum(String userInput)
    {   
        if (getPass() == true)
        {
            Integer userNum = Integer.valueOf(userInput);
            return userNum;
        }
        else
        {
            return 0;
        }
        
    }

    public void makeMatrix(int n, int m )
    {
        int A [][] = new int [n][m];
         
        //generate random numbers (0,99) for the N X M Matrix
        //each random number will be stored in an cell inside the matrix. 
        //array A stores the random numbers in its memory 
        for (int i = 0; i<n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                Random value = new Random();
                int cellValue = value.nextInt(99);
                A[i][j] = cellValue;
            }
        }
        setA(A);
    }
    public void printMatrix(int A[][])
    {
        for (int i = 0; i<n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                System.out.print(A[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    public void userDisplay()
    {
        System.out.println("Please provide values for your rows and columns in your matrix:");
        findN(getPass());
        findM(getPass());
        int rows = getN();
        int columns = getM();
        makeMatrix(rows,columns);
        int Matrix [][] = getA();
        printMatrix(Matrix);
    }
   
    public boolean validEntry(String testUserInput)
    {
        String tester = testUserInput;
        if (tester.length()<1)
        {
            System.out.println("No integer value: Please provide an integer value");
        }
        else
        {
            for (int i = 0; i<tester.length();i++)
            {
                char c = tester.charAt(i);
                if (Character.isDigit(c))
                { 
                    setPass(true);
                }
                else
                {
                    setPass(true);
                    System.out.println("invalid entry: Please provide an integer value");
                }
            }
        }
        return getPass();
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        MatrixOperation newMatrix = new MatrixOperation ();
        newMatrix.userDisplay();
    }
    
}
