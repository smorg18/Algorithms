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

    //get all the permutations for a given number of tasks
    static void permute(int[] p, int k) //int firstP ) 
    {
        
        if (k == p.length) 
        { 
            ArrayList<Integer> permList = new ArrayList<Integer>();
            for (int i = 0; i < p.length; i++) {
                permList.add(a[i]);
            }
            perms.add(permList);
        }
        else 
        {
            for (int i = k; i < p.length; i++) 
            {
                int recurP = p[k];
                p[k] = p[i];
                p[i] = recurP;
 
                permute(p, k + 1);//, firstP);
 
                recurP = p[k];
                p[k] = p[i];
                p[i] = recurP;
            }
            
        }
        
    }
    //return the min sum of task weight*(ft - dft )
    public static ArrayList<Integer> minimize (HashMap<Integer, Integer[]> tasks, int numOfTasks){
        //array with a permutation 
        ArrayList<Integer> minPerm = new ArrayList<Integer>();
        int min = 0;
        //go through permutation and calculate sum of task weight*(ft - dft )
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
                //duration 
                int dur = info[2];
                //finish time 
                int FT = startTime +dur; 
                //sum of fiish time - deasired ft 
                sum = sum +((info[3])*(FT-info[1]));
                startTime = FT; 
                
                //System.out.print(" [" + a[i] + "] ");
            }
            // set min to first perm             
            if (i ==0){
                min = sum;
                minPerm = permutation;
            }
            //if not first perm but smaller than min update min 
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
        //get num of tasks and seed from command lien 
        for (String arg : args) {
                numOfTasks = Integer.parseInt(args[0]);
                seed = Integer.parseInt(args[1]);
                //System.out.println(n);
        }

        // dictionary with tasks as keys and duration start time desired finish time and weight as values 
        HashMap<Integer, Integer[]> tasks = new HashMap<Integer, Integer[]>();

 
        List<String> results = new LinkedList<String>();
        //binaryPerm("", numOfTasks, results, numOfTasks); 
        int[] sequence = new int[numOfTasks];
        for (int i = 0; i< numOfTasks; i++){
            sequence[i] = i;
            //get random values for each value of a task 
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
            //add values to dic tionary with rtask as key 
            tasks.put(i, info);
        

        }
        
    
        int min = 0;
        //return min permand print 
        permute(sequence, 0);

        System.out.println(minimize(tasks, numOfTasks));
        
    }
}