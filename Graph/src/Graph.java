
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class SolvingTSP {
    int[][] W; int n;
    public SolvingTSP (String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        n = Integer.parseInt(sc.nextLine());
        W = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) W[i][j] = Integer.MAX_VALUE;
            String line = sc.nextLine();
            System.out.println("Line: " + line);
            String[] substring = line.split(" ");
            for(int j=0; j<substring.length; j+=2)
                W[i][Integer.parseInt(substring[j])] =
                        Integer.parseInt(substring[j+1]);
        }
    }
    public void display() {
        System.out.print("Num vertices n = "+n);
        for(int i=1; i<=n; i++) {
            System.out.println("");
            for(int j=1; j<=n; j++)
                if (W[i][j] == Integer.MAX_VALUE)
                    System.out.print("+Inf");
                else
                    System.out.printf("%4d ", W[i][j]);
        }
    }
    int[] HC; boolean[] Mark;
    void listAllCycle() {
        HC = new int[n+1]; Mark = new boolean[n+1];
        minHC = new int[n+1];
        HC[1] = 1; Mark[1] = true; listAllCycle(2, 0);
        System.out.println("Min total is " + minTotal);
        print(minHC);
    }
    void print(int[] HC) {
        for(int j=1; j<=n; j++) System.out.print(HC[j]+"-");
        System.out.println("1");
    }
    int count=0; int minTotal = Integer.MAX_VALUE;
    int[] minHC;
    void listAllCycle(int step, int prevSum) {
        if (step == n+1) {
            int sum = prevSum + W[HC[n]][1];
            System.out.printf("HC %3d (%4d): ", (++count), sum);
            print(HC);
            if (minTotal > sum) {
                minTotal = sum; minHC = Arrays.copyOf(HC, n+1);
            }
            return;
        }
        for(int j=1; j<=n; j++) {
            if(Mark[j] || (W[HC[step-1]][j] == Integer.MAX_VALUE)) continue;
            HC[step] = j; Mark[j] = true;
            listAllCycle(step+1, prevSum + W[HC[step-1]][j]); // ...
            Mark[j] = false;
        }
    }
}
public class Graph {
    public static void main(String[] args) throws FileNotFoundException {
        SolvingTSP GGGG = new SolvingTSP("D:\\_FU___\\GIANG-DAY\\"+ "11. SP23\\CSD201\\Outline\\tsp.txt");
        GGGG.display(); GGGG.listAllCycle(); System.out.println(""); return;

    }
}