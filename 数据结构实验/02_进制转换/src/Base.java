import java.util.Stack;


/*
 * ½øÖÆ×ª»»
 * */
public class Base {
	public static void main(String[] args) {
		answer(15, 2);
		answer(15, 8);
		answer(15, 16);
	}
	public static void answer(int number, int base) {
		Stack<Integer> stack = new Stack<>();
		while(number != 0) {
			stack.add(number % base);
			number = number / base;
		}
		
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			if(temp < 10) {
				System.out.printf("%d", temp);
			} else {
				switch (temp) {
					case 10:
						System.out.print("A");
						break;
					case 11:
						System.out.print("B");
						break;
					case 12:
						System.out.print("C");
						break;
					case 13:
						System.out.print("D");
						break;
					case 14:
						System.out.print("E");
						break;
					case 15:
						System.out.print("F");
						break;
				}
			}
		}
		System.out.println();
	}
}
