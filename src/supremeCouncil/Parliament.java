package supremeCouncil;
import deputies.Deputies;
import faction.Faction;

import java.util.ArrayList;
import java.util.List;

public class Parliament {

    public static Parliament parliament = new Parliament();

    private ArrayList<Faction> listOfFactions = new ArrayList<>();

    {
        Faction faction = new Faction("Foo");
        faction.add("A", "B", 70, 123, 1, 1000);
        faction.add("C", "D", 70, 123, 1, 2000);
        listOfFactions.add(faction);
    }

    private Parliament() {

    }

    public Faction getFraction(String name){
        return listOfFactions.stream().filter(faction -> faction.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    public void add(String name){
        Faction faction = new Faction(name);
        listOfFactions.add(faction);
        System.out.println("Ви успішно добавили фракцію");

        listOfFactions.forEach(System.out::println);
    }

    public void remove(String deleteName){

        listOfFactions.removeIf(faction -> faction.getName().equalsIgnoreCase(deleteName));
        System.out.println("Ви успішно видалили франкцію: "+ deleteName);

    }

    public void output(){
        listOfFactions.forEach(System.out::println);
    }

    public void clear(String outputName){

        listOfFactions.stream()
                .filter(faction -> faction.getName().equalsIgnoreCase(outputName))
                .forEach(Faction::clearDeputies);
    }

    public void specificOutput(String outputName){
        listOfFactions.stream().filter(faction -> faction.getName().equalsIgnoreCase(outputName))
                .forEach(Faction::toString);
    }

    public void getBiggestAmount() {
        List<Deputies> bA = listOfFactions.stream().map(Faction::getBiggestBride).toList();
        System.out.println(bA.stream().max(Deputies::compareTo).get());
    }

}
