import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        boolean start = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (start && Character.isLetter(c)) c = Character.toUpperCase(c);
            else if(Character.isLetter(c)) c = Character.toLowerCase(c);
            sb.append(c);
            start = (c == ' ');
        }
        return sb.toString();
    }
}