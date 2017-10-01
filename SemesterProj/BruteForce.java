//import
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap; 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.LinkedList;


//public class starts
public class BruteForce {
    //global variable array 
    public static ArrayList<ArrayList<Integer>> perms = new ArrayList<ArrayList<Integer>>();


    static void permute(int[] a, int k) //int firstP ) 
    {
        
        if (k == a.length) 
        { 
            ArrayList<Integer> permList = new ArrayList<Integer>();
            for (int i = 0; i < a.length; i++) {
                permList.add(a[i]);
            }
            perms.add(permList);
        }
        else 
        {
            for (int i = k; i < a.length; i++) 
            {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
 
                permute(a, k + 1);//, firstP);
 
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
            
        }
        
    }
    public static ArrayList<Integer> minimize (HashMap<Integer, Integer[]> tasks, int numOfTasks){
        
        ArrayList<Integer> minPerm = new ArrayList<Integer>();
        int min = 0;
        for (int i = 0; i < perms.size(); i++) 
        {
            ArrayList<Integer> permutation = new ArrayList<Integer>();
            permutation = perms.get(i);
            int task = permutation.get(0);
            Integer info []= tasks.get(task);
            int startTime = info[0];
            int sum = 0;
            for (int p = 0; p< numOfTasks; p++){
                task = permutation.get(p);
                info = tasks.get(task);
                int dur = info[2];
                int FT = startTime +dur; 
                sum = sum +((info[3])*(FT-info[1]));
                startTime = FT; 
                
                //System.out.print(" [" + a[i] + "] ");
            }
                        
            if (i ==0){
                min = sum;
                minPerm = permutation;
            }
            else if ( i!= 0 && sum<min){
                min = sum;
                minPerm = permutation;
            }
        }
            //minPerm = a;
        return minPerm;
            


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
            System.out.println("st"+startTime);
            int desiredFT = rand.nextInt(seed) + 1;
            System.out.println("dft"+desiredFT);
            int dur = rand.nextInt(seed) + 1;
            System.out.println("dur"+dur);
            int weight = rand.nextInt(seed) + 1;
            System.out.println("weight"+weight);
            Integer info []= {startTime, desiredFT, dur, weight};
            tasks.put(i, info);
        

        }
        
    
        int min = 0;
        permute(sequence, 0);

        System.out.println(minimize(tasks, numOfTasks));
        
    }
}