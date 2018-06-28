package chapter1;

/**
实现一个算法，确定一个字符串的所有字符是否全都不同。
假设不允许使用额外的数据结构，又该如何处理？
**/

/**空间占用可以减少为UniqueChars.java的八分之一**/
public class UniqueChars1 {
    public static boolean isUniqueChars(String str){
    	if(str.length()>26)
    		return false;
    	
    	int checker=0;
    	for(int i=0;i<str.length();i++){
    		int val=str.charAt(i)-'a';
    		//左移运算，丢弃最高位，0补最低位
    		if((checker&(1<<val))>0){
    			return false;
    		}
    		checker|=(1<<val);
    	}
    	return true;
    }
    
    public static void main(String[] args){
    	String str="ab,11cdfwe";
    	System.out.print(isUniqueChars(str));
    }
}
