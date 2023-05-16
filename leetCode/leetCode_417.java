// There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

// The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

// The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

// Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.


// Example 1:
// Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
// Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
// [0,4]: [0,4] -> Pacific Ocean 
//        [0,4] -> Atlantic Ocean
// [1,3]: [1,3] -> [0,3] -> Pacific Ocean 
//        [1,3] -> [1,4] -> Atlantic Ocean
// [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
//        [1,4] -> Atlantic Ocean
// [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
//        [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
// [3,0]: [3,0] -> Pacific Ocean 
//        [3,0] -> [4,0] -> Atlantic Ocean
// [3,1]: [3,1] -> [3,0] -> Pacific Ocean 
//        [3,1] -> [4,1] -> Atlantic Ocean
// [4,0]: [4,0] -> Pacific Ocean 
//        [4,0] -> Atlantic Ocean
// Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.

// Example 2:
// Input: heights = [[1]]
// Output: [[0,0]]
// Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row=heights.length;
        int col=heights[0].length;

        int pacific[][]=new int[row][col];
        int atlantic[][]=new int[row][col];

        int delRow[]={1,-1,0,0};
        int delCol[]={0,0,1,-1};


        for(int i=0;i<row;i++){
            dfs(i,0,heights,pacific,Integer.MIN_VALUE,delRow,delCol);//first col
            dfs(i,col-1,heights,atlantic,Integer.MIN_VALUE,delRow,delCol);//last col
        }

        for(int j=0;j<col;j++){
            dfs(0,j,heights,pacific,Integer.MIN_VALUE,delRow,delCol);//first row
            dfs(row-1,j,heights,atlantic,Integer.MIN_VALUE,delRow,delCol);//last row
        }

        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    List<Integer>res=new ArrayList<>();
                    res.add(i);
                    res.add(j);
                    ans.add(res);
                }
            }
        }
        return ans;
    }

    public void dfs(int i,int j,int [][]heights,int[][]visit,int height,int []delRow,int delCol[]){
        int n=heights.length;
        int m=heights[0].length;
        if(i<0 || i>=n || j<0 || j>=m || visit[i][j]==1 || heights[i][j] < height) return;
        visit[i][j]=1;
        
        for(int k=0;k<4;k++){
            int nrow=i+delRow[k];
            int ncol=j+delCol[k];

            dfs(nrow,ncol,heights,visit,heights[i][j],delRow,delCol);

        }
    }
}