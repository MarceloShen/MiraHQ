public class ST_P7_BinaryTreePracticePart1_Ashley_Mead {

    // binaryTreeProperties
    /*
        How many levels does it have?	
        3
        How many branches (non-leaves) does it have?	
        3
        Which node values are stored in the branches? (Write them separated by commas, in ascending order by value.)	
        2, 3, 5
        How many leaves does it have?	
        3
        Which node values are stored in the leaves? (Write them separated by commas, in ascending order by value.)	
        1, 4, 6
        What value is stored at the root of the tree?	
        3
        Which node(s) are the sibling(s) of the node storing the value 2? (If there is more than one, write them separated by commas, in ascending order by value.)	
        5
        Which node(s) are the children of the node storing the value 2? (Write them separated by commas, in ascending order by value.)	
        4, 6
    */

    // traversal 1
    /*
        pre-order	
        3, 5, 1, 2, 4, 6
        in-order	
        1, 5, 3, 4, 2, 6
        post-order	
        1, 5, 4, 6, 2, 3
    */

    // size
    // public int size() {
    //     return size(overallRoot);
    // }
    
    // public int size(IntTreeNode node) {
    //     if(node == null) {
    //         return 0;
    //     }
    //     return size(node.left) + 1 + size(node.right);
    // }

    // bstAdd1
    /*
        pre-order:
        Leia, Boba, Darth, Chewy, Han, Jabba, R2D2, Luke

        in-order:
        Boba, Chewy, Darth, Han, Jabba, Leia, Luke, R2D2

        post-order:
        Chewy, Jabba, Han, Darth, Boba, Luke, R2D2, Leia
    */

}