/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/


// method 1 using TreeMap and PriorityQueue(having MaxHeap)
      class Solution {
          public String frequencySort(String s) {

              // Building HashMap to store frequency
              HashMap<Character,Integer> map = new HashMap<>();
              for(char c:s.toCharArray()) {
                  map.put(c,map.getOrDefault(c,0) + 1);
              }

              // creating maxHeap so that maximum frequency comes at the top
              PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
              maxHeap.addAll(map.keySet());

              // making stringBuilder removing from heap and appending in StringBuilder
              StringBuilder result = new StringBuilder();
              while(!maxHeap.isEmpty()) {
                  char current = maxHeap.remove();
                  for(int i=0;i<map.get(current);i++) {
                      result.append(current);
                  }
              }
              return result.toString();
          }
      }


// method 2 using hashmap and sorting

    class Solution {
      public String frequencySort(String s) {
          if (s == null) {
            return null;
          }

          Map<Character, Integer> map = new HashMap<>();

          for (int i = 0; i < s.length(); ++i) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
          }

          List<Character> arrayList = new ArrayList<>(map.keySet());
          Collections.sort(arrayList, (n1, n2) -> (map.get(n2) - map.get(n1)));

          // build the string
          StringBuilder sb = new StringBuilder();
          for (Character c : arrayList) {
              int count = map.get(c);
              while (count > 0) {
                  sb.append(c);
                  count -= 1;
              }
          } 
         return sb.toString();
        }
    }
