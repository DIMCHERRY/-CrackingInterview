package chapter1;

/**
 *利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 *比如字符串aabcccccaaa会变成a2b1c5a3.
 *若压缩后的字符串没有变短，则返回原先的字符串。
 */

/**
 * 解法：迭代访问字符串，将字符拷贝至新字符，并数出重复字符。
 */

/**
 * 执行时间为O(p+k^2),p为原始字符串长度，k为字符序列数量。
 * 代码中s的字符序列数量为3。
 * 字符串拼接操作的时间复杂度为O（n^2）。
 */

/**
 *缺点：不存在字符检测，无法确认压缩后的字符串没有变短。
 */
public class CompressBad {
	public static String compressBad(String str){
		String mystr="";
		char last=str.charAt(0);
		int count=1;
		for(int i=1;i<str.length();i++){
			if(str.charAt(i)==last){//找到重复字符
				count++;
			}else{//插入字符的数目，更新last字符
				mystr+=last+""+count;
				last=str.charAt(i);
				count=1;
			}			
		}
		return mystr+last+count;
	}

	public static void main(String[] args){
		String s="abcde";
		System.out.print(compressBad(s));
}
}
