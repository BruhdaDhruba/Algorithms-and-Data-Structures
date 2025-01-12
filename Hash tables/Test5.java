public class Test5 {
 
    public static void main(String[] arg) {

    int n = 13513;
    Better better1 = new Better("/Users/dhrubadas/Desktop/ID1021/Hash tables/postnummer.csv", n);
    
    
    
    System.out.printf("#%7s%8s\n","Zipcode","Lookup");
    
    System.out.printf("%8s", "111 15");
    int a = better1.lookup(11115);
    System.out.printf("%8d\n", a);

    System.out.printf("%8s", "352 46");
    int b = better1.lookup(35246);
    System.out.printf("%8d\n", b);

    System.out.printf("%8s", "591 62");
    int d = better1.lookup(59162);
    System.out.printf("%8d\n", d);

    System.out.printf("%8s", "737 91");
    int e = better1.lookup(73791);
    System.out.printf("%8d\n", e);

    System.out.printf("%8s", "984 99");  
    int c = better1.lookup(98499);
    System.out.printf("%8d\n", c);

    }
}

