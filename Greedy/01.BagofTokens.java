class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if(tokens.length == 0) return 0;
        
        Arrays.sort(tokens);
        int low = 0;
        int score = 0;
        int high = tokens.length - 1;
        while(low < high) {
            if(power >= tokens[low]) {
                power -= tokens[low];
                low++;
                score++;
            } else if(score > 0) {
                power += tokens[high];
                high--;
                score--;
            } else {
                return score;
            }
        }
        if(tokens[low] <= power) score++;
        return score;
    }
}