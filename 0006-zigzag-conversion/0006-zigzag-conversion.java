class Solution {
    public String convert(String s, int numRows) {
        StringBuilder resultBuilder = new StringBuilder();
List<Character>[] rowGroups = new List[numRows];
int currentIndex = 0;
int directionFlag = numRows == 1 ? 0 : -1;

for (int row = 0; row < numRows; ++row)
  rowGroups[row] = new ArrayList<>();

for (final char character : s.toCharArray()) {
  rowGroups[currentIndex].add(character);
  if (currentIndex == 0 || currentIndex == numRows - 1)
    directionFlag *= -1;
  currentIndex += directionFlag;
}

for (List<Character> group : rowGroups)
  for (final char character : group)
    resultBuilder.append(character);

return resultBuilder.toString();

    }
}