/**
 * 
 */
package com.wayfair;

/**
 * @author Sachin Garg
 * print matrix multiplication table 
 *
 */
public class PrintMatrixMultiplicationTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] data = new int[5][5];
		
		matrixMultiplicationTable(5, 5);

	}

	static void matrixMultiplicationTable(int r, int c){
		int[][] tableMatrix = new int[r][c];
		
		for(int i=0; i < tableMatrix.length; i++){
			for (int j=0; j < tableMatrix[i].length; j++){
				tableMatrix[i][j] = (i+1)*(j+1);
			}
		}
		
		System.out.println(tableMatrix);
		for(int r1=0; r1 < tableMatrix.length; r1++){
			for(int matrix=0; matrix < tableMatrix[r1].length; matrix++){
				System.out.printf("%2d ",tableMatrix[r1][matrix]);
			}
		}
	
	}
}
