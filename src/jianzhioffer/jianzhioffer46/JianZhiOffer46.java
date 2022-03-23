package jianzhioffer.jianzhioffer46;

import java.io.Serializable;

/**
 * @author Dell
 */
public class JianZhiOffer46{

    //private static final long serialVersionUID = 7435413383365002397L;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(12258));
        System.out.println("a".charAt(0));
    }
}

class Solution {
    int count;
    public int translateNum(int num) {
        String[] array = String.valueOf(num).split("");
        count = 0;
        backtracking(array, 0, 1);
        return count;
    }

    public void backtracking(String[] array, int startIndex, int endIndex){
        if(endIndex == array.length){
            count++;
            return;
        }

        for(int i = startIndex; i < array.length; i++){
            if(!join(array, startIndex, endIndex)){
                startIndex++;
            }
            backtracking(array, startIndex, endIndex + 1);
            if(!join(array, startIndex, endIndex)){
                startIndex--;
            }
        }
    }

    public boolean join(String[] array, int startIndex, int endIndex){
        StringBuilder builder = new StringBuilder();
        for(int i = startIndex; i < endIndex; i++){
            builder.append(array[i]);
        }

        return Integer.valueOf(builder.toString()) < 26;
    }
}
