import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();

        Workers workers3 = new Workers(1,"hoa",2);
        Workers workers1 = new Workers(1,"hoa",2);
        bst.insert(workers3);
        bst.insert(workers1);

        // ques 3
        System.out.println("Ques 3");
        bst.descendingTravel();
        // ques 4
        System.out.println("Ques4");
        bst.countByAge(25);
        //ques 5
        System.out.println("Ques 5");
        bst.descendingTravel();
        System.out.println("After");
        bst.deleteRightmost();
        bst.descendingTravel();
        // ques 6
        System.out.println("after delete ques 5 and ques6 is");
        System.out.println(bst.getHeight());
        //ques 7
        System.out.println("Ques 7");
        Workers[] workers = {
                new Workers(1, "Na", 23),
                new Workers(2, "Ma", 21),
                new Workers(3, "La", 30),
                new Workers(4, "Ka", 41),
                new Workers(5, "Ra", 24)
        };
        bst.createLargestHeightTree(workers);
        System.out.println("New tree with largest height:");
        System.out.println("Height: " + bst.getHeight());


    }
}

class Workers {
    int id;
    String fullName;
    int age;

    public Workers(int id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
class Node{
    Workers workers;
    Node left;
    Node right;


    public Node(Workers workers) {
        this.workers = workers;
        this.left = null;
        this.right = null;
    }


    @Override
    public String toString() {
        return workers.getFullName();
    }
}

class RefNode {
    Node N;
    public RefNode() {
        N = null;
    }
}

class BST {
    Node root;

    public BST() {
        this.root = null;
    }


    // search
    Node search(Workers workers, RefNode parent) {
        Node t = root;
        while (t != null) {
            if (t.workers == workers) break;
            parent.N = t;
            if (t.workers.id > workers.id) t = t.left;
            else t = t.right;
        }
        return t;
    }


    // insert
    public void insert(Workers workers)
    {
        RefNode parent = new RefNode();
        Node pos = search(workers,parent);
        if(pos !=null) return;
        Node t = new Node(workers);
        if(parent.N == null) root = t;
        else if(parent.N.workers.id> workers.id) parent.N.left=t;
        else parent.N.right =t;
    }


    // descending travel
    public void descendingTravel ()
    {
        ArrayList<Workers> list = new ArrayList<>();
        desTravel(root,list);
        for (Workers workers:list)
        {
            System.out.println(workers.fullName);
        }
    }

    public void desTravel(Node curr,ArrayList<Workers> travel)
    {
        if(curr==null) return;
        desTravel(curr.right,travel);
        travel.add(curr.workers);
        desTravel(curr.left,travel);
    }

    // count by age ( 25)
    public void countByAge(int age)
    {
        ArrayList<Workers> list = new ArrayList<>();
        countByAge(root,list,age);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("Have "+list.size()+" worker");
    }

    public void countByAge(Node node,ArrayList<Workers> list,int age)
    {
        if(node == null) return;
        countByAge(node.left,list,age);
        countByAge(node.right,list,age);
        if(node.workers.age<age)list.add(node.workers);
    }


    // delete right most
    public void deleteRightmost() {
        root = deleteRightmost(root);
    }

    public Node deleteRightmost(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteRightmost(node.right);
        return node;
    }


    // get height by level order
    public int getHeight() {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
        }
        return height;
    }


    // create larges height tree
    public void createLargestHeightTree(Workers[] workers) {
        root = createLargestHeightTree(workers, 0, workers.length - 1);
    }

    private Node createLargestHeightTree(Workers[] workers, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        Node node = new Node(workers[mid]);
        node.left = createLargestHeightTree(workers, left, mid - 1);
        node.right = createLargestHeightTree(workers, mid + 1, right);
        return node;
    }

}

