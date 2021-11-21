import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    //solution_section===============================================
    public static int lc = 0;
    public static int rc = 0;
    
    public static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        lc = 0;
        rc = 0;
        countNode(root, x);
        int nnpex = n - (lc+rc+1);                      //nnpex = number of nodes in parent after excluding x
        int max = Math.max(nnpex, Math.max(lc, rc));
        if(max > (n/2))
            return true;
            
        return false;
    }
    
    
    public static int countNode(TreeNode root, int x){      //x = node coloured by opponent
        if(root == null){
            return 0;
        }
        
        int left = countNode(root.left, x);
        int right = countNode(root.right, x);
        
        if(root.val == x){
            lc = left;
            rc = right;
        }
        
        return left + right + 1;
    }
    
    
    
    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        
        int x = scn.nextInt();
        TreeNode root = createTree(arr, IDX);
        
        // int count = countNode(root, x);
        // System.out.println(count);           //see count of total nodes

        boolean ans = btreeGameWinningMove(root, countNode(root,x), x); //pass countNodes instead of n because we have to pass total number of nodes in tree excluding "-1"
        System.out.println(ans); 
    }

    public static void main(String[] args) {
        solve();
    }
}
