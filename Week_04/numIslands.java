public class Solution {
     // 方向数组
     final int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
     // 标记数组， 标记了grid的坐标对应的格子是否被访问过
     boolean[][] marked;
     // grid行数
     int rows;
     // grid列数
     int cols;
     char[][] grid;
 
     public int numIslands(char[][] grid) {
         rows = grid.length;
         if (rows == 0) {
             return 0;
         }
         cols = grid[0].length;
         this.grid = grid;
         marked = new boolean[rows][cols];
 
         int count = 0;
         for (int i=0; i<rows; i++) {
             for (int j=0; j<cols; j++) {
                 // 如果是岛屿中的一个点，并且没有被访问过
                 // 就进行深度优先遍历
                 if (!marked[i][j] && grid[i][j] == '1') {
                     count++;
                     // 从坐标为(i，j)的点开始进行深度优先遍历
                     dfs(i, j);
                 }
             }
         }
         return count;
     }
 
     // 从坐标为(i，j)的点开始进行深度优先遍历
     private void dfs(int i, int j) {
         marked[i][j] = true;
         // 得到4个方向的坐标
         for (int k=0; k<4; k++) {
             int newX = i + directions[k][0];
             int newY = j + directions[k][1];
             // 如果不越界、没有被访问过、并且还是陆地
             if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                 dfs(newX, newY); // 继续在新的坐标点开始进行深度优先搜索
             }
         }
     }
 
     // 判断是否越界
     private boolean inArea(int x, int y) {
         return x>=0 && x<=rows && y>=0 && y<=cols;
     }
}