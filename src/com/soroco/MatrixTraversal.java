package com.soroco;

import java.util.ArrayList;
import java.util.List;

public class MatrixTraversal {

	public static void main(String[] args) {
		/*a d j f
		  b c f m
		  j f q z
		abjfqz*/
		 int[][] x=new int[3][4];
		 System.out.println(x[1][1]);
		
		String target_string="abjfqz";
		List<List<String>> matrix=new ArrayList<>();
		List<String> l1=new ArrayList<>();
		l1.add("a");
		l1.add("b");
		l1.add("j");
		l1.add("d");
		
		List<String> l2=new ArrayList<>();
		l2.add("n");
		l2.add("j");
		l2.add("k");
		l2.add("m");
		
		List<String> l3=new ArrayList<>();
		l3.add("e");
		l3.add("f");
		l3.add("q");
		l3.add("z");
		
		matrix.add(l1);
		matrix.add(l2);
		matrix.add(l3);
		
		System.out.println("r:"+matrix.size());
		System.out.println("c:"+matrix.get(0).size());
		
		System.out.println(find_path(matrix,target_string));
	}
	
	static String find_path(List<List<String>> matrix, String target_string) {
        int r=matrix.size();
        int c=matrix.get(0).size();
        String[][] temp=new String[r+1][c+1];
        
        StringBuilder output=new StringBuilder();
        System.out.println("matrix.get(0).get(0).charAt(0):::"+matrix.get(0).get(0).charAt(0));
        if(matrix.get(0).get(0).charAt(0)!=target_string.charAt(0)){
            return "NO PATH";
        }
        int i,j,k=1;
        for(i=0;i<r;){
        	
        	if(k >= target_string.length())
        		break;
        	
            for(j=1;j<c;){
            	System.out.println(matrix.get(i).get(j).charAt(0));
//            	if(i >= j) output.append("D");
//            	else output.append("R");
                if(matrix.get(i).get(j).charAt(0)==target_string.charAt(k)){
                    output.append("R");
//                    temp[i][j]="R";
                    k++;
                    j++;
                } else if(i+1<r && j-1>0 && matrix.get(i+1).get(j-1).charAt(0)==target_string.charAt(k)){
//                    output.append("D");
//                    temp[i+1][j-1]="D";
                    k++;
                    i++;
                }
                else{
//                		System.out.println("No Path in else");
                	output.append("D");
                     j--;
                     i++;
                    break;
                }
            }
        }
        return output.deleteCharAt(0).deleteCharAt(output.length()-1).toString();
    }

}
