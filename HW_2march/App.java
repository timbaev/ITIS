package HW_2march;

/**
 * Created by Timbaev on 02.03.2017.
 * Test collections
 */
public class App {

    public static void main(String[] args) {
        ModifiableCollection<String> modifiableCollection = new ModifiableCollection<>();
        modifiableCollection.add("Test");
        modifiableCollection.add("ITIS");
        modifiableCollection.add("Hello world");

        System.out.println("get(1): " + modifiableCollection.get(1));

        modifiableCollection.remove("Test");

        System.out.println("size: " + modifiableCollection.size());

        //modifiableCollection.addAll(modifiableCollection); done
        //modifiableCollection.clear(); done
        System.out.println("Contains: " + modifiableCollection.contains("Test"));
        System.out.println("Contains All: " + modifiableCollection.containsAll(createTestCollection()));
        System.out.println("Equals: " + modifiableCollection.equals(createTestCollection()));
        System.out.println("hashCode: " + modifiableCollection.hashCode());
        System.out.println("isEmpty: " + createTestCollection().isEmpty());
        //System.out.println("removeAll: " + modifiableCollection.removeAll(createTestCollection()));
        System.out.println("retainAll: " + modifiableCollection.retainAll(createTestCollection()));

        System.out.println("_____________________________________________");
        for (String aModifiableCollection : modifiableCollection) {
            System.out.println(aModifiableCollection);
        }

        UnmodifiableCollection<String> unmodifiableCollection = new UnmodifiableCollection<>(modifiableCollection);
    }

    private static ModifiableCollection<String> createTestCollection() {
        ModifiableCollection<String> testCollection = new ModifiableCollection<>();
        testCollection.add("Hello");
        return testCollection;
    }
}
