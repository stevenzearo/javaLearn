package day2;

class Product {
    int id;
    String name;
    String category;
    float price;
    Product(int id, String name, String category, float price){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public static void main(String[] args){
        int LENGTH = 5;
        Product bread = new Product(1001, "bread", "food", 3.5f);
        Product hotdog = new Product(1002,"hotdog", "food", 2.5f);
        Product cola = new Product(2001, "cola", "drink", 4.9f);
        Product juice = new Product(2002, "juice", "drink", 5.9f);
        Product[] proList = new Product[4];
        proList[0] = bread;
        proList[1] = hotdog;
        proList[2] = cola;
        proList[3] = juice;
        for (int i = 0; i < proList.length-1; i++) {
            for (int j = 0; j < proList.length-1-i; j++) {
                Product pro1 = proList[j];
                Product pro2 = proList[j+1];
                Product temp = proList[j+1];
                if (pro1.price > pro2.price) {
                    proList[j+1] = pro1;
                    proList[j] = temp;
                }

            }

        }
        for (int i = 0; i < proList.length; i++) {
            System.out.println(proList[i].name+ "\t" +proList[i].price);

        }
    }
}
