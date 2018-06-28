package chapter1;

/*
 * 假定有一个方法，可检查一个单词是否为其他字符串的子串。
 * 给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成，要求只能调用一次isSubstring。
 * 比如waterbottle是erbottlewat旋转后的字符串。
 */

/*解法：
 * 假定s2由s1旋转而成，那么，我们可以找出旋转点在哪。
 * 例如,若以wat对waterbottle旋转，就会得到erbottlewat。
 * 在旋转字符串时，我们会把s1切分成两部分：x和y，并将它们重新组合成s2。
 *   s1=xy=waterbottle
 *   x=wat
 *   s2=yx=erbottlewat
 *   需要确认有没有办法将s1切分为x和y，以满足xy=s1和yx=s2。
 *   不论x和y之间的分割点在何处，我们会发现yx肯定是xyxy的子串。即，s2总是s1s1的子串。
 */

public class IsRotation {
    public static boolean isRotation(String s1,String s2){
    	int len=s1.length();
    	/*检查是s1和s2是否等长且不为空*/
    	if(len==s2.length()&&len>0){
    		/*拼接s1和s1，放入新字符串中*/
    		String s1s1=s1+s1;
    		return isSubString(s1s1,s2);
    	}
    	return false;
    }

	private static boolean isSubString(String s1s1, String s2) {
		if(s1s1.indexOf(s2)!=-1){
			return true;
		}else{
		    return false;
	}
	}
	
	public static void main(String[] args){
		String s1="waterbottle";
		String s2="rbottlewate";
		System.out.print(isRotation(s1,s2));
	}
}
