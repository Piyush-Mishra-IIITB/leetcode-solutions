class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int length = 0;
        int l = low;
        while (l > 0) {
            length++;
            l = l / 10;
        }

        StringBuilder sb = new StringBuilder();
        int a = 1;
        while (a < 10) {
            sb.append(a);
            a++;
        }

        int i = 0;
        int initialj = length;
        int j = initialj;
        while (true) {                  
            if (j > 9) {
                initialj++;
                length++;               
                if (length > 9) break;     
                j = initialj;
                i = 0;
            }
            int curr = Integer.parseInt(sb.substring(i, j));
            if (curr > high) {
                break;
            }
            if (curr >= low && curr <= high) {
                ans.add(curr);
            }
            j++;
            i++;
        }

        return ans;
    }
}