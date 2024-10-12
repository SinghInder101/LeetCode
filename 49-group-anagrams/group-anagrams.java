class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String> >map = new HashMap<String,List<String>>();

        for(String s:strs){
              String sortedStr = s.chars()
                              .sorted()
                              .mapToObj(c -> String.valueOf((char) c))
                              .collect(Collectors.joining());

                              if(map.containsKey(sortedStr)){
                                List<String> ans = map.get(sortedStr);
                                ans.add(s);
                                map.put(sortedStr,ans);
                              }
                              else{
                                List<String> list = new ArrayList<>();
                                list.add(s);
                                 map.put(sortedStr, list);
                              }



        }
 List<List<String>> result = new ArrayList<>(map.values());
 return result;



        


    }
}
