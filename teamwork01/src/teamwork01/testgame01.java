package teamwork01;

import java.io.FileInputStream;
import java.util.Random;
import java.util.Scanner;

import javazoom.jl.player.Player;

public class testgame01 {
    static String savedUsername = null; 
    static String savedPassword = null;

    // Quản lý các Player âm thanh nền và hiệu ứng
    static Player bgmPlayer = null;
    static Player environmentPlayer = null;
    static Player eventSoundPlayer = null;
    
    static Random rand = new Random();

    public static void main(String[] args) throws Exception {
        Scanner use = new Scanner(System.in);

        while (true) {
            System.out.println("\n=======================================================");
            System.out.println("  東京サバイバル (TOKYO SURVIVAL - GAME SoNG SÓT TÀI CHÍNH)");
            
           System.out.println("=======================================================");
            System.out.println("1. 新規登録 (Đăng ký tài khoan moi)");
            System.out.println("2. ゲーム開始 (Đăng nhập & Bat đau trò chơi)");
            System.out.println("3. ゲーム終了 (Thoát trò choi)");
            System.out.print("選択してください (Vui lòng chon so): ");

            String choice = use.nextLine(); 

            if (choice.equals("1")) {
                stopAllLongSounds(); 
                backgr();
                System.out.print("ユーザー名を入力してください (Nhập tên người chơi): "); 
                savedUsername = use.nextLine();
                System.out.print("パスワードを入力してください (Nhập mật khẩu): "); 
                savedPassword = use.nextLine();
                System.out.println("登録成功！さあ、東京へ旅立ちましょう！");

            } else if (choice.equals("2")) {
                if (savedUsername == null) { 
                    System.out.println("❌ エラー: 先にユーザー登録をしてください。"); 
                    erro();
                    continue; 
                }
                System.out.print("ユーザー名 (Tên đăng nhập): "); String username = use.nextLine();
                System.out.print("パスワード (Mật khẩu): "); String password = use.nextLine();

                if (savedUsername.equals(username) && savedPassword.equals(password)) {
                    System.out.println("\n🔓 ログイン成功！ (Đăng nhập thành công!)");
                    tiengdangnhap();
                    startGame(use); 
                } else { 
                    System.out.println("❌ ログイン失敗！"); 
                    erro();
                }

            } else if (choice.equals("3")) {
                System.out.println("ゲームを終了します。"); 
                stopAllLongSounds();
                break;
            } else { 
                System.out.println("無効な選択です！"); 
                erro();
            }
        }
        use.close(); 
    }

    public static void startGame(Scanner use) throws Exception {
        int balance = 50000;  
        int currentDay = 1;   
        int totalDays = 30;   
        
        stopAllLongSounds(); 
        play1();             
        amthanhmoitruog();   
        
        System.out.println("\n-------------------------------------------------------");
        System.out.println("【ストーリー / CỐT TRUYỆN】");
        System.out.println("あなたは手元にある50,000円だけで、大都市「東京」にやってきました。");
        System.out.println("(Bạn vừa đến thành phố lớn Tokyo với chỉ 50,000 Yên trong tay.)");
        System.out.println("\n目標 là quản lý tiền thật tốt để sống sót qua 30 ngày.");
        System.out.println("-------------------------------------------------------");
        System.out.print("Enterキーを押して開始... (Nhấn Enter để bắt đầu...)");
        use.nextLine();
        
        while (currentDay <= totalDays) {
            stopEventSound();

            System.out.println("\n=======================================================");
            System.out.println("📅 【" + currentDay + "日目 / Ngày thứ " + currentDay + "】");
            System.out.println("💰 現在の所持金: " + balance + " 円");
            System.out.println("=======================================================");

            // --- NGÀY 1 ---
            if (currentDay == 1) {
            	stopAllLongSounds(); 
                play1(); 
               
                System.out.println("🔊 [イベント]: 渋谷で大雨が降ってきました！(Trời mưa rất to ở Shibuya!)");
                System.out.println("1. タクシーに乗る (Khoảng -3,500円)");
                System.out.println("2. 電車と傘で頑張る (Khoảng -300円)");
                System.out.print("選択 (Lựa chọn): ");
                
                if (use.nextLine().equals("1")) { 
                    int loss = 2500 + rand.nextInt(2001); 
                    balance -= loss; 
                    System.out.println("💸 実費 (Thực tế trừ): -" + loss + "円");
                    
                    System.out.println("🚖 運転手：大雨ですね。タイミングよく捕まってよかったです！");
                    System.out.println("🚖 Tài xế: Trời mưa lớn quá, may mà bạn bắt taxi kịp đấy!");
                    System.out.println("🙂 自分：高いですが、ずぶ濡れになるよりはマシです。");
                    System.out.println("🙂 Bạn: Đắt thật nhưng còn hơn bị ướt như chuột lột.");
                    
                    tiengtien(); play1(); tiengmua();
                } else { 
                    int loss = 200 + rand.nextInt(201); 
                    balance -= loss; 
                    System.out.println("💸 実費 (Thực tế trừ): -" + loss + "円");
                    
                    System.out.println("🌧️ 自分：本当に大雨だな...");
                    System.out.println("🌧️ Bạn: Mưa to thật...");
                    System.out.println("🚉 駅員：風邪をひかないように気を付けてくださいね！");
                    System.out.println("🚉 Nhân viên ga tàu: Cẩn thận kẻo cảm lạnh nhé!");
                    
                    tiengga(); tiengtien(); play1(); 
                }
            } 
            // --- NGÀY 2 ---
            else if (currentDay == 2) {
            	stopAllLongSounds();
            	play1(); 
            	
                System.out.println("🔊 [イベント]: 友達から焼肉に誘われました！(Bạn bè rủ đi ăn thịt nướng!)");
                System.out.println("1. 高級焼肉店に行く (Khoảng -4,500円)");
                System.out.println("2. コンビニ弁当にする (Khoảng -500円)");
                System.out.print("選択 (Lựa chọn): ");
                
                if (use.nextLine().equals("1")) { 
                    int loss = 3800 + rand.nextInt(1401); 
                    balance -= loss; 
                    System.out.println("💸 実費 (Thực tế trừ): -" + loss + "円");
                    
                    System.out.println("🥩 友達：この店、最高に美味しいよね！乗る価値あるわ！");
                    System.out.println("🥩 Bạn bè: Quán này ngon tuyệt đúng không? Đáng tiền ghê!");
                    System.out.println("🥲 自分：美味しいけど、財布が泣いているよ...");
                    System.out.println("🥲 Bạn: Ngon thì ngon thật mà ví mình đang khóc thét đây...");
                    
                    tiengthitnuong(); tiengtien();play1(); 
                } else { 
                    int loss = 400 + rand.nextInt(251); 
                    balance -= loss; 
                    System.out.println("💸 実費 (Thực tế trừ): -" + loss + "円");
                    
                    System.out.println("🍱 自分：コンビニ弁当は早くて安くて助かる。");
                    System.out.println("🍱 Bạn: Ăn cơm hộp tiện lợi vừa nhanh lại vừa tiết kiệm.");
                    
                     tiengcuahantienloi(); tiengtien();play1(); 
                }
            } 
            // --- NGÀY 3 (PACHINKO) ---
            else if (currentDay == 3) {
            	stopAllLongSounds();
            	play1(); 
                System.out.println("🔊 [イベント]: パチンコ屋の前を通りかかった。(Đi ngang qua tiệm trò chơi Pachinko.)");
                System.out.println("1. 勝負する！(Vào chơi may rủi)");
                System.out.println("2. スルーする (Bỏ qua đi về)");
                System.out.print("選択 (Lựa chọn): ");
                
                if (use.nextLine().equals("1")) {
                    System.out.println("\n🎰 [PACHINCO SLOT] Đang quay...");
                    String[] icons = {"7", "🎰", "💎", "🍒", "❌"};
                    String slot1 = "", slot2 = "", slot3 = "";
                    for (int i = 0; i < 10; i++) {
                        slot1 = icons[rand.nextInt(icons.length)];
                        slot2 = icons[rand.nextInt(icons.length)];
                        slot3 = icons[rand.nextInt(icons.length)];
                        System.out.print("\r| " + slot1 + " | " + slot2 + " | " + slot3 + " |");
                        Thread.sleep(150); 
                    }
                    System.out.println("\n-----------------------");
                    
                    if (slot1.equals(slot2) && slot2.equals(slot3)) {
                        int jackpotGain = 20000 + rand.nextInt(20001); 
                        balance += jackpotGain; 
                        System.out.println("🎰 大当たり！ Thắng lớn! (+" + jackpotGain + "円)"); 
                        
                        System.out.println("🎉 自分：やったー！ジャックポットだ！人生逆転！");
                        System.out.println("🎉 Bạn: Ôi trúng Jackpot rồi! Đổi đời là đây chứ đâu!");
                        tiengtien();play1();
                    } else { 
                        int slotLoss = 2000 + rand.nextInt(2001); 
                        balance -= slotLoss; 
                        System.out.println("😭 大負け！ Mất tiền cược! (-" + slotLoss + "円)"); 
                        
                        System.out.println("💀 自分：ギャンブルなんてするんじゃなかった、一文無しだ...");
                        System.out.println("💀 Bạn: Biết thế không nghe máu liều ăn nhiều, mất trắng rồi...");
                         play1(); tiengtien();
                    }
                } else {
                    System.out.println("😎 自分：賢明な判断だ。あそこに入ったら破産する。");
                    System.out.println("😎 Bạn: May mà mình tỉnh táo, sa chân vào đấy là ra đê ở sớm.");
                    play1(); tiengtien();
                } 
            } 
            
            else if (currentDay == 4) {
            	stopAllLongSounds();
            	play1(); 
            	tiengdtroi();
                System.out.println("🔊 [イベント]: スマホの画面を割ってしまった！(Làm nứt màn hình điện thoại!)");
                System.out.println("1. すぐに修理する (Khoảng -12,000円)");
                System.out.println("2. そのまま使う (-0円)");
                System.out.print("選択 (Lựa chọn): ");
                
                if (use.nextLine().equals("1")) { 
                    int loss = 9000 + rand.nextInt(4001); 
                    balance -= loss; 
                    System.out.println("💸 実費 (Thực tế trừ): -" + loss + "円");
                    System.out.println("📱 修理屋：画面は新品同様になりましたよ！");
                    System.out.println("📱 Thợ sửa: Màn hình như mới rồi nhé em!");
                     play1(); tiengtien();
                } else {
                    System.out.println("📱 自分：少し見づらいけど、まだ動くから我慢して節約しよう。");
                    System.out.println("📱 Bạn: Thôi nhìn hơi lem nhem tí nhưng vẫn bấm được, tiết kiệm tiền đã.");
                    play1(); tiengtien();
                }
            } 
            // --- NGÀY 5 ---
            else if (currentDay == 5) {
            	stopAllLongSounds();
            	play1(); 
            	
                System.out.println("🔊 [イベント]: 道で財布を拾った！(Nhặt được chiếc ví rơi trên đường!)");
                System.out.println("1. 交番に届ける (Trả lại nhận hậu tạ)");
                System.out.println("2. ネコババする (Lén đút túi tiêu luôn)");
                System.out.print("選択 (Lựa chọn): ");
                
                if (use.nextLine().equals("1")) { 
                    int gain = 1500 + rand.nextInt(2001); 
                    balance += gain; 
                    System.out.println("😇 お礼を貰った！ Được hậu tạ: +" + gain + "円"); 
                    System.out.println("👮 警察官：親切にありがとう。落とし主からお礼を預かっています。");
                    System.out.println("👮 Cảnh sát: Cảm ơn lòng tốt của cháu, người mất ví có gửi chút quà hậu tạ.");
                    tiengtien(); play1(); tiengcoicachsat();
                } else { 
                    int gain = 6000 + rand.nextInt(6001); 
                    balance += gain; 
                    System.out.println("😈 悪魔の臨時収入 Nhặt được: +" + gain + "円"); 
                    System.out.println("😈 自分：誰も見てないよね…神様が助けてくれたと思おう。");
                    System.out.println("😈 Bạn: Không ai thấy đâu nhỉ... Coi như ông trời giúp mình đi.");
                    tiengtien(); play1(); 
                }
            } 
            // --- NGÀY 6 ---
            else if (currentDay == 6) {
            		stopAllLongSounds();
            		
            	play1(); 
                System.out.println("🔊 [イベント]: 古着屋でカッコいい服を見つけた！(Thấy bộ đồ rất bảnh ở tiệm đồ cũ!)");
                System.out.println("1. 購入する (Khoảng -6,000円)");
                System.out.println("2. 我慢する (-0円)");
                System.out.print("選択 (Lựa chọn): ");
                
                if (use.nextLine().equals("1")) { 
                    int loss = 4500 + rand.nextInt(2501); 
                    balance -= loss; 
                    System.out.println("💸 実費 (Thực tế trừ): -" + loss + "円");
                    System.out.println("🧥 自分：これを着ると、すごくスタイリッシュに見える！");
                    System.out.println("🧥 Bạn: Mặc bộ này lên trông phong cách hẳn!");
                     play1(); tiengtien();
                } else {
                    System.out.println("🧥 自分：古着なのに高いな、今回は諦めよう。");
                    System.out.println("🧥 Bạn: Đồ cũ thôi mà đắt ghê, nhịn vậy.");
                    play1(); tiengtien();
                }
            } 
            // --- NGÀY 7 ---
            else if (currentDay == 7) {
            	stopAllLongSounds();
            	play1();
            	
            	
                System.out.println("🔊 [イベント]: 今週の食料買い出しの日。(Ngày đi mua thực phẩm cho tuần.)");
                System.out.println("1. 業務スーパーで大量購入 (Khoảng -4,000円)");
                System.out.println("2. 外食で済ませる (Khoảng -8,000円)");
                System.out.print("選択 (Lựa chọn): ");
               
                
                if (use.nextLine().equals("1")) { 
                    int loss = 3200 + rand.nextInt(1301); 
                    balance -= loss; System.out.println("💸 実費 (Thực tế trừ): -" + loss + "円");
                    System.out.println("🛒 自分：業務スーパーは本当に安い！これで1週間は大丈夫。");
                    System.out.println("🛒 Bạn: Mua ở Gyomu Super đồ rẻ thật, tha hồ nấu cả tuần.");
                     play1(); tiengtien();
                } else { 
                    int loss = 6500 + rand.nextInt(2501); 
                    balance -= loss; System.out.println("💸 実費 (Thực tế trừ): -" + loss + "円");
                    System.out.println("🍽️ 自分：料理するのが面倒だから外食にしたけど、出費が痛い。");
                    System.out.println("🍽️ Bạn: Lười nấu quá, đi ăn tiệm cho nhanh nhưng xót ví ghê.");
                     play1(); tiengtien();
                }
            } 
            // --- NGÀY 8 ---
            else if (currentDay == 8) {
            	stopAllLongSounds();
            	play1();
            	
                System.out.println("🔊 [イベント]: 家の電球が切れて真っ暗に！(Bóng đèn phòng bị cháy!)");
                System.out.println("1. LED電球を買う (Khoảng -2,000円)");
                System.out.println("2. 暗闇で耐える (-0円)");
                System.out.print("選択 (Lựa chọn): ");
                
                if (use.nextLine().equals("1")) { 
                    int loss = 1500 + rand.nextInt(1001); 
                    balance -= loss; System.out.println("💸 実費 (Thực tế trừ): -" + loss + "円");
                    System.out.println("💡 自分：明るくなった！暗い部屋は気分まで落ち込むからね。");
                    System.out.println("💡 Bạn: Sáng sủa hẳn, phòng tối tăm nhìn âm u chịu không nổi.");
                     tiengtien();play1();
                } else {
                    System.out.println("💡 自分：スマホの画面の光で耐えよう。暗闇は人を強くする。");
                    System.out.println("💡 Bạn: Thôi thắp màn hình điện thoại dùng tạm, bóng tối làm ta mạnh mẽ hơn.");
                    tiengtien();play1();
                }
            } 
            // --- NGÀY 9 ---
            else if (currentDay == 9) {
            	stopAllLongSounds();
            	play1();
            	
            	tiengchuongdt();
                System.out.println("🔊 [イベント]: 故郷の両親から仕送りが届いた！(Bố mẹ gửi tiền tiếp tế!)");
                System.out.println("1. 感謝して受け取る (Biết ơn nhận lấy)");
                System.out.print("選択 (Lựa chọn): ");
                use.nextLine();
                int gain = 12000 + rand.nextInt(6001); 
                balance += gain; 
                System.out.println("💰 仕送り (Nhận tiếp tế): +" + gain + "円");
                System.out.println("😭 自分：お父さん、お母さんありがとう。ちょうどお金が尽きそうだったんだ。");
                System.out.println("😭 Bạn: Con cảm ơn bố mẹ, đúng lúc con đang sắp hết tiền ăn.");
                tiengtien();play1();
            } 
            // --- NGÀY 10 ---
            else if (currentDay == 10) {
            	stopAllLongSounds();
            	play1();
            	
                System.out.println("🔊 [イベント]: 水道代の請求書が届いた。(Hóa đơn tiền nước.)");
                System.out.println("1. すぐに支払う (Khoảng -3,500円)");
                System.out.println("2. 延期する (-0円)");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) { 
                    int loss = 3000 + rand.nextInt(1001); 
                    balance -= loss; System.out.println("💸 実費 (Thực tế trừ): -" + loss + "円");
                    System.out.println("🚰 自分：払ってスッキリした。水道を止められる心配もない。");
                    System.out.println("🚰 Bạn: Đóng xong cho nhẹ nợ, đỡ lo bị cắt nước.");
                    play1();tiengtien();
                } else {
                    System.out.println("🚰 自分：来月に引き延ばそう。早く止められないといいけど。");
                    System.out.println("🚰 Bạn: Thôi khất sang tháng sau, mong là họ không khóa vòi sớm.");
                    tiengtien();play1();
                }
            } 
            // --- NGÀY 11 TỚI NGÀY 30 ---
            else if (currentDay == 11) {
            	stopAllLongSounds();
            	play1();
            	tiengho();
                System.out.println("🔊 [イベント]: 風邪をひいてしまった...(Bị cảm cúm rồi...)");
                System.out.println("1. 病院に行って薬をもらう");
                System.out.println("2. 寝て治す");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) { 
                    int loss = 4000 + rand.nextInt(2001); balance -= loss; 
                    System.out.println("🏥 医者：薬をしっかり飲んで、ゆっくり休んでください。");
                    System.out.println("🏥 Bác sĩ: Uống thuốc đúng giờ và nghỉ ngơi nhé.");
                     play1();tiengtien();
                } else { 
                    int loss = 300 + rand.nextInt(401); balance -= loss; 
                    System.out.println("🛌 自分：ズーズー…布団にくるまって寝れば明日には治るはず。");
                    System.out.println("🛌 Bạn: Khụt khịt... Đắp chăn ngủ một giấc hi vọng ngày mai sẽ khỏi.");
                     tiengtien();play1();
                }
            } else if (currentDay == 12) {
            	stopAllLongSounds();
            	play1();
            	
                System.out.println("🔊 [イベント]: 秋葉原で限定フィギュア発売！(Mô hình giới hạn ở Akihabara!)");
                System.out.println("1. 転売用に並んで買う");
                System.out.println("2. スルーする");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) {
                    int loss = 8500 + rand.nextInt(3000); balance -= loss;
                    if (rand.nextBoolean()) { 
                        int gain = 18000 + rand.nextInt(12001); balance += gain; 
                        System.out.println("📈 自分：高値で転売できた！大儲けだ！");
                        System.out.println("📈 Bạn: Bán lại được giá hời quá, lãi đậm rồi!");
                        tiengtien(); play1();
                    } else { 
                        System.out.println("📉 自分：最悪だ、在庫を抱えて誰も買ってくれない。大赤字だ。");
                        System.out.println("📉 Bạn: Ôi không, ôm bom hàng tồn không ai mua, lỗ nặng rồi.");
                        play1();tiengtien();
                    }
                } else { 
                    System.out.println("🤖 自分：こういうのはリスクが高いから、やめておこう。");
                    System.out.println("🤖 Bạn: Mấy trò này hên xui lắm, bỏ qua."); 
                }
            } else if (currentDay == 13) {
            	stopAllLongSounds();
            	play1();
            	
                System.out.println("🔊 [イベント]: 電車の定期券が切れた。(Hết hạn vé tháng tàu điện.)");
                System.out.println("1. 1ヶ月分更新する");
                System.out.println("2. 自転車で移動");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) { 
                    int loss = 6000 + rand.nextInt(2001); balance -= loss; 
                    System.out.println("🚉 自分：電車移動が楽だし、天気を気にしなくていい。");
                    System.out.println("🚉 Bạn: Đi tàu cho nhàn, trời nắng mưa đỡ phải nghĩ.");
                     play1();tiengtien();tiengga();
                } else { 
                    int loss = 1000 + rand.nextInt(1001); balance -= loss; 
                    System.out.println("🚴 自分：健康にもいいし、たくさんのお金を節約できた。");
                    System.out.println("🚴 Bạn: Vừa rèn luyện sức khỏe vừa tiết kiệm được đống tiền.");
                     play1();tiengtien();tiengcoixedap();
                }
            } else if (currentDay == 14) {
            	stopAllLongSounds();
            	play1();
            	
                System.out.println("🔊 [イベント]: 歯が激しく痛み出した！(Đau răng dữ dội!)");
                System.out.println("1. 歯医者に行く");
                System.out.println("2. 薬で耐える");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) { 
                    int loss = 3000 + rand.nextInt(2001); balance -= loss; 
                    System.out.println("🦷 歯医者：ひどい虫歯ですね。早く治療しないと大変ですよ。");
                    System.out.println("🦷 Nha sĩ: Răng sâu nặng rồi, không chữa sớm là mệt đấy.");
                  play1();tiengtien();
                } else { 
                    int loss = 400 + rand.nextInt(401); balance -= loss; 
                    System.out.println("💊 自分：頬を押さえて耐える…痛み止めよ、救ってくれ。");
                    System.out.println("💊 Bạn: Ôm má chịu đựng... Thuốc giảm đau ơi cứu tôi.");
                    play1();tiengtien();
                }
            } else if (currentDay == 15) {
            	stopAllLongSounds();
            	 play1();
            	 
            	 tiengchaokhach();
                System.out.println("🔊 [イベント]: 単発のアルバイトを頼まれた。(Được nhờ làm thêm một ngày.)");
                System.out.println("1. 1日中働く");
                System.out.println("2. 断って休む");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) {
                    int jobType = rand.nextInt(3);
                    if (jobType == 0) {
                        int gain = 12000 + rand.nextInt(6001); balance += gain; 
                        System.out.println("💰 店長：今日はよく頑張ってくれたね！これボーナスだよ！");
                        System.out.println("💰 Chủ tiệm: Hôm nay em làm tốt lắm, thưởng thêm cho em này!");
                        play1();tiengtien();tiengchaokhach();
                    } else if (jobType == 1) {
                        int gain = 7000 + rand.nextInt(3001); balance += gain; 
                        System.out.println("💰 自分：標準的な日給をもらった。安定している。");
                        System.out.println("💰 Bạn: Nhận lương làm thêm cơ bản ổn định.");
                        play1();tiengtien();tiengchaokhach();
                    } else {
                        int loss = 2000 + rand.nextInt(3001); balance -= loss; 
                        System.out.println("😭 自分：ドジをして客の物を壊してしまい、給料から引かれた。");
                        System.out.println("😭 Bạn: Hậu đậu làm vỡ đồ của khách bị trừ luôn vào lương.");
                        play1();tiengtien();tiengvodo();
                    }
                } else { 
                    System.out.println("🛌 自分：疲れたから、今日は休んでエネルギーをチャージしよう。");
                    System.out.println("🛌 Bạn: Thôi mệt rồi, nghỉ ngơi một ngày sạc lại năng lượng."); 
                    play1();tiengtien();
                }
            } else if (currentDay == 16) {
            	stopAllLongSounds();
            	 play1();
                System.out.println("🔊 [イベント]: スクラッチくじを買ってみた。(Mua thử vé số cào.)");
                int cost = 800 + rand.nextInt(401); balance -= cost; erro();
                if (rand.nextInt(3) == 0) { 
                    int gain = 3000 + rand.nextInt(5001); balance += gain; 
                    System.out.println("🎟️ 自分：うわ、当たった！スクラッチくじって本当に当たるんだ！");
                    System.out.println("🎟️ Bạn: Wow trúng rồi! Vé số cào linh nghiệm thật!");
                    play1();tiengtien();
                } else { 
                    System.out.println("🎟️ 自分：ハズレか、数百円無駄にしちゃったな。");
                    System.out.println("🎟️ Bạn: Trượt rồi, mất toi mấy trăm Yên.");
                    play1();tiengtien();
                }
                use.nextLine();
            } else if (currentDay == 17) {
            	stopAllLongSounds();
            	 play1();
            	 tiengchaokhach();
            	 
                System.out.println("🔊 [イベント]: 美容院で髪を切りたい。(Đi cắt tóc.)");
                System.out.println("1. 1000円カット");
                System.out.println("2. オシャレなサロン");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) { 
                    int loss = 1000 + rand.nextInt(401); balance -= loss; 
                    System.out.println("✂️ 美容師：はい、お疲れ様。10分でスッキリですね。");
                    System.out.println("✂️ Thợ cắt: Xong rồi em, nhanh gọn lẹ đúng 10 phút.");
                    play1();tiengtien(); 
                } else { 
                    int loss = 4000 + rand.nextInt(2001); balance -= loss; 
                    System.out.println("💇‍♂️ スタイリスト：この髪型、お客様の輪郭にすごく似合っていますよ。");
                    System.out.println("💇‍♂️ Stylist: Kiểu tóc này cực hợp với khuôn mặt của bạn luôn.");
                    play1();tiengtien(); 
                }
            } else if (currentDay == 18) {
            	stopAllLongSounds();
            	 play1();
                System.out.println("🔊 [イベント]: 部屋のエアコンが故障した！(Điều hòa hỏng!)");
                System.out.println("1. 修理代を払う");
                System.out.println("2. 根性で耐える");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) { 
                    int loss = 6500 + rand.nextInt(3001); balance -= loss; 
                    System.out.println("🛠️ 修理屋：これでまた涼しい風が出るようになりましたよ。");
                    System.out.println("🛠️ Thợ sửa: Máy chạy mát lạnh lại rồi nhé.");
                    play1();tiengtien(); 
                } else { 
                    System.out.println("🥵 自分：暑すぎる/寒すぎる…扇風機か布団で耐えるしかない。");
                    System.out.println("🥵 Bạn: Nóng/lạnh quá... Thôi bật quạt hoặc đắp chăn chịu đựng vậy."); 
                    play1();tiengtien();tiengquatgio();
                }
            } else if (currentDay == 19) {
            	stopAllLongSounds();
            	 play1();
                System.out.println("🔊 [イベント]: 競馬のG1レースがある。(Giải đua ngựa lớn.)");
                System.out.println("1. 馬券を買う");
                System.out.println("2. 見送る");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) {
                    int loss = 2500 + rand.nextInt(1001); balance -= loss;
                    if (rand.nextInt(4) == 0) { 
                        int gain = 10000 + rand.nextInt(10001); balance += gain; 
                        System.out.println("🐎 自分：選んだ馬が1着でゴール！素晴らしい！");
                        System.out.println("🐎 Bạn: Chú ngựa mình chọn đã bứt phá về nhất! Tuyệt vời!");
                        play1();tiengtien();
                    } else { 
                        System.out.println("🐎 自分：馬の走りが遅すぎた、賭け金が全部消えた。");
                        System.out.println("🐎 Bạn: Ngựa chạy chậm quá, mất sạch tiền cược.");
                        play1();tiengtien();
                    }
                } else { 
                    System.out.println("😎 自分：ギャンブルの衝動を抑えて、家に帰ろう。");
                    System.out.println("😎 Bạn: Kiềm chế cơn máu chiến lại, đi về."); 
                }
            } else if (currentDay == 20) {
            	stopAllLongSounds();
            	 play1();
                System.out.println("🔊 [イベント]: 家賃の更新月だったのを忘れていた！(Tháng gia hạn tiền nhà!)");
                System.out.print("Enterキーを押して支払う (Nhấn Enter để thanh toán)...");
                use.nextLine();
                int loss = 18000 + rand.nextInt(4001); balance -= loss; 
                System.out.println("🏠 大家さん：今月の家賃、確かに受け取りました。");
                System.out.println("🏠 Chủ nhà: Nhận tiền nhà tháng này của cháu nhé.");
                play1();tiengtien();
            } else if (currentDay == 21) {
            	stopAllLongSounds();
            	 play1();
            	 tiengve();
                System.out.println("🔊 [イベント]: カフェで勉強・作業をしたい。(Muốn vào quán cafe làm việc.)");
                System.out.println("1. スターバックス");
                System.out.println("2. マクドナルド");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) { 
                    int loss = 550 + rand.nextInt(201); balance -= loss; 
                    System.out.println("☕ 自分：お洒落な空間で、勉強のモチベーションが上がる。");
                    System.out.println("☕ Bạn: Không gian sang chảnh, có động lực học tập hẳn.");
                    play1();tiengtien(); 
                } else { 
                    int loss = 100 + rand.nextInt(51); balance -= loss; 
                    System.out.println("🍔 自分：安いコーヒーを頼んで作業するのも悪くない。");
                    System.out.println("🍔 Bạn: Gọi ly nước rẻ tiền ngồi làm bài cũng ổn.");
                    play1();tiengtien(); 
                }
            } else if (currentDay == 22) {
            	stopAllLongSounds();
            	 play1();
            	
                System.out.println("🔊 [イベント]: 突然の身内の結婚式！(Đi đám cưới người thân.)");
                System.out.println("1. 出席する");
                System.out.println("2. 欠席する");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) { 
                    int loss = 8000 + rand.nextInt(4001); balance -= loss; 
                    System.out.println("🎉 自分：ご結婚おめでとうございます！ご祝儀で大金が飛んでいった。");
                    System.out.println("🎉 Bạn: Chúc mừng hạnh phúc anh chị! Tiền mừng cưới bay mất một khoản.");
                    play1();tiengtien(); 
                } else { 
                    System.out.println("🤫 自分：勉強が忙しいと言い訳して、ご祝儀を節約した。");
                    System.out.println("🤫 Bạn: Viện cớ bận học để ở nhà đỡ tốn tiền mừng."); 
                    play1();tiengtien();
                }
            } else if (currentDay == 23) {
            	stopAllLongSounds();
            	 play1();
                System.out.println("🔊 [イベント]: ネットオークションでカードが売れた！(Bán được thẻ bài hiếm trên mạng!)");
                System.out.print("Enterキーを押して確認 (Nhấn Enter để kiểm tra)...");
                use.nextLine();
                int gain = 7000 + rand.nextInt(4001); balance += gain; 
                System.out.println("💰 自分：よかった、ワンピースのレアカードが高値で売れた。");
                System.out.println("💰 Bạn: May quá thanh lý được thẻ bài One Piece giá cao ngất.");
                play1();tiengtien();
            } else if (currentDay == 24) {
            	stopAllLongSounds();
            	 play1();
                System.out.println("🔊 [イベント]: 住民税の請求書が届いた。(Hóa đơn thuế cư trú.)");
                System.out.print("Enterキーを押して支払う (Nhấn Enter để thanh toán)...");
                use.nextLine();
                int loss = 4500 + rand.nextInt(1001); balance -= loss; 
                System.out.println("🏦 自分：国への納税義務を果たした。");
                System.out.println("🏦 Bạn: Đã hoàn thành nghĩa vụ đóng thuế cho nhà nước.");
                play1();tiengtien();
            } else if (currentDay == 25) {
            	stopAllLongSounds();
            	 play1();
            	
                System.out.println("🔊 [イベント]: 浅草観光に出かけた。(Đi chơi ở Asakusa.)");
                System.out.println("1. 食べ歩き (Mua đồ ăn vặt dọc đường)");
                System.out.println("2. 写真だけ撮る");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) { 
                    int loss = 2500 + rand.nextInt(1001); balance -= loss; 
                    System.out.println("🍡 自分：ここでの団子と抹茶は本当に美味しいな。");
                    System.out.println("🍡 Bạn: Bánh mochi với nước trà ở đây ngon tuyệt cú mèo.");
                    play1();tiengtien(); tiengan();
                } else { 
                    int loss = 300 + rand.nextInt(201); balance -= loss; 
                    System.out.println("📸 自分：雷門で写真を撮って帰るだけ。一銭もかからない。");
                    System.out.println("📸 Bạn: Check-in cổng sấm Kaminarimon xong đi về, không tốn đồng nào.");
                    play1();tiengtien(); tiengmayanh();
                }
            } else if (currentDay == 26) {
            	stopAllLongSounds();
            	 play1();
            	 tiengchuongdt();
            	
                System.out.println("🔊 [イベント]: 友人に金を貸してくれと言われた。(Bạn hỏi vay tiền.)");
                System.out.println("1. 5,000円貸す");
                System.out.println("2. 断る");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) {
                    int loss = 4000 + rand.nextInt(2001); balance -= loss;
                    if (rand.nextBoolean()) { 
                        int gain = loss + (1000 + rand.nextInt(2001)); balance += gain; 
                        System.out.println("😇 良い友：助けてくれてありがとう！お礼を乗せて返すよ！");
                        System.out.println("😇 Bạn tốt: Cảm ơn cậu đã cứu nguy! Trả cậu tiền gốc kèm tiền cafe nhé!");
                        play1();tiengtien();
                    } else { 
                        System.out.println("😈 悪い友：（おかけになった電話は現在使われておりません…）");
                        System.out.println("😈 Bạn xấu: (Thuê bao quý khách vừa gọi hiện không liên lạc được...)");
                        play1();tiengtien(); 
                    }
                } else { 
                    System.out.println("🙅‍♂️ 自分：僕も生活費が足りないんだ、ごめんね。");
                    System.out.println("🙅‍♂️ Bạn: Tiền mình còn không đủ sống, thông cảm nha bạn hiền."); 
                    play1();tiengtien();
                }
            } else if (currentDay == 27) {
            	stopAllLongSounds();
            	 play1();
            	 
            	
                System.out.println("🔊 [イベント]: コインランドリーで洗濯する。(Đi giặt đồ ở tiệm công cộng.)");
                System.out.println("1. 乾燥機まで使う (Sấy khô luôn)");
                System.out.println("2. 部屋干しにする (Mang về phòng phơi)");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) { 
                    int loss = 600 + rand.nextInt(401); balance -= loss; 
                    System.out.println("👕 自分：乾燥機を使うと服がふわふわで気持ちいい！");
                    System.out.println("👕 Bạn: Quần áo sấy xong thơm tho, mềm mại mặc thích liền.");
                     play1();tiengtien();tiengmaygiac();tiengmua();
                } else { 
                    int loss = 300 + rand.nextInt(201); balance -= loss; 
                    System.out.println("👕 自分：部屋の窓際に干した。少し湿気るけどタダだ。");
                    System.out.println("👕 Bạn: Mang về phòng treo đầy cửa sổ, hơi ẩm tí nhưng free.");
                    play1();tiengtien();tiengmaygiac();
                }
            } else if (currentDay == 28) {
            	stopAllLongSounds();
            	 play1();
            	 
                System.out.println("🔊 [イベント]: 近所のスーパーでタイムセール！(Siêu thị giảm giá giờ chót!)");
                System.out.println("1. 半額弁当を買う");
                System.out.println("2. スルーする");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) { 
                    int loss = 700 + rand.nextInt(601); balance -= loss; 
                    System.out.println("🍱 自分：争奪戦に勝って半額の寿司弁当をゲット！お得すぎる！");
                    System.out.println("🍱 Bạn: Tranh nhau mãi mới giật được hộp cơm sushi nửa giá, quá hời!");
                    play1();tiengtien();
                } else { 
                    System.out.println("🍱 自分：今日は人混みに行くのが面倒だから、いいや。");
                    System.out.println("🍱 Bạn: Nay lười ra ngoài chen lấn quá, nhịn."); 
                    play1();
                }
            } else if (currentDay == 29) {
            	stopAllLongSounds();
           	 play1(); 
           	
                System.out.println("🔊 [イベント]: 財布を落としてしまったかも！？(Hình như rơi mất ví!?)");
                System.out.print("Enterキーを押して確認 (Nhấn Enter để kiểm tra)...");
                use.nextLine();
                if (rand.nextBoolean()) {
                    int loss = 4000 + rand.nextInt(4001); balance -= loss; 
                    System.out.println("😭 自分：本当に落とした！財布の中の現金が消えてしまった。");
                    System.out.println("😭 Bạn: Mất thật rồi! Đống tiền mặt trong ví bay màu theo gió.");
                    play1();tiengtien();
                } else {
                    System.out.println("😮‍💨 自分：あーよかった！バッグの底にあっただけで、落としてなかった。");
                    System.out.println("😮‍💨 Bạn: Hú hồn! Hóa ra nằm dưới đáy balo chứ không mất.");
                    play1();tiengtien();
                }
            } else if (currentDay == 30) {
            	stopAllLongSounds();
            	 play1();
            	 
                System.out.println("🔊 [イベント]: ついに最終日！(Ngày cuối cùng rồi!)");
                System.out.println("1. 贅沢豪華ディナー (Ăn mừng hoành tráng)");
                System.out.println("2. 質素に過ごす (Tiết kiệm đến cùng)");
                System.out.print("選択 (Lựa chọn): ");
                if (use.nextLine().equals("1")) { 
                    int loss = 8000 + rand.nextInt(4001); balance -= loss; 
                    System.out.println("🥂 自分：東京で30日間生き延びた！豪華にお祝いしよう！");
                    System.out.println("🥂 Bạn: Sống sót qua 30 ngày tại Tokyo! Phải tự thưởng một bữa ra trò!");
                    play1();tiengtien(); 
                } else { 
                    int loss = 400 + rand.nextInt(301); balance -= loss; 
                    System.out.println("🍜 自分：もうすぐクリアだ、最後はカップ麺で確実に締めくくろう。");
                    System.out.println("🍜 Bạn: Sắp ăn mừng chiến thắng rồi, ăn gói mì gói chốt hạ cho chắc ăn.");
                    play1();tiengtien();
                }
            }

            // --- KIỂM TRA GAME OVER ---
            if (balance <= 0) {
                stopAllLongSounds(); 
                tiengthua();         
                System.out.println("\n💀💀💀 【ゲームオーバー / GAME OVER】 💀💀💀");
                return; 
            }

            if (currentDay < totalDays) {
                System.out.print("\nEnterキーを押して次の日へ...");
                use.nextLine();
            }
            currentDay++; 
        }

        // --- CHIẾN THẮNG ---
        stopAllLongSounds(); 
        tiengwin();          
        System.out.println("\n🎉🎉🎉 【ゲームクリア / VICTORY】 🎉🎉🎉");
    }

    // --- HÀM ĐIỀU KHIỂN HỆ THỐNG ÂM THANH NỀN & EFFECT ---
    public static void stopEventSound() {
        if (eventSoundPlayer != null) {
            try { eventSoundPlayer.close(); } catch (Exception e) {}
            eventSoundPlayer = null;
        }
    }

    public static void stopAllLongSounds() {
        stopEventSound();
        if (bgmPlayer != null) { try { bgmPlayer.close(); } catch(Exception e){} bgmPlayer = null; }
        if (environmentPlayer != null) { try { environmentPlayer.close(); } catch(Exception e){} environmentPlayer = null; }
    }

    public static void play1() {
        if (bgmPlayer != null) return; 
        new Thread(() -> {
            try {
                bgmPlayer = new Player(new FileInputStream("asriel.mp3"));
                bgmPlayer.play();
            } catch (Exception e) {}
        }).start();
    }

    public static void amthanhmoitruog() {
        if (environmentPlayer != null) return; 
        new Thread(() -> {
            try {
                environmentPlayer = new Player(new FileInputStream("u_md6l89el2t-shinjuku-station-176549.mp3"));
                environmentPlayer.play();
            } catch (Exception e) {}
        }).start();
    }

    public static void backgr() {
        new Thread(() -> {
            try {
                if (bgmPlayer != null) bgmPlayer.close();
                bgmPlayer = new Player(new FileInputStream("freesound_community-8bit-music-for-game-68698.mp3"));
                bgmPlayer.play();
            } catch (Exception e) {}
        }).start();
    }

    public static void tiengmua() {
        stopEventSound(); 
        new Thread(() -> {
            try {
                eventSoundPlayer = new Player(new FileInputStream("kanematsutei-the-sound-of-raindrops-falling-145347.mp3"));
                eventSoundPlayer.play();
            } catch (Exception e) {}
        }).start();
    }

    public static void tiengthitnuong() {
        stopEventSound(); 
        new Thread(() -> {
            try {
                eventSoundPlayer = new Player(new FileInputStream("floraphonic-frying-pan-hot-sizzle-bacon-1-177978.mp3"));
                eventSoundPlayer.play();
            } catch (Exception e) {}
        }).start();
    }

    public static void tiengtien() {
        new Thread(() -> { try { new Player(new FileInputStream("u_oepgi4ep3v-som_matricula-464025.mp3")).play(); } catch (Exception e) {} }).start();
    }

    public static void erro() {
        new Thread(() -> { try { new Player(new FileInputStream("humordome-error-beep-453357.mp3")).play(); } catch (Exception e) {} }).start();
    }

    public static void tiengdangnhap() {
        new Thread(() -> { try { new Player(new FileInputStream("freesound_community-game-start-6104.mp3")).play(); } catch (Exception e) {} }).start();
    }

    public static void tiengthua() {
        stopAllLongSounds(); 
        new Thread(() -> { try { new Player(new FileInputStream("soundreality-riser-wildfire-285209.mp3")).play(); } catch (Exception e) {} }).start();
    }

    public static void tiengwin() {
        stopAllLongSounds(); 
        new Thread(() -> { try { new Player(new FileInputStream("mrstokes302-you-win-sfx-mrstokes302-442128.mp3")).play(); } catch (Exception e) {} }).start();
    }

    public static void tiengga() {
        stopEventSound(); 
        new Thread(() -> {
            try {
                eventSoundPlayer = new Player(new FileInputStream("freesound_community-012594_tokyo-58352.mp3"));
                eventSoundPlayer.play();
            } catch (Exception e) {}
        }).start();
    }

    public static void tiengcuahantienloi() {
        stopEventSound(); 
        new Thread(() -> {
            try {
                eventSoundPlayer = new Player(new FileInputStream("ssstik.io_1780471331606.mp3"));
                eventSoundPlayer.play();
            } catch (Exception e) {}
        }).start();
    }public static void tiengdtroi() {
        new Thread(() -> { try { new Player(new FileInputStream("tieng_do_vat_roi_tu_tren_cao_xuong-www_tiengdong_com.mp3")).play(); } catch (Exception e) {} }).start();
    }
    public static void tiengxeco() {
        new Thread(() -> { try { new Player(new FileInputStream("tieng_xe_co_ngoai_duong_duong_pho-www_tiengdong_com.mp3")).play(); } catch (Exception e) {} }).start();
    }
    public static void tiengcoicachsat() {
        new Thread(() -> { try { new Player(new FileInputStream("11325622-police-siren-sound-effect-240674.mp3")).play(); } catch (Exception e) {} }).start();
    }
    public static void tiengshopping() {
        new Thread(() -> { try { new Player(new FileInputStream("freesound_community-shopping-centre-24655.mp3")).play(); } catch (Exception e) {} }).start();
    }
    public static void tienbongden() {
        new Thread(() -> { try { new Player(new FileInputStream("freesound_community-led_mixing_with_moonlight-24965.mp3")).play(); } catch (Exception e) {} }).start();
}public static void tiengnuoc() {
    new Thread(() -> { try { new Player(new FileInputStream("mayankchawda-water-333590.mp3")).play(); } catch (Exception e) {} }).start();
}
public static void tiengbr() {
    new Thread(() -> { try { new Player(new FileInputStream("dragon-studio-spooky-chimes-359878.mp3")).play(); } catch (Exception e) {} }).start();
    }public static void tiengchuongdt() {
        new Thread(() -> { try { new Player(new FileInputStream("dragon-studio-phone-ringing-382734.mp3")).play(); } catch (Exception e) {} }).start();
}
    public static void tiengho() {
        new Thread(() -> { try { new Player(new FileInputStream("Am_thanh_tieng_ho-www_tiengdong_com.mp3")).play(); } catch (Exception e) {} }).start();
}public static void tiengcoixedap() {
    new Thread(() -> { try { new Player(new FileInputStream("tieng_coi_xe_Dap-www_tiengdong_com.mp3")).play(); } catch (Exception e) {} }).start();
}public static void tiengquangan() {
    new Thread(() -> { try { new Player(new FileInputStream("freesound_community-loud_japanese_diner_full_of_drunk_people_120-90surround-24312.mp3")).play(); } catch (Exception e) {} }).start();
}public static void tiengchaokhach() {
    new Thread(() -> { try { new Player(new FileInputStream("「いらっしゃいませ！」.mp3")).play(); } catch (Exception e) {} }).start();}
public static void tiengvodo() {
    new Thread(() -> { try { new Player(new FileInputStream("tieng_kinh_vo-www_tiengdong_com.mp3")).play(); } catch (Exception e) {} }).start();}
public static void tiengquatgio() {
    new Thread(() -> { try { new Player(new FileInputStream("tieng_quat_gio_keu-www_tiengdong_com.mp3")).play(); } catch (Exception e) {} }).start();}
public static void tiengve() {
    new Thread(() -> { try { new Player(new FileInputStream("tieng_ve_keu-www_tiengdong_com.mp3")).play(); } catch (Exception e) {} }).start();}
public static void tiengdamcuoi() {
    new Thread(() -> { try { new Player(new FileInputStream("tieng_vo_tay_khan_gia-www_tiengdong_com.mp3")).play(); } catch (Exception e) {} }).start();}
public static void tiengan() {
    new Thread(() -> { try { new Player(new FileInputStream("Am_thanh_uong_nuoc_nuot_thuc_an-www_tiengdong_com.mp3")).play(); } catch (Exception e) {} }).start();}
public static void tiengmayanh() {
    new Thread(() -> { try { new Player(new FileInputStream("Am_thanh_tieng_man_trap_may_anh-www_tiengdong_com.mp3")).play(); } catch (Exception e) {} }).start();}
public static void tiengmaygiac() {
    new Thread(() -> { try { new Player(new FileInputStream("tieng_may_giat_van_hanh_hoat_dong-www_tiengdong_com.mp3")).play(); } catch (Exception e) {} }).start();}

}


