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

		// 修改DEFAULT_BANK的Type，改前BANK，改後CASH
		modifyAccountType(AndroMoneyAccountNames.DEFAULT_BANK,
				AndroMoneyAccountClasses.BANK, AndroMoneyAccountNames.DEFAULT_CASH);

		// 驗證修改成功
		solo.clickLongOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		solo.sendKey(KeyEvent.KEYCODE_BACK);

		// 修改回去DEFAULT_BANK的Type，改前CASH，改後BANK
		modifyAccountType(AndroMoneyAccountNames.DEFAULT_BANK,
				AndroMoneyAccountNames.DEFAULT_CASH, AndroMoneyAccountClasses.BANK);
	}

	public void testModifyAccountTypeCredit() {
		jumpToAccountPage();

		// 修改DEFAULT_BANK的Type，改前BANK，改後CREDIT
		modifyAccountType(AndroMoneyAccountNames.DEFAULT_BANK,
				AndroMoneyAccountClasses.BANK, AndroMoneyAccountNames.DEFAULT_CASH);

		// 驗證修改成功
		solo.clickLongOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		solo.sendKey(KeyEvent.KEYCODE_BACK);

		// 修改回去DEFAULT_BANK的Type，改前CREDIT，改後BANK
		modifyAccountType(AndroMoneyAccountNames.DEFAULT_BANK,
				AndroMoneyAccountNames.DEFAULT_CASH, AndroMoneyAccountClasses.BANK);
	}

	public void testModifyAccountTypeBank() {
		jumpToAccountPage();

		// 修改DEFAULT_CASH的Type，改前CASH，改後BANK
		modifyAccountType(AndroMoneyAccountNames.DEFAULT_CASH,
				AndroMoneyAccountNames.DEFAULT_CASH, AndroMoneyAccountClasses.BANK);

		// 驗證修改成功
		solo.clickLongOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		assertTrue(solo.searchText(AndroMoneyAccountClasses.BANK));
		solo.sendKey(KeyEvent.KEYCODE_BACK);

		// 修改回去DEFAULT_BANK的Type，改前CASH，改後BANK
		modifyAccountType(AndroMoneyAccountNames.DEFAULT_CASH,
				AndroMoneyAccountClasses.BANK, AndroMoneyAccountNames.DEFAULT_CASH);
	}

	public void testModifyAccountNameEmpty() {
		jumpToAccountPage();
		// 修改DEFAULT_BANK的Name，改前DEFAULT_BANK，改後""
		modifyAccountName(AndroMoneyAccountNames.DEFAULT_BANK, "");
		// 驗證無法改
		assertTrue(solo
				.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
		solo.clickOnButton("取消");
		// 確認沒被改
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
	}

	public void testModifyAccountNameTheSame() {
		jumpToAccountPage();
		// 修改DEFAULT_BANK的Name，改前DEFAULT_BANK，改後MY_CASH
		modifyAccountName(AndroMoneyAccountNames.DEFAULT_BANK,
				AndroMoneyAccountNames.DEFAULT_BANK);
		// 驗證修改跟沒修改一樣
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
	}

	public void testModifyAccountNameNormal() {
		jumpToAccountPage();
		// 修改DEFAULT_BANK的Name，改前DEFAULT_BANK，改後MY_CASH
		modifyAccountName(AndroMoneyAccountNames.DEFAULT_BANK,
				AndroMoneyAccountNames.MY_CASH);
		// 驗證修改成功
		assertTrue(solo.searchText(AndroMoneyAccountNames.MY_CASH));
		// 修改回去DEFAULT_BANK的Name，改前MY_CASH，改後DEFAULT_BANK
		modifyAccountName(AndroMoneyAccountNames.MY_CASH,
				AndroMoneyAccountNames.DEFAULT_BANK);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
	}

	public void testModifyAccountNameSpecial() {
		String specialString = "+- */_\\@$%^:-P >_<";
		jumpToAccountPage();
		// 修改DEFAULT_BANK的Name，改前DEFAULT_BANK，改後specialString
		modifyAccountName(AndroMoneyAccountNames.DEFAULT_BANK, specialString);
		// 驗證修改成功
		assertTrue(solo.searchText(specialString));
		// 修改回去DEFAULT_BANK的Name，改前specialString，改後DEFAULT_BANK
		modifyAccountName(specialString, AndroMoneyAccountNames.DEFAULT_BANK);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
	}

	public void testModifyAccountNameTooLong() {
		String tooLongString = "01234567890123456789+++++++++++++";
		jumpToAccountPage();
		// 修改DEFAULT_BANK的Name，改前DEFAULT_BANK，改後specialString
		modifyAccountName(AndroMoneyAccountNames.DEFAULT_BANK, tooLongString);
		// 驗證修改成功
		assertTrue(solo.searchText(tooLongString.substring(0, 20)));
		// 修改回去DEFAULT_BANK的Name，改前specialString，改後DEFAULT_BANK
		modifyAccountName(tooLongString.substring(0, 20),
				AndroMoneyAccountNames.DEFAULT_BANK);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
	}

	public void testModifyAccountNameTrimSpace() {
		String spaceString = " What the space!  ";
		jumpToAccountPage();
		// 修改DEFAULT_BANK的Name，改前DEFAULT_BANK，改後specialString
		modifyAccountName(AndroMoneyAccountNames.DEFAULT_BANK, spaceString);
		// 驗證修改成功
		assertTrue(solo.searchText(spaceString.trim()));
		// 修改回去DEFAULT_BANK的Name，改前specialString，改後DEFAULT_BANK
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
			// 修改type的金額，改前0，改後"123456"
			modifyAccountMoney(type, "123456");
			modifyAccountName(type, modified);
			modifyAccountType(modified, type, accountTypes[(i+1)%3]);
			
			// 驗證修改成功
			solo.clickLongOnText(modified);
			solo.clickOnText("修改");
			solo.sendKey(KeyEvent.KEYCODE_BACK);
			assertTrue(solo.searchText(accountTypes[(i+1)%3]));
			assertTrue(solo.searchText(modified));
			assertTrue(solo.searchText("123456"));
			solo.sendKey(KeyEvent.KEYCODE_BACK);
			
			// 修改回去0
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
			// 修改type的金額，改前0，改後literal
			modifyAccountMoney(type, literal);
			// 驗證修改成功
			solo.clickLongOnText(type);
			solo.clickOnText("修改");
			solo.sendKey(KeyEvent.KEYCODE_BACK);
			assertTrue(solo.searchText(type));
			assertTrue(solo.searchText(literal));
			solo.sendKey(KeyEvent.KEYCODE_BACK);
			// 修改回去0
			modifyAccountMoney(type, "0");
		}
	}

	private void modifyAccountMoney(String accountName, String literal) {
		// 長按帳戶名稱，修改帳戶
		solo.clickLongOnText(accountName);

		// 將按下修改時，自動跳出的虛擬鍵盤隱藏
		solo.clickOnText("修改");
		solo.sendKey(KeyEvent.KEYCODE_BACK);

		solo.waitForText("初始金額");
		solo.clickOnEditText(1);
		KeyboardHelper.keyInLiteral(solo, literal);
		KeyboardHelper.pressOk(solo);

		// 將自動跳出的虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);

		// 確定修改
		solo.clickOnButton("確定");
	}

	private void modifyAccountType(String accountName, String original,
			String newType) {
		// 長按帳戶名稱，修改帳戶
		solo.clickLongOnText(accountName);

		// 將按下修改時，自動跳出的虛擬鍵盤隱藏
		solo.clickOnText("修改");
		solo.sendKey(KeyEvent.KEYCODE_BACK);

		solo.waitForText("類別");
		assertTrue(solo.searchText(original));
		solo.clickOnText(original);
		solo.clickOnText(newType);
		// 確定修改
		solo.clickOnButton("確定");
	}

	private void modifyAccountName(String originalAccount, String newAccountName) {
		// 長按帳戶名稱，修改帳戶
		solo.clickLongOnText(originalAccount);

		// 將按下修改時，自動跳出的虛擬鍵盤隱藏
		solo.clickOnText("修改");
		solo.sendKey(KeyEvent.KEYCODE_BACK);

		solo.waitForText("名稱");
		// 輸入帳戶名稱
		solo.clearEditText(0);
		solo.enterText(0, newAccountName);
		// 確定修改
		solo.clickOnButton("確定");
	}

	protected void tearDown() {
		super.tearDown();
	}
}
