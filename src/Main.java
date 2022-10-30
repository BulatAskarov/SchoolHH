import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            arrayList.add(sc.nextInt());
        }
        int sum = 0;
        for (int n : arrayList){
            sum += n;
        }
        System.out.println(sum / arrayList.size());

        Collections.sort(arrayList);
        System.out.println(arrayList);
    }

}
