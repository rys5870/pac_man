

import java.util.*;


public class Way {
    private static final int[] rowNum = {-1, 0, 0, 1};
    private static final int[] colNum = {0, -1, 1, 0};


    public static boolean isValid(boolean[][] visited, int row, int col) {
        return (row >= 0) && (row < TileManager.mapTileNum.length) && (col >= 0) && (col < TileManager.mapTileNum[0].length) && !TileManager.mapTileNum[row][col].isBlocked && !visited[row][col];
    }

    public static Queue<Tile> bfs(Tile start, Tile end) {
        Queue<Tile> q = new LinkedList<>();
        boolean[][] visited = new boolean[TileManager.mapTileNum.length][TileManager.mapTileNum[0].length];
        System.out.println(start.x+ ","+start.y);
        if(start.x>GamePanel.maxScreenCol-1){
            start.x = start.x/GamePanel.tileSize;
        }if(start.y>GamePanel.maxScreenRow-1){
            start.y = start.y/GamePanel.tileSize;
        }
        visited[start.x][start.y] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Tile tile = current.tile;

            if (tile.x == end.x && tile.y == end.y) {

                for (int i = current.path.size() - 2; i >= 0; i--) {
                    q.add(current.path.get(i));
                }
                return q;
            }

            for (int i = 0; i < 4; i++) {
                int row = tile.x + rowNum[i];
                int col = tile.y + colNum[i];

                if (isValid(visited, row, col)) {
                    visited[row][col] = true;
                    queue.add(new Node(new Tile(row, col), current.distance + 1, current.path));
                }
            }
        }

        return q; // אם לא נמצא מסלול
    }

    public static Queue<Tile> bfs2(Tile start, Tile end) {
        Queue<Tile> q = new LinkedList<>();
        boolean[][] visited = new boolean[TileManager.mapTileNum.length][TileManager.mapTileNum[0].length];
        Random random = new Random();
        /*for (int i = 0; i <10 ; i++) {
            int num1 = random.nextInt(0, TileManager.mapTileNum.length);
            int num2 = random.nextInt(0, TileManager.mapTileNum[0].length);

            visited[num1][num2] = true;
        }*/

        visited[2][1] = true;
        visited[33][1] = true;
        visited[1][36] = true;
        visited[33][36] = true;
        visited[18][19] = true;
        visited[17][14] = true;
        visited[27][32] = true;
        visited[15][6] = true;
       // visited[1][1] = true;

        visited[start.x][start.y] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Tile tile = current.tile;

            if (tile.x == end.x && tile.y == end.y) {

                for (int i = current.path.size() - 2; i >= 0; i--) {
                    q.add(current.path.get(i));
                }
                return q;
            }

            for (int i = 0; i < 4; i++) {
                int row = tile.x + rowNum[i];
                int col = tile.y + colNum[i];

                if (isValid(visited, row, col)) {
                    visited[row][col] = true;
                    queue.add(new Node(new Tile(row, col), current.distance + 1, current.path));
                }
            }
        }

        return q; // אם לא נמצא מסלול
    }
    public static Queue<Tile> bfs3(Tile start, Tile end) {
        Queue<Tile> q = new LinkedList<>();
        boolean[][] visited = new boolean[TileManager.mapTileNum.length][TileManager.mapTileNum[0].length];
        visited[start.x][start.y] = true;
        visited[6][1] = true;
        visited[5][1] = true;
        visited[1][36] = true;
        visited[33][36] = true;
        visited[18][19] = true;
        visited[17][14] = true;
        visited[27][32] = true;
        visited[15][6] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Tile tile = current.tile;

            if (tile.x == end.x && tile.y == end.y) {

                for (int i = current.path.size() - 2; i >= 0; i--) {
                    q.add(current.path.get(i));
                }
                return q;
            }

            for (int i = 0; i < 4; i++) {
                int row = tile.x + rowNum[i];
                int col = tile.y + colNum[i];

                if (isValid(visited, row, col)) {
                    visited[row][col] = true;
                    queue.add(new Node(new Tile(row, col), current.distance + 1, current.path));
                }
            }
        }

        return q; // אם לא נמצא מסלול
    }
    public static Queue<Tile> bfs4(Tile start, Tile end) {
        Queue<Tile> q = new LinkedList<>();
        boolean[][] visited = new boolean[TileManager.mapTileNum.length][TileManager.mapTileNum[0].length];
        visited[start.x][start.y/GamePanel.tileSize] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Tile tile = current.tile;

            if (tile.x == end.x && tile.y == end.y) {

                for (int i = current.path.size() - 2; i >= 0; i--) {
                    q.add(current.path.get(i));
                }
                return q;
            }

            for (int i = 0; i < 4; i++) {
                int row = tile.x + rowNum[i];
                int col = tile.y + colNum[i];

                if (isValid(visited, row, col)) {
                    visited[row][col] = true;
                    queue.add(new Node(new Tile(row, col), current.distance + 1, current.path));
                }
            }
        }

        return q; // אם לא נמצא מסלול
    }
}
