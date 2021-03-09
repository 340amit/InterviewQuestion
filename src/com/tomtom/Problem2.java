package com.tomtom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Problem2 {

	public static void main(String[] args) {
		Problem2 p2=new Problem2();
		
		int[][] A = {
				{ 5, 4, 4 },
				{ 4, 3, 4 },
				{ 3, 2, 4 },
				{ 2, 2, 2 },
				{ 3, 3, 4 },
				{ 1, 4, 4 },
				{ 4, 1, 1 }
			};
		
		int result = p2.solution(A);
		System.out.println("num of country is:"+result);
		Stack<List<Integer>> s=new Stack<>();
		List<Integer> a= new ArrayList<>();
		a.add(1);
		a.add(2);
		List<Integer> x=new ArrayList<> ();
		s.add(a);
//		System.out.println("Peek:"+s.peek());
		

	}
	
	int solution(int[][]A) {
		int num_row = A.length;
		int num_col = A[0].length;

		if (num_row < 2 && num_col < 2)
			return Math.min(num_row, num_col);

//		vector< vector<int> > B(num_row, vector<int>(num_col, -1));
		int[][] B=new int[num_row][num_col];
		for (int[] row: B) {
			Arrays.fill(row, -1);
		}
		    
		
		int num_country = 0;
		List<Integer> current_pos=new ArrayList<>();

		for (int row = 0; row < num_row; row++) {
			for (int col = 0; col < num_col; col++) {
				if (B[row][col] == -1) {
					current_pos.add(row);
					current_pos.add(col);
					if (!is_existing_country(A, B, current_pos)) {
						num_country++;
						B[current_pos.get(0)][current_pos.get(1)] = num_country;
					}

					print(B);

					extendCountry(A, B, current_pos);
				}
			}
		}

		return num_country;
	}
	
	void extendCountry(int[][] A,int[][]B, List<Integer> position) {
		int num_row = B.length;
		int num_col = B[0].length;
		
		Stack<List<Integer>> stack_pos=new Stack<>();
		stack_pos.push(position);
		
		while (!stack_pos.empty()) {
			List<Integer> current_pos = stack_pos.peek();
			stack_pos.pop();

			while (hasNext(A, B, current_pos)) {
				List<Integer> next_pos = next(A, B, current_pos);
				stack_pos.push(current_pos);
				current_pos = next_pos;

				print(B);
			}
		}
		
	}
	
	// Check if position is existing country.
	// If so, label it.
	boolean is_existing_country(int[][]A, int[][]B, List<Integer> position) {
		int num_row = B.length;
		int num_col = B[0].length;
		int x = position.get(0);
		int y = position.get(1);

		if (y < num_col - 1 && B[x][y + 1] != -1 && A[x][y] == A[x][y + 1]) {
			B[x][y] = B[x][y + 1];
			return true;
		}
		if (x < num_row - 1 && B[x + 1][y] != -1 && A[x][y] == A[x + 1][y]) {
			B[x][y] = B[x + 1][y];
			return true;
		}
		if (y > 0 && B[x][y - 1] != -1 && A[x][y] == A[x][y - 1]) {
			B[x][y] = B[x][y - 1];
			return true;
		}
		if (x > 0 && B[x - 1][y] != -1 && A[x][y] == A[x - 1][y]) {
			B[x][y] = B[x - 1][y];
			return true;
		}

		return false;
	}


	List<Integer> next(int[][] A, int[][] B, List<Integer> current_pos) {
		int num_row = B.length;
		int num_col = B[0].length;
		int x = current_pos.get(0);
		int y = current_pos.get(1);

		List<Integer> next_pos=new ArrayList<>();

		if (y < num_col - 1 && B[x][y + 1] == -1 && A[x][y] == A[x][y + 1]) {
			B[x][y + 1] = B[x][y];
			next_pos.add(x);
			next_pos.add(y + 1);
			return next_pos;
		}
		if (x < num_row - 1 && B[x + 1][y] == -1 && A[x][y] == A[x + 1][y]) {
			B[x + 1][y] = B[x][y];
			next_pos.add(x + 1);
			next_pos.add(y);
			return next_pos;
		}
		if (y > 0 && B[x][y - 1] == -1 && A[x][y] == A[x][y - 1]) {
			B[x][y - 1] = B[x][y];
			next_pos.add(x);
			next_pos.add(y - 1);
			return next_pos;
		}
		if (x > 0 && B[x - 1][y] == -1 && A[x][y] == A[x - 1][y]) {
			B[x - 1][y] = B[x][y];
			next_pos.add(x - 1);
			next_pos.add(y);
			return next_pos;
		}

		return next_pos;
	}


	boolean hasNext(int[][] A, int[][] B, List<Integer> current_pos) {
		int num_row = B.length;
		int num_col = B[0].length;
		int x = current_pos.get(0);
		int y = current_pos.get(1);

		if (y < num_col - 1 && B[x][y + 1] == -1 && A[x][y] == A[x][y + 1]) {
			return true;
		}
		if (x < num_row - 1 && B[x + 1][y] == -1 && A[x][y] == A[x + 1][y]) {
			return true;
		}
		if (y > 0 && B[x][y - 1] == -1 && A[x][y] == A[x][y - 1]) {
			return true;
		}
		if (x > 0 && B[x - 1][y] == -1 && A[x][y] == A[x - 1][y]) {
			return true;
		}

		return false;
	}


	void print(int[][] V) {
		int num_row = V.length;
		int num_col = V[0].length;

		for (int i = 0; i < num_row; i++) {
			for (int j = 0; j < num_col; j++) {
//				cout.width(3);
//				cout << V[i][j] << ", ";
				System.out.print(V[i][j]+",");
			}
			System.out.println();
		}
		System.out.println();	
	}

}
