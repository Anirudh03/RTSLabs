import java.util.*;

public class solution {

	public static String stringRotation(String s,int val)
	{
		// handling Edgeases
		if(s==null || s.trim().length()==0)
			return null;
		if(val<0)
			throw new IllegalArgumentException();

		val=val%s.length();

		s=s.substring(s.length()-val,s.length())+s.substring(0,s.length()-val);
		return s;
	}
	public static HashMap<String,Integer> aboveBelow(List<Integer> list,int target)
	{
		HashMap<String,Integer> map=new HashMap();
		map.put("above",0);
		map.put("below", 0);
		// handling Edgecases
		if(list==null || list.size()==0)
		{
			return map;
		}
		int count=0;
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i)>target)
			{
				count=map.get("above");
				map.put("above",count+1);
			}
			if(list.get(i)<target)
			{
				count=map.get("below");
				map.put("below",count+1);
			}

		}
		return map;
	}
	public static void main(String[]args)
	{

		//added try catch block to handle when the input
		// is given other than integer values.
		try
		{
			List<Integer> list = new ArrayList();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter an Integer target value ");
			int target=scanner.nextInt();

			System.out.println("Please Enter list of integers");

			while (scanner.hasNextInt()) {
				int i = scanner.nextInt();
				list.add(i);
			}

			HashMap<String,Integer> myMap=new HashMap();
			myMap=aboveBelow(list,target);
			System.out.println("The above and below values are "+myMap);
		}
		catch (Exception e)
		{
			System.out.println("Illegal values passed");
		}
		//rotateString
		//added try catch block to handle when the input
		// is given as other than string
		try
		{

			Scanner sc=new Scanner(System.in);
			System.out.println("Please Enter the string");
			String inputString=sc.nextLine();
			System.out.println("Rotate the String by: ");
			int value=sc.nextInt();

			String str=stringRotation(inputString,value);
			System.out.println("Rotated string is "+str);
		}
		catch(Exception e)
		{
			System.out.println("Illegal Arguments passed");
		}
	}
}
