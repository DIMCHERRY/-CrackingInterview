package chapter1;

/**给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串**/

/**解法：组成两个字符串的字符数量相同，遍历字符表，计算每个字符出现的次数 假设为ASCII字符集**/

public class Sort1 {
    public static boolean premutation(String s,String t){
    	if(s.length()!=t.length())
    		return false;
    	
    	int letters[]=new int[256];
    	
    	char[] s_array=s.toCharArray();
    	for(char c:s_array){
    		letters[c]++;
    	}
    	for(int i=0;i<t.length();i++){
    		int c=(int)t.charAt(i);
    		if(--letters[c]<0){
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args){
    	String s="abcdefghijklmn";
    	String t="abcdefghijklmn";
    	System.out.print(premutation(s,t));
    }
}
