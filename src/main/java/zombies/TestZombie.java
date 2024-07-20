package zombies;

public class TestZombie {
    public static void main(String[] args) {
        Zombie zombs = new Zombie(30,"No brains.");
//        zombs.setTeeth(30);
//        zombs.setBrains("No brains.");

        System.out.println(zombs.getTeeth());
        System.out.println(zombs.getBrains());
    }
}
