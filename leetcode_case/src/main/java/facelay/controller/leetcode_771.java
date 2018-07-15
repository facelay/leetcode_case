package facelay.controller;

/**
 * 771. 宝石与石头
 *
 * @author facelay
 * @date 2018年7月12日 下午4:04:29
 */
public class leetcode_771 {

    /**
     * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
     * <p>
     * S中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * <p>
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     * <p>
     * 示例 1:
     * <p>
     * 输入: J = "aA", S = "aAAbbbb" 输出: 3 示例 2:
     * <p>
     * 输入: J = "z", S = "ZZ" 输出: 0
     * <p>
     * 注意: S 和 J 最多含有50个字母。 J 中的字符不重复。
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            for (int k = 0; k < J.length(); k++) {
                if (S.charAt(i) == J.charAt(k)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        int count = new leetcode_771().numJewelsInStones(J, S);
        System.out.println("拥有宝石的数量：" + count);
    }
}
