import java.util.ArrayList;

public class City {
    String name;
    ArrayList<Connection> neighbors;

    public City(String na){
        this.name = na;
        this.neighbors = new ArrayList<>();
    }

    public void connect(City nxt, int dst){
        Connection c = new Connection(nxt, dst);
        neighbors.add(c);
    }


}