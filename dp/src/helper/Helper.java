package helper;

import java.util.List;

public class Helper {
    public static void print2DArr(int[][] arr) {
        for (int[] vs: arr) {
            for (int v: vs) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static void print2DArr(List<List<Integer>> arr) {
        for (List<Integer> v: arr) {
            System.out.println(v);
        }
    }

    public static void print2DArr(String[][] arr) {
        for (String[] vs: arr) {
            for (String v: vs) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static int binarySearchFirst(int[] arr, int start, int end, int target) {
        int left = start;
        int right = end;
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        if (res != - 1) {
            return res;
        }
        return left;
    }

    public static int binarySearchLast(int[] arr, int start, int end, int target) {
        int left = start;
        int right = end;
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }
        if (res != -1) {
            return res;
        }
        return left;
    }
}
