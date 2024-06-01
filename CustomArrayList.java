public class CustomArrayList {
    private Object[] array;
    private int size;
    private final int storage = 10;

    public CustomArrayList() {
        this.array = new Object[storage];
        this.size = 0;
    }

    // add method
    public void add(Object element) {
        if (size == array.length) {

            int new_storage = array.length * 2 ;
            Object[] newArray = new Object[new_storage];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = element;
        size++;

    }
    public Object remove(int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The index is not acceptable");
        }
        // Save the element that is going to be removed
        Object removedElement = array[index];

        // Shift elements to the left to fill the gap created by the removed element
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return removedElement;
    }
    //remove method by element
    public Object remove(Object element){
        for (int i = 0; i<size; i++){
            if (array[i].equals(element)){
                //calling the remove method by index
                return remove(i);
            }
        }
        //Element not found
        return 0;
    }
    public Object get(int index) {
        if (index >= size ||  index < 0 ) {
            throw new IndexOutOfBoundsException("The index is not acceptable");
        }
        return array[index];
    }



    public int size() {
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void display() {
        System.out.print("[");
        // Iterate through the array
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                System.out.print(","); // Print comma if not the first element
            }
            System.out.print(array[i]); // Print the element
        }
        System.out.println("]"); // Print closing bracket
    }
    public void set(int index, Object element) {
        if ( index >= size || index < 0 ) {
            throw new IndexOutOfBoundsException("The index is not acceptable!");
        }
        array[index] = element;
    }
//main class for testing the methods
    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList(); // Create an instance of CustomArrayList
        list.add(3);
        list.add("Java");
        list.add(12.56);
     //   list.display();
        //to set an element at a index 0
        list.set(0, "Python");
      //  list.display();
        list.remove("Java");
       //list.display();
       //checking the number of element in the list

          System.out.println(list.size());
        //check if the element is in the list
        System.out.println(list.isEmpty());
       list.display();

    }

}