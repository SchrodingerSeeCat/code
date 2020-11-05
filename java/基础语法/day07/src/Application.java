
public class Application {
    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        simulator.playSound(new Dog("阿黄"));
        simulator.playSound(new Cat("大白"));
    }
}

interface Animal{
    void cry();
    String getAnimalName();
}

class Simulator{
    public void playSound(Animal animal) {
        animal.cry();
        System.out.println(animal.getAnimalName());
    }
}
class Dog implements Animal{
    private String name;
    public Dog(String name) {
        this.name = name;
    }
    @Override
    public void cry() {
        System.out.println("狗 汪汪汪");
    }

    @Override
    public String getAnimalName() {
        return name;
    }

}

class Cat implements Animal{
    private String name;

    public Cat(String name) {
        this.name = name;
    }
    @Override
    public void cry() {
        System.out.println("猫 呜呜呜");
    }

    @Override
    public String getAnimalName() {
        return name;
    }
}