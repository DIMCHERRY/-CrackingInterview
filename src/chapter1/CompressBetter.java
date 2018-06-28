package chapter1;

/**
 *利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 *比如字符串aabcccccaaa会变成a2b1c5a3.
 *若压缩后的字符串没有变短，则返回原先的字符串。
 */

/*
 * 时间复杂度和空间复杂度均为O（N）
 */

public class CompressBetter {
	static String compressBetter(String str){
		/*检查压缩后的字符串是否会变得更长*/
		int size=countCompression(str);
		if(size>str.length()){
			return str;
		}
		
		StringBuffer mystr=new StringBuffer();
		char last=str.charAt(0);
		int count=1;
		for(int i=1;i<str.length();i++){
			if(str.charAt(i)==last){//找到重复字符
				count++;
			}else{
				mystr.append(last).append(count);//插入字符与数目
				last=str.charAt(i);
				count=1;
			}
		}
		/*在18行，当重复字符改变时，才会插入字符。
		 * 还需要在函数末尾更新字符串，因为最后一组重复字符还未放入压缩字符串中。
		 */
		mystr.append(last);
		mystr.append(count);
		return mystr.toString();
	}

	 static int countCompression(String str) {
		if(str==null||str.isEmpty())
			return 0;
		char last=str.charAt(0);
		int size=0;
		int count=1;
		for(int i=1;i<str.length();i++){
			if(str.charAt(i)==last){
				count++;
			}else{
				last=str.charAt(i);
				size+=1+String.valueOf(count).length();
				count=1;
			}		
		}
		size+=1+String.valueOf(count).length();
		return size;
	}

	 public static void main(String[] args){
		 String s="adeeeeeeeeee";
			System.out.print(compressBetter(s));
	 }
}
