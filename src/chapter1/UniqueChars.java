package chapter1;

/**
 *实现一个算法，确定一个字符串的所有字符是否全都不同。
 *假设不允许使用额外的数据结构，又该如何处理？
 **/

/**解法：构建一个布尔型的数据组，索引值i对应的标记指示该字符串是否含有字母表第i个字符。如果含有，则返回false**/

/**时间复杂度为O（n），空间复杂度为O（1）**/
public class UniqueChars {
	
	public static boolean isUniqueChars(String str){
		if(str.length()>256)
			return false;
		
		boolean[] char_set=new boolean[256];
		for(int i=0;i<str.length();i++){
			//charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1
			//将获取的字符以ASCII码形式赋给val
			int val=str.charAt(i);
			if(char_set[val]){
				return false;
			}
			char_set[val]=true;
		}
		return true;
	}

	public static void main(String[] args){
		String str="abcdeff";
		System.out.print(isUniqueChars(str));
	}
}
