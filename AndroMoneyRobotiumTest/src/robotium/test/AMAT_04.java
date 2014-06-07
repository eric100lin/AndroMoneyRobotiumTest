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

public final class AMAT_04 extends BaseInstrumentationTest {

	protected void setUp() {
		super.setUp();
	}
	
	public void testDeleteLastAccountAndItsTransactions() {
		
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
		
		//刪除帳戶[銀行]
		assertTrue(solo.waitForText(AndroMoneyAccountNames.DEFAULT_BANK));
		solo.clickLongOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		//彈出修改/刪除視窗
		assertTrue(solo.waitForText("\\[" + AndroMoneyAccountClasses.BANK + "\\]"
										+ AndroMoneyAccountNames.DEFAULT_BANK));
		assertTrue(solo.searchText("\\[" + AndroMoneyAccountClasses.BANK + "\\]"
										+ AndroMoneyAccountNames.DEFAULT_BANK));
		//點選刪除
		solo.clickOnText("刪除");
		assertTrue(solo.waitForText("是否確定刪除"));
		assertTrue(solo.searchText("是否確定刪除"));
		solo.clickOnButton("確定");
		assertTrue(solo.waitForText("將帳戶內所有紀錄刪除"));
		assertTrue(solo.searchText("將帳戶內所有紀錄刪除"));
		solo.clickOnButton("是");
		assertFalse(solo.waitForText(AndroMoneyAccountNames.DEFAULT_BANK));
		
		//刪除帳戶[信用卡]
		assertTrue(solo.waitForText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		solo.clickLongOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		//彈出修改/刪除視窗
		assertTrue(solo.waitForText("\\[" + AndroMoneyAccountClasses.CREDIT + "\\]"
										+ AndroMoneyAccountNames.DEFAULT_CREDIT));
		assertTrue(solo.searchText("\\[" + AndroMoneyAccountClasses.CREDIT + "\\]"
										+ AndroMoneyAccountNames.DEFAULT_CREDIT));
		
		//點選刪除
		solo.clickOnText("刪除");
		assertTrue(solo.waitForText("是否確定刪除"));
		assertTrue(solo.searchText("是否確定刪除"));
		solo.clickOnButton("確定");
		assertTrue(solo.waitForText("將帳戶內所有紀錄刪除"));
		assertTrue(solo.searchText("將帳戶內所有紀錄刪除"));
		solo.clickOnButton("是");
		assertFalse(solo.waitForText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		
		
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
		solo.clickOnButton("是");
		//確認toast訊息[僅剩一項無法刪除]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_DELETE_THE_LAST_ACCOUNT));
		
		
		//帳戶仍在
		assertTrue(solo.waitForText(AndroMoneyAccountNames.DEFAULT_CASH));
		//交易紀錄仍在
		//回到當日交易紀錄頁面
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		assertTrue(solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION));
		assertTrue(solo.searchText(AndroMoneyPlaceholders.ADD_TRANSACTION));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		assertTrue(solo.searchText("NT\\$ 643"));
	}
	
	protected void tearDown() {
		
		//recovery
		//點擊左側選單按鈕
		View view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//進入帳戶列表
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		assertTrue(solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		assertTrue(solo.searchText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		//新增帳戶[銀行]
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.BANK);
		//輸入帳戶名稱
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_BANK);
		solo.clickOnButton("確定");
		//確認Toast訊息
		assertTrue(solo.searchText(AndroMoneyToastMessages.SUCCES_ADD_ACCOUNT_HEADING));
		
		//新增帳戶[信用卡]
		assertTrue(solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CREDIT);
		//輸入帳戶名稱
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.clickOnButton("確定");
		//確認Toast訊息
		assertTrue(solo.searchText(AndroMoneyToastMessages.SUCCES_ADD_ACCOUNT_HEADING));
		
		//回到交易紀錄
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//刪除新增的交易紀錄
		assertTrue(solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION));
		assertTrue(solo.searchText(AndroMoneyPlaceholders.ADD_TRANSACTION));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		assertTrue(solo.searchText("NT\\$ 643"));
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText("詳細資料"));
		//點擊刪除按鈕
		solo.clickOnScreen(730, 90);//only for nexus7 portrait
		solo.waitForText("確定要刪除?");
		solo.clickOnButton("確定");
		
		super.tearDown();
	}
}
