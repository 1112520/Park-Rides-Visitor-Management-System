/**
 * 抽象的人员基类。
 * Employee 和 Visitor 都从这里继承通用属性。
 */
public abstract class Person {

    // 至少三个适合“人”的属性
    private String id;
    private String fullName;
    private int age;

    /**
     * 默认构造方法。
     */
    public Person() {
    }

    /**
     * 带参数构造方法，设置所有字段。
     */
    public Person(String id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        setAge(age);
    }

    // ----------------- Getter / Setter -----------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        // 可以简单校验一下，保证不是 null 或空字符串
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
     * 由子类实现的描述信息，用于多态展示。
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
}
