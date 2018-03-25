package algorithm;

import java.util.Comparator;

class Testprogram {
	public static void main(String[] args) {
		String[] arr= {"ZEBRA","alligator","crocodile"};
		System.out.println(findmax(arr,new CaseInsensitiveCompare()));
		}
}


public static <AnyType> AnyType findmax(AnyType [] arr,Comparator<? super AnyType> cmp)
{
	int maxIndex=0;
	for(int i=1;i<arr.length;i++)
		if(cmp.compare(arr[i], arr[maxIndex])>0)
			maxIndex=i;
	return arr[maxIndex];
}


class CaseInsensitiveCompare implements Comparator<String>
{

	@Override
	public int compare(String lhs, String rhs) {
		
		return lhs.compareToIgnoreCase(rhs);
	}
	
}


