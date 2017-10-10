/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadraticformula;
import java.util.Scanner;
/**
 *
 * Calculate a quadratic formula to find it's roots.
 * 
 * f(x) = ax^2 + bx +c
 * 
 * @author Anneka Bath
 * date 10/23/17
 */
public class QuadraticFormula {
    //****************************
    //set private variables a,b,&c 
    //****************************
    private double a,b,c;
    //********************
    //get calls for a,b,&c
    //********************
    public double getA()
    {
        return a;
    }
    public double getB()
    {
        return b;
    }
    public double getC()
    {
        return c;
    }
    //********************
    //set calls for a,b,&c
    //********************
    public void setA(double a)
    {
        this.a = a;
    }
    public void setB(double b)
    {
        this.b = b;
    }
    public void setC(double c)
    {
        this.c = c;
    }
    //**************************************
    //calculate the discriminant, (b^2 - 4ac)
    //**************************************
    public double calDiscrim(double a, double b, double c)
    {
        double discrim;
        discrim = b*b - 4*a*c;
        return discrim;
    }
    //********************************************************************
    // evaluate the quadratic equatioionby finding the roots. 
    // Output is depending on sign of the discriminant, or # of roots. 
    // Thus eveluate using an if, else if, else statement.
    //********************************************************************
    public void solveRoots (double discrim, double a, double b, double c)
    {
        double root1;
        double root2;
        double imag;
    
        // modify output depending on sign of discriminant
        if (discrim > 0) //two real roots
        {
            root1 = (-b + Math.sqrt(discrim))/(2*a);
            root2 = (-b - Math.sqrt(discrim))/(2*a);
            System.out.println("Two real roots: " + root1 + " and " + root2);
        }
        else if(discrim < 0)// two imagionary roots 
        { 
            imag = Math.sqrt(-discrim) /(2*a);
            System.out.println("Two imagionary roots: " + (-b/(2*a)) + "+/- i" + imag);
        }
        else {// one real roots 
            root1 = -b/(2*a);
            System.out.println("One real root: " + root1);
        }
    }
    //**************
    //main
    //**************
    public static void main(String[] args) {
        // TODO code application logic here
        QuadraticFormula quad = new QuadraticFormula();
        Scanner scan = new Scanner(System.in);

        System.out.println("The Quadratic formula finds teh root(s) \n" + 
                "where f(x) = 0 for the function f(x) = ax^2 + bx +c\n");

        System.out.print("a: ");
        double a =scan.nextDouble();
        quad.setA(a);
        System.out.print("b: ");
        double b = scan.nextDouble();
        quad.setB(b);
        System.out.print("c: ");
        double c = scan.nextDouble();
        quad.setC(c);
    }
}

