import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private static List<Horse> horses = new ArrayList<>();
    static Hippodrome game;


    public Hippodrome(List horses){
        this.horses=horses;
    }

    public List<Horse> getHorses(){
        return horses;
    }

    public void run() throws InterruptedException {
        for(int i=0;i<100;i++){
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for(Horse horse: horses){
            horse.move();
        }
    }

    public void print(){
        for(Horse horse: horses){
            horse.print();
        }
        for(int i=0;i<10;i++){
            System.out.println();
        }
    }

    public Horse getWinner(){
        Horse winner = null;
        if(horses.get(0).getDistance() > horses.get(1).getDistance() && horses.get(0).getDistance() > horses.get(2).getDistance()){winner=horses.get(0);}
        else if(horses.get(1).getDistance() > horses.get(0).getDistance() && horses.get(1).getDistance() > horses.get(2).getDistance()){winner=horses.get(1);}
        else if(horses.get(2).getDistance() > horses.get(1).getDistance() && horses.get(2).getDistance() > horses.get(0).getDistance()){winner=horses.get(2);}
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }


    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(horses);

        horses.add(new Horse("Lucy", 3, 0));
        horses.add(new Horse("Ruby", 3, 0));
        horses.add(new Horse("Eva", 3, 0));

        game.run();
        game.printWinner();
    }
}
