class Solution {
    public boolean isAnagram(String s, String t) {
        // Idea - 1 , sort both the strings and compare
        // Idea - 2, Put one string in HashMap and iterate over the second string
        // subtracting each value from HashMap as it comes,
        // If all the values in the hashmap are zero, it was an anagram
        // Idea - 3 put both in hashmap and use map1.equals(map2) ->

        if (s.length() != t.length()) {
            return false;

        }
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
           map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i), 0) + 1);
           map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i), 0) + 1);

        }
        System.out.println(map1);
        System.out.println(map2);
        
        if(map1.equals(map2)){
            return true;
        }
        return false;

    }
}