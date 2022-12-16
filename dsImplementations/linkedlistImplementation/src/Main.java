class Main {
    public static void main(String[] args) {
        LinkedList newList = new LinkedList();

        newList.append(3);
        newList.append(4);
       newList.prepend(2);
        newList.prepend(1);
        newList.insert(2,61);
       newList.show();

        System.out.println("----------");
        newList.delete(2);



        newList.show();

    }
}

