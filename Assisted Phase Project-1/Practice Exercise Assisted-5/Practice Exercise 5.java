Practice Exercise 5:
5. Writing a program in Java to verify implementations of collections:
 package collections;


		import java.util.*;

		public class collectionAssisted {

			public static void main(String[] args) {
				//creating arraylist
				System.out.println("ArrayList");
				ArrayList<String> city=new ArrayList<String>();   
			      city.add("Bangalore");//
			      city.add("Chennai");    	   
			      System.out.println(city);  
				
				//creating vector
			      System.out.println("\n");
			      System.out.println("Vector");
			      Vector<Integer> vec = new Vector();
			      vec.addElement(21); 
			      vec.addElement(13); 
			      System.out.println(vec);
				
				//creating linkedlist
			      System.out.println("\n");
			      System.out.println("LinkedList");
			      LinkedList<String> names=new LinkedList<String>();  
			      names.add("Loki");  
			      names.add("Ram");  	      
			      Iterator<String> itr=names.iterator();  
			      while(itr.hasNext()){  
			       System.out.println(itr.next());  
			       
			       //creating hashset
			       System.out.println("\n");
			       System.out.println("HashSet");
			       HashSet<Integer> set=new HashSet<Integer>();  
			       set.add(101);  
			       set.add(103);  
			       set.add(102);
			       set.add(104);
			       System.out.println(set);
			       
			       //creating linkedhashset
			       System.out.println("\n");
			       System.out.println("LinkedHashSet");
			       LinkedHashSet<Integer> set2=new LinkedHashSet<Integer>();  
			       set2.add(11);  
			       set2.add(13);  
			       set2.add(12);
			       set2.add(14);	       
			       System.out.println(set2);
			      	} 
			      }  
			

		// TODO Auto-generated method stub

	}
