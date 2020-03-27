/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题13 机器人的运动范围
 * 题目链接:https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/submissions/
 */

//本题思路为深度优先搜索(DFS)
class Solution {

    int m,n,k;

    boolean [][] visited;  //辅助记录已经访问过的点

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];

        return dfs(0, 0, k);  //从(0,0)开始出发
        
    }

    /**
     * 核心代码dfs函数
     * 参数列表
     * @param i 行索引
     * @param j 列索引
     * @param k 
     * @return
     */
    public int dfs(int i, int j, int k){
        //三个终止条件:
        //1.数组越界
        //2.点被访问过
        //3.数位和大于k
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || !isSuccess(i, j, k)){
            return 0;
        }
        //记录访问节点
        visited[i][j] = true;
        //返回向下和向右搜索的节点和
        return 1 + dfs(i + 1, j, k) + dfs(i, j + 1, k);
    }

    //判断数位和是否符合条件,本题要求数位和不能大于k
    public boolean isSuccess(int i, int j, int k){
        //数位和=个位+十位+百位+...
        if((i%10+i/10+j%10+j/10) <= k){
            return true;
        }
        return false;
    }
}