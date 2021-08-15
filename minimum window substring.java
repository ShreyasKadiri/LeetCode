class Solution {
  public String minWindow(String s, String t) {
    HashMap < Character, Integer > map = new HashMap < Character, Integer > ();
    for (char c: t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int i = 0;
    int j = 0;
    int count = map.size();
    int left = 0, right = s.length() - 1, minimum = s.length();
    boolean found = false;

    while (j < s.length()) {
      char secondCharacter = s.charAt(j++);
      if (map.containsKey(secondCharacter)) {
        map.put(secondCharacter, map.get(secondCharacter) - 1);
        if (map.get(secondCharacter) == 0) {
          count -= 1;
        }
      }
      if (count > 0) {
        continue;
      }
      while (count == 0) {
        char firstCharacter = s.charAt(i++);
        if (map.containsKey(firstCharacter)) {
          map.put(firstCharacter, map.get(firstCharacter) + 1);
          if (map.get(firstCharacter) > 0) {
            count += 1;
          }
        }

      }
      if (j - i < minimum) {
        left = i;
        right = j;
        found = true;
        minimum = j - i;
      }
    }
    return !found ? "" : s.substring(left - 1, right);
  }
}
