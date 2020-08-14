package com.treeyh.example.arithmetic.sort;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @version 1.0.0
 * @description: 快速排序 http://www.xuetangx.com/courses/course-v1:TsinghuaX+30240184X+sp/courseware/c15aad6e2dac4250934ea61d71deafd9/7d5cdb2eee004579ac0a20be2678495b/
 * @author: Tree
 * @create 2020-07-30 10:12
 */
public class FastSort {

    private static int[] nums = {76, 9, 83, 22, 54, 10, 36, 77, 47, 29};



    public static int[] sort(int[] nums, int l, int r) {
        if (l >= r) {
            return nums;
        }

        int i = l;
        int j = r;
        int x = nums[i];

        while (i < j) {
            for(; i < j; j--) {
                if (nums[j] < x) {
                    nums[i] = nums[j];
                    i++;
                    break;
                }
            }

            for(; i<j; i++){

                if (nums[i] > x) {
                    nums[j] = nums[i];
                    j--;
                    break;
                }
            }

        }
        nums[i] = x;
        sort(nums, l, i - 1);
        sort(nums, i+1, j);
        return nums;
    }



    public static int[] sort2(int[] nums, int l, int r) {
        if (l >= r) {
            return nums;
        }

        int i = l, j = r;
        int x = nums[l];

        while (i < j) {
            for(; i< j; j--){
                if(nums[j] < x) {
                    nums[i] = nums[j];
                    i++;
                    break;
                }
            }

            for(; i<j; i++) {
                if(nums[i] > x) {
                    nums[j] = nums[i];
                    j--;
                    break;
                }
            }
        }

        nums[i] = x;
        sort2(nums, l, i-1);
        sort2(nums,i+1, r);
        return nums;
    }


    public static int[] sort3(int[] nums, int l, int r) {
        if (l >= r) {
            return nums;
        }

        int i = l, j = r;
        int x = nums[l];

        while (i < j) {

            for(; i < j; j --) {
                if(x > nums[j]) {
                    nums[i++] = nums[j];
                    break;
                }
            }

            for(; i< j; i++) {
                if(nums[i] > x) {
                    nums[j--] = nums[i];
                    break;
                }
            }

        }

        nums[i] = x;
        sort3(nums, l, i-1);
        sort3(nums, i+1, r);
        return nums;
    }


    public static void main(String[] args) throws JsonProcessingException {

        int[] result = sort3(nums, 0, nums.length - 1);

        ObjectMapper om = new ObjectMapper();
        System.out.println(om.writeValueAsString(result));


    }

}
