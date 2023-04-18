public class GenericSort <T extends Comparable<? super T>> {

    public <T> void sort(T[] array) 
	{
		for (int i = 1; i < array.length; i++) 
		{
			int j = i;
			
			while (j > 0 && ((Comparable<? super T>) array[j - 1]).compareTo(array[j]) > 0) 
			{
				T value = array[j];
				array[j] = array[j - 1];
				array[j - 1] = value;
				j--;
			}
		}
	}

    public <T> void printArray(T[] array)
    {
        for(T element:array)
            System.out.print(element+" ");
        System.out.println("");
    }
       
    public static void main(String[] args) {
     
    Integer[] intArray={2,17,8,19,0};
    Character[] charArray= {'f','q','a','c'};
    String[] stringArray={"aa","ff","dd","bb"};
 
    System.out.println("Sorting integer array");
    GenericSort<Integer> intSort= new GenericSort<>();
    intSort.sort(intArray);
    intSort.printArray(intArray);

    System.out.println("Sorting character array");
    GenericSort<Character> charSort= new GenericSort<>();
    charSort.sort(charArray);
    charSort.printArray(charArray);

    System.out.println("Sorting String array");
    GenericSort<String> stringSort= new GenericSort<>();
    stringSort.sort(stringArray);
    stringSort.printArray(stringArray);
    }
}
