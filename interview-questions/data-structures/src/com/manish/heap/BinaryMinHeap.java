package com.manish.heap;

public class BinaryMinHeap<T> {
	
	Node<T>[] arr = null;
	
	int lastIndex; 
	
	public BinaryMinHeap(int maxHeapSize){
		arr = new Node[maxHeapSize];
		lastIndex = 0;
	}
	
	public void add(Node<T> nodeToAdd){
		if(lastIndex == 0){
			arr[lastIndex] = nodeToAdd;
			lastIndex++;
			return;
		}
		
		int currentIndex = lastIndex;
		
		arr[currentIndex] = nodeToAdd;
		
		int parentIndex = (currentIndex - 1)/2;
		
		while(nodeToAdd.weight < arr[parentIndex].weight && parentIndex >= 0){
			swap(nodeToAdd, arr[parentIndex]);
			currentIndex = parentIndex;
			nodeToAdd = arr[parentIndex];
			parentIndex = (currentIndex - 1)/2;
		}
		
		lastIndex++;
		
	}
	
	public Node<T> extract(){
		Node<T> nodeToExtract = arr[0];
		
		
		swap(nodeToExtract, arr[lastIndex-1]);
		
		int currentIndex = 0;
		arr[lastIndex - 1] = null;
		lastIndex--;
		
		int leftIndex = currentIndex * 2 + 1;
		int rightIndex = currentIndex * 2 + 2;
		
		
		
		while(leftIndex < this.lastIndex){
			Node<T> minNode = null;
			int minIndex = -1;
			if(rightIndex < this.lastIndex){
				if(arr[rightIndex].weight>arr[leftIndex].weight){
					minNode = arr[leftIndex];
					minIndex = leftIndex;
				}else{
					minNode = arr[rightIndex];
					minIndex = rightIndex;
				}
				
			}else{
				minNode = arr[leftIndex];
				minIndex = leftIndex;
			}
			if(minNode.weight < arr[currentIndex].weight){
				swap(minNode, arr[currentIndex]);
				
				
			}
			currentIndex = minIndex;
			leftIndex = currentIndex * 2 + 1;
			rightIndex = currentIndex * 2 + 2;
			
		}
		
		return nodeToExtract;
	}

	

	private void swap(Node<T> nodeToAdd, Node<T> node) {
		int weight1 = nodeToAdd.weight;
		T key = nodeToAdd.key;
		
		int temp = weight1;
		T tempKey = key;
		
				
		nodeToAdd.weight = node.weight;
		nodeToAdd.key = node.key;
		
		node.key = key;
		node.weight = weight1;
		
	}
	
	
	
	

}
