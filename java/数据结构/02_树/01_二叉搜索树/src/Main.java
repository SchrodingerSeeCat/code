import java.util.Comparator;

public class Main {
    // 左小右大比较器
    private static class PersonComparator1 implements Comparator<Person>{
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }
    // 左大右小比较器
    private static class PersonComparator2 implements Comparator<Person>{
        public int compare(Person e1, Person e2) {
            return e2.getAge() - e1.getAge();
        }
    }

    public static void main(String[] args){
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
        Integer[] arr = {7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
        for(int i = 0; i < arr.length; i++){
            bst1.add(arr[i]);
        }
//        bst1.postOrder(new BinarySearchTree.Visitor<Integer>() {
//            @Override
//            public boolean visit(Integer element) {
//                System.out.print("_" + element + "_ ");
//                return false;
//            }
//        });
//        System.out.println(bst1);

//        System.out.println(bst1.height());
//        System.out.println(bst1.isComplete());
//        bst1.inorderTraversal();
//        bst1.remove(7);
//        bst1.remove(4);
        System.out.println(bst1.contains(4));
//        bst1.remove(3);
//        bst1.inorderTraversal();
    }
}
