package com.tingcoder.leetcode.tree;

/***
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
 * @author yfeng
 * @date 2018-12-13 13:58
 */
public class PreOrderCheck_331 {
    private static String sep = ",";
    private static String nullNode = "#";

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

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || "".equals(preorder.trim())) {
            return false;
        }
        String[] segs = preorder.split(sep);
        SegmentIterator segmentIterator = new SegmentIterator(segs);
        return isValidatePreOrder(segmentIterator) && !segmentIterator.hasMoreSegment();
    }

    private boolean isValidatePreOrder(SegmentIterator segmentIterator) {
        if (!segmentIterator.hasMoreSegment()) {
            return false;
        }
        String seg = segmentIterator.getCurSegmentAndIncrement();
        if (nullNode.equals(seg)) {
            return true;
        }
        try {
            Integer curVal = Integer.parseInt(seg);
            return isValidatePreOrder(segmentIterator) && isValidatePreOrder(segmentIterator);
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void main(String[] args) {
        PreOrderCheck_331 poc = new PreOrderCheck_331();
        System.out.println(poc.isValidSerialization("1,#,#,1"));
    }
}
