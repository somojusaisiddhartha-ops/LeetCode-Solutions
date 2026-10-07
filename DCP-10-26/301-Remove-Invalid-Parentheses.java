class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            while (size-- > 0) {

                String current = queue.poll();

                // If valid, this is the minimum-removal level
                if (isValid(current)) {
                    result.add(current);
                    found = true;
                }

                // Don't generate next level if we already found
                // valid answers at this level
                if (found) {
                    continue;
                }

                // Try removing every parenthesis
                for (int i = 0; i < current.length(); i++) {

                    char c = current.charAt(i);

                    // We only remove parentheses
                    if (c != '(' && c != ')') {
                        continue;
                    }

                    String next =
                        current.substring(0, i) +
                        current.substring(i + 1);

                    // Avoid duplicate strings
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }

            // We found valid strings at this level.
            // Therefore minimum removals have been achieved.
            if (found) {
                break;
            }
        }

        return result;
    }


    static boolean isValid(String s) {

        int balance = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                balance++;
            }

            else if (c == ')') {
                balance--;

                // More ')' than '('
                if (balance < 0) {
                    return false;
                }
            }
        }

        // All '(' must have matching ')'
        return balance == 0;
    }
}
