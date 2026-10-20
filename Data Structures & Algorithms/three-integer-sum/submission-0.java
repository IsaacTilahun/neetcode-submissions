class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        

        /**
        Two-pointer solution with a passing index for the third number.

        Time Complexity: O(n^2) - Pass the list for the third index, with a scan every time
        Space Complexity: O(n^2) - For each i (which there are n), you may have O(n) many pairs.
        */
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int left = i+1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                int lflag = 0;
                int rflag = 0;

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++; lflag = 1;
                    right--; rflag = 1;
                } else if (sum > 0) {
                    right--; rflag = 1;
                } else if (sum < 0) {
                    left++; lflag = 1;
                }


                if (lflag == 1) {
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }

                if (rflag == 1) {
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }


            }


        }

        return result;
    }
}
