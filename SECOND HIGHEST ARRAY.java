public class SecondhighestArray {
	
		 
		public static void main(String[] args) {
	 
			int arr[] = { 14, 46, 47, 86, 92, 52, 48, 36, 66, 85 };
			int highest = arr[0];
			int secondhighest = arr[0];
			
			System.out.println("The given array is:" );
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+"\t");
			}
			for (int i = 0; i < arr.length; i++) {
	 
				if (arr[i] > highest) {
					secondhighest = highest;
					highest = arr[i];
	 
				} else if (arr[i] > secondhighest) {
					secondhighest = arr[i];
	 
				}
			}
	 
			System.out.println("\nSecond highest number is:" + secondhighest);
	 
		}
	
}
