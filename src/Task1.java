import java.util.ArrayList;
import java.util.Scanner;


public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstStackCount;
        int secondStackCount;
        int maxSalary;
        int salSum;
        int maxResCount;
        int resCount = 0;
        salSum = 0;
        ArrayList<String> firstStack = new ArrayList<>();
        ArrayList<String> secondStack = new ArrayList<>();

        firstStackCount = sc.nextInt();
        secondStackCount = sc.nextInt();
        maxSalary = sc.nextInt();


        for (int i = 0; i < Math.max(secondStackCount, firstStackCount); i++) {
            String first = sc.next();
            String second = sc.next();
            firstStack.add(first);
            secondStack.add(second);
        }


        int i = 0;
        while ((salSum < maxSalary) && (i < firstStackCount)) {
            if ((salSum + Integer.parseInt(firstStack.get(i))) <= maxSalary) {
                salSum += Integer.parseInt(firstStack.get(i));
                resCount++;
            } else break;
            i++;
        }

        maxResCount = resCount;

        if (i > 0) i = i - 1;

        for (int j = 0; j < secondStackCount; j++) {
            if ((salSum + Integer.parseInt(secondStack.get(j))) <= maxSalary) {
                salSum += Integer.parseInt(secondStack.get(j));
                resCount++;
            } else {
                while (((Integer.parseInt(secondStack.get(j)) + salSum) >= maxSalary) && (i > 0)) {
                    salSum -= Integer.parseInt(firstStack.get(i));
                    i--;
                    resCount--;
                }
                if ((salSum + Integer.parseInt(secondStack.get(j))) <= maxSalary) {
                    salSum += Integer.parseInt(secondStack.get(j));
                    resCount++;
                } else break;
            }
            if (resCount > maxResCount) {
                maxResCount = resCount;
            }
        }
        System.out.println(maxResCount);
    }
}
