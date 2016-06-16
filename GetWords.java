import java.awt.*;
import java.io.*;
import java.util.*; 

public class GetWords extends BinarySearchTree
{
    public static void main(String args[])/*throws IOException*/
    {
        try
        {
			
			BinarySearchTree b = new BinarySearchTree();
		/*b.insert("e");b.insert("B");
		b.insert("i");b.insert("D");b.insert("a");b.insert("f");b.insert("h");b.insert("g");
		b.insert("j");b.insert("k");b.insert("n");b.insert("c");
		System.out.println("Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		System.out.println("Check whether Node with value ABC exists : " + b.find("ABC"));
		System.out.println("try to delete node that not exist : " + b.delete("Abc"));		
		b.display(root);
		System.out.println("\n Delete Node  AB: " + b.delete("AB"));		
		b.display(root);
		System.out.println("\n Delete Node A : " + b.delete("A"));		
		b.display(root);*/
        	      
            FileReader reader = new FileReader("input.txt");
			FileWriter writer = new FileWriter("output.txt");
          
            BufferedReader bufferedReader = new BufferedReader(reader);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
 			
			String str = null;
		
            while( (str=bufferedReader.readLine()) != null )
            {
            
				// create reference varaible from StringTokenizer class	
				StringTokenizer s;
				
				
 				s=new StringTokenizer(str," ");

 			
				while (s.hasMoreTokens()) 
				{	
			
					String strdata=s.nextToken();
					String[] all;
					all = strdata .split("-");
					b.insert(all[0],all[1]);
					
				}				
				//bufferedWriter.write("\n");			
            }
			
			System.out.println("Original Tree : ");
			b.display(b.root);		
			System.out.println("");
			System.out.println("\n Check whether Node with value ABC exists : " + b.find("ABC"));
			System.out.println("\n try to delete node that not exist : " + b.delete("Ameliorae"));		
			b.display(root);
			System.out.println("");
			System.out.println("\n Delete Node  Delightful " + b.delete("Delightful"));		
			b.display(root);
			System.out.println("");
			System.out.println("\n Delete Node Typical : " + b.delete("Typical"));		
			b.display(root);
			
			
			
           bufferedReader.close();
		   bufferedWriter.flush();
		   bufferedWriter.close();
           reader.close();
	       writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


    }//main
}//class
