import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));

	}

	public static String decodeString(String s) {
		/*
		 * make a stack keep pushing each char of the s until ']' is found when ']'
		 * found -> a closed bracket element is finished hence, store in a stringBuilder
		 * -> string find the previous digit beofore '[' repeat the string to that many
		 * times of the digit in the string add the final string to the stack keep doing
		 * until -> it has traversing the end of the string
		 * 
		 * can create a integer stack and pop one b one the [] is accomplished
		 */

		if (s.length() == 1) {
			return s;
		}

		int count = 0;
		Stack<String> resultS = new Stack<String>();

		while (count < s.length()) {
			if (s.charAt(count) == ']') {
				// main algo
				String finalS = "";
				StringBuilder sb = new StringBuilder();
				while (!resultS.peek().equals("[")) {
					sb.append(resultS.pop()); // sb has all the chars till [
					// XX - strings hasnt got added
				}
				resultS.pop(); // removing the [
				// now fetch the previous digit // and repeat that many times
				int repeatI = 0;
				String repeatS = "";

				while (!resultS.isEmpty() && Character.isDigit(resultS.peek().charAt(0))) {
					if (Character.isDigit(resultS.peek().charAt(0))) {

						repeatS = resultS.pop() + repeatS; // jotting all the digit formated string together
					}
				}
				repeatI = Integer.parseInt(repeatS);

				finalS = sb.toString();
				sb.setLength(0); // clearing the StringBuilder
				for (int i = 1; i <= repeatI; i++) {
					sb.append(finalS); // adding the string to the SB to the repeated times
				}
				// done repeating //add to the main stack
				finalS = sb.toString();
				resultS.push(finalS);
				finalS = "";
				sb.setLength(0); // clearing the StringBuilder
				count++;
			} else {
				resultS.push(Character.toString(s.charAt(count)));
				count++;
			}
		}
		String output = "";
		while (!resultS.isEmpty()) {
			output = output + resultS.pop();
		}
		String fs = "";
		for (int i = output.length() - 1; i >= 0; i--) {
			fs = fs + output.charAt(i);
		}
		return fs;
		// return the final stack in a string format

	}
}
