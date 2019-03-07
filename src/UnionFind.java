import java.util.Arrays;

public class UnionFind {

    public static void main(String[] args) {
        new UnionFind().example();
    }

    private void example() {
        UnionFindTree uft = new UnionFindTree(5);

        System.out.printf("expected initial size is 0 -> [%d]\n", uft.size(0));

        uft.united(0, 1);
        uft.united(2, 3);
        uft.united(3, 4);

        System.out.printf("0-1  2-3-4\n", uft.size(0));
        System.out.printf("expected 0's size is 2 -> [%d]\n", uft.size(0));
        System.out.printf("expected 1's size is 2 -> [%d]\n", uft.size(1));
        System.out.printf("expected 2's size is 3 -> [%d]\n", uft.size(2));
        System.out.printf("expected 3's size is 3 -> [%d]\n", uft.size(3));
        System.out.printf("expected 4's size is 3 -> [%d]\n", uft.size(4));

        System.out.printf("find 0's root -> [%d]\n", uft.find(0));
        System.out.printf("find 1's root -> [%d]\n", uft.find(1));
        System.out.printf("find 2's root -> [%d]\n", uft.find(2));
        System.out.printf("find 3's root -> [%d]\n", uft.find(3));
        System.out.printf("find 4's root -> [%d]\n", uft.find(4));
    }

    /**
     * Union-Find Tree.
     */
    static class UnionFindTree {
        private int[] parent;

        UnionFindTree(int size) {
            parent = new int[size];
            Arrays.fill(parent, -1);
        }

        int find(int x) {
            if (parent[x] < 0) {
                // parent itself
                return x;
            } else {
                // find and set parent
                return parent[x] = find(parent[x]);
            }
        }

        boolean united(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                // already united
                return false;
            }

            if (size(rootX) < size(rootY)) {
                int tmp = rootX;
                rootX = rootY;
                rootY = tmp;
            }

            parent[rootX] += parent[rootY];
            parent[rootY] = rootX;
            return true;
        }

        int size(int x) {
            return -parent[find(x)];
        }

        boolean isSame(int x, int y) {
            return find(x) == find(y);
        }

    }
}
