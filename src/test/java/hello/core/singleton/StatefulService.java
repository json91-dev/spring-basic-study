package hello.core.singleton;

public class StatefulService {
    private int price; // 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("<UNK>");
        return price;
    }

    public int getPrice() {
        return price;
    }

}
