package com.practice;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class UniqueTrees {
    Map<Integer, Integer> map = new HashMap<>();

    public List<TreeNode> findUniqueStructuredNodes(int num) {
        if (num <= 0) return new ArrayList<TreeNode>();
        return findRootNodes(1, num);
    }

    public List<TreeNode> findRootNodes(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTrees = findRootNodes(start, i - 1);
            List<TreeNode> rightSubTrees = findRootNodes(i + 1, end);
            for (TreeNode leftSubtree : leftSubTrees)
                for (TreeNode rightSubTree : rightSubTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubtree;
                    root.right = rightSubTree;
                    result.add(root);
                }
        }
        return result;
    }

    public int findStructureUniqueBST(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n <= 1)
            return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int countLeft = findStructureUniqueBST(i - 1);
            int countRight = findStructureUniqueBST(n - i);
            count += (countLeft * countRight);
        }
        map.put(n, count);
        return count;
    }
}



