package ADIlec8;

import java.util.LinkedList;
import java.util.Queue;

public class main {
    public static void main(String[] args) {
        BT tree=new BT();
        tree.root=new Node(5);
        tree.root.left=new Node(4);
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(2);
        tree.root.left.right=new Node(1);

        tree.inorder(tree.root);
    }
}
class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
    }
}
class BT{
    Node root;

    BT(){
        this.root=null;
    }

    void inorder(Node root){
        if(root == null)return;

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    void postorder(Node root){
        if(root == null)return;

        inorder(root.left);
        inorder(root.right);
        System.out.println(root.data);
    }
    void preorder(Node root){
        if(root == null)return;

        System.out.println(root.data);
        inorder(root.left);
        inorder(root.right);
    }

    void levelorder(Node root){
        if(root == null) return;

        Queue<Node>q=new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.poll();

            System.out.println(temp.data);

            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
        }
    }
    void leftview(Node root){
        if(root == null) return;

        Queue<Node>q=new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                Node temp=q.poll();

             if(i == 0)  System.out.println(temp.data);

                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }

        }
    }



    void delete(int key){
        if(root == null) return;

        if(root.left == null && root.right == null){
            if(root.data ==key) {
                root=null;
                return;
            }
        }

        Node temp=null;
        Node keyNode=null;
        Node last=null;

        Queue<Node>q=new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()){
           temp= q.poll();
           if(temp.data == key){
               keyNode = temp;
           }
           if(temp.left != null){
               last =temp;
               q.add(temp.left);
           }
            if(temp.right != null){
                last =temp;
                q.add(temp.right);
            }

        }
        if(keyNode != null){
            keyNode.data = temp.data;
            if(last.right != null) {
                last.right = null;
            }
            else {
                last.left = null;
            }
        }
    }
}
class BST{
    Node root;

    BST(){
        root=null;
    }

    Node insert(int val){
        if(root == null){
            root=new Node(val);
           return root;
        }

        if(val < root.data){
            root.left=insert(val);
        }
        if(val > root.data){
            root.right=insert(val);
        }
        return root;     
    }
    Node delete(int key){
        if(root == null)return null;

        if(root.data < key){
            root.right=delete(key);
        }
        if(root.data > key){
            root.left=delete(key);
        }
        else{
//            if(root.left == null && root.right==null)return null;
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            root.data=minVal(root.right);

            root.right = delete(root.data);
        }
        return root;
    }
    int minVal(Node temp){
        int val=temp.data;
        while(temp != null){
            val=temp.data;
            temp=temp.left;
        }
        return val;
    }
}