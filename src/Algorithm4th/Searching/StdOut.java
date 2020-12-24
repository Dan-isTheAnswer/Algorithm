package Algorithm4th.Searching;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public final class StdOut {
    private static final String UTF8 = "UTF-8";
    private static final Locale locale = new Locale("en", "US");

    private static PrintWriter out;

    static {
        try {
            out = new PrintWriter(new OutputStreamWriter(System.out, UTF8), true);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e); 
        }
    }

    private StdOut() {}

    public static void close() {
        out.close();
    }
    /**
     * println
     */

    public static void println() {
        out.println();
    }

    public static void println(Object x) {
        out.println(x);
    }

    public static void println(boolean x) {
        out.println(x);
    }

    public static void println(char x) {
        out.println(x);
    }

    public static void println(double x) {
        out.println(x);
    }

    public static void println(float x) {
        out.println(x);
    } 
    
    public static void println(int x) {
        out.println(x);
    }

    public static void println(long x) {
        out.println(x);
    }

    public static void println(short x) {
        out.println(x);
    }

    public static void println(byte x) {
        out.println(x);
    }

    /**
     * Print
     */
    public static void print() {
        out.flush();
    }
    
    public static void print(Object x) {
        out.print(x);
        out.flush();
    }
    
    
    public static void print(boolean x) {
        out.print(x);
        out.flush();
    }
    
    
    public static void print(char x) {
        out.print(x);
        out.flush();
    }
    
    
    public static void print(double x) {
        out.print(x);
        out.flush();
    }
    
    
    public static void print(float x) {
        out.print(x);
        out.flush();
    }
    
    
    public static void print(int x) {
        out.print(x);
        out.flush();
    }
    
    
    public static void print(long x) {
        out.print(x);
        out.flush();
    }


    public static void print(byte x) {
        out.print(x);
        out.flush();
    }
    
    public static void printf(String format, Object... args) {
        out.printf(locale, format, args); 
        out.flush();
    }
    
    public static void printf(Locale locale, String format, Object... args) {
        out.printf(locale, format, args);
        out.flush();
    }
    
    /**
     * Test the class
     */
    public static void main(String[] args) {
        StdOut.println("Test");
        StdOut.println(17);
        StdOut.println(true);
        StdOut.printf("%.6f\n", 1.0/7.0);   
    }
    
} 
// Singleton Design Pattern: PrintWriter**

/**
 * https://www.w3schools.com/java/java_regex.asp
 * https://www.tutorialspoint.com/java/java_regular_expressions.htm
 * https://cmsdk.com/java/junit-test-of-method-with-scanner-and-system-in-java.html
 * java Scanner vs System.in ?? 
 */