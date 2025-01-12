import java.io.BufferedReader;
import java.io.FileReader;

public class Hash{
    Integer[] keys = new Integer[10000];
    Node [][] hash_table;
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



    public Hash(String file) {
        mod = 13513;
        hash_table = new Node[mod*2][1];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                addToBucket(new Node(code, row[1], Integer.valueOf(row[2])));
                keys[i++] = code;
            }
            max = i-1;
        }
        catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public static Integer hashInteger(Integer zip, Integer range){
        return zip % range;
    }

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
        Integer index = keys[i] % mod;
        cols[data[index]]++;
        data[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
        System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }

    public void addToBucket(Node n){
        Integer index = hashInteger(n.code, mod);
        if(hash_table[index][0] == null){
            hash_table[index][0] = n;
            return;
        }
        if(hash_table[index][0] != null){
            Node[] newBucket = new Node[hash_table[index].length + 1];
            for(int i = 0; i < hash_table[index].length; i++){
                newBucket[i] = hash_table[index][i];
            }
            newBucket[hash_table[index].length] = n;
            hash_table[index] = newBucket;
        }
    }

    public String lookup(Integer zip){
        Node [] bucket = hash_table[hashInteger(zip, mod)];
        for(int i = 0; i < bucket.length; i++){
              if(bucket[i] != null && zip.equals(bucket[i].code))
                return bucket[i].name; 
        }
        return null;
    }

    public static void main(String[] arg) {
        Hash hash1 = new Hash("/Users/dhrubadas/Desktop/ID1021/Hash tables/postnummer.csv");
        
        hash1.collisions(10000);//Best modulo for 2D hash table 
        hash1.collisions(20000);
        hash1.collisions(13513);//Best modulo
        hash1.collisions(13600);
        hash1.collisions(14000);
    }

}
