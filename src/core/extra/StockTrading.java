package core.extra;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Blake on 5/3/2017.
 */
public class StockTrading {
    private int T;
    private int N;
    private int[] Pi;
    private ArrayList<Integer> answers;

    public StockTrading() {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        answers = new ArrayList<>();
        for (int t = 0; t < T; t++) {
            N = scanner.nextInt();
            Pi = new int[N];
            for (int p = 0; p < N; p++) Pi[p] = scanner.nextInt();
            int maxTimesBought = getMaxTimesBought(Pi);
            answers.add(maxTimesBought);
        }
        for (int i = 0; i < answers.size(); i++) System.out.println("case #" + (i + 1) + ": " + answers.get(i));

    }

    private int getMaxTimesBought(int[] pi) {
        ArrayList<Integer> chainCounts = new ArrayList<>();
        for(int i =0;i<pi.length-1;i++){
           int lastBought = pi[i];
           int count =1;
           for(int j=i;j<pi.length;j++){
               if(lastBought>pi[j]){
                   lastBought = pi[j];
                   count++;
               }
           }
           chainCounts.add(count);
       }
        chainCounts.sort(Integer::compareTo);
        return chainCounts.get(chainCounts.size()-1);
    }
}
