class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

ArrayList<Integer> list = new ArrayList<Integer>();
int oneIndex = 0;
int secondIndex =0;


        for(int i = 0 ; i < m+n ;i++){
            if(oneIndex<m && secondIndex<n){
                if(nums1[oneIndex] <= nums2[secondIndex]){
                    list.add(nums1[oneIndex]);
                    oneIndex++;
                    continue;
                }
                else if(nums1[oneIndex] > nums2[secondIndex]){
                    list.add(nums2[secondIndex]);
                    secondIndex++;
                    continue;

                }   

            }
            if(oneIndex == m && secondIndex < n){
                 list.add(nums2[secondIndex]);
                    secondIndex++;
                    continue;


            }
            else if(secondIndex == n && oneIndex < m){
                list.add(nums1[oneIndex]);
                    oneIndex++;
                    continue;

            }
            

        }

         for (int i = 0; i < m + n; i++) {
            nums1[i] = list.get(i);
        }
        
        

}
}