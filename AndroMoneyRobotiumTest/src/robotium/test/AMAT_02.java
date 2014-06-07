package robotium.test;

import robotium.test.shared.AndroMoneyAccountClasses;
import robotium.test.shared.AndroMoneyAccountNames;
import robotium.test.shared.AndroMoneyMenuTitles;
import robotium.test.shared.AndroMoneyPlaceholders;
import robotium.test.shared.AndroMoneyToastMessages;
import robotium.test.shared.AvoidStartingPages;
import android.view.KeyEvent;
import android.view.View;

public class AMAT_02 extends BaseInstrumentationTest {

	protected void setUp() {
		super.setUp();
	}
	
	public void testAddExistedCashAccountWithPositiveIntegerAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		//輸入預設已存在帳戶名稱[現金]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CASH);
		//輸入金額[6842]
		solo.clickOnEditText(1);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//點擊數字鍵[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//點擊數字鍵[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能重覆]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedBankAccountWithNegativeIntegerAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.BANK);
		//輸入預設已存在帳戶名稱[銀行]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_BANK);
		//輸入金額[-6842]
		solo.clickOnEditText(1);
		//點擊[-]鍵
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//點擊數字鍵[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//點擊數字鍵[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能重覆]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedBankAccountWithPositiveFloatAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.BANK);
		//輸入預設已存在帳戶名稱[銀行]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_BANK);
		//輸入金額[68.42]
		solo.clickOnEditText(1);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//點擊數字鍵[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//點擊[.]鍵
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//點擊數字鍵[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能重覆]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedBankAccountWithNegativeFloatAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.BANK);
		//輸入預設已存在帳戶名稱[銀行]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_BANK);
		//輸入金額[-68.42]
		solo.clickOnEditText(1);
		//點擊[-]鍵
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//點擊數字鍵[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//點擊[.]鍵
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//點擊數字鍵[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能重覆]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedBankAccountWithZeroAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.BANK);
		//輸入預設已存在帳戶名稱[銀行]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_BANK);
		//輸入金額[0]
		solo.clickOnEditText(1);
		//點擊數字鍵[0]
		view = solo.getView("button_0");
		solo.clickOnView(view);

		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能重覆]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedBankAccountWithEmptyAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.BANK);
		//輸入預設已存在帳戶名稱[銀行]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_BANK);

		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能重覆]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedCreditAccountWithNegativeIntegerAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CREDIT);
		//輸入預設已存在帳戶名稱[信用卡]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CREDIT);
		//輸入金額[-6842]
		solo.clickOnEditText(1);
		//點擊[-]鍵
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//點擊數字鍵[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//點擊數字鍵[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能重覆]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedCreditAccountWithPositiveFloatAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CREDIT);
		//輸入預設已存在帳戶名稱[信用卡]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CREDIT);
		//輸入金額[68.42]
		solo.clickOnEditText(1);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//點擊數字鍵[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//點擊[.]鍵
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//點擊數字鍵[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能重覆]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedCreditAccountWithNegativeFloatAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CREDIT);
		//輸入預設已存在帳戶名稱[信用卡]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CREDIT);
		//輸入金額[-68.42]
		solo.clickOnEditText(1);
		//點擊[-]鍵
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//點擊數字鍵[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//點擊[.]鍵
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//點擊數字鍵[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能重覆]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedCreditAccountWithZeroAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CREDIT);
		//輸入預設已存在帳戶名稱[信用卡]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CREDIT);
		//輸入金額[0]
		solo.clickOnEditText(1);
		//點擊數字鍵[0]
		view = solo.getView("button_0");
		solo.clickOnView(view);

		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能重覆]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedCreditAccountWithEmptyAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CREDIT);
		//輸入預設已存在帳戶名稱[信用卡]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CREDIT);

		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能重覆]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddCashAccountWithEmptyNameAndNegativeIntegerAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		//輸入金額[-6842]
		solo.clickOnEditText(1);
		//點擊[-]鍵
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//點擊數字鍵[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//點擊數字鍵[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能為空白]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
	}
	
	public void testAddCashAccountWithEmptyNameAndPositiveFloatAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		//輸入金額[68.42]
		solo.clickOnEditText(1);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//點擊數字鍵[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//點擊[.]鍵
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//點擊數字鍵[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能為空白]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
	}
	
	public void testAddCashAccountWithEmptyNameAndNegativeFloatAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		//輸入金額[-68.42]
		solo.clickOnEditText(1);
		//點擊[.]鍵
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//點擊數字鍵[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//點擊[.]鍵
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//點擊數字鍵[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能為空白]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
	}
	
	public void testAddCashAccountWithEmptyNameAndZeroAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		//輸入金額[0]
		solo.clickOnEditText(1);
		//點擊數字鍵[6]
		view = solo.getView("button_0");
		solo.clickOnView(view);

		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能為空白]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
	}
	
	public void testAddCashAccountWithEmptyNameAndEmptyAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CASH);

		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能為空白]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
	}
	
	public void testAddBankAccountWithEmptyNameAndPositiveIntegerAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.BANK);
		//輸入金額[6842]
		solo.clickOnEditText(1);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//點擊數字鍵[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//點擊數字鍵[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能為空白]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
	}	
	
	public void testAddCreditAccountWithEmptyNameAndPositiveIntegerAmount() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//新增帳戶
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//相當於實體鍵 back
		//將虛擬鍵盤隱藏
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//選擇帳戶類別
		solo.waitForText("類別");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CREDIT);
		//輸入金額[6842]
		solo.clickOnEditText(1);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//點擊數字鍵[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//點擊數字鍵[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		//檢驗出現toast錯誤訊息[帳戶名稱不能為空白]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
	}	
	
	protected void tearDown() {
		super.tearDown();
	}
}
