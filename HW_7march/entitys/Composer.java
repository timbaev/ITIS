package HW_7march.entitys;


/**
 * Created by Timbaev on 08.03.2017.
 * Composer
 */
public class Composer implements Comparable<Composer> {

    private String name;
    private int age;

    public Composer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Composer o) {
        return name.compareTo(o.getName());
    }
}
