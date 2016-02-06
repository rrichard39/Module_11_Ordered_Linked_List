
public class Main 
{

	public Main() 
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) 
	{
		Integer i;
		boolean result;
		OrderedLinkedList newList = new OrderedLinkedList(); 
		System.out.println("Initial empty Linked List:");
		System.out.print(newList.toString());
		System.out.println("    Size: " + newList.size());
		i = 7;
		result = newList.remove(i);
		System.out.println("Remove " + i + ": " + result);
		System.out.print(newList.toString());
		System.out.println("    Size: " + newList.size());
		i = 1;
		newList.add(i);
		i = 2;
		newList.add(i);
		i = 3;
		newList.add(i);
		i = 5;
		newList.add(i);
		i = 6;
		newList.add(i);
		System.out.println("Initial loaded Linked List:");
		System.out.print(newList.toString());
		System.out.println("    Size: " + newList.size());

		i = 4;
		result = newList.add(i);
		System.out.println("Add " + i + ": " + result);
		System.out.print(newList.toString());
		System.out.println("    Size: " + newList.size());

		i = 3;
		result = newList.remove(i);
		System.out.println("Remove " + i + ": " + result);
		System.out.print(newList.toString());
		System.out.println("    Size: " + newList.size());

		i = 9;
		result = newList.remove(i);
		System.out.println("Remove " + i + ": " + result);
		System.out.print(newList.toString());
		System.out.println("    Size: " + newList.size());

		i = 0;
		result = newList.add(i);
		System.out.println("Add " + i + ": " + result);
		System.out.print(newList.toString());
		System.out.println("    Size: " + newList.size());

		i = -1;
		result = newList.add(i);
		System.out.println("Add " + i + ": " + result);
		System.out.print(newList.toString());
		System.out.println("    Size: " + newList.size());
		
		i = -1;
		result = newList.remove(i);
		System.out.println("Remove " + i + ": " + result);
		System.out.print(newList.toString());
		System.out.println("    Size: " + newList.size());

		i = 6;
		result = newList.remove(i);	
		System.out.println("Remove " + i + ": " + result);
		System.out.print(newList.toString());
		System.out.println("    Size: " + newList.size());
	}
}
