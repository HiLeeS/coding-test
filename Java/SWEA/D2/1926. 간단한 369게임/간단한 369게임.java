import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++)
		{
			String num = Integer.toString(i);
            if(num.contains("3") || num.contains("6") || num.contains("9")){
            	int len = num.length();
                for(int j = 0; j < len; j++){
                	if(num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9'){
                    	sb.append("-");
                    }
                }
                sb.append(" ");
            }
            else{
            	sb.append(i+" ");
            }

		}
        System.out.print(sb);
	}
}