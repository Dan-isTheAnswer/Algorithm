package Algorithm4th.Searching;

import java.io.BufferedInputStream;
import java.util.Locale;
import java.util.Scanner;

public final class StdIn {
    private static String charsetName = "UTF-8";
    private static Locale usLocale = new Locale("en", "US");
    private static Scanner scanner = new Scanner(new BufferedInputStream(System.in), charsetName);

    static { scanner.useLocale(usLocale); }

    private StdIn() { }

    public static boolean isEmpty() {
        return !scanner.hasNext();
    }

    public static String readString() {
        return scanner.next();
    }

    public static int readInt() {
        return scanner.nextInt();
    }

    public static double readDouble() {
        return scanner.nextDouble();
    }

    public static float readFloat() {
        return scanner.nextFloat();
    }

    public static short readShort() {
        return scanner.nextShort();
    }

    public static long readLong() {
        return scanner.nextLong();
    }

    public static byte readByte() {
        return scanner.nextByte();
    }

    public static boolean readBoolean() {
        String s= readString();
        if (s.equalsIgnoreCase("true")) return true;
        if (s.equalsIgnoreCase("false")) return false;
        if (s.equals("1")) return true;
        if (s.equals("0")) return false;
        throw new java.util.InputMismatchException();
    }

    public static boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    public static String readLine() {
        return scanner.nextLine();
    }

    public static char readChar() {
        String s = scanner.findWithinHorizon("(?s).", 1);
        return s.charAt(0);
    } 

    public static String readAll() {
        if (!scanner.hasNextLine()) return null;

        return scanner.useDelimiter("\\A").next();
    }

    public static int[] readInts() {
        String[] fields = readAll().trim().split("\\s+");
        int[] vals = new int[fields.length];
        for (int i = 0; i < fields.length; i++) 
            vals[i] = Integer.parseInt(fields[i]);
        return vals;
    }

    public static String[] readStrings() {
        String[] fields = readAll().trim().split("\\s+");
        return fields;
    }
    
    /**
     * Unit test
     */
    public static void main(String[] args) {
        System.out.println("Type a String: ");
        String s = StdIn.readString();
        System.out.println("Your string was: " + s);
        System.out.println();

        System.out.println("Type and int: ");
        int a = StdIn.readInt();
        System.out.println("Your int was: " + a);
        System.out.println();

        System.out.println("Type a boolean : ");
        boolean b = StdIn.readBoolean();
        System.out.println("Your boolean was: " + b);
        System.out.println();

        System.out.println("Type a double: " );
        double c = StdIn.readDouble();
        System.out.println("Your double was: " + c);
        System.out.println();
    }
    
}
// Scanner**