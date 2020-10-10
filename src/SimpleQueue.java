import java.util.NoSuchElementException;

public class SimpleQueue {
	
	public static String[] arr;
	public static int size;

	public SimpleQueue(int capacity) {
		if(capacity <= 0) {
			throw new IllegalArgumentException(); 
			}
		arr = new String[capacity];
		size = 0;
	}
	
	public synchronized boolean add(String str) {
		if(arr.length == size) { 
			throw new IllegalStateException("Queue full"); 
			}
		if(str == null) {
			throw new NullPointerException(); 
			}
		arr[size ++] = str;
		return true;
	}
	
	public void clear() {
		for(int i = 0; i < size; i++) {
			arr[i] = null;
		}
		size = 0;
	}
	
	public boolean contains(String str) {
		for(int i = 0; i < size; i++) {
			if(arr[i].equals(str)) { 
				return true; 
				}
		}
		return false;
	}
	
	public String element() {
		if(size == 0) { 
			throw new NoSuchElementException(); 
			}
		return arr[0];
	}
	
	public boolean offer(String str) {
		if(arr.length == size) { 
			return false; 
			}
		add(str);
		return true;
	}
	
	public String peek() {
		return arr[0];
	}
	
	public String poll() {
		try { 
			return remove(); 
			}
		catch (NoSuchElementException e) {
			return null; 
			}
	}
	
	public int remainingCapacity() {
		return arr.length - size;
	}
	
	public String remove() {
		return remove(0);
	}
	
	public boolean remove(String str) {
		int index = indexOf(str);
		if(index != -1) { remove(index); return true; }
		return false;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String str = "[";
		for(int i = 0; i < size-1; i++) {
			str += arr[i];
			str += ", ";
		}
		if(size != 0) {
			str += arr[size - 1];
		}
		str += "]";
		return str;
	}
	
	private int indexOf(String str) {
		for(int i = 0; i < size; i++) {
			if(arr[i].equals(str)) { return i; }
		}
		return -1;
	}
	
	private String remove(int index) {
		if(index < 0) { 
			throw new NoSuchElementException(); 
			}
		if(index >= size) { 
			throw new NoSuchElementException(); 
			}
		String str = arr[index];
		for(int i = index; i < size - 1; i ++) {
			arr[i] = arr[i + 1];
		}
		arr[--size] = null;
		
		return str;
	}
}