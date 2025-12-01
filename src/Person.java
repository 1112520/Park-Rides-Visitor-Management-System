import java.util.Objects;

/**
 * Abstract Person Base Class
 * Both Employee and Visitor inherit common attributes from this class.
 */
public abstract class Person {

    // At least three attributes suitable for a "person"
    private String id;
    private String fullName;
    private int age;

    /**
     * Default constructor.
     */
    public Person() {
    }

    /**
     * Parameterized constructor, sets all fields.
     */
    public Person(String id, String fullName, int age) {
        // Use setters to ensure consistent validation logic
        setId(id);
        setFullName(fullName);
        setAge(age);
    }

    // ----------------- Getter / Setter -----------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        // Simple validation to ensure it's not null or blank
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id cannot be null or blank");
        }
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("fullName cannot be null or blank");
        }
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("age cannot be negative");
        }
        this.age = age;
    }

    /**
     * Description implemented by subclasses, used for polymorphic display.
     */
    public abstract String getDescription();

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }

    // ----------------- equals / hashCode -----------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //
        if (o == null || getClass() != o.getClass()) return false; // Must be the same concrete class
        Person person = (Person) o;
        // 
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        // Consistent with equals: also generate hash based only on id
        return Objects.hash(id);
    }
}


