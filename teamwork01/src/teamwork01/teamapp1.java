package teamwork01;

import java.util.Scanner;

public class teamapp1 {
	 static String savedUsername;
	    static String savedPassword;

	    public static void main(String[] args) {

	        Scanner use = new Scanner(System.in);

	        while (true) {

	            System.out.println("\n費用管理アプリ");
	            System.out.println("===== MENU =====");
	            System.out.println("1. ユーザー登録");
	            System.out.println("2. ログイン");
	            System.out.println("3. 終了");
	            System.out.print("選択してください: ");

	            int choice = use.nextInt();
	            use.nextLine();

	            
	            if (choice == 1) {

	                System.out.print("ユーザー名: ");
	                savedUsername = use.nextLine();

	                System.out.print("パスワード: ");
	                savedPassword = use.nextLine();

	                System.out.println("登録成功！");

	            }

	           
	            else if (choice == 2) {

	                System.out.print("ユーザー名: ");
	                String username = use.nextLine();

	                System.out.print("パスワード: ");
	                String password = use.nextLine();

	                if (username.equals(savedUsername) && password.equals(savedPassword)) {
	                    System.out.println("ログイン成功！");
	                } else {
	                    System.out.println("ログイン失敗！");
	                }
	            }

	            
	            else if (choice == 3) {
	                System.out.println("終了します...");
	                break;
	            }

	            else {
	                System.out.println("無効な選択です！");
	            }
	        }

	        
	    }
	

	
}

