package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class P7576 {



    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        try {
            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);
            int[][] map = new int[h][w];
            Deque<int []> dq = new LinkedList<int []>();
            int numRipe = 0;
            for (int i = 0; i < h; i++)
            {
                String[] inp2 = br.readLine().split(" ");
                for (int j = 0; j < w; j++)
                {
                    map[i][j] = Integer.parseInt(inp2[j]);
                    if (map[i][j] == 1)
                    {
                        int[] curPoint = {i,j};
                        dq.add(curPoint);
                        numRipe++;
                    }
                }
            }
            int daysPast = 0;
            while (!dq.isEmpty())
            {
                int nextNumRipe = 0;
                for (int i = 0; i < numRipe; i++)
                {    
                    int[] curPoint = dq.remove();
                    for (int[] pt : directions)
                    {
                        int[] nextPt = {curPoint[0] + pt[0], curPoint[1] + pt[1]};
                        if (0 <= nextPt[0] && nextPt[0] < h && 0 <= nextPt[1] && nextPt[1] < w)
                        {
                            if (map[nextPt[0]][nextPt[1]] == 0)
                            {
                                map[nextPt[0]][nextPt[1]] = 1;
                                dq.add(nextPt);
                                nextNumRipe++;
                            }
                        }
                    }
                }
                if (nextNumRipe == 0)
                {
                    break;
                }
                daysPast++;
                numRipe = nextNumRipe;
            }
            //다 익었는지 검사
            for (int i = 0; i < h; i++)
            {
                for (int j = 0; j < w; j++)
                {
                    if (map[i][j] == 0)
                    {
                        System.out.println(-1);
                        return;
                    }
                }
            }
            System.out.println(daysPast);            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
