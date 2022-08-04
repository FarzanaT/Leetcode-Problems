import java.util.HashSet;

public class containsDuplicate {
	
	
public boolean containsDuplicate(int[] nums) {

        HashSet <Integer> hs = new HashSet<Integer>(); //-> time complexity winner
        for(int i : nums) {
        	hs.add(i);
        }
        
        if(hs.size() == nums.length) {
        	return false;
        }
        return true; 
        
        /* -> SPACE COMPLEXITY WINNER
         *Arrays.sort(nums);
        for(int i = 0; i<nums.length-1; i++){
        if(nums[i] == nums[i+1]){
            return true;
        }
            }
        return false; 
         * 
         */
    }
}
