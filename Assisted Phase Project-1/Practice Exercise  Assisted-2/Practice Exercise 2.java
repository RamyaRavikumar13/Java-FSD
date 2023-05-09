Practice Exercise 2:
2. Writing a program in java to implement access modifiers.
package Java_a;

public class Access_Specifiers1 {

	public static void main(String[] args) {
		//default
		System.out.println("Dafault Access Specifier");
		 Default_Access_Specifier obj= new  Default_Access_Specifier (); 		  
        obj.display(); 

	}

}
package Java_a;

public class Access_Specifiers2 {
	public static void main(String[] args) {
		
		System.out.println("Private Access Specifier");
		Access_Specifiers2  obj= new Access_Specifiers2(); 
        
	}
}
package Java_a;

 class Default_Access_Specifier {

	  void display() 
	     { 
	         System.out.println("You are using defalut access specifier"); 
	     } 
	}
package Java_a;

 class Private_Access_Specifier {
	 
	   private void display() 
	    { 
	        System.out.println("You are using private access specifier"); 
	    } 


}
