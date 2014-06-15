package robotium.test;

import robotium.test.shared.AndroMoneyAccountNames;
import robotium.test.shared.AndroMoneyToastMessages;
import robotium.test.shared.KeyboardHelper;
import android.view.KeyEvent;

public class AMAT_06 extends BaseInstrumentationTest {
	private static final String accountTypes[] = { AndroMoneyAccountNames.DEFAULT_CASH,
			AndroMoneyAccountNames.DEFAULT_BANK, AndroMoneyAccountNames.DEFAULT_CREDIT };
	private static final String moneys[] = { "5533", "-2756", "27.56", "-27.56", "0", "" };
	
	public void testAddCashAccountNameWithConflict() {
		jumpToAccountPage();
		clickModifyAccount(AndroMoneyAccountNames.DEFAULT_CASH);
		for(String type : accountTypes) {
			if(type==AndroMoneyAccountNames.DEFAULT_CASH)
				continue;
			for(String money : moneys) {
				fillAccountName(type);
				fillAccountMoney(money);
				solo.clickOnButton("�T�w");
				assertTrue(solo
						.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
			}
		}
	}
	
	public void testAddBankAccountNameWithConflict() {
		jumpToAccountPage();
		clickModifyAccount(AndroMoneyAccountNames.DEFAULT_BANK);
		for(String type : accountTypes) {
			if(type==AndroMoneyAccountNames.DEFAULT_BANK)
				continue;
			for(String money : moneys) {
				fillAccountName(type);
				fillAccountMoney(money);
				solo.clickOnButton("�T�w");
				assertTrue(solo
						.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
			}
		}
	}
	
	public void testAddCreditAccountNameWithConflict() {
		jumpToAccountPage();
		clickModifyAccount(AndroMoneyAccountNames.DEFAULT_CREDIT);
		for(String type : accountTypes) {
			if(type==AndroMoneyAccountNames.DEFAULT_CREDIT)
				continue;
			for(String money : moneys) {
				fillAccountName(type);
				fillAccountMoney(money);
				solo.clickOnButton("�T�w");
				assertTrue(solo
						.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
			}
		}
	}
	
	public void testAddAccountNameEmpty() {
		jumpToAccountPage();
		for(String type : accountTypes) {
			clickModifyAccount(type);
			fillAccountName("");
			solo.clickOnButton("�T�w");
			// ���ҵL�k��
			assertTrue(solo
					.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
			solo.clickOnButton("����");
			// �T�{�S�Q��
			assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
		}
	}
	
	private void clickModifyAccount(String accountName) {
		// �����b��W�١A�ק�b��
		solo.clickLongOnText(accountName);

		// �N���U�ק�ɡA�۰ʸ��X��������L����
		solo.clickOnText("�ק�");
		solo.sendKey(KeyEvent.KEYCODE_BACK);
	}
	
	private void fillAccountName(String accountName) {
		solo.waitForText("�W��");
		// ��J�b��W��
		solo.clearEditText(0);
		solo.enterText(0, accountName);
	}

	private void fillAccountMoney(String literal) {
		solo.waitForText("��l���B");
		solo.clickOnEditText(1);
		KeyboardHelper.keyInLiteral(solo, literal);
		KeyboardHelper.pressOk(solo);

		// �N�۰ʸ��X��������L����
		solo.sendKey(KeyEvent.KEYCODE_BACK);
	}
}
