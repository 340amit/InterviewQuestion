package com.klarna;

public class OrdinalFormating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String numberToOrdinal(Integer number) {
	      
	      if(number == 0) return "0";
	      if (number % 100 <= 13 && number % 100 >= 11) return formOrdinal(number,"th"); 
	      
	      switch (number % 10) {
	        case 1:
	          return formOrdinal(number,"st");
	        case 2:
	          return formOrdinal(number,"nd");
	        case 3:
	          return formOrdinal(number,"rd");
	        default:
	          return formOrdinal(number,"th");
	        }
		}
	  
	  static String formOrdinal(Integer number, String suffix){
	    StringBuilder sb = new StringBuilder();
	    return sb.append(number).append(suffix).toString();
	  }  

}
