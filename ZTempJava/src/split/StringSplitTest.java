package split;

import java.util.Arrays;

public class StringSplitTest {

	public static void main(String...strs){
	String str = "com.pg.str.ysr.SRVIVICE";
	String[] strArr= str.split("\\.");
	System.out.println("strArr "+Arrays.toString(strArr));
	System.out.println("strArr size "+strArr.length);
	System.out.println("last strArr "+((strArr.length > 0)?strArr[strArr.length-1]:null));
	System.out.println(StringSplitTest.class.toString());
	System.out.println(StringSplitTest.class.getPackage().toString());
	}
	
}
