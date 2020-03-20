package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class P_16235 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] nmk = br.readLine().split(" ");
			int n = Integer.parseInt(nmk[0]);
			int m = Integer.parseInt(nmk[1]);
			int k = Integer.parseInt(nmk[2]);
			int[][] toAdd = new int[n][n];
			int[][] A = new int[n][n];
			int[][] dirs = {{0, 1}, {0, -1}, {1, 1}, {1, 0}, {1, -1}, {-1, 1}, {-1, 0}, {-1, -1}};
			for (int i = 0; i < n; i++)
			{
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < n; j++)
				{
					toAdd[i][j] = Integer.parseInt(line[j]);
					A[i][j] = 5;
				}
			}
			LinkedList<Tree> trees = new LinkedList<Tree>();

			for (int i = 0; i < m; i++)
			{
				String[] line = br.readLine().split(" ");
				trees.add(new Tree(Integer.parseInt(line[0])-1, Integer.parseInt(line[1])-1, Integer.parseInt(line[2])));
			}
			while (k > 0)
			{
				
				//Spring
				int i = 0;
				ArrayList<Tree> deadTrees = new ArrayList<Tree>();
				while (!trees.isEmpty() && i < trees.size())
				{
					Tree t = trees.get(i);
					if (A[t.x][t.y] >= t.age)
					{
						A[t.x][t.y] -= t.age;
						t.age++;
						i++;
						
					}
					else
					{
						deadTrees.add(t);
						trees.remove(i);
					}
				}
				
				//Summer
				for (Tree t : deadTrees)
				{
					A[t.x][t.y] += t.age / 2;
				}
				
				//Fall
				LinkedList<Tree> newTrees = new LinkedList<Tree>();
				for (Tree t : trees)
				{
					if (t.age % 5 == 0)
					{
						for (int j = 0; j < dirs.length; j++)
						{
							if (0 <= t.x + dirs[j][0] && t.x + dirs[j][0] < n 
									&& 0 <= t.y + dirs[j][1] && t.y + dirs[j][1] < n)
							{
								newTrees.add(new Tree(t.x + dirs[j][0],t.y + dirs[j][1],1));
							}
						}
						
					}
				}
				trees.addAll(newTrees);
				
				//Winter
				for (i = 0; i < n; i++)
				{
					for (int j = 0; j < n; j++)
					{
						A[i][j] += toAdd[i][j];
					}
				}
			
				k--;
			}
			System.out.println(trees.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}

class Tree implements Comparable<Tree> {
	int x;
	int y;
	int age;
	Tree(int x, int y, int age)
	{
		this.x = x;
		this.y = y;
		this.age = age;
	}
	@Override
	public int compareTo(Tree t) {
		return this.age - t.age;
	}
}
