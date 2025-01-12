import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
    Node[] data;
    int max;
    public class Node {
        String code;
        String name;
        Integer pop;

        public Node(String c, String n, Integer p){
            this.code = c;
            this.name = n;
            this.pop = p;
        }
    }

    public String linear(String zip){
        for(int i = 0; i < data.length; i++){
            if(zip.equals((data[i]).code))
              return (data[i]).name;
        }
        return null;
    }

    public String binary(String zip){
        int mn = 0;
        int mx = max;

        while(true){
            int index = (mn + mx)/2;
            int cmp = zip.compareTo(data[index].code);

            if(cmp == 0){
                return data[index].name;
            }

            if(cmp > 0 && index < mx){
                mn = index + 1;
                continue;
            }

            if(cmp < 0 && index > mn){
                mx = index - 1;
                continue;
            }
            break;
        }
        return null;
    }

    public Zip(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        }
        catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
}

