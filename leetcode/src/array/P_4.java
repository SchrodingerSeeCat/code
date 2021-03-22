package array;

import java.util.Arrays;

public class P_4 {
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 3};
        int[] num2 = new int[]{2, 4};
        P_4 p = new P_4();
        System.out.println(p.findMedianSortedArrays3(num1, num2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int d1 = nums1.length - 1, d2 = nums2.length - 1;

        if (d1 == 1 && d2 == 1) {
            if (nums1[0] >= nums2[0] && nums1[1] <= nums2[1]) {
                return (nums1[0] + nums1[1]) / 2.0;
            }
            if (nums2[0] >= nums1[0] && nums2[1] <= nums1[1]) {
                return (nums2[0] + nums2[1]) / 2.0;
            }
        }
        // 先考虑一个数组为空的情况
        if (nums1.length == 0) {
            if (nums2.length % 2 == 0) {
                return (nums2[d2 / 2] + nums2[d2 / 2 + 1]) / 2.0;
            }
            return nums2[d2 / 2];
        }

        if (nums2.length == 0) {
            if (nums1.length % 2 == 0) {
                return (nums1[d1 / 2] + nums1[d1 / 2 + 1]) / 2.0;
            }
            return nums1[d1 / 2];
        }
        int s1 = 0, s2 = 0;
        int m1 = 0, m2 = 0;
        while(s1 != d1 || s2 != d2) {
            m1 = (s1 + d1) >> 1;
            m2 = (s2 + d2) >> 1;
            if(nums1[m1] == nums2[m2] && m1 != m2) {
                return nums1[m1];
            }

            if (nums1[m1] < nums2[m2]) {
                // 舍弃num1中较小的一半
                if ((s1 + d1) % 2 != 0) {
                    s1 = m1 + 1;
                } else {
                    s1 = m1;
                }
                d2 = m2; // 舍弃num2中较大的一半
            } else {
                // 舍弃num2中较小的一半
                if ((s2 + d2) % 2 != 0) {
                    s2 = m2 + 1;
                } else {
                    s2 = m2;
                }
                d1 = m1; // 舍弃num1中较大的一半
            }
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (nums1[s1] + nums2[s2]) / 2.0;
        }
        return Math.min(nums1[s1], nums2[s2]);
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] result = null;
        int i = 0, j = 0, k = -1;
        int mid = ((nums1.length + nums2.length) >> 1) - 1;
        boolean isEven = false;
        if ((nums1.length + nums2.length) % 2 == 0) {
            isEven = true;
            result = new int[2];
        } else {
            result = new int[1];
        }

        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                if (k == mid) {
                    result[0] = nums1[i];
                    if (!isEven) return result[0];
                }
                if (k == mid + 1) {
                    result[1] = nums1[i];
                    break;
                }
                i++;
                k++;
            } else {
                if (k == mid) {
                    result[0] = nums2[j];
                    if (!isEven) return result[0];
                }
                if (k == mid + 1) {
                    result[1] = nums2[j];
                    break;
                }
                j++;
                k++;
            }
        }

        while(i < nums1.length && k < mid + 1) {
            if (k == mid) {
                result[0] = nums1[i];
                if (!isEven) return result[0];
            }
            if (k == mid + 1) {
                result[1] = nums1[i];
                break;
            }
            i++;
            k++;
        }

        while (j < nums2.length && k < mid + 1) {
            if (k == mid) {
                result[0] = nums2[j];
                if (!isEven) return result[0];
            }
            if (k == mid + 1) {
                result[1] = nums2[j];
                break;
            }
            j++;
            k++;
        }
        return (result[0] + result[1]) / 2.0;
    }

    public double findMedianSortedArrays3(int[] nums1, int[] nums2){
        int i = 0, j = 0, k = 0;
        int[] arr = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            arr[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            arr[k++] = nums2[j++];
        }
        if (arr.length % 2 == 0) {
            return (arr[(arr.length - 1) / 2] + arr[((arr.length - 1) / 2) + 1]) / 2.0;
        }
        return arr[(arr.length - 1) / 2];
    }
}
