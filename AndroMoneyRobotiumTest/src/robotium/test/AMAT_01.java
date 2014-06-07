package robotium.test;
//robotium-solo-4.0.jar
//import com.jayway.android.robotium.solo.Solo;
//robotium-solo-5.1.jar
import robotium.test.shared.AndroMoneyAccountClasses;
import robotium.test.shared.AndroMoneyAccountNames;
import robotium.test.shared.AndroMoneyMenuTitles;
import robotium.test.shared.AndroMoneyPlaceholders;
import robotium.test.shared.AvoidStartingPages;
import android.view.KeyEvent;
import android.view.View;

public class AMAT_01 extends BaseInstrumentationTest {

	protected void setUp() {
		super.setUp();
	}
	
	public void testAddCashAccountWithNegativeIntegerAmount() {
		
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
		//輸入帳戶名稱
		solo.enterText(0, AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//輸入金額[-2756]
		solo.clickOnEditText(1);
		//點擊[-]鍵
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//點擊數字鍵[7]
		view = solo.getView("button_7");
		solo.clickOnView(view);
		//點擊數字鍵[5]
		view = solo.getView("button_5");
		solo.clickOnView(view);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//長按帳戶名稱，修改帳戶
		solo.clickLongOnText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.clickOnText("修改");
		assertTrue(solo.searchText(AndroMoneyAccountClasses.CASH));
		assertTrue(solo.searchText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT));
		assertTrue(solo.searchText("-2756"));
		
	}
	
	public void testAddCashAccountWithPositiveFloatAmount() {
		
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
		//輸入帳戶名稱
		solo.enterText(0, AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//輸入金額[27.56]
		solo.clickOnEditText(1);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//點擊數字鍵[7]
		view = solo.getView("button_7");
		solo.clickOnView(view);
		//點擊[.]鍵
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//點擊數字鍵[5]
		view = solo.getView("button_5");
		solo.clickOnView(view);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//長按帳戶名稱，修改帳戶
		solo.clickLongOnText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.clickOnText("修改");
		assertTrue(solo.searchText(AndroMoneyAccountClasses.CASH));
		assertTrue(solo.searchText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT));
		assertTrue(solo.searchText("27.56"));
		
	}
	
	public void testAddCashAccountWithNegativeFloatAmount() {
		
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
		//輸入帳戶名稱
		solo.enterText(0, AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//輸入金額[-27.56]
		solo.clickOnEditText(1);
		//點擊[-]鍵
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//點擊數字鍵[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//點擊數字鍵[7]
		view = solo.getView("button_7");
		solo.clickOnView(view);
		//點擊[.]鍵
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//點擊數字鍵[5]
		view = solo.getView("button_5");
		solo.clickOnView(view);
		//點擊數字鍵[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//長按帳戶名稱，修改帳戶
		solo.clickLongOnText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.clickOnText("修改");
		assertTrue(solo.searchText(AndroMoneyAccountClasses.CASH));
		assertTrue(solo.searchText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT));
		assertTrue(solo.searchText("-27.56"));
		
	}
	
	public void testAddCashAccountWithZeroAmount() {
		
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
		//輸入帳戶名稱
		solo.enterText(0, AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//輸入金額[0]
		solo.clickOnEditText(1);
		//點擊數字鍵[0]
		view = solo.getView("button_0");
		solo.clickOnView(view);

		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//長按帳戶名稱，修改帳戶
		solo.clickLongOnText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.clickOnText("修改");
		assertTrue(solo.searchText(AndroMoneyAccountClasses.CASH));
		assertTrue(solo.searchText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT));
		assertTrue(solo.searchText("0"));
		
	}
	
	public void testAddCashAccountWithEmptyAmount() {
		
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
		//輸入帳戶名稱
		solo.enterText(0, AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);

		//確定新增帳戶
		solo.clickOnButton("確定");
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//長按帳戶名稱，修改帳戶
		solo.clickLongOnText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.clickOnText("修改");
		assertTrue(solo.searchText(AndroMoneyAccountClasses.CASH));
		assertTrue(solo.searchText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT));
		assertTrue(solo.searchText("0"));
		
	}
	
	public void testAddCreditAccountWithPositiveIntegerAmount() throws InterruptedException {
		
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
		//輸入帳戶名稱
		solo.enterText(0, AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//輸入金額[5533]
		solo.clickOnEditText(1);
		//點擊數字鍵[5]兩次
		view = solo.getView("button_5");
		solo.clickOnView(view);
		solo.clickOnView(view);
		//點擊數字鍵[3]兩次
		view = solo.getView("button_3");
		solo.clickOnView(view);
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//長按帳戶名稱，修改帳戶
		solo.clickLongOnText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.clickOnText("修改");
		assertTrue(solo.searchText(AndroMoneyAccountClasses.CREDIT));
		assertTrue(solo.searchText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT));
		assertTrue(solo.searchText("5533"));
		
	}
	
	public void testAddBankAccountWithPositiveIntegerAmount() throws InterruptedException {
		
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
		//輸入帳戶名稱
		solo.enterText(0, AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//輸入金額[5533]
		solo.clickOnEditText(1);
		//點擊數字鍵[5]兩次
		view = solo.getView("button_5");
		solo.clickOnView(view);
		solo.clickOnView(view);
		//點擊數字鍵[3]兩次
		view = solo.getView("button_3");
		solo.clickOnView(view);
		solo.clickOnView(view);
		//確定輸入金額
		solo.clickOnButton("OK");
		//確定新增帳戶
		solo.clickOnButton("確定");
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//長按帳戶名稱，修改帳戶
		solo.clickLongOnText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.clickOnText("修改");
		assertTrue(solo.searchText(AndroMoneyAccountClasses.BANK));
		assertTrue(solo.searchText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT));
		assertTrue(solo.searchText("5533"));
		
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
