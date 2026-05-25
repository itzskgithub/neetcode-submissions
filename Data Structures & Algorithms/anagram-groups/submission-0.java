class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> mainList = new LinkedList<>();
        boolean[] visited = new boolean[strs.length];

        for(int i = 0; i < strs.length; i++){

            if(visited[i]) continue;
            List<String> list = new ArrayList<>();

            list.add(strs[i]);
            visited[i] = true;
            for(int j = i + 1; j < strs.length; j++){
                
                if(!visited[j] && isAnagram(strs[i], strs[j])){
                    list.add(strs[j]);
                    visited[j] = true;
                }
            }
            mainList.add(list);
        }
        return mainList;
        
    }
    private boolean isAnagram(String s1, String s2){

        if(s1.length() != s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for(char c : s2.toCharArray()){
            if(!map.containsKey(c) || map.get(c) == 0){
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}
