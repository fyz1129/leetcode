package jianzhioffer.jianzhioffer45;

/**
 * 快速排序
 * @author Dell
 */
public class JianZhiOffer45 {
    public static void main(String[] args) {
        int[] nums = {5,1,2,3,7,8,2};
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public static void quickSort(int[] nums, int slow, int high) {
        if(slow < high){
            int meddle = getMeddle(nums, slow, high);
            quickSort(nums, slow, meddle - 1);
            quickSort(nums, meddle + 1, high);
        }
    }

    private static int getMeddle(int[] nums, int slow, int high) {
        //将temp最为旗帜，基准位
        int temp = nums[slow];
        while(slow < high){
            while (slow < high && nums[high] >= temp){
                high--;
            }
            //System.out.println(nums[high]);
            nums[slow] = nums[high];
            while (slow < high && nums[slow] <= temp){
                slow++;
            }
            nums[high] = nums[slow];
        }
        nums[slow] = temp;
        return slow;
    }
}


