package robotium.test;

import robotium.test.shared.AndroMoneyAccountClasses;
import robotium.test.shared.AndroMoneyAccountNames;
import robotium.test.shared.AndroMoneyMenuTitles;
import robotium.test.shared.AndroMoneyPlaceholders;
import robotium.test.shared.AndroMoneyTransactionTypes;
import robotium.test.shared.AvoidStartingPages;
import android.view.KeyEvent;
import android.view.View;

public class AMAT_13 extends BaseInstrumentationTest {
	
	protected void setUp() {
		super.setUp();
	}
	
	public void testExportRecordsToDevices() throws InterruptedException {
		AvoidStartingPages.toDo(solo);
		
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		//輸入帳戶名稱
		solo.enterText(0, AndroMoneyAccountNames.MY_CASH);
		//輸入金額[9517]
		solo.clickOnEditText(1);
		//點擊數字鍵[9]
		view = solo.getView("button_9");
		solo.clickOnView(view);
		//點擊數字鍵[5]
		view = solo.getView("button_5");
		solo.clickOnView(view);
		//點擊數字鍵[1]
		view = solo.getView("button_1");
		solo.clickOnView(view);
		//點擊數字鍵[7]
		view = solo.getView("button_7");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		
		//對帳戶[現金]新增一筆收入
		//點擊帳戶[現金]
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.waitForText(AndroMoneyTransactionTypes.OUTGOING);
		//點選tab[支出]
		solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
		//輸入金額[100]
		//點擊數字鍵[1]
		solo.clickOnButton("1");
		//點擊數字鍵[0]兩次
		solo.clickOnButton("0");
		solo.clickOnButton("0");
		//確定輸入金額
		solo.clickOnButton("OK");
		solo.waitForText("存入");
		solo.clickOnText("存入");
		//返回帳戶[現金]資訊頁面
		solo.waitForText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.DEFAULT_CASH);
		assertTrue(solo.searchText("NT\\$ -100.00"));
		
		//返回帳戶頁面
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		
		//對帳戶[銀行]新增一筆收入
		//點擊帳戶[銀行]
		solo.waitForText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.waitForText(AndroMoneyTransactionTypes.INCOME);
		//點選tab[收入]
		solo.clickOnText(AndroMoneyTransactionTypes.INCOME);
		//輸入金額[753]
		//點擊數字鍵[7]
		solo.clickOnButton("7");
		//點擊數字鍵[5]
		solo.clickOnButton("5");
		//點擊數字鍵[3]
		solo.clickOnButton("3");
		//確定輸入金額
		solo.clickOnButton("OK");
		solo.waitForText("存入");
		solo.clickOnText("存入");
		//返回帳戶[銀行]資訊頁面
		solo.waitForText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.DEFAULT_BANK);
		assertTrue(solo.searchText("NT\\$ 753.00"));
		
		//返回帳戶頁面
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		
		//對新的帳戶新增一筆轉帳
		//點擊新的帳戶
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		solo.clickOnText(AndroMoneyAccountNames.MY_CASH);
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.waitForText(AndroMoneyTransactionTypes.TRANSFER);
		//點選tab[轉帳]
		solo.clickOnText(AndroMoneyTransactionTypes.TRANSFER);
		//輸入金額[426]
		//點擊數字鍵[4]
		solo.clickOnButton("4");
		//點擊數字鍵[2]
		solo.clickOnButton("2");
		//點擊數字鍵[6]
		solo.clickOnButton("6");
		//確定輸入金額
		solo.clickOnButton("OK");
		//選擇轉出帳戶
		solo.clickOnText("從：");//clickInList reference:http://blog.denevell.org/android-instrumentation-click-list.html 
		//跳至帳戶列表
		//選擇新的帳戶
		solo.waitForText("長按修改");
		solo.clickOnText(AndroMoneyAccountNames.MY_CASH);
		//選擇轉入帳戶
		solo.clickOnText("到：");
		//跳至帳戶列表
		//選擇帳戶[信用卡]
		solo.waitForText("長按修改");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.waitForText("存入");
		solo.clickOnText("存入");
		//返回帳戶[信用卡]資訊頁面
		solo.waitForText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		assertTrue(solo.searchText("NT\\$ 9,091.00"));
		
		//返回帳戶頁面
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		
		//回到選單
		view = solo.getView("up");
		solo.clickOnView(view);
		view = solo.getView("up");
		solo.clickOnView(view);
		
		//選擇[匯入（出）]
		solo.waitForText(AndroMoneyMenuTitles.IMPORT_EXPORT);
		solo.clickOnText(AndroMoneyMenuTitles.IMPORT_EXPORT);
		solo.waitForText(AndroMoneyMenuTitles.IMPORT_EXPORT);
		//選擇[備份資料庫]
		solo.clickOnText("備份資料庫");
		solo.waitForText("備份資料庫");
		//選擇[備份至內部空間]
		solo.clickOnText("備份至內部空間");
		//確定備份
		if(solo.searchText("溫馨提醒"))
			solo.clickOnButton("確定");
		//回到當日交易紀錄頁面
		view = solo.getView("up");
		solo.clickOnView(view);
		
		//點擊第一筆
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText("詳細資料"));
		//點擊刪除按鈕
		solo.clickOnScreen(730, 90);//only for nexus7 portrait
		solo.waitForText("確定要刪除?");
		solo.clickOnButton("確定");
		
		//點擊第二筆
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("詳細資料", 1, 5000);
		//點擊刪除按鈕
		solo.clickOnScreen(730, 90);//only for nexus7 portrait
		solo.waitForText("確定要刪除?");
		solo.clickOnButton("確定");
		//點擊選單[帳戶]
		view = solo.getView("up");
		solo.clickOnView(view);
		solo.waitForText(AndroMoneyMenuTitles.ACCOUNT);
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		
		//長按帳戶名稱，刪除新的帳戶
		solo.clickLongOnText(AndroMoneyAccountNames.MY_CASH);
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		solo.clickOnText("刪除");
		//確定刪除帳戶
		solo.clickOnButton("確定");
		//確定刪除帳戶所有紀錄
		solo.clickOnButton("是");
		assertFalse(solo.searchText(AndroMoneyAccountNames.MY_CASH));
		
		//回到當日交易紀錄畫面
		view = solo.getView("up");
		solo.clickOnView(view);
		solo.waitForText("日", 1, 5000);
		assertTrue(solo.searchText("日"));
		
		
		view = solo.getView("up");
		solo.clickOnView(view);
		//選擇[匯入（出）]
		solo.clickOnText(AndroMoneyMenuTitles.IMPORT_EXPORT);
		solo.waitForText(AndroMoneyMenuTitles.IMPORT_EXPORT);
		//選擇[還原資料庫]
		solo.clickOnText("還原資料庫");
		solo.waitForText("還原資料庫");
		//選擇[從內部空間還原]
		solo.clickOnText("從內部空間還原");
		//確定還原
		if(solo.searchText("溫馨提醒"))
			solo.clickOnButton("確定");
		
		//回到當日交易紀錄
		view = solo.getView("up");
		solo.clickOnView(view);
		//驗證第一筆資料
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		assertTrue(solo.searchText("NT\\$ 100"));
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//驗證第二筆資料
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
		assertTrue(solo.searchText("NT\\$ 753"));
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//驗證第三筆資料
		solo.clickOnText(AndroMoneyAccountNames.MY_CASH);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText(AndroMoneyAccountNames.MY_CASH));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		assertTrue(solo.searchText("NT\\$ 426"));
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		
		//點擊選單[帳戶]
		view = solo.getView("up");
		solo.clickOnView(view);
		
		solo.waitForText(AndroMoneyMenuTitles.ACCOUNT);
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.clickLongOnText(AndroMoneyAccountNames.MY_CASH);
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		assertTrue(solo.searchText(AndroMoneyAccountNames.MY_CASH));
		assertTrue(solo.searchText(AndroMoneyAccountClasses.CASH));
		
		solo.sendKey(KeyEvent.KEYCODE_BACK);
	}
	
	protected void tearDown() {
		
		
		//長按帳戶名稱，刪除新的帳戶
		solo.clickLongOnText(AndroMoneyAccountNames.MY_CASH);
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		solo.clickOnText("刪除");
		//確定刪除帳戶
		solo.clickOnButton("確定");
		//確定刪除帳戶所有紀錄
		solo.clickOnButton("是");
		assertFalse(solo.searchText(AndroMoneyAccountNames.MY_CASH));
		
		//回到當日交易紀錄畫面
		View view = solo.getView("up");
		solo.clickOnView(view);
		solo.waitForText("日", 1, 5000);
		assertTrue(solo.searchText("日"));
		//點擊第一筆
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText("詳細資料"));
		//點擊刪除按鈕
		solo.clickOnScreen(730, 90);//only for nexus7 portrait
		solo.waitForText("確定要刪除?");
		solo.clickOnButton("確定");
		
		//點擊第二筆
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("詳細資料", 1, 5000);
		//點擊刪除按鈕
		solo.clickOnScreen(730, 90);//only for nexus7 portrait
		solo.waitForText("確定要刪除?");
		solo.clickOnButton("確定");
		
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		view = solo.getView("up");
		solo.clickOnView(view);
		solo.waitForText(AndroMoneyMenuTitles.ACCOUNT, 1, 5000);
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyMenuTitles.ACCOUNT, 1, 5000);
		solo.waitForText(AndroMoneyAccountNames.DEFAULT_CASH);	
		super.tearDown();
	}
}
