
public class searchAlgo {
	public static boolean binarySearch(int [] x, int num) {	
		int i=0;
		int j = x.length-1;
		int middle = ((j+1)-i)/2;
		while(i<=j) {
		if (num == x[middle]) {
			return true;
			}
		else if (i==j) {
			return false;
		}
		else if (num > x[middle]) {
			i = middle +1;
		    middle = i + (((j+1)-i)/2);
		}
		else if ( num < x [middle]) {		
			j = middle-1;
			middle = i + (((j+1)-i)/2);
		}		
		}
		return false;
	}
public static void main (String [] args) {
	int [] x = new int [] {2,3,4,6,9,10,11,14,17,20,22};
	System.out.println(binarySearch(x,12));
}
}
