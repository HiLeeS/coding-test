
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String str = br.readLine();
            int left = 0;
            int right = str.length()-1;
            int res = 1;
            while(left < right){
            	if(str.charAt(left) != str.charAt(right)){
                	res = 0;
                    break;
                }
                left++;
                right--;
            }
		
            sb.append("#").append(test_case).append(" ").append(res).append("\n");

		}
        System.out.print(sb);
	}
}