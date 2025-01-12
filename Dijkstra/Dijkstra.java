public class Dijkstra { 
    private Path[] done;//paths to cities where we know the shortest distance so far
    private Queue queue; //paths yet to be explored
    

    private class Path{
        //Info we have on a found sofar shortest path

        private City city; //city we're at
        private City prev; //previous city
        private Integer dist; // total distance from destination
        private Integer index; //index in queue

        private Path(City cty, City prv, Integer dst) {
            this.city = cty;
            this.prev = prv;
            this.dist = dst;
            this.index = null;
        }
    }

    private class Queue{
        //Array implementation

        private int last;
        private Path[] heap;

        private Queue(Integer n){
            last = 0;
            heap = new Path[n];
        }

        private boolean isEmpty(){
            return (last == 0);
        }

        private void add(Path k){
            heap[last] = k;
            k.index = last;
            bubble(last);
            last++;
        }

        private Path remove(){
            if (last == 0)
              return null;
            
            Path nxt = heap[0];

            heap[0] = heap[(last - 1)];
            heap[0].index = 0;
            heap[(last - 1)] = null;
            last--;

            sink(0);

            return nxt;
        }

        private int getParentIndex(int t) {
            return t % 2 == 0 ? (t - 2) / 2 : (t - 1) / 2;
        }

        private void bubble(int i) {
            if (i == 0)
              return;
        
            int parent = getParentIndex(i);
        
            if (heap[parent].dist < heap[i].dist)
              return;
        
            swap(i, parent);
            bubble(parent);
        }

        private void sink(int i){
            int left = (i * 2) + 1;
            int right = (i * 2) + 2;

            if(left >= last)
              return;

            if(right >= last){
                if(heap[left].dist > heap[i].dist)
                  swap(i, left);
                return;
            }

            if(heap[left].dist < heap[right].dist){
                if(heap[left].dist < heap[i].dist){
                    swap(i, left);
                    sink(left);
                }
            } else{
                if(heap[right].dist < heap[i].dist){
                    swap(i, right);
                    sink(right);
                }
            }
        }

        private void swap(int i, int j){
            Path k = heap[i];
            heap[j].index = i;
            heap[i] = heap[j];
            k.index = j;
            heap[j] = k;
        }
    }

    public Dijkstra(Map map){
        int n = map.size();
        done = new Path[n];
        queue = new Queue(n);
    }

    public Integer dist(City city){
        if(city != null && done[city.id] != null)
          return done[city.id].dist;
        else
          return null;
    }

    public Integer cities(){
        Integer n = 0;
        for(int i = 0; i < done.length; i++)
          if(done[i] == null)
            n++;
        return n;
    }

    public City from(City city){
        return done[city.id].prev;
    }

    public void Search(City from, City dest){
        Path ex = new Path(from, null, 0);
        queue.add(ex);
        done[from.id] = ex;
        shortest(dest);
    }

    public void shortest(City dest){
        while(!queue.isEmpty()){
            Path entr = queue.remove();

            City city = entr.city;

            if(city == dest){
                break;
            }

            Integer sofar = entr.dist;

            for(Connection con : city.neighbors){
                City to = con.city;
                if(done[to.id] == null){
                    Path ex = new Path(to, city, sofar + con.dist);
                    done[to.id] = ex;
                    queue.add(ex);
                } else{
                    Path ex = done[to.id];
                    if(ex.dist > sofar + con.dist){
                        ex.dist = sofar + con.dist;
                        ex.prev = city;
                        queue.bubble(ex.index);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java Dijkstra From (To)");
            return;
        }
    
        Map map = new Map("europe.csv");
    
        City from = map.lookup(args[0]);
        City dest = null;
        
        if (args.length > 1)
          dest = map.lookup(args[1]);
           
        Integer dist;
        Integer stops = 0;
    
        long t0 = System.nanoTime();
    
        Dijkstra djk = new Dijkstra(map);
    
        djk.Search(from, dest);
    
        long t1 = System.nanoTime();
    
        dist = djk.dist(dest);

        for(City prv = dest; prv != null; prv = djk.from(prv)){
            System.out.println(" -- " + prv.name);
            stops++;
        }

        if(dest != null){
            System.out.println("quickest route from " + from.name + " to " + dest.name + " takes " + dist + " minutes");
            System.out.println("Found in: " + ((t1 - t0)/1_000) + " us ");
        }
    }
}




