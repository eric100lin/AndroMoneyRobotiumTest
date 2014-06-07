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
		
		solo.waitForText("��");
		assertTrue(solo.searchText("��"));
		
		View view;
		//�I�����������s
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//�s�W�b��
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//�۷������� back
		//�N������L����
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//��ܱb�����O
		solo.waitForText("���O");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		//��J�b��W��
		solo.enterText(0, AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//��J���B[-2756]
		solo.clickOnEditText(1);
		//�I��[-]��
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�I���Ʀr��[7]
		view = solo.getView("button_7");
		solo.clickOnView(view);
		//�I���Ʀr��[5]
		view = solo.getView("button_5");
		solo.clickOnView(view);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//�����b��W�١A�ק�b��
		solo.clickLongOnText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.clickOnText("�ק�");
		assertTrue(solo.searchText(AndroMoneyAccountClasses.CASH));
		assertTrue(solo.searchText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT));
		assertTrue(solo.searchText("-2756"));
		
	}
	
	public void testAddCashAccountWithPositiveFloatAmount() {
		
		AvoidStartingPages.toDo(solo);
		
		solo.waitForText("��");
		assertTrue(solo.searchText("��"));
		
		View view;
		//�I�����������s
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//�s�W�b��
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//�۷������� back
		//�N������L����
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//��ܱb�����O
		solo.waitForText("���O");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		//��J�b��W��
		solo.enterText(0, AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//��J���B[27.56]
		solo.clickOnEditText(1);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�I���Ʀr��[7]
		view = solo.getView("button_7");
		solo.clickOnView(view);
		//�I��[.]��
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//�I���Ʀr��[5]
		view = solo.getView("button_5");
		solo.clickOnView(view);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//�����b��W�١A�ק�b��
		solo.clickLongOnText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.clickOnText("�ק�");
		assertTrue(solo.searchText(AndroMoneyAccountClasses.CASH));
		assertTrue(solo.searchText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT));
		assertTrue(solo.searchText("27.56"));
		
	}
	
	public void testAddCashAccountWithNegativeFloatAmount() {
		
		AvoidStartingPages.toDo(solo);
		
		solo.waitForText("��");
		assertTrue(solo.searchText("��"));
		
		View view;
		//�I�����������s
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//�s�W�b��
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//�۷������� back
		//�N������L����
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//��ܱb�����O
		solo.waitForText("���O");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		//��J�b��W��
		solo.enterText(0, AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//��J���B[-27.56]
		solo.clickOnEditText(1);
		//�I��[-]��
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�I���Ʀr��[7]
		view = solo.getView("button_7");
		solo.clickOnView(view);
		//�I��[.]��
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//�I���Ʀr��[5]
		view = solo.getView("button_5");
		solo.clickOnView(view);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//�����b��W�١A�ק�b��
		solo.clickLongOnText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.clickOnText("�ק�");
		assertTrue(solo.searchText(AndroMoneyAccountClasses.CASH));
		assertTrue(solo.searchText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT));
		assertTrue(solo.searchText("-27.56"));
		
	}
	
	public void testAddCashAccountWithZeroAmount() {
		
		AvoidStartingPages.toDo(solo);
		
		solo.waitForText("��");
		assertTrue(solo.searchText("��"));
		
		View view;
		//�I�����������s
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//�s�W�b��
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//�۷������� back
		//�N������L����
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//��ܱb�����O
		solo.waitForText("���O");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		//��J�b��W��
		solo.enterText(0, AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//��J���B[0]
		solo.clickOnEditText(1);
		//�I���Ʀr��[0]
		view = solo.getView("button_0");
		solo.clickOnView(view);

		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//�����b��W�١A�ק�b��
		solo.clickLongOnText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.clickOnText("�ק�");
		assertTrue(solo.searchText(AndroMoneyAccountClasses.CASH));
		assertTrue(solo.searchText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT));
		assertTrue(solo.searchText("0"));
		
	}
	
	public void testAddCashAccountWithEmptyAmount() {
		
		AvoidStartingPages.toDo(solo);
		
		solo.waitForText("��");
		assertTrue(solo.searchText("��"));
		
		View view;
		//�I�����������s
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//�s�W�b��
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//�۷������� back
		//�N������L����
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//��ܱb�����O
		solo.waitForText("���O");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		//��J�b��W��
		solo.enterText(0, AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);

		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//�����b��W�١A�ק�b��
		solo.clickLongOnText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.clickOnText("�ק�");
		assertTrue(solo.searchText(AndroMoneyAccountClasses.CASH));
		assertTrue(solo.searchText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT));
		assertTrue(solo.searchText("0"));
		
	}
	
	public void testAddCreditAccountWithPositiveIntegerAmount() throws InterruptedException {
		
		AvoidStartingPages.toDo(solo);
		
		solo.waitForText("��");
		assertTrue(solo.searchText("��"));
		
		View view;
		//�I�����������s
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//�s�W�b��
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//�۷������� back
		//�N������L����
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//��ܱb�����O
		solo.waitForText("���O");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CREDIT);
		//��J�b��W��
		solo.enterText(0, AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//��J���B[5533]
		solo.clickOnEditText(1);
		//�I���Ʀr��[5]�⦸
		view = solo.getView("button_5");
		solo.clickOnView(view);
		solo.clickOnView(view);
		//�I���Ʀr��[3]�⦸
		view = solo.getView("button_3");
		solo.clickOnView(view);
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//�����b��W�١A�ק�b��
		solo.clickLongOnText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.clickOnText("�ק�");
		assertTrue(solo.searchText(AndroMoneyAccountClasses.CREDIT));
		assertTrue(solo.searchText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT));
		assertTrue(solo.searchText("5533"));
		
	}
	
	public void testAddBankAccountWithPositiveIntegerAmount() throws InterruptedException {
		
		AvoidStartingPages.toDo(solo);
		
		solo.waitForText("��");
		assertTrue(solo.searchText("��"));
		
		View view;
		//�I�����������s
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//�s�W�b��
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//�۷������� back
		//�N������L����
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//��ܱb�����O
		solo.waitForText("���O");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.BANK);
		//��J�b��W��
		solo.enterText(0, AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//��J���B[5533]
		solo.clickOnEditText(1);
		//�I���Ʀr��[5]�⦸
		view = solo.getView("button_5");
		solo.clickOnView(view);
		solo.clickOnView(view);
		//�I���Ʀr��[3]�⦸
		view = solo.getView("button_3");
		solo.clickOnView(view);
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		//�����b��W�١A�ק�b��
		solo.clickLongOnText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT);
		solo.clickOnText("�ק�");
		assertTrue(solo.searchText(AndroMoneyAccountClasses.BANK));
		assertTrue(solo.searchText(AndroMoneyAccountNames.NON_REPEATED_ACCOUNT));
		assertTrue(solo.searchText("5533"));
		
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
