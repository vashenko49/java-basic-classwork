import java.lang.reflect.Array;

public class User {
    private String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName( String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "this is user name = "+ name + " and age is "+ age;
    }
}


class Runner {
    public static void main(String[] args) {
        User user = new User("Gogo gogo jksfdg sdfjng sdfjhg gogo sdfgn gogo", 5);


    }
}