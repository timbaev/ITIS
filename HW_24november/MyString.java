import java.util.Arrays;

/** This class help to create new String
 * @author Timur Shafigullin
 * @version 1.0
 * Created by Timbaev on 24.11.2016.
 */
public class MyString {

    /** Array of symbols
     */
    private char[] string;

    /** Create new String
     * @param str string, which needs to be created
     */
    public MyString(String str) {
        string = str.toCharArray();
    }

    /** Create new empty object
     * @see MyString#MyString(String)
     */
    public MyString() {
        string = new char[0];
    }

    /** To attach a new MyString to current MyString
     * @param myString MyString, which needs to be connected
     */
    public void concat(MyString myString) {
        if (myString.length() != 0) {
            char[] myStringChar = myString.toCharArray();
            char[] c = new char[string.length + myStringChar.length];
            System.arraycopy(string, 0, c, 0, string.length);
            System.arraycopy(myStringChar, 0, c, string.length, myStringChar.length);
            string = c.clone();
        }
    }

    /** Convert MyString to array of chars
     * @return array of chars
     */
    public char[] toCharArray() {
        return string;
    }

    /** Get symbol in the specified position
     * @param position number of a position of an element in MyString
     * @return symbol in the specified position
     */
    public char charAt(int position) {
        if (position > string.length) {
            return '0';
        }
        return string[position];
    }

    /** The index in this MyString of the first entrance of the specified substring returns.
     *  If this substring doesn't meet, returns -1.
     * @param myString The specified substring
     * @return Index of the first entrance
     */
    public int indexOf(MyString myString) {
        if (myString.length() > string.length || myString.length() == 0) {
            return -1;
        }
        char[] c = myString.toCharArray();
        int k = 0;
        for (int i = 0; i < string.length; i++) {
            if (string[i] == c[0]) {
                for (int j = 0; j < c.length; j++) {
                    if (i + j > c.length && string[i + j] == c[j]) {
                        k++;
                    } else {
                        break;
                    }
                }
                if (k == c.length) {
                    return i;
                } else {
                    k = 0;
                }
            }
        }
        return -1;
    }

    /** This method returns a new string that is a substring of this string.
     * @param start index of element the beginning of new substring
     * @param end index of element the end of new substring
     * @return new substring of this MyString
     */
    public MyString substring(int start, int end) {
        try {
            char[] c = new char[end - start + 1];
            System.arraycopy(string, start, c, 0, end - start + 1);
            return new MyString(new String(c));
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    /** This method designates the relation of equivalence of objects.
     * @param object other object to which it is compared
     * @return result of comparing (true or false)
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        MyString myString = (MyString) object;
        if (this.toString().equals(myString.toString())) {
            return true;
        }
        return false;
    }

    /** This method separates this MyString around this character.
     * @param split the character which separates MyString
     * @return array of new MyString, as a result of separates
     */
    public MyString[] split(char split) {
        if (string.length == 0) {
            return null;
        }
        int countOfSplits = 0;
        for (int i = 0; i < string.length; i++) {
            if (string[i] == split) {
                countOfSplits++;
            }
        }
        MyString[] stringsArray = new MyString[countOfSplits + 1];
        int k = 0;
        int j = 0;
        int sumLengthStrings = 0;
        int countOfIterations = 0;
        for (int i = 0; i < string.length; i++) {
            countOfIterations++;
            if (string[i] == split) {
                char[] c = new char[countOfIterations];
                System.arraycopy(string, j, c, 0, countOfIterations - 1);
                MyString string = new MyString(new String(c));
                stringsArray[k] = string;
                k++;
                countOfIterations = 0;
                j = i + 1;
                sumLengthStrings += c.length - 1;
            }
        }
        //вытаскиваем последнее слово
        int wordSize = string.length - sumLengthStrings - countOfSplits;
        char[] c = new char[wordSize];
        System.arraycopy(string, string.length - wordSize, c, 0, wordSize);
        MyString string = new MyString(new String(c));
        stringsArray[k] = string;

        return stringsArray;
    }

    /** This method returning number of characters in MyString.
     * @return quantity of characters in MyString
     */
    public int length() {
        return string.length;
    }

    /** This method serves for representation of an object in the form of a string.
     * @return a new string
     */
    public String toString() {
        return new String(string);
    }
}
