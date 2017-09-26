//import
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap; 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.LinkedList;


public class BruteForce {
     static void permute(int[] a, int k) 
    {
        if (k == a.length) 
        {
            for (int i = 0; i < a.length; i++) 
            {
                System.out.print(" [" + a[i] + "] ");
            }
            System.out.println();
        } 
        else 
        {
            for (int i = k; i < a.length; i++) 
            {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
 
                permute(a, k + 1);
 
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }
     public static void main(String [] args) {
    //System.out.println("Command-line arguments:");
        int numOfTasks = 0;
        int seed = 1000;
        for (String arg : args) {
                numOfTasks = Integer.parseInt(args[0]);
                seed = Integer.parseInt(args[1]);
                //System.out.println(n);
        }
        HashMap<Integer, Integer[]> tasks = new HashMap<Integer, Integer[]>();

 
        List<String> results = new LinkedList<String>();
        //binaryPerm("", numOfTasks, results, numOfTasks); 
        int[] sequence = new int[numOfTasks];
        for (int i = 0; i< numOfTasks; i++){
            sequence[i] = i;
            Random rand = new Random();
            int startTime = rand.nextInt(seed) + 1;
            int desiredFT = rand.nextInt(seed) + 1;
            int dur = rand.nextInt(seed) + 1;
            int weight = rand.nextInt(seed) + 1;
            Integer info []= {startTime, desiredFT, dur, weight};
            tasks.put(i, info);
        

        }
        permute(sequence, 0);
    }
}