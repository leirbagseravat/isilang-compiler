import java.util.Scanner; 
public class MainClass { 
    public static void main(String args[]){ 
        Scanner _key = new Scanner(System.in);
        double a; 
        double b; 
        String t1; 
        String t2; 
        a = _key.nextDouble(); 
        b = _key.nextDouble(); 
        t1 = _key.nextLine(); 
        if (a<b) {
            System.out.println("caiu no primeiro"); 
            System.out.println(a); 
        }  
        System.out.println(a); 
        if (b<a) {
            System.out.println("não era para cair aqui"); 
        } else {
        System.out.println("caiu no segundo"); 
        System.out.println(b); 
        } 
        while (a<b) {
            System.out.println(a); 
            a = a+1; 
        } 
        b = a+b*2; 
        System.out.println(b); 
        System.out.println(t1); 
    }
}