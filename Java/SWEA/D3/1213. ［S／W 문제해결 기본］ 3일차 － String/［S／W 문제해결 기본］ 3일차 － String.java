
import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int test = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String string = br.readLine();
			
			int count = 0;
			int len = str.length();
			for(int i = 0; i <= string.length()-len; i++) {
				if(string.substring(i, i+len).equals(str)) count++;
				
			}
			
			sb.append("#"+test+" "+count+"\n");
			

		}
        System.out.print(sb);
	}
}