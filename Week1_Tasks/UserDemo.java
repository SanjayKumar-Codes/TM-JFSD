class User {
    private String name;
    private int age;

    public User(String name, int age) {
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
    public String toString() {
        return "User {name='" + name + "', age=" + age + "}";
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        User user = (User ) obj;
        return age == user.age && name.equals(user.name);
    }
}

class SecondUser {
    private String name;
    private int age;

    public SecondUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class UserDemo {
    public static void main(String[] args) {
        User user1 = new User("Alice", 30);
        User user2 = new User("Alice", 30);
        SecondUser secondUser = new SecondUser ("Alice", 30);

        System.out.println(user1); // Calls overridden toString
        System.out.println("User 1 equals User2: " + user1.equals(user2)); // Should be true
        System.out.println("User 1 equals Second:User " + user1.equals(secondUser )); // Should be false
    }
}