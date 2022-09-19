package com.problem;

import java.util.Stack;

public class LargestRactangleAreaInHistogram {
	
	private static void largestAreaInHistogram(int[] arr, int n) {
		int left[] = new int[n];
		int right[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		//prev smallest element;
		for(int i=0;i<n;i++) {
			
			while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
				stack.pop();
			
			if(stack.isEmpty())
				left[i] = 0;
			else
				left[i] = stack.peek()+1;
			
			stack.push(i);
			
		}
		
		stack.clear();
		//next smallest element;
		for(int i=n-1;i>=0;i--) {
			
			while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
				stack.pop();
			
			if(stack.isEmpty())
				right[i] = n-1;
			else
				right[i] = stack.peek()-1;
			
			stack.push(i);
			
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			
			max = Math.max(max, arr[i]*(right[i]-left[i]+1));
		}
		
		
		System.out.println("Area: "+max);
		
		
	}

	public static void main(String[] args) {
		
		int arr[] = {2, 1, 5, 6, 2, 3, 1};
		int n = arr.length;
		
		largestAreaInHistogram(arr, n);

	}

}
