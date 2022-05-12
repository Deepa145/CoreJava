package com.chainsys.collections;
import java.util.Iterator;
import java.util.ArrayDeque;

public class ArrayDequeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArrayDeque<String> arraydeque=new ArrayDeque<String>();
arraydeque.push("A");
arraydeque.push("B");
arraydeque.push("X");
arraydeque.push("Z");
arraydeque.push("D");
arraydeque.push("X");//duplicate value
arraydeque.push("Z");//duplicate value
arraydeque.push("E");
arraydeque.push("F");
//System.out.println("Before Popping the stack:"+arraydeque.size());
//while(arraydeque.peek() !=null)
//	System.out.println(arraydeque.pop()+" ");
//System.out.println("After Popping the stack:"+arraydeque.size());
Iterator<String> iterator=arraydeque.iterator();
while(iterator.hasNext())
{
System.out.println("/t"+iterator.next());	
}
System.out.println("Descending Order");
Iterator<String> striterator=arraydeque.descendingIterator();
while(striterator.hasNext())
{
System.out.println("/t"+striterator.next());	
}
arraydeque.addFirst("H");
arraydeque.addFirst("I");
iterator=arraydeque.iterator();
while(iterator.hasNext())
{
System.out.println("/t"+iterator.next());	
}
System.out.println("*****pollFirst:"+arraydeque.pollFirst());
System.out.println(arraydeque);
System.out.println("*****pollLast:"+arraydeque.pollLast());
System.out.println(arraydeque);
System.out.println("*****peekFirst:"+arraydeque.peekFirst());
System.out.println(arraydeque);
System.out.println("*****peekLast:"+arraydeque.peekLast());
System.out.println(arraydeque);
System.out.println("*****removeFirst:"+arraydeque.removeFirst());
System.out.println(arraydeque);
System.out.println("*****removeLast:"+arraydeque.removeLast());
System.out.println(arraydeque);
System.out.println("*****removeFirstOccurrence:"+arraydeque.removeFirstOccurrence("X"));
System.out.println(arraydeque);
System.out.println("*****removeLastOccurrence:"+arraydeque.removeLastOccurrence("Z"));
System.out.println(arraydeque);

}
}
