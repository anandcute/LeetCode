// Given two BSTs, return elements of merged BSTs in sorted form.

// Examples :

// Input:
// BST1:
//        5
//      /   \
//     3     6
//    / \
//   2   4  
// BST2:
//         2
//       /   \
//      1     3
//             \
//              7
//             /
//            6
// Output: 1 2 2 3 3 4 5 6 6 7
// Explanation: After merging and sorting the two BST we get 1 2 2 3 3 4 5 6 6 7.

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

public class MergedTwoBST {
    Node root1;
    Node root2;
    class Node{
        int data;
        Node left, right;
        Node(int value){
            data = value;
            left = right = null;
        }
    }
    MergedTwoBST(int value , boolean ifFirstTree){
        if(ifFirstTree)
            root1 = new Node(value);
        else
            root2 = new Node(value);    
    }
    
    public Node insert(Node root , int value){
        if(root == null){
            return new Node(value);
        }
        if(value < root.data){
            root.left = insert(root.left , value);
        }
        else{
            root.right = insert(root.right , value);
        }
        return root;
    }
    public void inorder(Node root , List<Integer> list){
        if(root != null){
            inorder(root.left , list);
            list.add(root.data);
            inorder(root.right , list);
        }
    }
    public List<Integer> mergeTwoBST(Node root1 , Node root2){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        return mergeList(list1 , list2);
    }
    public List<Integer> mergeList(List<Integer> list1 , List<Integer> list2){
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                result.add(list1.get(i++));
            }
            else
                result.add(list2.get(j++));
        }
        while(i < list1.size())
            result.add(list1.get(i++));
        while (j < list2.size()) {
            result.add(list2.get(j++));
        }    

        return result;
    }
    public static void main(String[] args) {
        MergedTwoBST bst = new MergedTwoBST(5 , true);
        bst.insert(bst.root1 , 3);
        bst.insert(bst.root1 , 6);
        bst.insert(bst.root1 , 2);
        bst.insert(bst.root1 , 4);

        MergedTwoBST bst1 = new MergedTwoBST(2 , false);
        bst.insert(bst1.root2 , 1);
        bst.insert(bst1.root2 , 3);
        bst.insert(bst1.root2 , 7);
        bst.insert(bst1.root2 , 6);

        List<Integer> mergedList = bst.mergeTwoBST(bst.root1, bst1.root2);
        System.out.println(mergedList);
        

    }

}
