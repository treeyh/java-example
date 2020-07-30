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

//    public static void merge(int[] ids, int l, int mi, int r){
//
//        List<Integer> tmpls =new ArrayList<Integer>(mi - l + 1);
//        //复制出左边一段
//        for(int i = l; i <= mi; i++){
//            tmpls.add(ids[i]);
//        }
//        List<Integer> tmprs =new ArrayList<Integer>(r - mi );
//        for(int i = mi+1; i <= r; i++){
//            tmprs.add(ids[i]);
//        }
//
//        for(int i = l, j = 0, k = 0; (j < tmpls.size()) || (k < tmprs.size()); ){
//            if(j < tmpls.size() && ((k >= tmprs.size()) || (tmpls.get(j) <= tmprs.get(k)))){
//                ids[i++] = tmpls.get(j++);
//            }
//            if(k< tmprs.size() && ((j >= tmpls.size() ) || (tmpls.get(j) > tmprs.get(k)))){
//                ids[i++] = tmprs.get(k++);
//            }
//        }
//    }


    public static void main(String[] args) throws JsonProcessingException {

        int[] result = sort(nums, 0, nums.length - 1);

        ObjectMapper om = new ObjectMapper();
        System.out.println(om.writeValueAsString(result));


    }


}
