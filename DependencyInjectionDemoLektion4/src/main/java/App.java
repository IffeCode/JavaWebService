public class App {

    public static void main(String[] args) {

        App.run();

    }

    public static void run(){

        DiceRoll1 d1 = new DiceRoll1();
        System.out.println(d1.asText());


        DiceRoll2 d2 = new DiceRoll2(
                new RandomlyGeneratedNumbers()
        );
        System.out.println(d2.asText());


    }

}
