public class Naive {

    public static Integer shortest(City from, City to, Integer max){
        if(max < 0){
            return null;
        }
        
        if(from == to){
            return 0;
        }

        Integer shrt = null;

        for(int i = 0; i < from.neighbors.size(); i++){
            if(from.neighbors.get(i) != null){
              Connection conn = from.neighbors.get(i);
              Integer dist = shortest(conn.city, to, max - conn.distance);
              
              if((dist != null) && ((shrt == null) || (shrt > dist + conn.distance)))
                shrt = dist + conn.distance;
               
              if((shrt != null) && (max > shrt)) {
                max = shrt;
              }
            }
        }
        return shrt;
    }
    
    public static void main(String[] args) {
        Map map = new Map("trains.csv");

        if(args.length < 3){
            System.out.println("usage: <from> <to> <max-depth>");
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

        Integer depth = Integer.valueOf(args[2]);
        
        long t0 = System.nanoTime();
        Integer dist = shortest(from, to, depth);
        long t1 = System.nanoTime();
        
        if(dist != null){
        System.out.println("quickest route from " + from.name + " to " + to.name + " : " + dist + " minutes, found in " + ((t1-t0)/1_000_000) + " us");
        }
    }
}
