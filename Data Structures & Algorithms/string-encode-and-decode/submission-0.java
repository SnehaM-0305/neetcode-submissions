class Solution {

    public String encode(List<String> strs) {
StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length())
              .append("#")
              .append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {

            // find '#'
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }

            // get length
            int len = Integer.parseInt(s.substring(i, j));

            // extract string
            int start = j + 1;
            int end = start + len;

            result.add(s.substring(start, end));

            // move pointer
            i = end;
        }

        return result;
    }
}
