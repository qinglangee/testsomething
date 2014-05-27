package com.zhch.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;

public class WriteLine {
	public void test() throws IOException {
		Random r = new Random();
		String ls = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<10000000;i++){
			int a = r.nextInt(1000);
			if(a%2 == 0){
				a = -a;
			}
			sb.append(a).append(ls);
		}
		FileUtils.write(new File("/home/lifeix/temp/d3/number"), sb);
	}
	
	public static void sum(int[] nums, int start, int end){
		long sum = 0;
		for(int i=start;i<=end;i++){
			sum += nums[i];
		}
		System.out.println("sum:" + sum);
	}

	public static void main(String[] args) throws IOException {
		WriteLine t = new WriteLine();
		//t.test();
		findMaxSum();
		System.out.println("over!");
	}
	
	public static void findMaxSum() throws IOException{
		File file = new File("/home/lifeix/temp/d3/number");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		int[] nums = new int[10000000];
		int index = 0;
		while((line = br.readLine()) != null){
			nums[index++] = Integer.parseInt(line);
		}
		Num input = new Num(nums, 0, nums.length -1);
		
		int[] a = new int[]{1,-8,2,3,-5,3,4,5};
//		input = new Num(a, 0, a.length - 1);

		long t1 = System.currentTimeMillis();
		Num result = findMax(input);
		long t2 = System.currentTimeMillis();
		sum(nums, result.start, result.end);
		System.out.println("sum:" + result.sum + " start:" + result.start + " end:" + result.end + " time:" + (t2 - t1));
		lineMax(input.nums);
	}
	
	public static Num findMax(Num input) throws IOException{
		if(input.start == input.end){
			input.sum = input.nums[input.start];
			return input;
		}
		Num leftSub = new Num(input.nums, input.start, input.mid);
		Num rightSub = new Num(input.nums, input.mid + 1, input.end);
		Num left = findMax(leftSub);
		Num right = findMax(rightSub);
		Num mid = findMaxMiddle(input);
		if(left.sum >= right.sum && left.sum >= mid.sum){
			return left;
		}
		if(right.sum >= left.sum && right.sum >= mid.sum){
			return right;
		}
		return mid;
	}
	public static Num findMaxMiddle(Num input){
		long leftSum = 0;
		long sum = 0;
		long rightSum = 0;
		int left = input.mid;
		Num result = new Num(input.nums);
		
		for(int i=input.mid;i>=input.start;i--){
			sum += input.nums[i];
			if(sum > leftSum){
				left = i;
				leftSum = sum;
			}
			
		}
		int right = input.mid;
		sum = 0;
		for(int i=input.mid+1;i<=input.end;i++){
			sum += input.nums[i];
			if(sum > rightSum){
				right = i;
				rightSum = sum;
			}
			
		}
		result.start = left;
		result.end  = right;
		result.sum = leftSum + rightSum;
		return result;
	}
	
	public static void lineMax(int[] nums){
		long t1 = System.currentTimeMillis();
		long sum = 0;
		int start = 0;
		int end = 0;
		long minusSum = 0;
		int nextStart = 0;
		long nextSum = 0;
		
		for(int i=0;i<nums.length;i++){
			int num = nums[i];
			nextSum += num;
			if(nextSum > 0){
				if(minusSum + num > 0){
					if(sum + minusSum < 0){
						start = nextStart;
						end = i;
						sum = nextSum;
					}else{
						end = i;
						sum = sum + minusSum + num;
					}
					minusSum = 0;
				}else{
					if(minusSum + sum > 0){
						minusSum += num;
					}else{
						start = nextStart;
						end = i;
						sum = nextSum;
						minusSum = 0;
						nextStart = i + 1;
						nextSum = 0;
					}
				}
			}else{
				minusSum += num;
				nextSum = 0;
				nextStart = i+1;
			}
//			System.out.println("sum:" + sum + " start:" + start + " end:" + end + " minusSum:" + minusSum + " nS:" + nextStart + " n:" + nextSum);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("sum:" + sum + " start:" + start + " end:" + end + " time:" + (t2 - t1));
		
//		for(int i=0;i<nums.length;i++){
//			int num = nums[i];
//			if(num > 0){
//				if(end + 1 == i){
//					end = i;
//					sum += num;
//				}else{
//					if(minusSum + num > 0){
//						if(sum + minusSum < 0){
//							start = nextStart;
//							end = i;
//							sum = num;
//							minusSum = 0;
//						}else{
//							end = i;
//							sum = sum + minusSum + num;
//							minusSum = 0;
//						}
//					}else{
//						if(num + nextSum > sum){
//							start = nextStart;
//							end = i;
//							sum = num;
//							minusSum = 0;
//						}else{
//							minusSum += num;
//							nextStart = i;
//							nextSum += num;
//						}
//					}
//				}
//			}else{
//				minusSum += num;
//				if(nextSum + num > 0){
//					nextSum += num;
//				}else{
//					nextStart = i + 1;
//					nextSum = 0;
//				}
//			}
//		}
	}
}
class Num{
	public int[] nums;
	public long sum;
	public int start;
	public int mid;
	public int end;
	public Num(){}
	public Num(int[] nums){
		this.nums = nums;
	}
	public Num(int[] nums, int s, int e){
		this.nums = nums;
		start = s;
		end = e;
		mid = (s+e)/2;
	}
}
