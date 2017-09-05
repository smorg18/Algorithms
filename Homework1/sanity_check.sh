#!/bin/sh

clear

RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m'


echo "\n\n========================"
echo "Testing your programs..."
echo "========================\n\n"

echo "1 First removing all the .class files and old output files..."
rm -f *.class
rm -f knap_output.txt
rm -f perm_output.txt
rm -f tsp_output.txt

echo "\n\n2 Now compiling the .java files...\n"

echo "\n   2A Compiling Knapsack.java...\n"
javac -classpath . Knapsack.java

echo "\n   2B Compiling Permutation.java...\n"
javac -classpath . Permutation.java

echo "\n   2C Compiling TSP.java..."
javac -classpath . TSP.java

echo "\n\n3 Running programs...\n"

echo "\n   3A Running Knapsack class...\n"
java -classpath . Knapsack 50 > knap_output.txt

echo "\n   3B Running Permutation class...\n"
java -classpath . Permutation 4 > perm_output.txt

echo "\n   3C Running TSP class...\n"
java -classpath . TSP > tsp_output.txt

echo "\n\nTesting result of Knapsack program...\n"

diff knap_output.txt sample_knap_output.txt
if [ $? -ne 0 ]; 
then
     echo "Your knapsack program ${RED}FAILED${NC} the sanity test.  That means that you have a mistake in the code."
else
     echo "Your knapsack program ${GREEN}PASSED${NC} the sanity test.  That may not mean it performs correctly for every input file, but it does for the sample input file."
fi



echo "\n\nTesting result of Permutation program...\n"
diff perm_output.txt sample_perm_output.txt
if [ $? -ne 0 ];
then
    echo "Your permutation program ${RED}FAILED${NC} the sanity test.  That means that you have a mistake in the code."
else
    echo "Your permutation program ${GREEN}PASSED${NC} the sanity test.  That may not mean it performs correctly for every input file, but it does for the sample input file."
fi

echo "\n\nTesting result of TSP program...\n"

diff tsp_output.txt sample_tsp_output.txt
if [ $? -ne 0 ];
then
    echo "Your tsp program ${RED}FAILED${NC} the sanity test.  That means that you have a mistake in the code."
else
    echo "Your tsp program ${GREEN}PASSED${NC} the sanity test.  That may not mean it performs correctly for every input file, but it does for the sample input file."
fi

echo "\n\n...done with tests.\n"

