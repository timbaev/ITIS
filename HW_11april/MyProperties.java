package HW_11april;

import java.io.*;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * Created by Timbaev on 12.04.2017.
 * My true properties class
 */
public class MyProperties extends Hashtable<Object, Object> {


    public MyProperties() {}

    public MyProperties(MyProperties defaults) {
        Enumeration<Object> keys = defaults.keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = defaults.get(key);
            put(key, value);
        }
    }

    public String getProperty(String key) {
        return get(key).toString();
    }

    public String getProperty(String key, String defaultValue) {
        Object value = get(key);
        if (value != null) return value.toString();
        return defaultValue;
    }

    public void load(InputStream inStream) throws IOException {
        load(new InputStreamReader(inStream));
    }

    public void load(Reader reader) throws IOException {
        BufferedReader buffReader = new BufferedReader(reader);
        String line;
        while ((line = buffReader.readLine()) != null) {
            String[] keyValue = line.split(" = ");
            put(keyValue[0], keyValue[1]);
        }
    }

    public void list(PrintStream out) {
        list(new PrintWriter(out));
    }

    public void list(PrintWriter out) {
        out.println("-----List Properties------");
        Enumeration<Object> enumeration = keys();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement().toString();
            String value = get(key).toString();
            out.println(key + " = " + value);
        }
        out.println("----------------------------");
    }

    public Enumeration<?> propertyNames() {
        return keys();
    }

    public Object setProperty(String key, String value) {
        Object previousValue = get(key);
        put(key, value);
        return previousValue;
    }

    public void store(Writer writer, String comments) throws IOException {
        storeBuffer(new BufferedWriter(writer), comments);
    }

    public void store(OutputStream out, String comments) throws IOException {
        storeBuffer(new BufferedWriter(new OutputStreamWriter(out)), comments);
    }

    private void storeBuffer(BufferedWriter bf, String comments) throws IOException {
        bf.write("#" + comments);
        bf.newLine();
        Enumeration<Object> enumeration = keys();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement().toString();
            String value = get(key).toString();
            bf.write(key + " = " + value);
            bf.newLine();
        }
        bf.flush();
    }

    public Set<String> stringPropertyNames() {
        Set<String> setKeys = new HashSet<>();
        Enumeration<Object> keys = keys();
        while (keys.hasMoreElements()) {
            setKeys.add(keys.nextElement().toString());
        }
        return setKeys;
    }

    @Override
    public String toString() {
        return stringPropertyNames().toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        Enumeration<Object> keys = keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = get(key);
            result = prime * result + key.hashCode();
            result = prime * result + value.hashCode();
        }
        return result;
    }
}
