package HW_18april;

import java.io.*;
import java.util.Date;

/**
 * Created by Timbaev on 18.04.2017.
 *
 */
public class App {

    public static void main(String[] args) {
        testSerializationObject();
        testSerializationString();
        testSerializationInt();
    }

    private static void testSerializationString() {
        String string = "Hello, World!";
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("test"))) {
            stream.writeObject(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("test"))) {
            Object object = stream.readObject();
            System.out.println(object.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void testSerializationObject() {
        SimplePOJO simpleObject = new SimplePOJO("Title", new Date(), 56);
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("object"))) {
            stream.writeObject(simpleObject);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("object"))) {
            SimplePOJO myObject = (SimplePOJO) stream.readObject();
            System.out.println(myObject);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void testSerializationInt() {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("testInt"))) {
            dataOutputStream.writeInt(17538);
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("testInt"))) {
            int result = dataInputStream.readInt();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
