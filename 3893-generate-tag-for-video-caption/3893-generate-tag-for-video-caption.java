class Solution {
    public String generateTag(String caption) {
        // Handle null or empty input
        if (caption == null || caption.trim().isEmpty()) {
            return "#";
        }
        
        String[] arr = caption.trim().split("\\s+"); // Use regex to handle multiple spaces
        StringBuilder sb = new StringBuilder("#");
        
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            
            // Skip empty words (shouldn't happen with trim() and \\s+, but safety check)
            if (word.isEmpty()) {
                continue;
            }
            
            if (i == 0) {
                // First word: all lowercase
                sb.append(word.toLowerCase());
            } else {
                // Subsequent words: capitalize first letter, lowercase rest
                sb.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    sb.append(word.substring(1).toLowerCase());
                }
            }
        }
        
        // Truncate if longer than 100 characters
        if (sb.length() > 100) {
            sb.setLength(100);
        }
        
        return sb.toString();
    }
}