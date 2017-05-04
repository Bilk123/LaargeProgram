package core.extra;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Blake on 5/3/2017.
 */
public class AverageProfit {
    private int T;
    private int N;
    private int M;
    private int[] Pi;
    private ArrayList<Interval> answer;

    public AverageProfit() {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        int[] intervalHolder;
        ArrayList<Interval> intervals = new ArrayList<>();
        ArrayList<Double> averages = new ArrayList<>();
        answer = new ArrayList<>();
        for (int t = 0; t < T; t++) {
            intervals.clear();
            averages.clear();
            N = scanner.nextInt();
            M = scanner.nextInt();
            Pi = new int[N];
            for (int i = 0; i < N; i++) {
                Pi[i] = scanner.nextInt();
               // System.out.print(Pi[i]+"; ");
            }
            //System.out.println();
            int interval;
            for (int c = 0; c < Pi.length - M; c++) {
                interval = c + M;
                intervalHolder = new int[interval];
                for (int i = 0; i < Pi.length - interval+1; i++) {
                   // System.out.println("Interval: " + (i + 1) + " - " + (i + interval));
                    for (int j = 0; j < M + c; j++) {
                        intervalHolder[j] = Pi[i + j];
                        //System.out.print(intervalHolder[j] + "  ");
                    }
                    //System.out.println(" : Average: " + getAverage(intervalHolder));
                    //System.out.println();
                    averages.add(getAverage(intervalHolder));
                    intervals.add(new Interval(i, i + interval));
                }
            }
            int highestIndex = 0;
            for (int i = 0; i < averages.size(); i++) {
                if (averages.get(highestIndex) < averages.get(i)) highestIndex = i;
                else if (averages.get(highestIndex) == averages.get(i))
                    if (intervals.get(highestIndex).range < intervals.get(i).range) highestIndex = i;
                    else if (intervals.get(highestIndex).range == intervals.get(i).range)
                        if (intervals.get(highestIndex).A < intervals.get(i).A) highestIndex = 1;
            }
            answer.add(intervals.get(highestIndex));

        }
        for (int i = 0; i < T; i++) {
            System.out.println("case #" + (i + 1) + ": " + answer.get(i));
        }
    }

    public static double getAverage(int[] profits) {
        double sum = 0;
        for (int i = 0; i < profits.length; i++) {
            sum += profits[i];
        }
        return sum / (double) profits.length;
    }

    private class Interval {
        public int A, B;
        public int range;

        public Interval(int A, int B) {
            this.B = B;
            this.A = A;
            range = B - A;
        }

        @Override
        public String toString() {
            return (A + 1) + " " + (B);
        }
    }
}
