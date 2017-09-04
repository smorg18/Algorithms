
//import
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap; 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap; 
public class Permutation {
    //get weight and value sum of set 
    public static int orderCheck(ArrayList<Integer>perm, int n){
        int criteriaMet = 0;
        for (int i = 1; i< n; i++){
            if (perm.get(i)> perm.get(i-1)){
                criteriaMet = 1;
            }
        }
        return criteriaMet;
    }

    public static int greatestIndexI (ArrayList<Integer>perm, int n){
        int greatestIndex =0;
        for (int i = 0; i<(n-1); i++){
            if (perm.get(i)<perm.get(i+1)){
                greatestIndex = i;
            }
        }
        return greatestIndex;
    }
    public static int greatestIndexJ (ArrayList<Integer>perm, int n, int i){
        int greatestIndex =0;
        for (int j = 0; j<n; j++){
            if (perm.get(i)<perm.get(j)){
                greatestIndex = j;
            }
        }
        return greatestIndex;
    }
    public static void main(String [] args) {
        System.out.println("Command-line arguments:");
        int n = 0;
        for (String arg : args) {
                n = Integer.parseInt(args[0]);
                System.out.println(n);
        }

        
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("sample_perm_output.txt"));
            ArrayList<Integer> perm = new ArrayList<>();
            for (int l=0; l< n; l++)
            {
                perm.add(l+1);
            }
            String Line = Integer.toString(perm.get(0));
            for (int c = 1; c < n; c++){
                Line = Line + " " + Integer.toString(perm.get(c));
            }
            try{
                    Line= Line + "\n";
                    writer.write(Line);
                }
            catch  (IOException e) {
                System.out.println("Failed to write to file ");
            }
            while (orderCheck(perm,n) == 1){
                int i = greatestIndexI(perm, n);
                int j = greatestIndexJ(perm,n,i);
                int aI = perm.get(i);
                int aJ = perm.get(j);
                perm.set(i, aJ);
                perm.set(j, aI);
                for (int m = i+1;m < (n-1); m++){
                    int oldM = perm.get(m);
                    int newM = perm.get(m+1);
                    perm.set(m,newM);
                    perm.set((m+1),oldM);

                }
                String newLine = Integer.toString(perm.get(0));
                for (int c = 1; c < n; c++){
                    newLine = newLine + " " + Integer.toString(perm.get(c));
                }
                try{
                    newLine= newLine + "\n";
                    writer.write(newLine);
                }
                catch  (IOException e) {
                    System.out.println("Failed to write to file ");
                }
                
            }
            try {
                    writer.close();
                }
            catch (IOException e) {
                    System.out.println("Failed to close file ");
                }
        }
        catch(IOException e) {
                System.out.println("Failed to create file ");
            }
    }
}
