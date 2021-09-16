import java.util.ArrayList;
import java.util.Scanner;
/**
*Replaces '+' with '+++'
*/
public class Main1 {
    public static void main(String[] args) {
        ArrayList<String> myArrayList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("First line");
        myArrayList.add(sc.nextLine());
        System.out.println("Second line");
        myArrayList.add(sc.nextLine());
        System.out.println("Third line");
        myArrayList.add(sc.nextLine());
        System.out.println("Forth line");
        myArrayList.add(sc.nextLine());
        System.out.println("Fifth line");
        myArrayList.add(sc.nextLine());


        String b;
        System.out.println(myArrayList);
        for (int i = 0; i < myArrayList.size(); i++) {

                int l = myArrayList.indexOf("+");
                String a = myArrayList.get(i);
                System.out.println(a);

                if (a.contains("+")){
                    b = a.replace("+","+++");

                myArrayList.remove(i);
                myArrayList.add(i,b);

                }
        }


        System.out.println(myArrayList);
    }
}
