package com.soroco;

public class SamallestNumber{ 
   
 // function to form the smallest number 
 // using at most one swap operation 
 public static String smallestNumber(String str){ 
       
     char[] num = str.toCharArray(); 
     int n = str.length(); 
     int[] rightMin = new int[n]; 

     rightMin[n - 1] = -1; 
     int right = n - 1; 
 
     for (int i = n - 2; i >= 1; i--)  {   
         if (num[i] > num[right]) {
        	 rightMin[i] = right;
         }  

         else
         {  
         rightMin[i] = -1; 

         // update 'right' index 
         right = i; 
         } 
     } 

     // special condition for the 1st  
     // digit so that it is not swapped  
     // with digit '0' 
     int small = -1; 
     for (int i = 1; i < n; i++) 
         if (num[i] != '0') 
         { 
             if (small == -1) 
             { 
                 if (num[i] < num[0]) 
                     small = i; 
             } 
             else if (num[i] < num[small]) 
                 small = i;                  
         } 
   
     if (small != -1){ 
         char temp; 
         temp = num[0]; 
         num[0] = num[small]; 
         num[small] = temp; 
     } 
     else
     { 
         // traverse the 'rightMin[]'  
         // array from 2nd digit up  
         // to the last digit 
         for (int i = 1; i < n; i++)  
         {  
             // if for the current digit,  
             // smaller right digit exists,  
             // then swap it with its smaller 
             // right digit and break 
             if (rightMin[i] != -1)  
             {  
                 // performing the required  
                 // swap operation 
                 char temp; 
                 temp = num[i]; 
                 num[i] = num[rightMin[i]]; 
                 num[rightMin[i]] = temp; 
                 break; 
             } 
         } 
     } 

     // required smallest number 
     return (new String(num));          
 } 
   
 // driver function 
 public static void main(String argc[]){ 
//     String num = "9625635"; 
     String num="81111111112";
     System.out.println("Smallest number: "+ 
                       smallestNumber(num)); 
 } 
} 
