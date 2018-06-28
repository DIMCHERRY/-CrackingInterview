package chapter1;

/**给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串**/

/**解法：比较对字符串排序之后，二者是否相同**/
public class Sort {
    public static String sort(String s){
    	char[] content=s.toCharArray();
    	java.util.Arrays.sort(content);
    	return new String(content);
    }
    
    //permutation的意思为排列
    public static boolean permutation(String s,String t){
    	if(s.length()!=t.length()){
    		return false;
    	}
    	return sort(s).equals(sort(t));
    }
    
    public static void main(String[] args){
    	String s="abcde";
    	String t="edcba";
    	System.out.print(permutation(sort(s),sort(t)));
    }
}
