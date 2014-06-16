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
	
	public void editMoney(int i)
	{
		solo.clickOnButton(1); //數入金額BUTTON
		solo.clickOnButton("AC");
		
		switch(i)
		{
		case 0:
			solo.clickOnButton("6");
			solo.clickOnButton("0");
			solo.clickOnButton("2");
			solo.clickOnButton("3");
			break;
		case 1:
			solo.clickOnButton("-");
			solo.clickOnButton("5");
			solo.clickOnButton("2");
			solo.clickOnButton("3");
			solo.clickOnButton("0");
			break;
		case 2:
			solo.clickOnButton("9");
			solo.clickOnButton("．");
			solo.clickOnButton("7");
			solo.clickOnButton("4");
			break;
		case 3:
			solo.clickOnButton("-");
			solo.clickOnButton("8");
			solo.clickOnButton("．");
			solo.clickOnButton("2");
			solo.clickOnButton("5");
			break;
		case 4:
			solo.clickOnButton("0");
			break;
		case 5:
			break;
		}
		solo.clickOnButton("OK");
	}
	
	public void editAccount(int i)
	{
		switch(i)
		{
		case 0:
			solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
			break;
		case 1:
			solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
			break;
		case 2:
			solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
			break;
		}
		
	}
	
	public void editMemo(int i)
	{
		solo.clickOnText("備註：");
		switch(i)
		{
		case 0:
			solo.enterText(0, "This is Edit.");
			break;
		case 1:
			solo.clearEditText(0);
			break;
		}
		solo.clickOnButton("確定");
	}
	
	public void editContent(int moneyid,int accountid,int textid)
	{

		solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
		
		editMoney(moneyid);

		solo.clickOnText("類別：");
		solo.clickOnText("服飾美容");
		solo.clickOnText("配件");
		
		solo.clickOnText("帳戶：");
		editAccount(accountid);
		
		solo.clickOnText("專案：");
		solo.clickOnText("個人");
		
		solo.clickOnText("商家：");
		solo.clickOnText("星巴克");
		
		solo.clickOnText("週期：");
		solo.clickOnText("一次");
		solo.clickOnButton("確定");
		
		editMemo(textid);
	}
	
	public void checkMoney(int i)
	{
		switch(i)
		{
		case 0:
			assertTrue(solo.searchText("6,023"));
			break;
		case 1:
			assertTrue(solo.searchText("-5,230"));
			break;
		case 2:
			assertTrue(solo.searchText("9.74"));
			break;
		case 3:
			assertTrue(solo.searchText("-8.25"));
			break;
		case 4:
			assertTrue(solo.searchText("0"));
			break;
		case 5:
			assertTrue(solo.searchText("0"));
			break;
		}
	}
	
	public void checkAccount(int i)
	{
		switch(i)
		{
		case 0:
			assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
			break;
		case 1:
			assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
			break;
		case 2:
			assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
			break;
		}
		
	}
	
	public void checkMemo(int i)
	{
		switch(i)
		{
		case 0:
			assertTrue(solo.searchText("This is Edit."));
			break;
		case 1:
			assertFalse(solo.searchText("This is Edit."));
			break;
		}
	}
	
	public void checkContent(int moneyid,int accountid,int textid)
	{
		editAccount(accountid);
		solo.waitForText("詳細資料");
		
		checkMoney(moneyid);
		checkAccount(accountid);
		checkMemo(textid);
		assertTrue(solo.searchText("服飾美容 - 配件"));	
		assertTrue(solo.searchText("個人"));
		assertTrue(solo.searchText("星巴克"));
		
	}
	
	
	/// TestCase Prototype
	public void DefaultTransactionInMainpage(int moneyid,int accountid,int textid)
	{
		AvoidStartingPages.toDo(solo);
		
		DefaultNew();
		//修改支出
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("詳細資料");
		
		clickOnDialogButton("修改");
		
		editContent( moneyid, accountid, textid);
		
		solo.clickOnButton("存入");
		
		//Check
		checkContent(moneyid, accountid, textid);
		
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		/*
		//確認後刪除
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.waitForText("詳細資料");
		clickOnDialogButton(solo.getImageButton(0).getId()); //刪除Button
		solo.clickOnButton("確定");
		assertFalse(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		*/
	}
	
	public void DefaultTransactionInAccountpage(int moneyid,int accountid,int textid)
	{
		AvoidStartingPages.toDo(solo);
		
		DefaultNew();
		
		jumpToAccountPage();
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		//修改支出
		solo.clickOnText("餐飲");
		solo.waitForText("詳細資料");
		
		clickOnDialogButton("修改");
		
		editContent( moneyid, accountid, textid);
		
		solo.clickOnButton("存入");
		
		//回到MainPage
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		
		//Check
		checkContent(moneyid, accountid, textid);
		solo.sendKey(KeyEvent.KEYCODE_BACK);

	}
	

	////// TestCase Manager
	public void testEditTransactionWithPositiveNumberToCreditInMainpage() {
		DefaultTransactionInMainpage(0,0,0);	}
	public void testEditTransactionWithNegativeNumberToBankInMainpage() {
		DefaultTransactionInMainpage(1,1,1);	}
	public void testEditTransactionWithPositiveFloatToCashInMainpage() {
		DefaultTransactionInMainpage(2,2,0);	}
	public void testEditTransactionWithNegativeFloatToCreditInMainpage() {
		DefaultTransactionInMainpage(3,0,1);	}
	public void testEditTransactionWithZeroToBankInMainpage() {
		DefaultTransactionInMainpage(4,1,0);	}
	public void testEditTransactionWithNoinputToCashInMainpage() {
		DefaultTransactionInMainpage(5,2,1);	}
	
	
	public void testEditTransactionWithPositiveNumberToCreditInAccountpage(int moneyid,int accountid,int textid) {
		DefaultTransactionInAccountpage(0,0,0);	}
	public void testEditTransactionWithNegativeNumberToBankInAccountpage() {
		DefaultTransactionInAccountpage(1,1,1);	}
	public void testEditTransactionWithPositiveFloatToCashInAccountpage() {
		DefaultTransactionInAccountpage(2,2,0);	}
	public void testEditTransactionWithNegativeFloatToCreditInAccountpage() {
		DefaultTransactionInAccountpage(3,0,1);	}
	public void testEditTransactionWithZeroToBankInAccountpage() {
		DefaultTransactionInAccountpage(4,1,0);	}
	public void testEditTransactionWithNoinputToCashInAccountpage() {
		DefaultTransactionInAccountpage(5,2,1);	}
	
	
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
