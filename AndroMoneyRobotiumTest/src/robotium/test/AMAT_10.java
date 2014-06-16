package robotium.test;

import robotium.test.shared.AndroMoneyAccountClasses;
import robotium.test.shared.AndroMoneyAccountNames;
import robotium.test.shared.AndroMoneyMenuTitles;
import robotium.test.shared.AndroMoneyPlaceholders;
import robotium.test.shared.AndroMoneyTransactionTypes;
import robotium.test.shared.AvoidStartingPages;
import robotium.test.shared.KeyboardHelper;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

public class AMAT_10 extends BaseInstrumentationTest {

	protected void setUp() {
		super.setUp();
	}
	
	public void DefaultNew()
	{
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
		//產生一筆支出
		//輸入金額 5533
		solo.clickOnButton("5");
		solo.clickOnButton("5");
		solo.clickOnButton("3");
		solo.clickOnButton("3");
		solo.clickOnButton("OK");
		solo.clickOnText("類別：");
		solo.clickOnText("餐飲食品");
		solo.scrollListToTop(1);
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
		solo.clickOnButton("確定");
		solo.clickOnButton("存入");
		solo.waitForText(" 5,533");
	}
	
	public void editContent()
	{

		solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
		solo.clickOnText("5533");
		
		solo.clickOnButton("AC");
		solo.clickOnButton("6");
		solo.clickOnButton("0");
		solo.clickOnButton("2");
		solo.clickOnButton("3");
		solo.clickOnButton("OK");
		
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
	}
	public void testEditDefaultAccountWithDefaultTransactionInMainpage() {
		AvoidStartingPages.toDo(solo);
		
		DefaultNew();
		//修改支出
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("詳細資料");
		
		clickOnDialogButton("修改");
		
		editContent();
		
		solo.clickOnButton("確定");
		solo.clickOnButton("存入");
		
		//Check
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.waitForText("詳細資料");
		assertTrue(solo.searchText("6,023"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		assertTrue(solo.searchText("服飾美容 - 配件"));	
		assertTrue(solo.searchText("個人"));
		assertTrue(solo.searchText("星巴克"));
		assertTrue(solo.searchText("This is Edit."));
		
		//確認後刪除
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.waitForText("詳細資料");
		clickOnDialogButton(solo.getImageButton(0).getId()); //刪除Button
		solo.clickOnButton("確定");
		assertFalse(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		
		
	}
	
	public void testEditDefaultAccountWithDefaultTransactionInAccountpage() {
		AvoidStartingPages.toDo(solo);
		
		DefaultNew();
		
		jumpToAccountPage();
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		//修改支出
		solo.clickOnText("餐飲");
		solo.waitForText("詳細資料");
		
		clickOnDialogButton("修改");
		
		editContent();
		
		solo.clickOnButton("確定");
		solo.clickOnButton("存入");
		
		//回到MainPage
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		
		//Check
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.waitForText("詳細資料");
		assertTrue(solo.searchText("6,023"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		assertTrue(solo.searchText("服飾美容 - 配件"));	
		assertTrue(solo.searchText("個人"));
		assertTrue(solo.searchText("星巴克"));
		assertTrue(solo.searchText("This is Edit."));
		
		//確認後刪除
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.waitForText("詳細資料");
		clickOnDialogButton(solo.getImageButton(0).getId()); //刪除Button
		solo.clickOnButton("確定");
		assertFalse(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		
		
	}
	
	protected void clear(String text)
	{
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		while(solo.searchText(text))
		{
			solo.clickOnText(text);
			solo.waitForText("詳細資料");
			clickOnDialogButton(solo.getImageButton(0).getId()); //刪除Button
			solo.clickOnButton("確定");
		}
	}
	
	protected void tearDown() {
		
		clear(AndroMoneyAccountNames.DEFAULT_CASH);
		clear(AndroMoneyAccountNames.DEFAULT_CREDIT);
		clear(AndroMoneyAccountNames.DEFAULT_BANK);
		
		super.tearDown();
	}

}
