import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private City[] cities;
    private final int mod = 541;
    private int size;
    
    public Map(String file) {
        cities = new City[mod];
        size = 0;

        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                i++;
                String[] row = line.split(",");
                City one = lookup(row[0]);
                City two = lookup(row[1]);
                Integer dist = Integer.valueOf(row[2]);
                one.connect(two, dist);
                two.connect(one, dist);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    private Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    private Integer size(){
        return size;
    }
    
    public City find(String name){
        Integer indx = hash(name);
        while(true){
            if(cities[indx] == null){
                return null;
            }
            if(cities[indx].name.equals(name))
                return cities[indx];
            indx++;
            if(indx == cities.length)
                indx = 0;
        }
    }

    public City lookup(String name){
        Integer indx = hash(name);
        while(true){
            if(cities[indx] == null) {
                size++;
                City city = new City(name);
                cities[indx] = city;
                return city;
            }

            if(cities[indx].name.equals(name))
              return cities[indx];
            System.out.printf("collision: %s and %s both has to %d\n", cities[indx].name, name, indx);
            indx = (indx + 1) % mod;
        }
    }

    public static void main(String[] args){
        Map map = new Map("trains.csv");

        System.out.println("added " + map.size() + " cities");

        for(int i = 0; i < map.mod; i++){
            if(map.cities[i] != null){
                City city = map.cities[i];
                int cnx = 0;
                for(int j = 0; j < city.neighbors.size(); j++){
                    if(city.neighbors.get(j) != null)
                      cnx++;
                }
                System.out.print("(" + cnx + ") " + map.cities[i].name + ": ");

                for(int j = 0; j < city.neighbors.size(); j++) {
                    if(city.neighbors.get(j) != null)
                      System.out.print(city.neighbors.get(j).city.name + ", ");
                }
                System.out.println("");
            }
        }
    }

}