package com.treeyh.example.arithmetic.sort;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @description: 归并排序 http://www.xuetangx.com/courses/course-v1:TsinghuaX+30240184X+sp/courseware/706d387daf2d4495aeb7fea3246a82ce/2c649da951724376bc495067fafd21cb/
 * @author: Tree
 * @email: tree@ejyi.com
 * @create 2020-07-30 11:06
 */
public class MergeSort {




    private static int[] nums = {76, 9, 83, 22, 54, 10, 36, 77, 47, 29};



    public static int[] sort(int[] nums, int l, int r) {
        if (l >= r) {
            return nums;
        }


        int mi = (l + r) >> 1;
        sort(nums, l, mi);
        sort(nums, mi+1, r);
        merge(nums, l, mi, r);

        return nums;
    }


    public static void merge(int[] num, int l, int mi, int r) {

        List<Integer>  ls = new ArrayList<Integer>(mi-l+1);
        List<Integer>  rs = new ArrayList<Integer>(r-mi);

        for (int i=l; i<=mi; i++){
            ls.add(num[i]);
        }

        for (int i=mi+1; i<=r; i++){
            rs.add(num[i]);
        }

        int i = l, j = 0, k = 0;
        for (; j < ls.size() || k < rs.size(); ) {
            if (j < ls.size() && (k >= rs.size() || ls.get(j) <= rs.get(k))){
                num[i++] = ls.get(j++);
            }
            if (k < rs.size() && (j >= ls.size() || ls.get(j) >= rs.get(k))) {
                num[i++] = rs.get(k++);
            }
        }

    }


    private static  int[] sort2(int[] nums, int l, int r) {

        if (l >= r) {
            return nums;
        }

        int mi = (l + r) >> 1;
        sort2(nums, l, mi);
        sort2(nums, mi +1, r);
        merge2(nums, l, mi, r);

        return nums;
    }

    private static void  merge2(int[] nums, int l, int mi, int r) {

        int[] lefts = new int[mi - l + 1];
        int[] rights = new int[r - mi];

        for(int i = l; i<=mi; i++){
            lefts[i - l] = nums[i];
        }
        for(int i = mi+1; i<=r; i++){
            rights[i - (mi + 1)] = nums[i];
        }

        int i = 0, j=0 , k=l;

        for(;i<lefts.length || j<rights.length;) {
            if(i<lefts.length && (j>=rights.length || lefts[i] <= rights[j])) {
                nums[k++] = lefts[i++];
            }
            if(j<rights.length && (i>=lefts.length || lefts[i] >= rights[j]) ) {
                nums[k++] = rights[j++];
            }
        }
    }

    public static void main(String[] args) throws JsonProcessingException {

        int[] result = sort2(nums, 0, nums.length - 1);

        ObjectMapper om = new ObjectMapper();
        System.out.println(om.writeValueAsString(result));


    }


}
