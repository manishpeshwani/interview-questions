package com.manish.heap;

import java.util.Arrays;

public class BinaryMinHeapTest {

	public static void main(String[] args) {
		BinaryMinHeap<String> heap = new BinaryMinHeap<String>(10);
		Node<String> n1 = new Node<String>();
		n1.key = "A";
		n1.weight = 75;
		heap.add(n1);
		
		Node<String> n2 = new Node<String>();
		n2.key = "B";
		n2.weight = 70;
		heap.add(n2);
		
		
		Node<String> n3 = new Node<String>();
		n3.key = "C";
		n3.weight = 80;
		heap.add(n3);
		
		
		Node<String> n4 = new Node<String>();
		n4.key = "D";
		n4.weight = 100;
		heap.add(n4);
		
		Node<String> n5 = new Node<String>();
		n5.key = "E";
		n5.weight = 90;
		heap.add(n5);
		
		Node<String> n6 = new Node<String>();
		n6.key = "F";
		n6.weight = 62;
		heap.add(n6);
		
		
		Node<String> n7 = new Node<String>();
		n7.key = "G";
		n7.weight = 52;
		heap.add(n7);
		
		System.out.println(Arrays.toString(heap.arr));
		
		System.out.println(heap.lastIndex);
		System.out.println(heap.extract());
		
		System.out.println(Arrays.toString(heap.arr));
		
System.out.println(heap.extract());
		
		System.out.println(Arrays.toString(heap.arr));
		
System.out.println(heap.extract());
		
		System.out.println(Arrays.toString(heap.arr));
		
System.out.println(heap.extract());
		
		System.out.println(Arrays.toString(heap.arr));
		
System.out.println(heap.extract());
		
		System.out.println(Arrays.toString(heap.arr));

	}

}
