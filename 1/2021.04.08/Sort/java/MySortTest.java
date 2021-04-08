package sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class MySortTest {

    private static final int LENGTH = 20000;
    private static final int BOUND = 10000000;
    private static final int TIMES = 10;


    @Test
    public void testBubbleSort() {
        int[] array = generateRandomArray();
        int[] array2 = Arrays.copyOf(array, array.length);
        Arrays.sort(array);
        MySort0408.bubbleSort(array2);
        Assert.assertArrayEquals(array, array2);
    }

    @Test
    public void testInsertSort() {
        int[] array = generateRandomArray();
        int[] array2 = Arrays.copyOf(array, array.length);
        Arrays.sort(array);
        MySort0408.insertSort(array2);
        Assert.assertArrayEquals(array, array2);
    }

    @Test
    public void testSelectionSort() {
        int[] array = generateRandomArray();
        int[] array2 = Arrays.copyOf(array, array.length);
        Arrays.sort(array);
        MySort0408.selectionSort(array2);
        Assert.assertArrayEquals(array, array2);
    }

    @Test
    public void testMergeSort() {
        int[] array = generateRandomArray();
        int[] array2 = Arrays.copyOf(array, array.length);
        Arrays.sort(array);
        array2 = MySort0408.mergeSort(array2);
        Assert.assertArrayEquals(array, array2);
    }

    @Test
    public void testQuickSort() {
        int[] array = generateRandomArray();
        int[] array2 = Arrays.copyOf(array, array.length);
        Arrays.sort(array);
        MySort0408.quickSort(array2);
        Assert.assertArrayEquals(array, array2);
    }

    @Test
    public void testBubblePerformance() {
        for (int i = 0; i < TIMES; i++) {
            int[] array = generateRandomArray();
            MySort0408.bubbleSort(array);
        }
    }

    @Test
    public void testMergePerformance() {
        for (int i = 0; i < TIMES; i++) {
            int[] array = generateRandomArray();
            MySort0408.mergeSort(array);
        }
    }

    @Test
    public void testQuickPerformance() {
        for (int i = 0; i < TIMES; i++) {
            int[] array = generateRandomArray();
            MySort0408.quickSort(array);
        }
    }

    @Test
    public void testSelectionPerformance() {
        for (int i = 0; i < TIMES; i++) {
            int[] array = generateRandomArray();
            MySort0408.selectionSort(array);
        }
    }

    @Test
    public void testInsertPerformance() {
        for (int i = 0; i < TIMES; i++) {
            int[] array = generateRandomArray();
            MySort0408.insertSort(array);
        }
    }

    private static int[] generateRandomArray() {
        int[] res = new int[LENGTH];
        Random random = new Random();
        for (int i = 0; i < res.length; i++) {
            res[i] = random.nextInt(BOUND);
        }
        return res;
    }
}

