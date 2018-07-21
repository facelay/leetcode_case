package com.facelay.leetcode.testController;

import facelay.base.UnionFindSet;
import facelay.inter.UnionFind;

import java.util.Random;

public class UnionFindTest {

    public double elapseTime(UnionFind uf, int m) {

        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {

        int size = 10000000;
        int m = 10000000;
        UnionFindSet uf = new UnionFindSet(size);
        System.out.println("UnionFindSet elapsed time:" + new UnionFindTest().elapseTime(uf, m) + " s");

        /**
         * 测试结果是对于千万级数据的操作时间大约为5.6s，所以性能是没有问题的
         */
    }
}
