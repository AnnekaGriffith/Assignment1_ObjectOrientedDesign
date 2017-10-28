/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixoperation;
import static java.sql.DriverManager.println;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Matrix Operations Class: general NxM matrix where generic matric class 
 * accepts user input and generates a random matrix.
 *                      
 * example: 2x2 matrix: A = 23 54 where A[i][j] is a random number from 0 to 99 
 *                          98 97
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
    private int [][] A;//an Array that stores a Matrix
    private int m,n;//m is the # of columns, n is the # of rows
    private Scanner matrix;
    //************************
    //opens file and catches 
    //************************
    public void openFile() 
    {
        try
        {
            matrix = new Scanner (new File ("C:\\Users\\ozzma\\Documents\\OOD&P\\MatrixOperation\\test\\Matrix.txt"));
        }
        catch(Exception e )
        {
            System.out.println("no file");
        }
    } 

    public void readFile()
    {
        try
        {
            int numN = matrix.nextInt();
            int numM = matrix.nextInt();
            setM(numM);
            setN(numN);
        }
        catch(Exception e )
        {
            System.out.println("not an int try again");
        }
        
    }
    public void closeFile()
    {
        matrix.close();
    }
   //***************************
    //Set commands for m, n, & A.
    //***************************
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
    //************************
    //Get calls for m, n, & A.
    //Returns: m,n,& A 
    //************************
    public int getM ()
    {
        return m;
    }
    public int getN()
    {
        return n;
    }
    public int[][] getA ()
    {
        return A;
    }
    
    //***********************************************************************
    //FindN communicates directly to the User to get a valid value of rows. 
    //The userInputN value is checked by sending the String to validEntry().
    //If validEntry returns true the user string userInputN is converted into an 
    //integer value.
    //Returns: int rowsN.
    //************************************************************************
    /*public boolean validEntry(String testUserInput)
    {
        boolean check;
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
                    check =true;
                }
                else
                {
                    setPass(true);
                    System.out.println("invalid entry: Please provide an integer value");
                }
            }
        }
        return getPass();
    }*/

    //**************************************************************************
    //gives int A array random numbers (0,99) for the N value of rows and the M 
    //value of columns each random number will be stored in a cell inside the 
    //matrix which is tracked by counters i(rows) and j(columns). Which step 
    //through the for loops where the rows will fill up with as many m values, 
    //and there will be as many rows as there are n values.
    // Returns: int A[][]
    //**************************************************************************
    public int[][] makeMatrix(int n, int m )
    {
        int A [][] = new int [n][m];
         
        for (int i = 0; i<n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                Random value = new Random();
                int cellValue = value.nextInt(99);
                A[i][j] = cellValue;
            }
        }
        return A;
    }
    //**************************************************************************
    //printMatrix recieves an Array and formats it to print out like a matrix.
    //this is done by using getN and getM to import the n and m values to 
    //appropiately space out each Array value.
    //**************************************************************************
    public void printMatrix(int A[][])
    {
        int rows = getN();
        int column =getM();
        for (int i = 0; i<rows; i++)
        {
            for (int j = 0; j < column; j++)
            {
                System.out.print(A[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    //*********************************************************************
    //User interface enviornment. it allows the user to create a new matrix 
    //with just two lines in the main
    //**********************************************************************

    /**
     *
     * @param scan
     * @throws Exception
     */
    public void displayUI()
    {
        System.out.println("Please provide values for your rows and columns in your matrix:");
        readFile();
        System.out.println("you entered " + getN() + " rows");
        System.out.println("you entered " + getM() + " columns");

        int Matrix1[][] = makeMatrix(getN(),getM());
        setA(Matrix1);
        printMatrix(getA());      
    }
    //***********
    //main
    //************
    public static void main(String[] args) 
    {
        // TODO code application logic here
        MatrixOperation MatrixA1 = new MatrixOperation ();
        MatrixA1.openFile();
        MatrixA1.displayUI();
        int [][] A1 = MatrixA1.getA();
        int A1rows = MatrixA1.getN();
        int A1columns = MatrixA1.getM();
        
        MatrixA1.displayUI();
        int [][] A2 = MatrixA1.getA();
        int A2rows = MatrixA1.getN();
        int A2columns = MatrixA1.getM();
        
        MatrixMultiplication multi = new MatrixMultiplication ();
        MatrixAddition add = new MatrixAddition ();

        multi.multiCheck(A1, A2, A1rows, A2rows, A1columns, A2columns);
        add.addCheck(A1, A2, A1rows, A2rows, A1columns, A2columns);
        
        System.out.println();
        MatrixA1.displayUI();
        int [][] A3 = MatrixA1.getA();
        int A3rows = MatrixA1.getN();
        int A3columns = MatrixA1.getM();
        
        MatrixA1.displayUI();
        int [][] A4 = MatrixA1.getA();
        int A4rows = MatrixA1.getN();
        int A4columns = MatrixA1.getM();
        
        MatrixMultiplication multi2 = new MatrixMultiplication ();
        MatrixAddition add2 = new MatrixAddition ();

        multi2.multiCheck(A3, A4, A3rows, A4rows, A3columns, A4columns);
        add2.addCheck(A3, A4, A3rows, A4rows, A3columns, A4columns);
        
        System.out.println();
        MatrixA1.displayUI();
        int [][] A5 = MatrixA1.getA();
        int A5rows = MatrixA1.getN();
        int A5columns = MatrixA1.getM();
        
        MatrixA1.displayUI();
        int [][] A6 = MatrixA1.getA();
        int A6rows = MatrixA1.getN();
        int A6columns = MatrixA1.getM();
        
        MatrixMultiplication multi3 = new MatrixMultiplication ();
        MatrixAddition add3 = new MatrixAddition ();

        multi3.multiCheck(A5, A6, A5rows, A6rows, A5columns, A6columns);
        add3.addCheck(A5, A6, A5rows, A6rows, A5columns, A6columns);
        MatrixA1.closeFile();
       
    }
    
}
