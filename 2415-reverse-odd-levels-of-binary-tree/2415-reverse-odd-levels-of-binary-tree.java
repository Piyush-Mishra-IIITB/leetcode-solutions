class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            List<TreeNode> nodes = new ArrayList<>();

            for(int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                nodes.add(curr);

                if(curr.left != null) {
                    q.offer(curr.left);
                }

                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }

            if(level % 2 == 1) {

                int l = 0;
                int r = nodes.size() - 1;

                while(l < r) {

                    int temp = nodes.get(l).val;
                    nodes.get(l).val = nodes.get(r).val;
                    nodes.get(r).val = temp;

                    l++;
                    r--;
                }
            }

            level++;
        }

        return root;
    }
}