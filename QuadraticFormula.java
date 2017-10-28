/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadraticformula;
import java.io.File;
import java.util.Scanner;
/**
 * Calculate a quadratic formula to find it's roots.
 * f(x) = ax^2 + bx +c
 * 
 * @author Anneka Bath
 * date 10/23/17
 */

   
public class QuadraticFormula {
    
    double p; //root1
    double q; //root2
    double imag; //imagionary number
    private Scanner quadratic;
    
    public void openFile() 
    {
        try
        {
            quadratic = new Scanner (new File ("C:\\Users\\ozzma\\Documents\\OOD&P\\QuadraticFormula\\Quadratic_Test.txt"));
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
            while(quadratic.hasNext())
            {
                
                double a =quadratic.nextDouble();
                System.out.print("a: " + a + " ");
                double b = quadratic.nextDouble();
                System.out.print("b: " + b + " ");
                
                double c = quadratic.nextDouble();
                System.out.print("c: " + c + "\n");
                ComplexNums nums = new ComplexNums(a,b,c); 
                double discrim = calDiscrim(nums.getA(),nums.getB(),nums.getC());
                solveRoots(discrim, nums.getA(),nums.getB(),nums.getC());
                checkRoots(nums.getA(),nums.getB(),nums.getC(), Getp(), Getq());
                System.out.print("\n");
            }
        }
        catch(Exception e )
        {
            System.out.println("not an int try again");
        }
        
    }
    public void closeFile()
    {
        quadratic.close();
    }
    //**************************************
    //calculate the discriminant, (b^2 - 4ac)
    //**************************************
    public double calDiscrim( double a , double b, double c)
    {
        double discrim;
        discrim = b*b - 4*a*c;
        return discrim;
    }
    //**********************************
    // Get calls for both roots p and q
    //**********************************
    public double Getp ()
    {
        return p;
    }
    public double Getq ()
    {
        return q;
    }
    //********************************************************************
    // SolveRoots: evaluate the quadratic equatioionby finding the roots. 
    // Output is depending on sign of the discriminant, or # of roots. 
    // Thus eveluate using an if, else if, else statement.
    //********************************************************************
    public void solveRoots (double discrim, double a, double b, double c)
    {
        // modify output depending on sign of discriminant
        if (discrim > 0) //two real roots
        {
            p = (-b + Math.sqrt(discrim))/(2*a);
            q = (-b - Math.sqrt(discrim))/(2*a);
            System.out.println("Two real roots: p = " + p + " and q = " + q + "\n");
        }
        else if(discrim < 0)// two imagionary roots 
        { 
            imag = Math.sqrt(-discrim) /(2*a);
            System.out.println("Two imagionary roots: " + (-b/(2*a)) + "+/- i" + imag+ "\n");
        }
        else {// one real roots 
            p = -b/(2*a);
            System.out.println("One real root: p = " + p + "\n");
        }
    }
    //*******************************************************
    //checkRoots: makes sure that p*q = c/a & p+q = -(b/a)
    //*******************************************************
    public void checkRoots (double a, double b, double c, double p, double q)
    {
        System.out.println("Checking if the roots p and q are correct:");
        double check1 = p*q; 
        double answer1 = c/a;
        System.out.println("roots p*q = " + check1 + " Which equal c/a = " + answer1);
        double check2 = p+q;
        double answer2 = (-b)/a;
        System.out.println("roots p+q = " + check2 + " Which equal -(b/a) = " + answer2);
    }

    //**************
    //main
    //**************
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("The Quadratic Equation formula finds the root(s) \n" + 
                "where f(x) = 0 for the function f(x) = ax^2 + bx +c\n");
        
        QuadraticFormula quad = new QuadraticFormula();
        quad.openFile();
        quad.readFile();
        quad.closeFile();
    }
}

