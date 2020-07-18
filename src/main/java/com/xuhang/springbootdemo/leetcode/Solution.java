package com.xuhang.springbootdemo.leetcode;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * @author xuhang
 * @date 2019/10/15 17:05
 */
public class Solution {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if (nums==null || nums.length<2){
            return res;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target-nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }

            map.put(nums[i], i);
        }

        return res;
    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * @param x
     * @return
     */
    public int reverse(int x) {
//        String y = String.valueOf(x);
//        String str ;
//        if (y.length()==1){
//            return x;
//        }
//        StringBuffer sb = new StringBuffer();
//        for (int i = y.length() -1; i >= 0; i--) {
//            sb.append(y.charAt(i));
//        }
//        str = sb.toString();
//
//        if(y.indexOf("-")==0){
//            str = str.substring(0, sb.toString().length() - 1);
//        }
//        if (Long.parseLong(str)>Integer.MAX_VALUE|| Long.parseLong(str)<Integer.MIN_VALUE){
//            return 0;
//        }
//        if(y.indexOf("-")==0){
//            return 0-Integer.parseInt(str);
//        }
//
//
//        return Integer.parseInt(str);

        long res =0;

        while (x!=0){
            res = res *10 + x%10;
            x /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }

        }
            return (int) res;
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {

        if (x<0 || x !=0 && x%10 ==0  ){
            return false;
        }
        int param = x ;
        int rever = 0;
        while (x > 0) {
            rever = rever * 10 + x %10;
            x /= 10;
        }

        return param == rever;


    }
//    public int romanToInt(String s) {
//
//    }

    public static void main(String[] args) {
//        int[] nums = {2,7,15,11};
//        int target = 9;
//
//        int[] ints = new Solution().twoSum(nums, target);
//
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }

        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusDays(-1);
        System.out.println(localDate.toString());

        System.out.println(new Solution().isPalindrome(1221));


    }
}
