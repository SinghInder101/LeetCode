class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        return bs(arr,0,arr.length-1);
        
        
    }
    
    public int bs(int[] arr,int i,int j){
        if(i<=j){
        int mid = (i+j)/2;
            if(i == j){
                
                return i;
            }
        if(mid-1 < 0 || mid+1 >=arr.length){
            if(mid-1 < 0){
                if(arr[mid]<arr[mid+1]){
                    return bs(arr,mid+1,j);
                    
                }
                else{
                    if( mid+1 >=arr.length){
                        return bs(arr,i,j-1);
                    }
                    
                }
            }
        }
        if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
            
            return mid;

        }
        if(arr[mid] < arr[mid+1] && arr[mid] > arr[mid -1]){
           return bs(arr,mid+1,j);
            
        }
         if(arr[mid] > arr[mid+1] && arr[mid] < arr[mid -1]){
             
            return bs(arr,i,mid-1);
    
            
        }
        }
        return -1;
        
        
        
        
        
        
    }
}