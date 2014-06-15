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
		//���ͤ@����X
		//��J���B 5533
		//solo.clickOnButton("5");
		//solo.clickOnButton("5");
		//solo.clickOnButton("3");
		//solo.clickOnButton("3");
		//solo.clickOnButton("OK");
		/*solo.clickOnText("���O�G");
		solo.clickOnText("�\�����~");
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
		solo.clickOnButton("�T�w");*/
		//solo.clickOnButton("�s�J");
		//solo.waitForText(" 5,533");
		//solo.waitForText(" 5");
		
		//solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		//solo.waitForText("�ԲӸ��", 1, 5000);
		//assertTrue(solo.searchText("5,533"));
		//assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		//assertTrue(solo.searchText("�\�����~ - ���\"));	
		
		//�ק��X
		solo.clickOnText("�\�����~ - ���\");
		solo.waitForDialogToOpen();
		solo.clickLongOnText("�ק�");
	
		//solo.clickOnButton("�ƻs");
		//solo.clickOnImageButton(0);
		/*
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
		solo.clickOnButton("�T�w");
		solo.clickOnButton("�s�J");
		solo.waitForText(" 5,533");*/
		
	}

	protected void tearDown() {
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//�R���b��
		View view = solo.getView("button_delete");
		solo.clickOnView(view);
		solo.clickOnButton("�T�w");
		solo.clickOnButton("�O");
		solo.waitForText(
							AndroMoneyPlaceholders.ADD_ACCOUNT,
							1,
							5000
						);
		super.tearDown();
	}

}
