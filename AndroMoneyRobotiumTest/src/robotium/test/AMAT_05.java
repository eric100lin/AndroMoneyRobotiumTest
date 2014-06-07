package robotium.test;

import robotium.test.shared.AndroMoneyAccountClasses;
import robotium.test.shared.AndroMoneyAccountNames;
import robotium.test.shared.AndroMoneyMenuTitles;
import robotium.test.shared.AndroMoneyPlaceholders;
import robotium.test.shared.AndroMoneyToastMessages;
import robotium.test.shared.AvoidStartingPages;
import robotium.test.shared.KeyboardHelper;
import android.view.KeyEvent;
import android.view.View;

public class AMAT_05 extends BaseInstrumentationTest {

	protected void setUp() {
		super.setUp();
	}

	public void testModifyAccountTypeCash() {
		jumpToAccountPage();

		// �ק�DEFAULT_BANK��Type�A��eBANK�A���CASH
		modifyAccountType(AndroMoneyAccountNames.DEFAULT_BANK,
				AndroMoneyAccountClasses.BANK, AndroMoneyAccountNames.DEFAULT_CASH);

		// ���ҭק令�\
		solo.clickLongOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		solo.sendKey(KeyEvent.KEYCODE_BACK);

		// �ק�^�hDEFAULT_BANK��Type�A��eCASH�A���BANK
		modifyAccountType(AndroMoneyAccountNames.DEFAULT_BANK,
				AndroMoneyAccountNames.DEFAULT_CASH, AndroMoneyAccountClasses.BANK);
	}

	public void testModifyAccountTypeCredit() {
		jumpToAccountPage();

		// �ק�DEFAULT_BANK��Type�A��eBANK�A���CREDIT
		modifyAccountType(AndroMoneyAccountNames.DEFAULT_BANK,
				AndroMoneyAccountClasses.BANK, AndroMoneyAccountNames.DEFAULT_CASH);

		// ���ҭק令�\
		solo.clickLongOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		solo.sendKey(KeyEvent.KEYCODE_BACK);

		// �ק�^�hDEFAULT_BANK��Type�A��eCREDIT�A���BANK
		modifyAccountType(AndroMoneyAccountNames.DEFAULT_BANK,
				AndroMoneyAccountNames.DEFAULT_CASH, AndroMoneyAccountClasses.BANK);
	}

	public void testModifyAccountTypeBank() {
		jumpToAccountPage();

		// �ק�DEFAULT_CASH��Type�A��eCASH�A���BANK
		modifyAccountType(AndroMoneyAccountNames.DEFAULT_CASH,
				AndroMoneyAccountNames.DEFAULT_CASH, AndroMoneyAccountClasses.BANK);

		// ���ҭק令�\
		solo.clickLongOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		assertTrue(solo.searchText(AndroMoneyAccountClasses.BANK));
		solo.sendKey(KeyEvent.KEYCODE_BACK);

		// �ק�^�hDEFAULT_BANK��Type�A��eCASH�A���BANK
		modifyAccountType(AndroMoneyAccountNames.DEFAULT_CASH,
				AndroMoneyAccountClasses.BANK, AndroMoneyAccountNames.DEFAULT_CASH);
	}

	public void testModifyAccountNameEmpty() {
		jumpToAccountPage();
		// �ק�DEFAULT_BANK��Name�A��eDEFAULT_BANK�A���""
		modifyAccountName(AndroMoneyAccountNames.DEFAULT_BANK, "");
		// ���ҵL�k��
		assertTrue(solo
				.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
		solo.clickOnButton("����");
		// �T�{�S�Q��
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
	}

	public void testModifyAccountNameTheSame() {
		jumpToAccountPage();
		// �ק�DEFAULT_BANK��Name�A��eDEFAULT_BANK�A���MY_CASH
		modifyAccountName(AndroMoneyAccountNames.DEFAULT_BANK,
				AndroMoneyAccountNames.DEFAULT_BANK);
		// ���ҭק��S�ק�@��
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
	}

	public void testModifyAccountNameNormal() {
		jumpToAccountPage();
		// �ק�DEFAULT_BANK��Name�A��eDEFAULT_BANK�A���MY_CASH
		modifyAccountName(AndroMoneyAccountNames.DEFAULT_BANK,
				AndroMoneyAccountNames.MY_CASH);
		// ���ҭק令�\
		assertTrue(solo.searchText(AndroMoneyAccountNames.MY_CASH));
		// �ק�^�hDEFAULT_BANK��Name�A��eMY_CASH�A���DEFAULT_BANK
		modifyAccountName(AndroMoneyAccountNames.MY_CASH,
				AndroMoneyAccountNames.DEFAULT_BANK);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
	}

	public void testModifyAccountNameSpecial() {
		String specialString = "+- */_\\@$%^:-P >_<";
		jumpToAccountPage();
		// �ק�DEFAULT_BANK��Name�A��eDEFAULT_BANK�A���specialString
		modifyAccountName(AndroMoneyAccountNames.DEFAULT_BANK, specialString);
		// ���ҭק令�\
		assertTrue(solo.searchText(specialString));
		// �ק�^�hDEFAULT_BANK��Name�A��especialString�A���DEFAULT_BANK
		modifyAccountName(specialString, AndroMoneyAccountNames.DEFAULT_BANK);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
	}

	public void testModifyAccountNameTooLong() {
		String tooLongString = "01234567890123456789+++++++++++++";
		jumpToAccountPage();
		// �ק�DEFAULT_BANK��Name�A��eDEFAULT_BANK�A���specialString
		modifyAccountName(AndroMoneyAccountNames.DEFAULT_BANK, tooLongString);
		// ���ҭק令�\
		assertTrue(solo.searchText(tooLongString.substring(0, 20)));
		// �ק�^�hDEFAULT_BANK��Name�A��especialString�A���DEFAULT_BANK
		modifyAccountName(tooLongString.substring(0, 20),
				AndroMoneyAccountNames.DEFAULT_BANK);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
	}

	public void testModifyAccountNameTrimSpace() {
		String spaceString = " What the space!  ";
		jumpToAccountPage();
		// �ק�DEFAULT_BANK��Name�A��eDEFAULT_BANK�A���specialString
		modifyAccountName(AndroMoneyAccountNames.DEFAULT_BANK, spaceString);
		// ���ҭק令�\
		assertTrue(solo.searchText(spaceString.trim()));
		// �ק�^�hDEFAULT_BANK��Name�A��especialString�A���DEFAULT_BANK
		modifyAccountName(spaceString.trim(),
				AndroMoneyAccountNames.DEFAULT_BANK);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
	}

	public void testModifyAccountMoneyWithPositiveInteger() {
		accountMoneyTesting("5533");
	}

	public void testModifyAccountMoneyWithNegativeInteger() {
		accountMoneyTesting("-2756");
	}

	public void testModifyAccountMoneyWithPositiveFloat() {
		accountMoneyTesting("27.56");
	}

	public void testModifyAccountMoneyWithNegativeFloat() {
		accountMoneyTesting("-27.56");
	}

	public void testModifyAccountMoneyWithZero() {
		accountMoneyTesting("0");
	}

	public void testModifyAccountMoneyWithEmpty() {
		accountMoneyTesting("");
	}

	public void testModifyMixed() {
		jumpToAccountPage();
		String modified = "modified";
		String accountTypes[] = { AndroMoneyAccountNames.DEFAULT_CASH,
				AndroMoneyAccountNames.DEFAULT_BANK, AndroMoneyAccountNames.DEFAULT_CREDIT };
		for (int i=0;i<accountTypes.length;i++) {
			String type = accountTypes[i];
			// �ק�type�����B�A��e0�A���"123456"
			modifyAccountMoney(type, "123456");
			modifyAccountName(type, modified);
			modifyAccountType(modified, type, accountTypes[(i+1)%3]);
			
			// ���ҭק令�\
			solo.clickLongOnText(modified);
			solo.clickOnText("�ק�");
			solo.sendKey(KeyEvent.KEYCODE_BACK);
			assertTrue(solo.searchText(accountTypes[(i+1)%3]));
			assertTrue(solo.searchText(modified));
			assertTrue(solo.searchText("123456"));
			solo.sendKey(KeyEvent.KEYCODE_BACK);
			
			// �ק�^�h0
			modifyAccountMoney(modified, "0");
			modifyAccountType(modified, accountTypes[(i+1)%3], type);
			modifyAccountName(modified, type);
		}
	}
	
	private void accountMoneyTesting(String literal) {
		jumpToAccountPage();
		String accountTypes[] = { AndroMoneyAccountNames.DEFAULT_CASH,
				AndroMoneyAccountNames.DEFAULT_BANK, AndroMoneyAccountNames.DEFAULT_CREDIT };
		for (String type : accountTypes) {
			// �ק�type�����B�A��e0�A���literal
			modifyAccountMoney(type, literal);
			// ���ҭק令�\
			solo.clickLongOnText(type);
			solo.clickOnText("�ק�");
			solo.sendKey(KeyEvent.KEYCODE_BACK);
			assertTrue(solo.searchText(type));
			assertTrue(solo.searchText(literal));
			solo.sendKey(KeyEvent.KEYCODE_BACK);
			// �ק�^�h0
			modifyAccountMoney(type, "0");
		}
	}

	private void modifyAccountMoney(String accountName, String literal) {
		// �����b��W�١A�ק�b��
		solo.clickLongOnText(accountName);

		// �N���U�ק�ɡA�۰ʸ��X��������L����
		solo.clickOnText("�ק�");
		solo.sendKey(KeyEvent.KEYCODE_BACK);

		solo.waitForText("��l���B");
		solo.clickOnEditText(1);
		KeyboardHelper.keyInLiteral(solo, literal);
		KeyboardHelper.pressOk(solo);

		// �N�۰ʸ��X��������L����
		solo.sendKey(KeyEvent.KEYCODE_BACK);

		// �T�w�ק�
		solo.clickOnButton("�T�w");
	}

	private void modifyAccountType(String accountName, String original,
			String newType) {
		// �����b��W�١A�ק�b��
		solo.clickLongOnText(accountName);

		// �N���U�ק�ɡA�۰ʸ��X��������L����
		solo.clickOnText("�ק�");
		solo.sendKey(KeyEvent.KEYCODE_BACK);

		solo.waitForText("���O");
		assertTrue(solo.searchText(original));
		solo.clickOnText(original);
		solo.clickOnText(newType);
		// �T�w�ק�
		solo.clickOnButton("�T�w");
	}

	private void modifyAccountName(String originalAccount, String newAccountName) {
		// �����b��W�١A�ק�b��
		solo.clickLongOnText(originalAccount);

		// �N���U�ק�ɡA�۰ʸ��X��������L����
		solo.clickOnText("�ק�");
		solo.sendKey(KeyEvent.KEYCODE_BACK);

		solo.waitForText("�W��");
		// ��J�b��W��
		solo.clearEditText(0);
		solo.enterText(0, newAccountName);
		// �T�w�ק�
		solo.clickOnButton("�T�w");
	}

	protected void tearDown() {
		super.tearDown();
	}
}
