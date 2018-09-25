package com.intuit;
/*package com.intuit;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
         Enter your code here. Read input from STDIN. Print output to STDOUT 
//        User user = new User("amit","");
    }
}

class User{
    private String userId;
    private String userName;
    private String regStatus;
	
    public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRegStatus() {
		return regStatus;
	}
	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}
    
}

class Book{
	private String id;
    private String name;
    private String author;
    private String category;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}

class Registration{
    private HashMap<String,User> userList= new HashMap<>();
    public HashSet<String> userIdData=new HashSet<>();
    
    public String validateUserId(String userId){
        if(!userIdData.contains(userId)){
        	userIdData.add(userId);
            return "Avaialble";
        }else {
        	return "Not Avaialble, Try Another";
        }
    }
    
    public String registerUser(String id,User user){
        if(!userList.containsKey(id)) {
        		userList.put(id, user);
        }
        if(approveUser(user)) {
        		return "Registration Successfull";
        }
        return "Registration Not Successfull";
    }
    
    public boolean approveUser(User user) {
    		user.setRegStatus("Approved");
    		return true;
    }
}

class LoanBook{
	
}

class BookSearch{
	public List<Book> bookList=new ArrayList<>();
	public Book getBook(String name,String author,String category) {
		for(Book book:bookList) {
			
		}
	}
}


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
         Enter your code here. Read input from STDIN. Print output to STDOUT 
        User user1=new User("abc1","Amit","Not Approved");
        Registration register=new Registration();
        register.registerUser(Math.random()*1000+"",user1);
        
        
        
        
        LibraryManagement lm = new LibraryManagement();
        lm.addBook("Advance Algorithm", "Algorithms", "Coreman");
        lm.addBook("Head First Java", "Java", "firstman");
        lm.addBook("Head First Python", "Python", "secondman");
        
        List<Book> searchedBook = null;
        searchedBook = lm.searchByAuthor("Coreman"); // by authors
        System.out.println("searchedBook by author : " + searchedBook.size()  + " book name " +  searchedBook.get(0).getBookId());
        
        searchedBook.clear();
        
        searchedBook = lm.searchByCategories("Python"); // by authors
        System.out.println("searchedBook by categorie : " + searchedBook.size() + " book name " +  searchedBook.get(0).getBookId());
        
        
        Thread userFirst = new Thread(new BookAllocation(lm,searchedBook.get(0)));
        Thread userSecond = new Thread(new BookAllocation(lm,searchedBook.get(0)));

        userFirst.start();
        åuserSecond.start();

    }
}

class User{
    private String userId;
    private String userName;
    private String regStatus;
    
    public User(String userId,String userName,String regStatus){
        this.userId=userId;
        this.userName=userName;
        this.regStatus=regStatus;
    }
    
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getRegStatus() {
        return regStatus;
    }
    public void setRegStatus(String regStatus) {
        this.regStatus = regStatus;
    }
    
}

class Registration{
    private HashMap<String,User> userList= new HashMap<>();
    public HashSet<String> userIdData=new HashSet<>();
    
    public String validateUserId(String userId){
        if(!userIdData.contains(userId)){
            userIdData.add(userId);
            return "Avaialble";
        }else {
            return "Not Avaialble, Try Another";
        }
    }
    
    public String registerUser(String id,User user){
        if(!userList.containsKey(id)) {
                userList.put(id, user);
        }
        if(approveUser(user)) {
                return "Registration Successfull";
        }
        return "Registration Not Successfull";
    }
    
    public boolean approveUser(User user) {
            user.setRegStatus("Approved");
            return true;
    }
}

class LibraryManagement{
    Map<String, List<Book>> categories= new HashMap<>();
    Map<String, List<Book>> authors = new HashMap<>();
    Map<String,List<Book>> bookAllocationMap = new HashMap<>();
    
    public synchronized boolean loanBook(User user, Book book){
            if(book.getIsBookAvailable()){
                book.setIsBookAvailable(false);
                if(bookAllocationMap.get(user.getUserId()) != null){
                    bookAllocationMap.get(user.getUserId()).add(book);
                }else{
                    List<Book> bkLst = new ArrayList();
                    bkLst.add(book);
                    bookAllocationMap.put(user.getUserId(),bkLst);
                } 
                return true;    
            }
            else return false;
    }
    
    
    public List<Book> searchByCategories(String categorie){
        if(categories.get(categorie) != null) return categories.get(categorie);
        else return null;
    }
    
    public List<Book> searchByAuthor(String authorName){
        if(authors.get(authorName) != null) return authors.get(authorName);
        else return null;
    }
    
    
    public boolean addBook(String bookName, String categorie, String authorName){
        Book bk = new Book(((int)(Math.random()*10000))+"", bookName,categorie,authorName);
        bk.setIsBookAvailable(true);
        if(categories.get(categorie) != null){
            categories.get(categorie).add(bk);
        }else{
            List<Book> bkLst = new ArrayList();
            bkLst.add(bk);
            categories.put(categorie,bkLst);
        }  
        
        if(authors.get(authorName) != null){
            authors.get(authorName).add(bk);
        }else{
            List<Book> bkLst = new ArrayList();
            bkLst.add(bk);
            authors.put(authorName,bkLst);
        }  
        System.out.println("categorie size " + categories.size());
        return true;
    }
}

class Book{
    private String bookId;
    private String bookName; 
    private String author;
    private String catgories;
    private boolean isBookAvailable;    
    
    public boolean getIsBookAvailable() {
        return isBookAvailable;
    }
    public void setIsBookAvailable(boolean isBookAvailable) {
        this.isBookAvailable = isBookAvailable;
    }
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public Book(String bookId, String bookName, String author, String catgories) {
        super();
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.catgories = catgories;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCatgories() {
        return catgories;
    }
    public void setCatgories(String catgories) {
        this.catgories = catgories;
    }
    
    
}

class BookAllocation implements Runnable{

private LibraryManagement lm;
private Book book;


public BookAllocation(LibraryManagement lm, Book book) {
super();
this.lm = lm;
this.book = book;
}



@Override
public void run() {
// TODO Auto-generated method stub
//User user = new User(((int)(Math.random()*10000))+"");
System.out.println("is book allocated : " + Thread.currentThread()+ " : "+ lm.loanBook(user, book));

}


}
*/