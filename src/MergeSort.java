public class MergeSort {

    public int[] sort(int[] nums) {
        int step = 1;
        int[] arr1 = nums;
        int[] arr2 = new int[nums.length];
        while (step < nums.length) {
            for (int i = 0; i < arr1.length; i = i + step * 2) {
                int[] temp1;
                int[] temp2;
                if (i + step > arr1.length) {
                    temp1 = new int[arr1.length -i];
                } else {
                    temp1 = new int[step];
                }
                if (temp1.length < step) {
                    temp2 = new int[0];
                } else if (i + step*2 > arr1.length) {
                    temp2 = new int[arr1.length - step -i];
                } else {
                    temp2 = new int[step];
                }
                for (int j = 0; j < step; j++) {
                    if (i + j < arr1.length) {
                        temp1[j] = arr1[i + j];
                    }
                    if (i + j + step < arr1.length) {
                        temp2[j] = arr1[i + j + step];
                    }
                }
                int[] temp3 = change(temp1, temp2, step);
                for (int j = 0; j < temp3.length; j++) {
                    if (j + i < arr1.length) {
                        arr2[j + i] = temp3[j];
                    }
                }

            }
            step = step*2;
            arr1 = arr2;
            arr2 = new int[nums.length];
        }
        return arr1;
    }

    private int[] change(int[] arr1, int[] arr2, int step) {
        int[] res = new int[arr1.length + arr2.length];
        int ind1 = 0;
        int ind2 = 0;
        for (int i  = 0; i < res.length; i++) {
            if (ind1 == arr1.length && arr2.length == 0) {
                return res;
            }
            if (ind1 == arr1.length) {
                res[i] = arr2[ind2];
                ind2++;
                continue;
            }
            if ((ind2 == arr2.length) || arr1[ind1] <= arr2[ind2]) {
                res[i] = arr1[ind1];
                ind1++;
            } else if ( (arr1[ind1] > arr2[ind2])) {
                res[i] = arr2[ind2];
                ind2++;
            }
        }
        return res;
    }
}
