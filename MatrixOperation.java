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

    public static void MatrixOperation(int N, int M )
    {
        int [][] A =new int [N][M];
        //generate random numbers (0,99) for the N X M Matrix
        //each random number will be stored in an cell inside the matrix. 
        //array A stores the random numbers in its memory 
       
        for (int i = 0; i<N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                Random value = new Random();
                int cellValue = value.nextInt(99);
                A[i][j] = cellValue;
            }
        }
        for (int i = 0; i<N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                System.out.print(A[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.print("do you want to make a Matrix? Y/N ");
        Scanner newMatrix = new Scanner(System.in);
        String retry = newMatrix.next();
        displayUI(retry);
    }
    
    public static void displayUI(String makeMatrix)
    {
        String make = makeMatrix.toUpperCase();
        if (make.equals("Y"))
        {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Please provide values for your rows and columns in your matrix:");
            System.out.println("rows: ");
            int userInputN = userInput.nextInt();
            System.out.println("columns: ");
            int userInputM = userInput.nextInt();
            MatrixOperation(userInputN, userInputM);

        }
        else if (make.equals("N"))
        {
            System.out.println("see you later!");
            System.exit(0);
        }
        else
        {
            System.out.println("Invalid entry");
            
            System.out.print("do you want to make a Matrix? Y/N ");
            Scanner userInput = new Scanner(System.in);
            String retry = userInput.next();
            displayUI(retry);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner matrix = new Scanner(System.in);
        System.out.print("do you want to make a Matrix? Y/N ");
        String userInput= matrix.next();
        displayUI(userInput);
    }
    
}
