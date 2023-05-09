Practice Exercise 7:
7. Writing a program in Java to verify the implementation of inner classes.
package innerClass;

public class innerClassAssissted1 {

	private String msg="Welcome to Java"; 
	 
	 class Inner{  
	  void hello(){System.out.println(msg+", Let us start learning Inner Classes");}  
	 }  


	public static void main(String[] args) {

		innerClassAssissted1 obj=new innerClassAssissted1();
		innerClassAssissted1.Inner in=obj.new Inner();  
		in.hello();  
	}
}
package innerClass;

public class innerClassAssisted2 {
	

		private String msg="Inner Classes";

		 void display(){  
			 class Inner{  
				 void msg(){
					 System.out.println(msg);
				 }  
		  }  
		  
		  Inner l=new Inner();  
		  l.msg();  
		 }  

		 
		public static void main(String[] args) {
			innerClassAssisted2  ob=new innerClassAssisted2 ();  
			ob.display();  
			}
		}


abstract class AnonymousInnerClass {
	   public abstract void display();
	}
package innerClass;

public class innerClassAssisted3 {
	public static void main(String[] args) {
	AnonymousInnerClass i = new AnonymousInnerClass() {

	         public void display() {
	            System.out.println("Anonymous Inner Class");
	         }
	      };
	      i.display();
	   }
	}
