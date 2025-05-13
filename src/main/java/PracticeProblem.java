public class PracticeProblem {

	public static void main(String args[]) {

	}


    public static int searchMazeMoves(String[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;

       
        int startRow = rows - 1;
        int startCol = 0;

       
        boolean[][] visited = new boolean[rows][cols];

       
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.add(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        int[][] directions = {{-1, 0}, {1, 0},  {0, -1}, {0, 1}};

        
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int row = current[0];
            int col = current[1];
            int steps = current[2];

         
            if (maze[row][col].equals("F")) {
                return steps;
            }

         
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

            
                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    !maze[newRow][newCol].equals("#") &&
                    !visited[newRow][newCol]) {

                    queue.add(new int[]{newRow, newCol, steps + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

       
        return -1;
    }

    


   
   public static int noOfPaths(String[][] pathArr) {
			int col = 0;
			int row = pathArr.length - 1;

			return noOfPathsHelper(pathArr, row, col);
		}

		public static int noOfPathsHelper(String[][] pathArr, int row, int col) {
			int cols = pathArr[0].length;
			int rows = pathArr.length;

			if (row < 0 || row >= rows || col < 0 || col >= cols) {
				return 0;
			}
			
			if (pathArr[row][col].equals("F")) {
				return 1;
			}

			int right = noOfPathsHelper(pathArr, row, col + 1);
			int up = noOfPathsHelper(pathArr, row - 1, col);
			return up + right;
		}
}


   


	


