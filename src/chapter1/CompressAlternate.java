package chapter1;

/**
 *利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 *比如字符串aabcccccaaa会变成a2b1c5a3.
 *若压缩后的字符串没有变短，则返回原先的字符串。
 */

/*
 * 时间复杂度和空间复杂度均为O（N）
 */

public class CompressAlternate {
	static String compressAlternate(String str){
		int size=countCompression(str);
		if(size>=str.length()){
			return str;
		}
		
		char[] array=new char[size];
		int index=0;
		char last=str.charAt(0);
		int count=1;
		for(int i=1;i<str.length();i++){
			if(str.charAt(i)==last){
				count++;
			}else{
				/*更新重复字符的数目*/
				index=setChar(array,last,index,count);
				last=str.charAt(i);
				count=1;
			}
		}
		/*以最后一组重复字符更新字符串*/
		index=setChar(array,last,index,count);
		return String.valueOf(array);
	}

	private static int setChar(char[] array, char c, int index, int count) {
		array[index]=c;
		index++;
		
		/*将数目转换成字符串，然后转换成字符数组*/
		char[] cnt=String.valueOf(count).toCharArray();
		
		/*从最大的数字到最小的，复制字符*/
		for(char x : cnt){
			array[index]=x;
			index++;
		}
		return index;
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
	 
	public static void main(String[] args) {
		 String s="aeeeeeeeee";
			System.out.print(compressAlternate(s));
	}

}
