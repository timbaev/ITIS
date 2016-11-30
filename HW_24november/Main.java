/**
 * Created by Timbaev on 24.11.2016.
 *
 */
public class Main {

    public static void main(String args[]) { //test methods
        MyString myString = new MyString("string");
        myString.concat(new MyString("concat"));
        System.out.println("concat: " + myString.toString());
        char[] c = myString.toCharArray();
        System.out.print("toCharArray: ");
        for (char b : c) {
            System.out.print(b);
        }
        System.out.println();
        System.out.println("charAt: " + myString.charAt(3));
        System.out.println("indexOf: " + myString.indexOf(new MyString("con")));
        System.out.println("substring: " + myString.substring(4, 7));
        MyString str = myString;
        System.out.println("equals with reference: " + myString.equals(str));
        System.out.println("equls: " + myString.equals(new MyString("stringconcat")));
        MyString splitString = new MyString("test,hello,word,ITIS");
        MyString[] splitedStrings = splitString.split(',');
        System.out.print("split: ");
        if (splitedStrings != null) {
            for (MyString s : splitedStrings) {
                System.out.print(s.toString() + "; ");
            }
            System.out.println();
        } else {
            System.out.println("null");
        }
        System.out.println("length: " + myString.length());
    }
}
