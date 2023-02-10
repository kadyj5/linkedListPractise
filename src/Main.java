import java.util.*;


record City(String name, int distance){
    @Override
    public String toString() {
        return String.format("%s (%d)", this.name, this.distance);
    }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ListIterator listIterator;

    public static void main(String[] args) {

        LinkedList<City> linkedList = new LinkedList<>();
//        new City("Sidney", 0);
        City city1 = new City("Adelaide", 1374);
        addPlace(linkedList,city1);
//        linkedList.add(new City("Alice Springs", 2771));
//        linkedList.add(new City("Perth", 917));
//        linkedList.add(new City("Darwin", 3972));
        linkedList.sort(Comparator.comparingInt(City::distance));
        boolean isOn = true;
        while(isOn){
            String option = scanner.nextLine().trim();
            switch (option){
                case "F" -> forward(linkedList);
                case "B" -> backward(linkedList);
                case "L" -> listPlaces(linkedList);
                case "M" ->
                case "Q" -> isOn = false;
            }
        }
    }

    private static void addPlace(LinkedList<City> list, City city){
        for(City c : list){
            if(!c.name().equalsIgnoreCase(city.name())) {
                list.add(city);
            }
        }
    }
    private static void menu(){
        System.out.println();
    }

    private static void listPlaces(LinkedList<City> linkedList) {
        listIterator = linkedList.listIterator(1);
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
    }

    private static void backward(LinkedList<City> linkedList) {
        listIterator = linkedList.listIterator();
        if(listIterator.hasPrevious()){
            listIterator.previous();
        }
    }
    private static void forward(LinkedList<City> linkedList){

        listIterator = linkedList.listIterator();
        if(listIterator.hasNext()){
            listIterator.next();
        }
    }


}
