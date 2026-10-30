package aiwa.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import aiwa.customers.Customer;

public class CustomerHtmlView {

   
    public void showList(ArrayList<Customer> customers) {
        try (FileWriter fw = new FileWriter("customerList.html")) {
            fw.write("<!DOCTYPE html>\n");
            fw.write("<html>\n");
            fw.write("<head>\n");
            fw.write("<meta charset=\"UTF-8\">\n");
            fw.write("<title>Customer List</title>\n");
            fw.write("<link rel='stylesheet' href='style.css'>\n");
            fw.write("</head>\n");
            fw.write("<body>\n");
            fw.write("<h1><img height='30px' src='img/images.jpg' alt='Logo'> 顧客一覧</h1>\n");
            
    
            fw.write("<table border=\"1\" style=\"border-collapse: collapse;\">\n");
            
       
            fw.write("<tr>\n");
            fw.write("<th>顧客コード</th>\n");
            fw.write("<th>顧客名</th>\n");
            fw.write("</tr>\n");

      
            for (Customer c : customers) {
                fw.write("<tr>\n");
                fw.write("<td style=\"text-align: center;\"><a href='details/" + c.getCustomecode() + ".html'>" + c.getCustomecode() + "</a></td>\n");
                fw.write("<td>" + c.getCustomeName() + "</td>\n");
                fw.write("</tr>\n");
                showDetail(c);
            }

            fw.write("</table>\n");
            fw.write("</body>\n");
            fw.write("</html>\n");

            System.out.println("customerList.htmlを作成しました");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showDetail(Customer customer) {
     
        File dir = new File("details");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try (FileWriter fw = new FileWriter("details/" + customer.getCustomecode() + ".html")) {
            fw.write("<!DOCTYPE html>\n");
            fw.write("<html>\n");
            fw.write("<head>\n");
            fw.write("<meta charset=\"UTF-8\">\n");
            fw.write("<title>Customer Detail - " + customer.getCustomecode() + "</title>\n");
       
            fw.write("<link rel='stylesheet' href='../style.css'>\n");
            fw.write("</head>\n");
            fw.write("<body>\n");
            
      
            fw.write("<h1><img height='30px' src='../img/images.jpg' alt='Logo'> 顧客詳細</h1>\n");

            fw.write("<table border=\"1\" style=\"border-collapse: collapse;\">\n");
            
            fw.write("<tr>\n");
            fw.write("<th>顧客コード</th>\n");
            fw.write("<td>" + customer.getCustomecode() + "</td>\n");
            fw.write("</tr>\n");

            fw.write("<tr>\n");
            fw.write("<th>顧客名</th>\n");
            fw.write("<td>" + customer.getCustomeName() + "</td>\n");
            fw.write("</tr>\n");
            
            fw.write("<tr>\n");
            fw.write("<th>住所</th>\n");
            fw.write("<td>" + customer.getAddress() + "</td>\n");
            fw.write("</tr>\n");

            fw.write("</table>\n");
     
            fw.write("<br><a href='../customerList.html'><img height='30px' src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRg4o_t1YANUymaRWXxmWclsN6G4WspOEi_rDxXxTEwjw&s=10'></a>\n");
            fw.write("</body>\n");
            fw.write("</html>\n");
            
            System.out.println(customer.getCustomecode() + ".htmlを作成しました");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}