// Name: Mohamed Ameen Omar
// Student number: u16055323

import java.util.ArrayList;
/**
 * The class definition for a Binary Heap
 */
public class BinHeap<T extends Comparable<? super T>> {
	// The elements of the heap are stored in this list; do not modify!
	ArrayList<T> list = new ArrayList<T>();

	/**
	 * This functions prints the contents of the inner list of the heap on a single line.
	 */
	@Override
	public String toString() {
		String s = "";
		int level = 1;
		for (int i = 0; i < list.size(); i++) {
			s += list.get(i) + " ";
			if (i == Math.pow(2, level)-2 && i != (list.size()-1)) {
				s += "\n";
				level++;
			}
		}
		return s;
	}

	////// You may not change any code above this line //////

	////// Implement the functions below this line //////

	/**
	* Inserts the given element into the tree.
	* @param el
	* 		 	The element to be inserted into the tree
	*
	*/
	public void insert(T el)
	{
		//add to end of list
		list.add(el);
		//make heap from last element
		heapifyUp(list.size()-1);
		// Your code here
	}

	/**
	* Delete the given element from the tree.
	* @param el
	* 		 	The element to be deleted from the tree
	*
	*/
	public void remove(T el)
	{
		// Your code here

		//index of element to remove
		int pos = list.indexOf(el);

		int end = list.size() - 1;

		//if not in the list
		if(pos == -1)
		{
			return;
		}


		if(pos != end)
		{
			swap(pos, end);

			list.remove(list.size() - 1);

			heapifyDown(pos);
		}

		else
		{
			list.remove(list.size() - 1);
		}

		//run again to check if theres another one in the list
		remove(el);

	}



	//Helper functions

	//returns index of Parent of node passed in
	private int getParent(int index)
	{

		if(index < 0 || index >= list.size())
		{
			return -1;
		}

		else if(index == 0 && !list.isEmpty())
		{
			return -1;
		}

		else
		{
			return ((index-1)/3);
		}


	}


	//index of child
	private int getChild(int index, int child)
	{
		//out of bounds
		if( ( child < 0 )||( child > 2)||( index < 0 )||( index >= list.size() ) )
		{
				return -1;
		}

		int x = (3 * index) + child + 1;

		//out of bounds
		if(x >= list.size())
		{
			return -1;
		}


		else
		{
			return x;
		}

	}



	//bubbles up
	private void heapifyUp(int index)
	{
			if(index < 0|| index >= list.size() )
			{
				return;
			}


			else if(index == 0)
			{
				return;
			}

			int x = getParent(index);

			if(list.get(index).compareTo(list.get(x))>0)
			{
				swap(x, index);
				heapifyUp(x);
			}
	}


	//swaps elements
		private void swap(int x, int index2)
		{
			if(x < 0 || (index2 < 0) || x >= list.size() || index2 >= list.size() )
			{
					return;
			}

			else
			{
					T temp = list.get(x);
					T temp2 = list.get(index2);

					list.set(x, temp2);
					list.set(index2,temp);


					return;
			}
		}

		//sort out the list after deleting
		private void heapifyDown(int index)
		{

			if( (index >= list.size() )|| (index < 0) )
			{
				return;
			}

			int a = getChild(index, 0);
			int b = getChild(index, 1);
			int c = getChild(index, 2);

			if(a != -1)
			{
				int greater = a;

				if(b != -1)
				{
					if((list.get(greater).compareTo(list.get(b))<0))
					{
						greater = b;
					}

					if(c != -1)
					{
						if((list.get(greater).compareTo(list.get(c))<0))
						{
							greater = c;
						}

					}
				}

				if( list.get(index).compareTo(list.get(greater) ) < 0 )
				{
					this.swap(index, greater);
					heapifyDown(greater);
				}
			}
		}
}
