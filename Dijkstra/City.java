import java.util.ArrayList;

public class City {
    String name;
    Integer id;
    ArrayList<Connection> neighbors;

    public City(String na, Integer i){
        this.name = na;
        this.id = i;
        this.neighbors = new ArrayList<>();
    }

    public void connect(City nxt, int dst){
        Connection c = new Connection(nxt, dst);
        neighbors.add(c);
    }


}