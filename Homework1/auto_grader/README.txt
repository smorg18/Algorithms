// Dave Toth
// August 28, 2017

To use this testing program:



1 (If necessary) change the owner and group of the files in auto_grader folder you extracted to you with the command 

	chown your_username:your_username -R auto_grader

at the command line.



2 (If necessary) change the file sanity_check.sh to be executable by typing 

	chmod +x sanity_check.sh 

at the command line.



3 Put your files (TSP.java, Knapsack.java, Permutation.java) into the folder with this readme file.  The files must be named exactly as above or this testing tool will fail, which means your programs will not get credit.



4 Run the sanity checks by typing

	sh sanity_check.sh

at the command line.  The script will indicate which of your 3 programs passes the sanity tests and which fails.  The script will also indicate the differences between the output of your program and the expected output of the sample tests I have bundled using the diff command.
