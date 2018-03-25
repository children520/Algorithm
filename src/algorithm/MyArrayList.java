package algorithm;

import java.util.Iterator;

import org.omg.CORBA.Any;
/*
 * ArrayList�������ʵ��
 */
public class MyArrayList<AnyType> implements Iterable<AnyType> {
	private static final int DEFAULT_CAPACTIY=10;
	private int theSize;
	private AnyType[] theItems;
	 public MyArrayList() {
		doClear();
	}
	private void doClear() {
		theSize=0;
		ensureCapacity(DEFAULT_CAPACTIY);
	}
	public int size() {
		return theSize;
	}
	public boolean isEmpty() {
		return size()==0;
	}
	public void trimTosize() {
		ensureCapacity(size());
	}
	public AnyType get(int idx) {
		if(idx<0||idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		return theItems[idx];
	}
	public AnyType set(int idx,AnyType newVal ) {
		if(idx<0||idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		AnyType old=theItems[idx];
		theItems[idx]=newVal;
		return old;
	}
	private void ensureCapacity(int newCapactiy) {
		if(newCapactiy<theSize)
			return;
		AnyType[] old=theItems;
		//Ϊ����������ڴ�
		theItems=(AnyType[]) new Object[newCapactiy];
		for(int i=0;i<size();i++) {
			//�������ݿ�����������
			theItems[i]=old[i];
		}
	}
	/*
	 * ��ӵ����ĩ��ͨ������ָ����λ��
	 */
	public boolean add(AnyType x) {
		add(size(),x);
		return true;
	}
	private void add(int idx, AnyType x) {
		//��������ĳ��ȣ���1��������鳤��Ϊ0�����
		if(theItems.length==size())
			ensureCapacity(size()*2+1);
		for(int i=theSize;i>idx;i--)
			//�Ӻ�ʼ����Ԫ�س���һ��һ����������
			theItems[i]=theItems[i-1];
		theItems[idx]=x;
		
		theSize++;
	}
	public AnyType remove(int idx) {
		AnyType removedItem=theItems[idx];
		for(int i=idx;i<size()-1;i++)
			//�����Ԫ����ǰ��һ��
			theItems[i]=theItems[i+1];
		theSize--;
		return removedItem;
	}
	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return (Iterator<AnyType>) new ArrayListIterator();
	}

/*
 * ͨ��ʹ���ڲ��࣬��������Ӷ��ⲿ������һ����ʽӦ�ã��ö��������ڲ������Ĺ���
 */
private class ArrayListIterator implements Iterable<AnyType>{
	private int current=0;
	public boolean hasNext() {
		return current<size();
	}
	public AnyType next() {
		if(!hasNext())
			throw new java.util.NoSuchElementException();
		return theItems[current++];
	}
	public void remove() {
		MyArrayList.this.remove(--current);
	}
	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
public static void main(String[] args) {
	MyArrayList<String> arrayList=new MyArrayList<>();
	arrayList.iterator().hasNext();
}
}