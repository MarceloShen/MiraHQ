import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of MyList with an array (a longer exercise would be to
 * implement the List interface as is done in the class java.util.ArrayList: the
 * source of the ArrayList class is available from Sun. Check it out).
 * 
 * @author Marcelo Shen, Ashley Mead, Eashver Elango, Brandon Yi
 */

public class MyArrayList<E> implements MyList<E> {

	// Use an array for the implementation
	private E[] items;

	// Default capacity of the array
	private static final int DEFAULT_CAPACITY = 10;

	// Number of elements in the array
	private int size;

	// private Class<MyArrayList> type = (Class<MyArrayList>) ((MyArrayList)
	// getClass());

	/**
	 * Constructs a MyArrayList with a specified capacity
	 */
	public MyArrayList(int initialCapacity) {
		this.items = (E[]) new Object[initialCapacity];
		this.size = 0;
	}

	/**
	 * Constructs a MyArrayList with a default capacity
	 */
	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Returns the number of elements in this list.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Returns true if this list contains no elements.
	 */
	public boolean isEmpty() {
		return this.size() == 0;
	}

	/**
	 * Appends the specified element to the end of this list
	 */
	public boolean add(E o) {
		// If there is no room in the array items
		// Make room for the new element
		if (this.size >= this.items.length) {
			// throw new RuntimeException("list capacity exceeded"); // This was a
			// "temporary measure" in the slide
			E[] newList = (E[]) new Object[size * 2];
			// copy all elements into newList
			for (int i = 0; i < items.length; i++) {
				newList[i] = this.items[i];
			}
			this.items = newList;
		}

		// add the new element
		this.items[this.size] = o;
		this.size++;
		return true;
	}

	/**
	 * Empties this List
	 */
	public void clear() {
		for (int k = 0; k < this.size; k++) { // optional
			this.items[k] = null; // triggers a garbage collection if it is the only reference
		}
		this.size = 0;
	}

	/**
	 * Returns the element at the specified position in this list.
	 */
	public E get(int index) {
		// Check if index is out of bound
		assert !(index < 0 || index >= this.size) : "Index out of bounds!";
		return this.items[index];
	}

	public boolean set(int index, E element) {
		// Check if index is out of bound
		if (index < 0 || index >= this.size) {
			return false;
		}
		if (element == null && index == this.size - 1) {
			this.size--;
			while (this.size > 0 && this.items[this.size - 1] == null) {
				this.size--;
			}
		}
		this.items[index] = element;
		return true;
	}

	/**
	 * Returns the index of the specified element (-1 if there is no match)
	 */
	public int indexOf(Object o) {
		// If o is null (look for a null element in the array)
		if (o == null) {
			for (int i = 0; i < this.size(); i++) {
				E elem = this.get(i);
				if (elem == null) {
					return i;
				}
			}
		} else // o is an object (use equals)
		{
			for (int i = 0; i < this.size(); i++) {
				E elem = this.get(i);
				if (elem != null && elem.equals(o)) {
					return i;
				}
			}
		}

		// If we get here, o is not in the list
		return -1;
	}

	/**
	 * Returns true if this list contains the specified element.
	 */
	public boolean contains(Object o) {
		return this.indexOf(o) != -1;
	}

	/**
	 * Removes the element in the List at position index
	 */
	public boolean remove(int index) {
		if(index < 0 || index >= this.size) {
			throw new IllegalStateException();
		}
		E removedElem = this.items[index];
		for(int i = index + 1; i < this.size; i++) {
			this.items[i-1] = this.items[i];
		}
		this.items[this.size - 1] = null;
		this.size--;
		return true;
	}

	/**
	 * Removes the element in the List at position index
	 */
	public boolean remove(Object o) {
		int pos = indexOf(o);
		if (pos != -1) {
			this.remove(pos);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Adds the specified object at the specified location
	 */
	public boolean add(int index, E o) {
		if (index < 0 || index >= this.size) {
			if (index == this.size) {
				this.add(o);
			} else {
				return false;
			}
		}
		if (this.size >= this.items.length) {
			E[] newList = (E[]) new Object[size * 2];
			// copy all elements into newList
			for (int i = 0; i < items.length; i++) {
				newList[i] = items[i];
			}
			this.items = newList;
		}
		for (int i = this.size - 1; i >= index; i--) {
			this.items[i + 1] = this.items[i];
		}
		size++;
		this.items[index] = o;
		return true;
	}

	/**
	 * Is this List equal to the specified object?
	 */
	public boolean equals(Object o) {
		// If o and this are equal in memory, return true
		if (o == this)
			return true;

		// If o isn't an ArrayList return false
		if (!(o instanceof MyArrayList))
			return false;

		// Iterate through both arraylists
		Iterator e1 = this.iterator();
		Iterator e2 = ((MyArrayList) o).iterator();
		while (e1.hasNext() && e2.hasNext()) {
			// Get the values at the indexes
			Object o1 = e1.next();
			Object o2 = e2.next();
			// Check if either are null and then check for equality
			if (!(o1 == null ? o2 == null : o1.equals(o2)))
				return false;
		}

		// If either have hit the end of the iterating, return false.
		return !(e1.hasNext() || e2.hasNext());
	}

	/**
	 * An inner class to define the iterator
	 */
	private class MyIterator implements Iterator<E> {
		private int index = 0;

		private MyArrayList<E> list;

		private int lastIndex = -1; // index of the object most recently visited

		/**
		 * Create an iterator for a MyArrayList
		 */
		public MyIterator(MyArrayList<E> list) {
			this.list = list;
		}

		/**
		 * Any element left in the list?
		 */
		public boolean hasNext() {
			// the last possible index that has next is list.size()-2
			// so anything less than list.size()-1 will have a next value.
			return this.index < this.list.size() - 1;
		}

		/**
		 * Returns the current element in the list and move to the next element
		 */
		public E next() {
			// Throw exception at the end of iterating
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			// save last index
			this.lastIndex = this.index;

			// get the value at the index
			E result = this.list.get(this.index);

			// move index forward for next iteration
			this.index++;

			// return result
			return result;
		}

		/**
		 * Removes the last object returned by next
		 */
		public void remove() {
			// Remove the last value by removing the value at the last index we were at
			this.list.remove(this.lastIndex);
		}
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * 
	 * @return an iterator over the elements in this list in proper sequence.
	 */
	public Iterator<E> iterator() {
		return new MyIterator(this);
	}
}
