import java.util.*;


record City(String name, int distance){
    @Override
    public String toString() {
        return String.format("%s (%d)", this.name, this.distance);
    }
}

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        menu();
        LinkedList<City> linkedList = new LinkedList<>();

        City city1 = new City("Warsaw", 1374);
        City city2 = new City("Krakow", 1274);
        City cityStart = new City("Sidney", 0);

        linkedList.addFirst(cityStart);
        addPlace(linkedList,city1);
        addPlace(linkedList,city2);
        ListIterator listIterator = linkedList.listIterator();

        System.out.println(linkedList);
        boolean isOn = true;
        while(isOn){
            String option = scanner.nextLine().trim().toUpperCase();
            switch (option){
                case "F" -> forward(linkedList,listIterator);
                case "B" -> backward(linkedList,listIterator);
                case "L" -> listPlaces(linkedList,listIterator);
                case "M" -> menu();
                case "Q", default -> isOn = false;
            }
        }
    }

    private static void addPlace(LinkedList<City> list, City city){
        for(City c : list){
            if(c.name().equalsIgnoreCase(city.name())) {
                System.out.println("Alread exists!");
                return;
//
            }
        }
        list.add(city);
        list.sort(Comparator.comparingInt(City::distance));
    }
    private static void menu(){
        System.out.println("""
                select action:
                (F)orward
                (B)ackwards
                (L)ist Places
                (M)enu
                (Q)uit
                """);
    }

    private static void listPlaces(LinkedList<City> linkedList,ListIterator<City> iterator ) {
        int back = 0;
        while (iterator.hasNext()){
            back++;
            System.out.println(iterator.next());
        }
        while (back > 0){
            iterator.previous();
            back--;
        }
    }

    private static void backward(LinkedList<City> linkedList,ListIterator<City> iterator) {
        if(iterator.hasPrevious()){
            iterator.previous();
            System.out.println("moved backwards to another city");
        }
    }
    private static void forward(LinkedList<City> linkedList,ListIterator<City> iterator){
        if(iterator.hasNext()){
            iterator.next();
            System.out.println("moved forward to another city");
        }
    }


}
