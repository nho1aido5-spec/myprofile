package aiwa.controller;

import java.util.ArrayList;
import java.util.Scanner;

import aiwa.Model.CustomerModel;
import aiwa.View.CustomerHtmlView;
import aiwa.customers.Customer;

public class CustomerController {
    public static void main(String[] args) {
        Scanner scanInt = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);

        CustomerModel cm = new CustomerModel();
        CustomerHtmlView view = new CustomerHtmlView();

        System.out.println("*** 顧客検索 ***");

        while (true) {
            System.out.println("\n--- menu ---");
            System.out.println("1:顧客リスト 2:顧客詳細 3:キーワード検索 4:住所検索 0:終了");

            int menu = scanInt.nextInt();

            if (menu == 1) {
                // 1. Danh sách khách hàng
                ArrayList<Customer> customers = cm.findAll();
                view.showList(customers);

            } else if (menu == 2) {
                // 2. Chi tiết theo Mã khách hàng (Customecode)
                System.out.println("顧客コードを入力してください");
                int code = scanInt.nextInt();

                Customer c = cm.findById(code);
                view.showDetail(c);

            } else if (menu == 3) {
                // 3. Tìm theo từ khóa (Tên)
                System.out.println("キーワードを入力してください");
                String keyword = scanStr.next();

                ArrayList<Customer> customers = cm.findByKeyWord(keyword);
                view.showList(customers);

            } else if (menu == 4) {
                // 4. Tìm theo địa chỉ (address)
                System.out.println("住所を入力してください");
                String address = scanStr.next();

                ArrayList<Customer> customers = cm.findByAddress(address);
                view.showList(customers);

            } else if (menu == 0) {
                // 0. Thoát chương trình
                System.out.println("終了します");
                break;
            }
        }

        scanInt.close();
        scanStr.close();
    }
}