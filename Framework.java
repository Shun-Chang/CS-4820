import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Framework {
    // number of men (women)
    int n;
    // preference list of men (n*n)
    int MenPrefs[][];
    // preference list of women (n*n)
	int WomenPrefs[][]; 
    
    // your output should fill this arraylist which is empty at start
	ArrayList<MatchedPair> MatchedPairsList;

    public class MatchedPair {
        // man's number
        int man;
        // woman's number
		int woman;

        public MatchedPair(int Man, int Woman) {
            man = Man;
            woman = Woman;
		}
		
		public MatchedPair() {	

        }
	}
		
	// reading the input
	void input(String input_name) {
        File file = new File(input_name);
		BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
			
			String text = reader.readLine();
			
			String [] parts = text.split(" ");
			n = Integer.parseInt(parts[0]);
			
			MenPrefs = new int[n + 1][n];
			WomenPrefs = new int[n + 1][n];

            for (int i = 1; i <= n; i++) {
                text = reader.readLine();
                String [] mList = text.split(" ");
				for (int j = 0; j < n; j++) {
                    MenPrefs[i][j] = Integer.parseInt(mList[j]);
                }
			}
			
			for (int i = 1; i <= n; i++) {
				text = reader.readLine();
				String [] wList = text.split(" ");
				for (int j = 0;j < n; j++) {
					WomenPrefs[i][j] = Integer.parseInt(wList[j]);
                }
			}
            reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// writing the output
	void output(String output_name) {
        try {
            PrintWriter writer = new PrintWriter(output_name, "UTF-8");

            for (int i = 0; i < MatchedPairsList.size(); i++) {
				writer.println(MatchedPairsList.get(i).man + " " + MatchedPairsList.get(i).woman);
			}
            writer.close();
		} catch (Exception e) {
            e.printStackTrace();
		}
	}
	
	public Framework(String[] Args) {
        input(Args[0]);

		MatchedPairsList = new ArrayList<MatchedPair>(); // your should put the final stable matching in this array list
		
		/* NOTE
		 * if you want to declare that man x and woman y will get matched in the matching, you can
		 * write a code similar to what follows:
		 * MatchedPair pair=new MatchedPair(x,y);
		 * MatchedPairsList.add(pair);
		*/
		
		//YOUR CODE GOES HERE
		
		output(Args[1]);
	}
	
    // Strings in Args are the name of the input file followed by the name of the output file
	public static void main(String[] Args) {
		new Framework(Args);
	}
}