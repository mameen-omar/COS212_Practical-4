/*
*We gave you a main file to test you code. How nice are we?
*/
public class main {
	public static void main(String [] args) {
		BinHeap<Integer> h = new BinHeap<Integer>();
		h.insert(6);
		h.insert(2);
		h.insert(8);
		h.insert(1);
		h.insert(9);
		h.insert(5);
		h.insert(4);

		System.out.println(h);
		System.out.println();
		h.remove(1);
		System.out.println(h);
		System.out.println();
		h.remove(5);
		System.out.println(h);
		System.out.println();
		h.remove(9);
		System.out.println(h);
		System.out.println();
		h.remove(2);
		System.out.println(h);
		System.out.println();
		h.remove(4);
		System.out.println(h);
		System.out.println();
		h.remove(6);
		System.out.println(h);
		System.out.println();
		h.remove(8);
		System.out.println(h);
		
		/* Expected Output:
			9
			8 6
			1 2 5 4

			9
			8 6
			4 2 5

			9
			8 6
			4 2

			8
			4 6
			2

			8
			4 6

			8
			6

			8
		*/
	}
}