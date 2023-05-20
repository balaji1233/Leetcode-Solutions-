
class Solution {

    public static HashMap<String,Integer>m;
    public static List<TreeNode>arr;
    public String a(TreeNode root){


        if(root == null){

            return "";

        }

        String str ="(";

        str+=a(root.left);
        str+=Integer.toString(root.val);
        str+=a(root.right);

        str+=")";


        if(m.get(str) != null && m.get(str) == 1){


            arr.add(root);

        }

        if(m.containsKey(str)){

            m.put(str,m.get(str)+1);

        }else{


            m.put(str,1);

        }
        return str;

    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        arr =  new LinkedList<>();
        m =  new HashMap<>();
        a(root);
        return arr;

    }
}
