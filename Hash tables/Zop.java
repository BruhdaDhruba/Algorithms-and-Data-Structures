import java.io.BufferedReader;
import java.io.FileReader;

public class Zop {
    Node[] data;
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

    public Zop(String file) {
        data = new Node[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        }
        catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public String lookup(Integer indx){
        if(data[indx] == null)
          return null;
        return data[indx].name;
    }

}
