package facelay.controller;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * @author facelay
 * @date 2018年7月16日 下午5:49:36
 */
public class leetcode_303_2 {
    /**
     * sum[i]存储前i个元素的和,sum[0]=0;
     * <p>
     * sum[i]存储nums[0...i-1]的和。
     */
    private int[] sum;
    private int[] data;

    /**
     * 给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。
     * <p>
     * 示例：
     * <p>
     * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
     * <p>
     * sumRange(0, 2) -> 1
     * <p>
     * sumRange(2, 5) -> -1
     * <p>
     * sumRange(0, 5) -> -3
     * <p>
     * 说明:
     * <p>
     * 1、你可以假设数组不可变。
     * <p>
     * 2、会多次调用 sumRange 方法。
     *
     * @param nums
     * @return
     */
    public leetcode_303_2(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        sum = new int[nums.length + 1]; // 此处因为sum[0]=0，所以会有一个偏移量
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    //这种update操作为  O(n)  级别的，速度不行
    public void update(int index, int val) {
        data[index] = val;
        for (int i = index + 1; i < data.length; i++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        leetcode_303_2 leetcode_303_2 = new leetcode_303_2(nums);
        int range = leetcode_303_2.sumRange(0, 2);
        System.out.println("返回结果：" + range);
        leetcode_303_2.update(1, 10);
        int range2 = leetcode_303_2.sumRange(0, 2);
        System.out.println("修改后的返回结果：" + range2);
    }

}
