public class Paths {
   City[] path;
   int sp;
   
   public Paths(){
    path = new City[54];
    sp = 0;
   }

   public Integer shortest(City from, City to){
    if(from == to){
        return 0;
    }

    for(int i = 0; i < sp; i++){
        if(path[i] == from)
          return null;
    }

    path[sp++] = from;

    Integer shrt = null;

    for(int i = 0; i < from.neighbors.size(); i++){
        if(from.neighbors.get(i) != null){
            Connection conn = from.neighbors.get(i);
            Integer dist = shortest(conn.city, to);

            if((dist != null) && ((shrt == null) || (shrt > dist + conn.distance)))
              shrt = dist + conn.distance;
        }
    }
    path[sp--] = null;
    return shrt;
   }

   public static void main(String[] args) {
    Map map = new Map("trains.csv");

    if(args.length < 2){
        System.out.println("usage: <from> <to>");
        return;
    }
    
    City from = map.find(args[0]);
    City to = map.find(args[1]);
    
    if(from == null){
        System.out.printf(" %s is not in the map\n", args[0]);
        return;
    }

    if(to == null){
        System.out.printf(" %s is not in the map\n", args[1]);
        return;
    }
    
    long t0 = System.nanoTime();
    Integer dist = null;
    Paths pth = new Paths();
    dist = pth.shortest(from, to);
    long t1 = System.nanoTime();
    
    if(dist != null){
    System.out.printf("quickest route from %s to %s : %d min, found in %d us\n", args[0], args[1], dist, ((t1-t0)/1_000_000));
    }
    else{
        System.out.printf("no path found, searched for %.0f " + ((t1-t0)/1_000_000) + " ms ");
    }
}
}
