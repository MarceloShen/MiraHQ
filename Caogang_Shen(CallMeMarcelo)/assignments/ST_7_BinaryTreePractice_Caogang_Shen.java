/* Binary Tree Properties
 * 3
 * 3
 * 2, 3, 5
 * 3
 * 1, 4, 6
 * 3
 * 5
 * 4, 6
*/
/* Traversal1
 * 3, 5, 1, 2, 4, 6
 * 1, 5, 3, 4, 2, 6
 * 1, 5, 4, 6, 2, 3
*/
/* bsdAdd1
 * Leia, Boba, Darth, Chewy, Han, Jabba, R2D2, Luke
 * Boba, Chewy, Darth, Han, Jabba, Leia, Luke, R2D2
 * Chewy, Jabba, Han, Darth, Boba, Luke, R2D2, Leia 
*/
// size
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
