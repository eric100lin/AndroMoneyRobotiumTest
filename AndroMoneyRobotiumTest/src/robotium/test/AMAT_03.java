package robotium.test;

import robotium.test.shared.AndroMoneyAccountClasses;
import robotium.test.shared.AndroMoneyAccountNames;
import robotium.test.shared.AndroMoneyMenuTitles;
import robotium.test.shared.AndroMoneyPlaceholders;
import robotium.test.shared.AndroMoneyToastMessages;
import robotium.test.shared.AndroMoneyTransactionTypes;
import robotium.test.shared.AvoidStartingPages;
import android.view.KeyEvent;
import android.view.View;

public final class AMAT_03 extends BaseInstrumentationTest {
	
	protected void setUp() {
		super.setUp();
	}
	
	public void testDeleteDefaultExistedCashAccountWithoutItsTransactions() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//進入帳戶列表
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		assertTrue(solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		assertTrue(solo.searchText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		
		//進入[現金]帳戶資訊頁面
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		assertTrue(solo.waitForText(AndroMoneyAccountNames.DEFAULT_CASH) & 
					solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION));
		//[現金]帳戶目前金額為0.00
		assertTrue(solo.searchText("NT\\$ 0.00"));
		//新增一筆交易資料到[現金]帳戶
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		//進入新增交易資料頁面
		assertTrue(solo.waitForText(AndroMoneyTransactionTypes.OUTGOING) &
					solo.waitForText(AndroMoneyTransactionTypes.INCOME) &
					solo.waitForText(AndroMoneyTransactionTypes.TRANSFER));
		assertTrue(solo.searchText(AndroMoneyTransactionTypes.OUTGOING) &
					solo.searchText(AndroMoneyTransactionTypes.INCOME) &
					solo.searchText(AndroMoneyTransactionTypes.TRANSFER));
		//新增一筆[支出]
		solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
		//輸入交易金額[643]
		solo.clickOnButton("6");
		solo.clickOnButton("4");
		solo.clickOnButton("3");
		//確定輸入金額
		solo.clickOnButton("OK");
		solo.waitForText("存入");
		solo.clickOnText("存入");
		//回到[現金]帳戶資訊頁面
		assertTrue(solo.waitForText(AndroMoneyAccountNames.DEFAULT_CASH) & 
					solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION));
		//[現金]帳戶目前金額為-643
		assertTrue(solo.searchText("NT\\$ -643.00"));
		
		//返回帳戶列表
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		assertTrue(solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		assertTrue(solo.searchText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		solo.clickLongOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		//彈出修改/刪除視窗
		assertTrue(solo.waitForText("\\[" + AndroMoneyAccountClasses.CASH + "\\]"
										+ AndroMoneyAccountNames.DEFAULT_CASH));
		assertTrue(solo.searchText("\\[" + AndroMoneyAccountClasses.CASH + "\\]"
										+ AndroMoneyAccountNames.DEFAULT_CASH));
		//點選刪除
		solo.clickOnText("刪除");
		assertTrue(solo.waitForText("是否確定刪除"));
		assertTrue(solo.searchText("是否確定刪除"));
		solo.clickOnButton("確定");
		assertTrue(solo.waitForText("將帳戶內所有紀錄刪除"));
		assertTrue(solo.searchText("將帳戶內所有紀錄刪除"));
		solo.clickOnButton("否");
		//確認toast訊息
		assertTrue(solo.searchText(AndroMoneyToastMessages.SUCCESS_DELETE_ACCOUNT));
		
		//回到當日交易紀錄頁面
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		assertTrue(solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION));
		assertTrue(solo.searchText(AndroMoneyPlaceholders.ADD_TRANSACTION));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		assertTrue(solo.searchText("NT\\$ 643"));
	}
	
	protected void tearDown() {
		
		//recovery
		
		//刪除新增交易資料
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText("詳細資料"));
		//點擊刪除按鈕
		solo.clickOnScreen(730, 90);//only for nexus7 portrait
		solo.waitForText("確定要刪除?");
		solo.clickOnButton("確定");
		
		//點擊左側選單按鈕
		View view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//進入帳戶列表
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		assertTrue(solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		assertTrue(solo.searchText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		//新增帳戶[現金]
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		//輸入帳戶名稱
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CASH);
		solo.clickOnButton("確定");
		//確認Toast訊息
		assertTrue(solo.searchText(AndroMoneyToastMessages.SUCCES_ADD_ACCOUNT_HEADING));
		
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		super.tearDown();
	}
}
