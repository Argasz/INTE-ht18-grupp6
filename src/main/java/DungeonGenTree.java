public class DungeonGenTree<T> {
    private GenTreeNode root;
    private int size = 0;


    public boolean add(T data){
        size++;
        if(root ==  null){
            root = new GenTreeNode(data);
            return true;
        }else{
            return root.add(data);
        }
    }
    public boolean remove(T data){
        size--;
        return true;
    }

    public boolean contains(T data){
        if(root == null){
            return false;
        }else{
            return root.contains(data);
        }

    }

    public void clear(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public int depth(){
        return 1;
    }


}

class GenTreeNode<T>{
    private T data;
    private GenTreeNode<T> left, right;
    GenTreeNode(T data){
        this.data = data;
    }

    boolean add(T data){
        if(left == null){
            left = new GenTreeNode<>(data);
            return true;
        }else if(right == null) {
            right = new GenTreeNode<>(data);
            return true;
        }else{
            return left.add(data);
        }

    }

    boolean contains(T data){
        if(this.data.equals(data)){
            return true;
        }else if (left != null){
            return left.contains(data);
        }else if (right != null){
            return right.contains(data);
        }else{
            return false;
        }
    }

}
