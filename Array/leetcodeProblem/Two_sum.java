package Array.leetcodeProblem;

public class Two_sum {
    public static int[] Two_Sum(int[] nums , int target){
        int n =nums.length;
        int sum =0;
        for(int i =0;i<n;i++){
            for(int j=i+1;j<n;j++){
                sum =nums[i] + nums[j];
                if(sum ==target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args){
        int[] nums = {2,4,7,5,8};
        int target =9;
        int[] result =Two_Sum(nums,target);
        System.out.println("[" +result[0] + "," +result[1] +"]");
    }
}
