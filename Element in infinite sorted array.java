public class Solution {

public static void main(String[] args) {
    // Assuming sorted array of infinite length
    int a[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

    int elementToFind = 12;

    int finalIndex = getFinalIndex(a, elementToFind);

    if (finalIndex == -1) {
        System.out.println("Element not found");
    }
    System.out.println("Found element:" + a[finalIndex]);

}

private static int getFinalIndex(int[] a, int elementToFind) {

    int power = 2;
    int finalIndex = (int) Math.pow(2, power);

    for (int i = 0; i < finalIndex;) {

        if (elementToFind == a[finalIndex]) {
            return finalIndex;
        }

        else if (elementToFind < a[finalIndex]) {
            System.out.println("search through binary search algo");
            // taking i as starting index in binary search call
            int searchedIndex = callToBinarySearch(a, i, finalIndex);
            return searchedIndex;
        }

        else {
            i = finalIndex + 1;
            power = power * 2;
            finalIndex = (int) Math.pow(2, power);

        }
    }
    return -1;
   }
}
