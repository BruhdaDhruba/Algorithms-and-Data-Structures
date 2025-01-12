import java.io.BufferedReader;
import java.io.FileReader;

public class Better {
    Node [] data;
    int mod;
    int max;
    
    public class Node {
        Integer code;
        String name;
        Integer pop;

        public Node(Integer c, String n, Integer p){
            this.code = c;
            this.name = n;
            this.pop = p;
        }
    }



    public Better(String file, int m) {
        mod = m;
        data = new Node[mod *2];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                Node n = new Node(code, row[1], Integer.valueOf(row[2]));
                insert(n.code, n);
            }
            max = i-1;
        }
        catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    

    public int insert(Integer code, Node entry){
        Integer indx = code % mod; 
        int collisions = 0;
        boolean p = false;
        while(true){
            if (data[indx] == null){
                data[indx] = entry;
                break;
            }
            indx = (indx + 1) % mod;
            collisions++;
            p = true;
        }
        if(p)
          System.out.println();
        return collisions;
    }

    
    public int lookup(Integer zip) {
        Integer indx = zip % mod;
        int elementsChecked = 0;
        while (true) {
            if (data[indx] == null)
                break;
            if (data[indx].code.equals(zip))
                break;
            indx++;
            elementsChecked++;
            if (indx == mod)
                indx = 0;
        }
        return elementsChecked;
    }


}




