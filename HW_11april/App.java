package HW_11april;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Timbaev on 12.04.2017.
 * Test for my properties
 */
public class App {

    public static void main(String[] args) {
        testMyProperty();
    }

    private static void testMyProperty() {
        FileInputStream inputStream;
        MyProperties properties = new MyProperties();

        try {
            inputStream = new FileInputStream("config.properties");
            properties.load(inputStream);

            String host = properties.getProperty("db.host");
            String login = properties.getProperty("db.login");
            String password = properties.getProperty("db.password");
            String empty = properties.getProperty("db.empty", "none");

            System.out.println("host: " + host);
            System.out.println("login: " + login);
            System.out.println("password: " + password);
            System.out.println("empty: " + empty);

            System.out.println("Enum element: " + properties.propertyNames().nextElement());

            String value = properties.setProperty("db.host", "localhost").toString();
            System.out.println("previous value: " + value);

            properties.store(System.out, "Timbaev");
            StringWriter stringWriter = new StringWriter();
            properties.store(stringWriter, "WriteTest");
            System.out.println("store: " + stringWriter.toString());

            System.out.println("set: " + properties.stringPropertyNames());

            PrintWriter writer = new PrintWriter(System.out);
            properties.list(writer);
            writer.flush();

            MyProperties propertiesNew = new MyProperties(properties);
            System.out.println("New properties: " + propertiesNew.stringPropertyNames());

            System.out.println("toString: " + properties);
            System.out.println("HashCode: " + properties.hashCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
