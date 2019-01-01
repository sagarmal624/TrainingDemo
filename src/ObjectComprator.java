import java.util.Comparator;

public class ObjectComprator implements Comparator<Object> {
    public int compare(Object object1, Object object2) {
        if (object1 instanceof User) {
            User user1 = (User) object1;
            User user2 = (User) object2;
            return user1.getName().compareTo(user2.getName());
        } else {
            Person person1 = (Person) object1;
            Person person2 = (Person) object2;
            return person1.getName().compareTo(person2.getName());
        }
    }
}
