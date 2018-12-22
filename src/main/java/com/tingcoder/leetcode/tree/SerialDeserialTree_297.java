package com.tingcoder.leetcode.tree;

import com.tingcoder.leetcode.base.TreeNode;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/description/
 * @author yfeng
 * @date 2018-12-13 13:58
 */
public class SerialDeserialTree_297 {
    private static String sep = ",";
    private static String nullNode = "$";

    private static class SegmentIterator {
        private String[] segs;
        private int curIdx;

        public SegmentIterator(String[] segs) {
            this.segs = segs;
        }

        public String getCurSegmentAndIncrement() {
            return segs[curIdx++];
        }

        public boolean hasMoreSegment() {
            return curIdx < segs.length;
        }
    }

    public String serialize(TreeNode root) {
        StringBuffer buf = new StringBuffer();
        if (root == null) {
            buf.append(nullNode);
            return buf.toString();
        } else {
            buf.append(root.val);
        }
        buf.append(sep);
        buf.append(serialize(root.left));
        buf.append(sep);
        buf.append(serialize(root.right));
        return buf.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data.trim())) {
            return null;
        }
        String[] segs = data.split(sep);
        SegmentIterator segmentIterator = new SegmentIterator(segs);
        return deserializeFromSegments(segmentIterator);
    }

    private TreeNode deserializeFromSegments(SegmentIterator segmentIterator) {
        if (!segmentIterator.hasMoreSegment()) {
            return null;
        }
        String curSeg = segmentIterator.getCurSegmentAndIncrement();
        if (curSeg.equals(nullNode)) {
            return null;
        } else {
            TreeNode curNode = new TreeNode(Integer.parseInt(curSeg));
            curNode.left = deserializeFromSegments(segmentIterator);
            curNode.right = deserializeFromSegments(segmentIterator);
            return curNode;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        SerialDeserialTree_297 codec = new SerialDeserialTree_297();
        String serializeVal = codec.serialize(root);

        System.out.println("serialize value : " + serializeVal);
        TreeNode deseriaVal = codec.deserialize(serializeVal);
        System.out.println(codec.serialize(deseriaVal));
    }
}