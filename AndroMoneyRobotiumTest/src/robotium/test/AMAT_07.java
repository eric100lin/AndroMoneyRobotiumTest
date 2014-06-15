package robotium.test;

//robotium-solo-4.0.jar
//import com.jayway.android.robotium.solo.Solo;
//robotium-solo-5.1.jar
import robotium.test.shared.AndroMoneyAccountNames;
import robotium.test.shared.AndroMoneyPlaceholders;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

@SuppressWarnings("rawtypes")
public class AMAT_07 extends BaseInstrumentationTest {

	protected void setUp() {
		super.setUp();
	}
	
	public void testAddExpenses()  throws InterruptedException	{
//		AvoidStartingPages.toDo(solo);
		
//		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
//		solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
//		//輸入金額 5533
//		solo.clickOnButton("5");
//		solo.clickOnButton("5");
//		solo.clickOnButton("3");
//		solo.clickOnButton("3");
//		solo.clickOnButton("OK");
//		solo.clickOnText("類別：");
//		solo.clickOnText("餐飲食品");
//		solo.clickOnText("早餐");
//		solo.clickOnText("帳戶：");
//		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
//		solo.clickOnText("專案：");
//		solo.clickOnText("無");
//		solo.clickOnText("商家：");
//		solo.clickOnText("無");
//		solo.clickOnText("週期：");
//		solo.clickOnText("一次");
//		solo.clickOnButton("確定");
//		solo.clickOnText("備註：");
//		solo.clickOnButton("確定");
//		solo.clickOnButton("存入");
//		solo.waitForText(" 5,533");
//		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
//		solo.waitForText("詳細資料", 1, 5000);
//		assertTrue(solo.searchText("5,533"));
//		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
//		assertTrue(solo.searchText("餐飲食品 - 早餐"));		
	}
	
	
	protected void tearDown() {
		solo.waitForText("詳細資料");

		clickWidgetOnDialog("modify_record");
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		clickWidgetOnDialog("delet_record");
		
		solo.waitForText("確定要刪除？");
		solo.clickOnButton("確定");
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		super.tearDown();
	}

}
