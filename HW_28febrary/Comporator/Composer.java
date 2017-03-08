package CW_28febrary.Comporator;

/**
 * Created by Timbaev on 28.02.2017.
 *
 */
public class Composer implements Comparable<Composer> {

    private String name;

    public Composer(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Composer o) {
        return name.compareTo(o.getName());
    }

    public String getName() {
        return name;
    }
}
