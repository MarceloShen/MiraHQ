public class ST_7_BinaryTreePractice_Caogang_Shen {
    public class IntTree {
        private IntTreeNode overallRoot;
        public int size() {
            return partialSize(overallRoot);
        }
        
        private int partialSize(IntTreeNode node) {
            if (node == null) return 0;
            else {
                return 1 + partialSize(node.left) + partialSize(node.right);
            }
        }
    }
}
