package robotium.test;

import robotium.test.shared.AndroMoneyAccountClasses;
import robotium.test.shared.AndroMoneyAccountNames;
import robotium.test.shared.AndroMoneyMenuTitles;
import robotium.test.shared.AndroMoneyPlaceholders;
import robotium.test.shared.AndroMoneyTransactionTypes;
import robotium.test.shared.AvoidStartingPages;
import robotium.test.shared.KeyboardHelper;
import android.view.KeyEvent;
import android.view.View;

public class AMAT_10 extends BaseInstrumentationTest {

	protected void setUp() {
		super.setUp();
	}
	
	public void testAddCashAccountWithNegativeIntegerAmount() {
AvoidStartingPages.toDo(solo);
		
		//solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		//solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
		//產生一筆支出
		//輸入金額 5533
		//solo.clickOnButton("5");
		//solo.clickOnButton("5");
		//solo.clickOnButton("3");
		//solo.clickOnButton("3");
		//solo.clickOnButton("OK");
		/*solo.clickOnText("類別：");
		solo.clickOnText("餐飲食品");
		solo.clickOnText("早餐");
		solo.clickOnText("帳戶：");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.clickOnText("專案：");
		solo.clickOnText("無");
		solo.clickOnText("商家：");
		solo.clickOnText("無");
		solo.clickOnText("週期：");
		solo.clickOnText("一次");
		solo.clickOnButton("確定");
		solo.clickOnText("備註：");
		solo.clickOnButton("確定");*/
		//solo.clickOnButton("存入");
		//solo.waitForText(" 5,533");
		//solo.waitForText(" 5");
		
		//solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		//solo.waitForText("詳細資料", 1, 5000);
		//assertTrue(solo.searchText("5,533"));
		//assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		//assertTrue(solo.searchText("餐飲食品 - 早餐"));	
		
		//修改支出
		solo.clickOnText("餐飲食品 - 早餐");
		solo.waitForDialogToOpen();
		solo.clickLongOnText("修改");
	
		//solo.clickOnButton("複製");
		//solo.clickOnImageButton(0);
		/*
		solo.clickOnText("類別：");
		solo.clickOnText("服飾美容");
		solo.clickOnText("配件");
		solo.clickOnText("帳戶：");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.clickOnText("專案：");
		solo.clickOnText("個人");
		solo.clickOnText("商家：");
		solo.clickOnText("星巴克");
		solo.clickOnText("週期：");
		solo.clickOnText("一次");
		solo.clickOnButton("確定");
		solo.clickOnText("備註：");
		solo.enterText(0, "This is Edit."); 
		solo.clickOnButton("確定");
		solo.clickOnButton("存入");
		solo.waitForText(" 5,533");*/
		
	}

	protected void tearDown() {
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//刪除帳戶
		View view = solo.getView("button_delete");
		solo.clickOnView(view);
		solo.clickOnButton("確定");
		solo.clickOnButton("是");
		solo.waitForText(
							AndroMoneyPlaceholders.ADD_ACCOUNT,
							1,
							5000
						);
		super.tearDown();
	}

}
