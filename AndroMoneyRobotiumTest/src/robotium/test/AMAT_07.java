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
//		//��J���B 5533
//		solo.clickOnButton("5");
//		solo.clickOnButton("5");
//		solo.clickOnButton("3");
//		solo.clickOnButton("3");
//		solo.clickOnButton("OK");
//		solo.clickOnText("���O�G");
//		solo.clickOnText("�\�����~");
//		solo.clickOnText("���\");
//		solo.clickOnText("�b��G");
//		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
//		solo.clickOnText("�M�סG");
//		solo.clickOnText("�L");
//		solo.clickOnText("�Ӯa�G");
//		solo.clickOnText("�L");
//		solo.clickOnText("�g���G");
//		solo.clickOnText("�@��");
//		solo.clickOnButton("�T�w");
//		solo.clickOnText("�Ƶ��G");
//		solo.clickOnButton("�T�w");
//		solo.clickOnButton("�s�J");
//		solo.waitForText(" 5,533");
//		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
//		solo.waitForText("�ԲӸ��", 1, 5000);
//		assertTrue(solo.searchText("5,533"));
//		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
//		assertTrue(solo.searchText("�\�����~ - ���\"));		
	}
	
	
	protected void tearDown() {
		solo.waitForText("�ԲӸ��");

		clickWidgetOnDialog("modify_record");
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		clickWidgetOnDialog("delet_record");
		
		solo.waitForText("�T�w�n�R���H");
		solo.clickOnButton("�T�w");
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		super.tearDown();
	}

}
