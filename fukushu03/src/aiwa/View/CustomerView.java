package aiwa.View;

import java.util.ArrayList;

import aiwa.customers.Customer;

public class CustomerView {

    // Hiển thị danh sách khách hàng (dùng cho Menu 1, 3, 4)
    public void showList(ArrayList<Customer> customers) {
        if (customers == null || customers.isEmpty()) {
            System.out.println("該当する顧客が見つかりません。");
            return;
        }

        for (Customer c : customers) {
            System.out.println("--------------------");
            System.out.println("顧客コード: " + c.getCustomecode());
            System.out.println("顧客名: " + c.getCustomeName());
            System.out.println("住所: " + c.getAddress());
        }
    }

    // Hiển thị chi tiết 1 khách hàng (dùng cho Menu 2)
    public void showDetail(Customer c) {
        if (c == null) {
            System.out.println("該当する顧客が見つかりません。");
            return;
        }

        System.out.println("--------------------");
        System.out.println("顧客コード: " + c.getCustomecode());
        System.out.println("顧客名: " + c.getCustomeName());
        System.out.println("住所: " + c.getAddress());
    }
}