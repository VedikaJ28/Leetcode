class Solution {
    public int trap(int[] height) {
        // int[] prefix=new int[height.length];
        // int[] suffix=new int[height.length];
        int count=0;
        // prefix[0]=height[0];
        // suffix[height.length-1]=height[height.length-1];

        // for(int i=1;i<height.length-1;i++){
        //     prefix[i]=Math.max(prefix[i-1],height[i]);
        // }

        // for(int i=height.length-2;i>=0;i--){
        //     suffix[i]=Math.max(suffix[i+1],height[i]);
        // }

        // for(int i=1;i<height.length-1;i++){
        //     count+=Math.min(prefix[i],suffix[i])- height[i];
        // }
        int lmax=0; int rmax=0; int l=0; int r=height.length-1;
        while(l<r){
            if(height[l]<=height[r]){
                if(lmax>height[l]) count+=lmax-height[l];
                else lmax=height[l];
                l++;
            }
            else{
                if(rmax>height[r]) count+=rmax-height[r];
                else rmax=height[r];
                r--;
            }
        }
        return count;
    }
}