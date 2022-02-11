/**
* @author Maksim Dashchynski
* @version 1.1
 * */

package by.belstu.it.dashchynski.basejava;

import static java.lang.Math.*;

public class JavaTest {
    /** Static field
     * @value 0
     * */
    static int sint;    // 3b

    final int INT_CONST = 1;
    public final int PUB_INT_CONST = 2;
    public static final int PUB_STAT_INT_CONST = 3;

    public static void main(String[] args) {
        Ex_3b();
        Ex_3d();
        Ex_3e();
        Ex_3f();
        Ex_3g();

        String str_for_parm = "parm";
        var wrapperString = new WrapperString(str_for_parm) {
            @Override
            public void replace(char oldchar, char newchar) {
                System.out.printf("[override] Replace a character '%c' with '%c'\n", oldchar, newchar);
                setStr(getStr().replaceAll(String.valueOf(oldchar), String.valueOf(newchar)));
            }

            public void delete(char newchar) {
                System.out.println("Deleting " + newchar);
                setStr(getStr().replace(newchar, ' '));
            }
        };
        wrapperString.replace('p', 'w');
        System.out.println(wrapperString.getStr());
        wrapperString.delete('r');
        System.out.println(wrapperString.getStr());
    }


    private static void Ex_3g() {
        char[][] c1;
        char[] c2[];
        char c3[][];

        boolean[] empty_array = new boolean[0];
        //System.out.println(empty_array[1]);

        c1 = new char[3][];
        c1[0] = new char[0];
        c1[1] = new char[1];
        c1[2] = new char[2];
        System.out.println("Array length: " + c1.length);
        System.out.println("Line length c1[0]: " + c1[0].length);
        System.out.println("Line length c1[1]: " + c1[1].length);
        System.out.println("Line length c1[2]: " + c1[2].length);

        c2 = new char[][]{{'1', '2', '3'}, {'x', 'y', 'z'}};
        c3 = new char[][]{{'7', '8', '9'}, {'x', 'y', 'z'}};
        boolean comrez = c2 == c3;
        System.out.println("comrez: " + comrez);
        c2 = c3;
        System.out.println("c2 == c3: " + (c2 == c3));

        for (char[] i : c2) {
            for (char j : i) {
                System.out.println(j);
            }
        }
    }

    private static void Ex_3f() {
        System.out.println("--------------Ex_3f--------------");
        String s34 = "2345";

        byte[] str_into_bytes = s34.getBytes();
        System.out.print("Transformation s34 into set of bytes: ");
        for (byte i : str_into_bytes) {
            System.out.print(i);
        }
        String ret_s34 = new String(str_into_bytes);
        System.out.println("\nReturn s34 into string: " + ret_s34);

        System.out.println("(1 way) Convert string to boolean: " + Boolean.valueOf(s34));
        System.out.println("(2 way) Convert string to boolean: " + Boolean.parseBoolean(s34));

        String str1, str2;
        /*start of initializer block*/
        {
            str1 = "Hello";
            str2 = "Hello";
        }
        /*end of initializer block*/
        System.out.println("str1 == str2: " + (str1 == str2)); // Compares references, not values
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // Compares values
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2)); // Performs a char value comparison
        str2 = null;
        System.out.println("Now str2 value's is null.");
        System.out.println("str1 == str2: " + (str1 == str2)); // Compares references, not values
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // Compares values
        // Exception, because str2 is null.
        //System.out.println("str1.compareTo(str2): " + str1.compareTo(str2)); // Performs a char value comparison

        String str3 = "Road to hell";
        String[] words = str3.split(" ");
        for (String i : words) {
            System.out.println(i);
        }
        System.out.println("str3.contains(\"t\"): " + str3.contains("t"));
        System.out.println("str3.hashCode(): " + str3.hashCode());
        System.out.println("str3.length(): " + str3.length());
        System.out.println("str3.indexOf(\"l\"): " + str3.indexOf("l"));
        System.out.println("str3.replace(\"o\",\"i\"): " + str3.replace("o", "i"));
    }

    private static void Ex_3e() {
        System.out.println("--------------Ex_3e--------------");
        Boolean v_b = true;
        Character v_ch = 'i';
        Integer v_int = 99;     // Autoboxing
        Double v_dou = 4.6735;
        Short v_sh = 55;
        Long v_long = 52809L;
        Byte v_byte = -34;      // Autoboxing

        System.out.println("99 >>> 2: " + (v_int >>> 2));
        System.out.println("~(-34): " + (~v_byte));
        System.out.println("v_sh + v_ch: " + (v_sh + v_ch));

        System.out.println("Long.MIN_VALUE: " + Long.MIN_VALUE);
        System.out.println("Long.MAX_VALUE: " + Long.MAX_VALUE);
        System.out.println("Double.MIN_VALUE: " + Double.MIN_VALUE);
        System.out.println("Double.MAX_VALUE: " + Double.MAX_VALUE);

        int unbox_int = v_int;      // Unboxing
        byte unbox_byte = v_byte;   // Unboxing

        System.out.println("Integer.toHexString(v_int): " + Integer.toHexString(v_int));
        System.out.println("Integer.highestOneBit(33): " + Integer.highestOneBit(33));
        System.out.println("Integer.parseInt(\"54\"): " + Integer.parseInt("54"));
        System.out.println("Integer.parseInt(\"10101\",2): " + Integer.parseInt("10101", 2));
    }

    private static void Ex_3d() {
        System.out.println("--------------Ex_3d--------------");
        System.out.println("PI: " + Math.PI);
        System.out.println("E: " + Math.E);
        System.out.println("PI(with round): " + Math.round(PI));
        System.out.println("E(with round): " + Math.round(E));
        System.out.println("Math.min(PI,E): " + Math.min(PI, E));
        System.out.println("Random number: " + Math.random()); // [0.0,1.0)
    }

    private static void Ex_3b() {
        System.out.println("--------------Ex_3b--------------");
        char ch = 'e';
        int num = 21;
        short shnum = 11;
        byte b = 45;
        long lngnum = 1024;
        boolean trf = false;
        double dounum = 13.69;
        String str = "simple string";
        System.out.println("Exercise 3b");
        System.out.println("String + int: " + (str + num));
        System.out.println("String + char: " + (str + ch));
        System.out.println("byte=byte + int: " + (b + num));
        System.out.println("int=double + long: " + (int) (dounum + lngnum));
        System.out.println("long=int + 2147483647: " + ((long) num + 2147483647));
        //(long)(num+2147483647)=negative value((long)(int+int))
        //((long)num+2147483647)=positive value(long+int)=long+long
        System.out.println("static int sint: " + sint);
        System.out.println("boolean = boolean && boolean: " + (trf && !trf));
        System.out.println("boolean = boolean ^ boolean: " + (trf ^ !trf)); // ^ = XOR
        System.out.println("boolean + boolean: error");
        System.out.println("static int sint: " + sint);
        long big_number = 9223372036854775807L;
        long big_number_in_16 = 0x7fff_ffff_fffL;
        char symb_a = 'a';
        char symb_in_16 = '\u0061';
        char val_in_char = 97;
        System.out.println("'a' + '\\u0061' + (char)97: " + (symb_a + symb_in_16 + val_in_char));
        System.out.println("3.45 % 2.4: " + (3.45 % 2.4));
        System.out.println("1.0 / 0.0: " + (1.0 / 0.0));
        System.out.println("0.0 / 0.0: " + (0.0 / 0.0));
        System.out.println("log(-345): " + Math.log(-345));
        System.out.println("Float.intBitsToFloat(0x7F800000): " + Float.intBitsToFloat(0x7F800000));
        System.out.println("Float.intBitsToFloat(0xFF800000): " + Float.intBitsToFloat(0xFF800000));
        System.out.println("In what number systems can integer constants be written?");
        System.out.println("Answer: In binary(0b*(0/1)), octal(0*(0-7)), decimal, hexadecimal(0x*(0-F)) systems.");
    }
}
