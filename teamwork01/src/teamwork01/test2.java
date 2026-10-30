package teamwork01;

import java.util.ArrayList;
import java.util.Scanner;

// --- CLASS PHỤ 1: Quản lý một khoản chi (Expenses / အသုံးစရိတ်) ---
class Expense {
    private String category;
    private int amount;

    public Expense(String category, int amount) {
        this.category = category;
        this.amount = amount;
    }
    public String getCategory() { return category; }
    public int getAmount() { return amount; }
}


class Income {
    private String source;
    private int amount;

    public Income(String source, int amount) {
        this.source = source;
        this.amount = amount;
    }
    public String getSource() { return source; }
    public int getAmount() { return amount; }
}


public class test2 {
    static String savedUsername = null; 
    static String savedPassword = null;
    static int monthlyBudget = 0; // Hạn mức chi tiêu

    public static void main(String[] args) {
        Scanner use = new Scanner(System.in);
        while (true) {
            System.out.println("\n費用管理アプリ (App Quản Lý Tài Chính / ဘဏ္ဍာရေးစီမံခန့်ခွဲမှု App)");
            System.out.println("===== 初期メニュー (MENU BAN ĐẦU / အဓိကမီနူး) =====");
            System.out.println("1. ユーザー登録 (Đăng ký tài khoản / အကောင့်ဖွင့်ရန်)");
            System.out.println("2. ログイン (Đăng nhập / လော့ဂ်အင်ဝင်ရန်)");
            System.out.println("3. 終了 (Thoát App / ပိတ်ရန်)");
            System.out.print("選択してください (Vui lòng chọn / ရွေးချယ်ပါ): ");

            String choice = use.nextLine(); 
            if (choice.equals("1")) {
                System.out.print("ユーザー名 (Tên đăng ký / အသုံးပြုသူအမည်): "); savedUsername = use.nextLine();
                System.out.print("パスワード (Mật khẩu đăng ký / စကားဝှက်): "); savedPassword = use.nextLine();
                System.out.println("登録成功！ (Đăng ký thành công! / အကောင့်ဖွင့်ခြင်း အောင်မြင်သည်!)");
            } else if (choice.equals("2")) {
                if (savedUsername == null) { 
                    System.out.println("エラー: まだユーザーが登録されていません。(Lỗi: Chưa có tài khoản! / အကောင့်မရှိသေးပါ!)"); 
                    continue; 
                }
                System.out.print("ユーザー名 (Tên đăng nhập / အသုံးပြုသူအမည်): "); String username = use.nextLine();
                System.out.print("パスワード (Mật khẩu đăng nhập / စကားဝှက်): "); String password = use.nextLine();

                if (savedUsername.equals(username) && savedPassword.equals(password)) {
                    System.out.println("ログイン成功！ (Đăng nhập thành công! / လော့ဂ်အင်ဝင်ခြင်း အောင်မြင်သည်!)");
                    showMainMenu(use); 
                } else { 
                    System.out.println("ログイン失敗！ (Sai tài khoản hoặc mật khẩu / စကားဝှက်မှားနေသည်)"); 
                }
            } else if (choice.equals("3")) {
                System.out.println("終了します... (Đang thoát / ပိတ်နေပါသည်...)"); break;
            } else { 
                System.out.println("無効な選択です！ (Lựa chọn không hợp lệ / မမှန်ကန်သော ရွေးချယ်မှု!)"); 
            }
        }
        use.close(); 
    }

    public static void showMainMenu(Scanner use) {
        ArrayList<Expense> expenseList = new ArrayList<>();
        ArrayList<Income> incomeList = new ArrayList<>();

        while (true) {
            System.out.println("\n===== 財務管理メニュー (MENU QUẢN LÝ / ဘဏ္ဍာရေးမီနူး) =====");
            System.out.println("1. 収入を追加する (Thêm khoản THU VÀO / ဝင်ငွေထည့်ရန်)");
            System.out.println("2. 費用を追加する (Thêm khoản CHI RA / အသုံးစရိတ်ထည့်ရန်)");
            System.out.println("3. 予算を設定する (Cài đặt HẠN MỨC CHI / အသုံးစရိတ်ကန့်သတ်ချက်သတ်မှတ်ရန်)");
            System.out.println("4. 収支レポートを見る (Xem BÁO CÁO TÀI CHÍNH / ငွေစာရင်းရှင်းတမ်းကြည့်ရန်)");
            System.out.println("5. ログアウト (Đăng xuất / လော့ဂ်အောက်ထွက်ရန်)");
            System.out.print("選択してください (Vui lòng chọn / ရွေးချယ်ပါ): ");

            String choice = use.nextLine();

           
            if (choice.equals("1")) {
                System.out.print("収入のソース (Nguồn thu - Ví dụ: 給料 / ဝင်ငွေလမ်းကြောင်း): "); 
                String source = use.nextLine();
                System.out.print("金額 (Số tiền thu / ပမာဏ): "); 
                int amount = use.nextInt(); use.nextLine();
                incomeList.add(new Income(source, amount));
                System.out.println("収入を追加しました！ (Đã thêm khoản thu! / ဝင်ငွေထည့်ပြီးပါပြီ!)");

            
            } else if (choice.equals("2")) {
                System.out.print("費用のカテゴリー (Danh mục chi - Ví dụ: 食費 / အသုံးစရိတ်အမျိုးအစား): "); 
                String category = use.nextLine();
                System.out.print("金額 (Số tiền chi / ပမာဏ): "); 
                int amount = use.nextInt(); use.nextLine();
                expenseList.add(new Expense(category, amount));
                System.out.println("費用を追加しました！ (Đã thêm khoản chi! / အသုံးစရိတ်ထည့်ပြီးပါပြီ!)");

               
                if (monthlyBudget > 0) {
                    int totalExp = 0;
                    for (Expense exp : expenseList) totalExp += exp.getAmount();
                    if (totalExp > monthlyBudget) {
                        System.out.println("⚠️ 警告: 今月の予算を超えています！ (Cảnh báo: Vượt quá hạn mức! / သတ်မှတ်ချက်ထက် ကျော်လွန်နေသည်!)");
                    }
                }

            
            } else if (choice.equals("3")) {
                System.out.print("今月の予算を設定してください (Nhập hạn mức chi tiêu - 円 / ကန့်သတ်ချက်ငွေပမာဏ): ");
                monthlyBudget = use.nextInt(); use.nextLine();
                System.out.println("予算を設定しました！ (Cài đặt hạn mức thành công! / သတ်မှတ်ချက် အောင်မြင်သည်!)");

            // 4. XEM BÁO CÁO (REPORT)
            } else if (choice.equals("4")) {
                int totalInc = 0; for (Income inc : incomeList) totalInc += inc.getAmount();
                int totalExp = 0; for (Expense exp : expenseList) totalExp += exp.getAmount();
                int balance = totalInc - totalExp;

                System.out.println("\n====== 収支レポート (BÁO CÁO TÀI CHÍNH / ငွေစာရင်းရှင်းတမ်း) ======");
                System.out.println("総収入 (Tổng thu nhập / စုစုပေါင်းဝင်ငွေ):  +" + totalInc + " 円");
                System.out.println("総費用 (Tổng chi tiêu / စုစုပေါင်းအသုံးစရိတ်):  -" + totalExp + " 円");
                System.out.println("現在の残高 (Số dư hiện tại / လက်ကျန်ငွေ): " + balance + " 円");
                System.out.println("----------------------------------------");
                
                if (monthlyBudget > 0) {
                    System.out.println("設定された予算 (Hạn mức đã cài / သတ်မှတ်ငွေ): " + monthlyBudget + " 円");
                    double percent = ((double) totalExp / monthlyBudget) * 100;
                    System.out.printf("予算の使用率 (Tỷ lệ đã tiêu / အသုံးပြုမှုနှုန်း): %.1f%%\n", percent);
                    
                    if (percent >= 100) {
                        System.out.println("状態 (Trạng thái / အခြေအနေ): ❌ 予算オーバー！ (Đã vượt quá ngân sách! / ငွေကုန်လွန်သွားပြီ!)");
                    } else if (percent >= 80) {
                        System.out.println("状態 (Trạng thái / အခြေအနေ): ⚠️ 危険ゾーン！ (Vùng nguy hiểm! / သတိပြုရန်!)");
                    } else {
                        System.out.println("状態 (Trạng thái / အခြေအနေ):  安全です！ (An toàn! / စိတ်ချရပါသည်!)");
                    }
                } else {
                    System.out.println("💡 ヒント: 予算を設定すると管理しやすくなります。(Hãy cài hạn mức để dễ quản lý hơn.)");
                }

           
            } else if (choice.equals("5")) {
                System.out.println("ログアウトしました。 (Đã đăng xuất / လော့ဂ်အောက်လုပ်ပြီးပါပြီ။)");
                break;
            } else {
                System.out.println("無効な選択です！");
            }
        }
    }
}