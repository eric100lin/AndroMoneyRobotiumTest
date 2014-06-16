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
		//���ͤ@����X
		//��J���B 5533
		solo.clickOnButton("5");
		solo.clickOnButton("5");
		solo.clickOnButton("3");
		solo.clickOnButton("3");
		solo.clickOnButton("OK");
		solo.clickOnText("���O�G");
		solo.clickOnText("�\�����~");
		solo.scrollListToTop(1);
		solo.clickOnText("���\");
		solo.clickOnText("�b��G");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.clickOnText("�M�סG");
		solo.clickOnText("�L");
		solo.clickOnText("�Ӯa�G");
		solo.clickOnText("�L");
		solo.clickOnText("�g���G");
		solo.clickOnText("�@��");
		solo.clickOnButton("�T�w");
		solo.clickOnText("�Ƶ��G");
		solo.clickOnButton("�T�w");
		solo.clickOnButton("�s�J");
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
		
		solo.clickOnText("���O�G");
		solo.clickOnText("�A�����e");
		solo.clickOnText("�t��");
		solo.clickOnText("�b��G");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.clickOnText("�M�סG");
		solo.clickOnText("�ӤH");
		solo.clickOnText("�Ӯa�G");
		solo.clickOnText("�P�ڧJ");
		solo.clickOnText("�g���G");
		solo.clickOnText("�@��");
		solo.clickOnButton("�T�w");
		solo.clickOnText("�Ƶ��G");
		solo.enterText(0, "This is Edit."); 
	}
	public void testEditDefaultAccountWithDefaultTransactionInMainpage() {
		AvoidStartingPages.toDo(solo);
		
		DefaultNew();
		//�ק��X
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("�ԲӸ��");
		
		clickOnDialogButton("�ק�");
		
		editContent();
		
		solo.clickOnButton("�T�w");
		solo.clickOnButton("�s�J");
		
		//Check
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.waitForText("�ԲӸ��");
		assertTrue(solo.searchText("6,023"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		assertTrue(solo.searchText("�A�����e - �t��"));	
		assertTrue(solo.searchText("�ӤH"));
		assertTrue(solo.searchText("�P�ڧJ"));
		assertTrue(solo.searchText("This is Edit."));
		
		//�T�{��R��
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.waitForText("�ԲӸ��");
		clickOnDialogButton(solo.getImageButton(0).getId()); //�R��Button
		solo.clickOnButton("�T�w");
		assertFalse(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		
		
	}
	
	public void testEditDefaultAccountWithDefaultTransactionInAccountpage() {
		AvoidStartingPages.toDo(solo);
		
		DefaultNew();
		
		jumpToAccountPage();
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		//�ק��X
		solo.clickOnText("�\��");
		solo.waitForText("�ԲӸ��");
		
		clickOnDialogButton("�ק�");
		
		editContent();
		
		solo.clickOnButton("�T�w");
		solo.clickOnButton("�s�J");
		
		//�^��MainPage
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		
		//Check
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.waitForText("�ԲӸ��");
		assertTrue(solo.searchText("6,023"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		assertTrue(solo.searchText("�A�����e - �t��"));	
		assertTrue(solo.searchText("�ӤH"));
		assertTrue(solo.searchText("�P�ڧJ"));
		assertTrue(solo.searchText("This is Edit."));
		
		//�T�{��R��
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.waitForText("�ԲӸ��");
		clickOnDialogButton(solo.getImageButton(0).getId()); //�R��Button
		solo.clickOnButton("�T�w");
		assertFalse(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		
		
	}
	
	protected void clear(String text)
	{
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		while(solo.searchText(text))
		{
			solo.clickOnText(text);
			solo.waitForText("�ԲӸ��");
			clickOnDialogButton(solo.getImageButton(0).getId()); //�R��Button
			solo.clickOnButton("�T�w");
		}
	}
	
	protected void tearDown() {
		
		clear(AndroMoneyAccountNames.DEFAULT_CASH);
		clear(AndroMoneyAccountNames.DEFAULT_CREDIT);
		clear(AndroMoneyAccountNames.DEFAULT_BANK);
		
		super.tearDown();
	}

}
