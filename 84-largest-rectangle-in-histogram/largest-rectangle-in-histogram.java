class Pair {
    int first;
    int second;

    // Constructor to initialize the pair
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

   
}
class Solution {
    
    public int largestRectangleArea(int[] heights) {
        
        Stack<Pair> stack = new Stack<Pair>();
        int maxHeight = 0;
        
        for(int i = 0 ; i<heights.length ; i++){
            if(i == 0 ){
                stack.push(new Pair(heights[i],0));
            }
            else{
                
                if(heights[i]<stack.peek().first && !stack.isEmpty()){
                    int startPoint = i;
                    
                    while(!stack.isEmpty() && stack.peek().first >= heights[i] ){
                        int currHeight = (i-stack.peek().second)*stack.peek().first ;
                    if(currHeight > maxHeight)
                    {
                        maxHeight = currHeight;
                    }

                        Pair a = stack.pop();
                    startPoint = a.second;

                    }
                    stack.push(new Pair(heights[i],startPoint));
                    
                }
                else{
                   
                    if(stack.peek().first == heights[i]){
                        continue;
                    }
                    else{
                        stack.push(new Pair(heights[i],i));
                    }

                }
                
            }
           

           


        }
        int curr = heights.length - 1; 
      

        while(!stack.isEmpty()){
             System.out.println(stack.peek().first+" " + stack.peek().second);
              int currHeight = stack.peek().first * (curr-stack.peek().second+1);
              if(currHeight>maxHeight){
                maxHeight = currHeight;
              }
              stack.pop();


        }
        return maxHeight;


        
    }
}
