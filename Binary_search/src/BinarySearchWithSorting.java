import java.util.Arrays;

public class BinarySearchWithSorting {
    public static void main(String[] args) {
        int[] array = {19, 5, 1, 15, 7, 11, 13, 3, 9, 17};

        // Проверка и сортировка массива, если необходимо
        if (!isSorted(array)) {
            System.out.println("Массив не отсортирован. Сортировка...");

            // Сортировка массива (можно использовать любой алгоритм сортировки)
            Arrays.sort(array);

            System.out.println("Массив отсортирован.");
        }

        int target = 11;
        int result = binarySearchIterative(array, target);

        if (result != -1) {
            System.out.println("Искомый элемент " + target + " находится на позиции " + result);
        } else {
            System.out.println("Искомый элемент " + target + " не найден.");
        }
    }

    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false; // Массив не отсортирован
            }
        }
        return true; // Массив отсортирован
    }

    public static int binarySearchIterative(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Искомый элемент найден
            } else if (array[mid] < target) {
                left = mid + 1; // Искать в правой половине
            } else {
                right = mid - 1; // Искать в левой половине
            }
        }
        return -1; // Элемент не найден
    }
}