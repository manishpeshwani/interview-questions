package com.manish.queue;

import java.util.Arrays;

public class Queue {
	
	int[] arr = new int[0];
	
	int head =0;
	int tail =-1;
	int size =0;
	
	public void offer(int val){
		
		if(arr.length == size){
			int newSize = size == 0 ? 5 : size*2;
			int[] newArray = new int[newSize];
			if(tail > head){
				int currentIndex = 0; 
				for(int i=head; i<tail;i++){
					newArray[currentIndex] = arr[i];
					currentIndex++;
				}
				
				size = currentIndex;
				head = 0;
				tail = currentIndex-1;
			}else {
				int currentIndex =0;
				size = 0;
				for(int i=head; i<arr.length;i++){
					newArray[currentIndex] = arr[i];
					currentIndex++;
					size++;
				}
				
				for(int i=0; i<tail;i++){
					newArray[currentIndex] = arr[i];
					currentIndex++;
					size++;
				}
				
				head = 0;
				tail = currentIndex;
			}
			
			arr = newArray;
		}
		
		if(tail <= size){
			arr[tail] = val;
			tail++;
			size++;
		}else {
			tail = 0;
			arr[tail] = val;
			tail++;
			size++;
		}
		
		
	}
	
	public int poll(){
		
		if(size == 0){
			return -1;
		}
		
		int headVal = arr[head];
		arr[head] = 0;
		head++;
		size--;
		
		return headVal;
		
	}
	
	public static void main(String[] args){
		Queue q = new Queue();
		q.offer(10);//0
		q.offer(1);//1
		q.offer(20);//2
		q.offer(50);//3
		q.offer(100);//4
		q.poll();//removed 0
		q.poll();//removed 1
		q.offer(40);//should go at 0;
		q.offer(66);
		q.offer(76);
		q.offer(86);
		q.offer(761);
		q.offer(762);
		q.offer(763);
		q.offer(764);
		q.poll();
		q.offer(768);
		q.offer(7681);
		q.offer(7682);
		q.offer(7683);
		q.offer(7684);
		q.offer(7685);
		q.offer(7686);
		q.offer(7687);
		q.offer(7688);
		q.offer(76881);
		q.offer(76882);
		System.out.println(Arrays.toString(q.arr));
		
	}

}
