import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Nathan Wang
 * 
 *         Nov 13, 2013
 * 
 *         Built to test CS261 2013 Fall HW9-BinarySearchTrees HW Assignment.
 *         The values in the numbers.txt file are 4 randomly generated sequences of 100 by random.org.
 * 
 * 		   Compare testOutput.txt to answers.txt.  answers.txt is what the ideal printout should look like.
 */
public class BinarySearchTreeTester
{
	public static final String INTS_LOCATION = "numbers.txt";
	public static final String ORDER_COMPARISON_LOCATION = "printInORderComparison.txt";

	/**
	 * @param fileLocation Location of the File
	 * @return parsed integers from file at fileLocation
	 * 
	 *         File must be formatted as "int int int int int\nint int int"
	 */
	public static int[][] parseInts(String fileLocation)
	{
		File f = new File(fileLocation);
		ArrayList<String> firstPass = new ArrayList<String>();
		int[][] re = null;
		String[][] secondPass;
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(f);
		}
		catch (FileNotFoundException e)
		{
			System.err.println("FILE NOT FOUND");
			System.err.println("Please provide a valid file path");
		}
		while (scanner.hasNextLine())
			firstPass.add(scanner.nextLine());
		re = new int[firstPass.size()][];
		secondPass = new String[re.length][];
		for (int i = 0; i < re.length; i++)
		{
			secondPass[i] = firstPass.get(i).split(" ");
			re[i] = new int[secondPass[i].length];
			for (int j = 0; j < re[i].length; j++)
			{
				re[i][j] = Integer.parseInt(secondPass[i][j]);
			}
		}
		return re;
	}

	public static int[][] testInts()
	{
		int[][] values = parseInts("test.txt");
		for (int i = 0; i < values.length; i++)
			System.out.print(values[i][0] + ",");
		System.out.println("");
		return values;
	}

	public static void main(String[] args)
	{
		int[][] values = parseInts(INTS_LOCATION);
		// values = testInts();
		//testInts();
		PrintStream sD = System.out;
		PrintStream out = null;
		try
		{
			out = new PrintStream(new FileOutputStream("testOutput.txt"));
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BinarySearchTree[] trees = new BinarySearchTree[values.length];
		for (int i = 0; i < values.length; i++)
			for (int j = 0; j < values[i].length; j++)
			{
				if (j == 0)
					trees[i] = new BinarySearchTree(values[i][j]);
				else
					trees[i].insert(values[i][j]);
			}
		// if there is an error before here your insert method has a bug.

		// look in the answer key for proper outputs or compare the testOutput.txt to the answerKey.txt

		// has test
		double[] has = { 93, 0, 66, 37, 17, 43, 64, 52, 62, 82, 73, 68, 4, 87,
				89, 74, 51, 99, 53, 3, 56, 84, 6, 25, 53, 88, 42, 79, 55, 39,
				0, 4, 7, 75, 51, 15, 79, 88, 54, 52 };

		System.out.println("Has Test:");
		for (int i = 0; i < has.length; i++)
			System.out.println(trees[i].has(has[i]));
		System.out.println();
		
		System.setOut(out);
		System.out.println("Has Test:");
		for (int i = 0; i < has.length; i++)
			System.out.println(trees[i].has(has[i]));
		System.out.println();
		System.setOut(sD);
		// has end

		// find max test
		System.out.println("Find Max Test:");
		for (int i = 0; i < trees.length; i++)
			System.out.println(trees[i].findMax());
		System.out.println();
		System.setOut(out);
		System.out.println("Find Max Test:");
		for (int i = 0; i < trees.length; i++)
			System.out.println(trees[i].findMax());
		System.out.println();
		System.setOut(sD);
		// find max end

		// find min test
		System.out.println("Find Min Test:");
		for (int i = 0; i < trees.length; i++)
			System.out.println(trees[i].findMin());
		System.out.println();
		System.setOut(out);
		System.out.println("Find Min Test:");
		for (int i = 0; i < trees.length; i++)
			System.out.println(trees[i].findMin());
		System.out.println();
		System.setOut(sD);
		// find min end

		// find Predecessor test
		double[] predTest = { 24, 12, 69, 91, 17, 19, 57, 63, 40, 59, 84, 16,
				47, 59, 92, 50, 5, 81, 2, 67, 5, 83, 62, 28, 67, 57, 96, 27,
				56, 50, 0, 4, 7, 75, 51, 15, 79, 88, 54, 52 };
		System.out.println("Predecessor Test:");
		for (int i = 0; i < trees.length; i++)
			System.out.println(trees[i].findPredecessor(predTest[i]));
		System.out.println();
		System.setOut(out);
		System.out.println("Predecessor Test:");
		for (int i = 0; i < trees.length; i++)
			System.out.println(trees[i].findPredecessor(predTest[i]));
		System.out.println();
		System.setOut(sD);

		// find Successor test
		double[] succTest = { 40, 95, 55, 56, 49, 53, 1, 91, 85, 66, 17, 64,
				91, 58, 63, 84, 89, 24, 78, 66, 8, 96, 64, 66, 97, 54, 58, 37,
				98, 92, 0, 4, 7, 75, 51, 15, 79, 88, 54, 52 };

		System.out.println("Find Successor Test:");
		for (int i = 0; i < trees.length; i++)
			System.out.println(trees[i].findSuccessor(succTest[i]));
		System.out.println();
		System.setOut(out);
		System.out.println("Find Successor Test:");
		for (int i = 0; i < trees.length; i++)
			System.out.println(trees[i].findSuccessor(succTest[i]));
		System.out.println();
		System.setOut(sD);
		// end find successor

		// print in order test
		System.out.println("Print In Order Test:");
		for (int i = 0; i < trees.length; i++)
		{
			trees[i].printInOrder();
		}
		System.out.println();

		System.setOut(out);
		System.out.println("Print In Order Test:");
		for (int i = 0; i < trees.length; i++)
		{
			trees[i].printInOrder();
		}
		System.out.println();
		System.setOut(sD);
		// print in order end.

		// delete test
		double[] deleteTest = { 5, 69, 17, 44, 23, 66, 22, 4, 53, 79, 2, 28, 2,
				60, 55, 72, 82, 82, 61, 32, 85, 4, 26, 2, 77, 85, 46, 80, 78,
				9, 0, 4, 7, 75, 51, 15, 79, 88, 54, 52 };
		System.out.println("Delete Test:");
		for (int i = 0; i < trees.length; i++)
			System.out.println(trees[i].delete(deleteTest[i]));
		System.out.println();
		//reset trees
		for (int i = 0; i < values.length; i++)
			for (int j = 0; j < values[i].length; j++)
			{
				if (j == 0)
					trees[i] = new BinarySearchTree(values[i][j]);
				else
					trees[i].insert(values[i][j]);
			}
		System.setOut(out);
		System.out.println("Delete Test:");
		for (int i = 0; i < trees.length; i++)
			System.out.println(trees[i].delete(deleteTest[i]));
		System.out.println();
		System.setOut(sD);
		// delete end
		
	}
}
