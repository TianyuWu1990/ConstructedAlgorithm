import CtCILibrary.TreeNode;
import Tree.MyBinaryTreeMethods;

import java.util.*;

class PlayGround {
      public static void main(String[] args) {
            TreeNode root = TreeNode.createMinimalBST(new int[]{1,2,-3,22,21,224,24,-2,424,-234,-23,-424,5,6,-7,8});
            root.print();

            MyBinaryTreeMethods my = new MyBinaryTreeMethods();
            my.printLevelOrder(root);
      }
}