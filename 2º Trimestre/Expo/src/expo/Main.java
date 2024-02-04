package expo;

import java.util.Arrays;

public class Main {
  
  public class ArrayRemovalExample {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] positionsToRemove = {9, 8, 7};
  
    for (int i = 0; i < positionsToRemove.length; i++) {
      int indexToRemove = positionsToRemove[i];
      for (int j = indexToRemove; j < arr.length - 1; j++) {
        arr[j] = arr[j + 1];
      }
    }
  
    int newLength = arr.length - positionsToRemove.length;
    arr = Arrays.copyOf(arr, newLength);
  
    System.out.println("Array después de la eliminación: " + Arrays.toString(arr));
  }
}
}
