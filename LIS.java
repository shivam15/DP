

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        int[] lis = new int[A.size()];
        for(int i=0;i<A.size();i++)
            lis[i] = 1;
        
        for(int i=1;i<A.size();i++){
            for(int j=0;j<i;j++){
                if(A.get(i)>A.get(j) && lis[i] < lis[j] +1)
                    lis[i] = lis[j] +1; 
            }
        }
        int max = 0;
        for(int i=0;i<A.size();i++)
            if(max<lis[i])
                max = lis[i];
                
        return max;
    }
}
