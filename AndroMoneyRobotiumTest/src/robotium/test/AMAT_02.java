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
		//��J�w�]�w�s�b�b��W��[�{��]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CASH);
		//��J���B[6842]
		solo.clickOnEditText(1);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�I���Ʀr��[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//�I���Ʀr��[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��୫��]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedBankAccountWithNegativeIntegerAmount() {
		
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
		//��J�w�]�w�s�b�b��W��[�Ȧ�]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_BANK);
		//��J���B[-6842]
		solo.clickOnEditText(1);
		//�I��[-]��
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�I���Ʀr��[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//�I���Ʀr��[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��୫��]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedBankAccountWithPositiveFloatAmount() {
		
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
		//��J�w�]�w�s�b�b��W��[�Ȧ�]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_BANK);
		//��J���B[68.42]
		solo.clickOnEditText(1);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�I���Ʀr��[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//�I��[.]��
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//�I���Ʀr��[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��୫��]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedBankAccountWithNegativeFloatAmount() {
		
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
		//��J�w�]�w�s�b�b��W��[�Ȧ�]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_BANK);
		//��J���B[-68.42]
		solo.clickOnEditText(1);
		//�I��[-]��
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�I���Ʀr��[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//�I��[.]��
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//�I���Ʀr��[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��୫��]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedBankAccountWithZeroAmount() {
		
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
		//��J�w�]�w�s�b�b��W��[�Ȧ�]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_BANK);
		//��J���B[0]
		solo.clickOnEditText(1);
		//�I���Ʀr��[0]
		view = solo.getView("button_0");
		solo.clickOnView(view);

		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��୫��]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedBankAccountWithEmptyAmount() {
		
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
		//��J�w�]�w�s�b�b��W��[�Ȧ�]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_BANK);

		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��୫��]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedCreditAccountWithNegativeIntegerAmount() {
		
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
		//��J�w�]�w�s�b�b��W��[�H�Υd]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CREDIT);
		//��J���B[-6842]
		solo.clickOnEditText(1);
		//�I��[-]��
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�I���Ʀr��[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//�I���Ʀr��[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��୫��]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedCreditAccountWithPositiveFloatAmount() {
		
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
		//��J�w�]�w�s�b�b��W��[�H�Υd]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CREDIT);
		//��J���B[68.42]
		solo.clickOnEditText(1);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�I���Ʀr��[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//�I��[.]��
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//�I���Ʀr��[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��୫��]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedCreditAccountWithNegativeFloatAmount() {
		
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
		//��J�w�]�w�s�b�b��W��[�H�Υd]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CREDIT);
		//��J���B[-68.42]
		solo.clickOnEditText(1);
		//�I��[-]��
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�I���Ʀr��[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//�I��[.]��
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//�I���Ʀr��[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��୫��]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedCreditAccountWithZeroAmount() {
		
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
		//��J�w�]�w�s�b�b��W��[�H�Υd]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CREDIT);
		//��J���B[0]
		solo.clickOnEditText(1);
		//�I���Ʀr��[0]
		view = solo.getView("button_0");
		solo.clickOnView(view);

		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��୫��]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddExistedCreditAccountWithEmptyAmount() {
		
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
		//��J�w�]�w�s�b�b��W��[�H�Υd]
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CREDIT);

		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��୫��]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EXISTED_NAME));
	}
	
	public void testAddCashAccountWithEmptyNameAndNegativeIntegerAmount() {
		
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
		//��J���B[-6842]
		solo.clickOnEditText(1);
		//�I��[-]��
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�I���Ʀr��[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//�I���Ʀr��[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��ର�ť�]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
	}
	
	public void testAddCashAccountWithEmptyNameAndPositiveFloatAmount() {
		
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
		//��J���B[68.42]
		solo.clickOnEditText(1);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�I���Ʀr��[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//�I��[.]��
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//�I���Ʀr��[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��ର�ť�]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
	}
	
	public void testAddCashAccountWithEmptyNameAndNegativeFloatAmount() {
		
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
		//��J���B[-68.42]
		solo.clickOnEditText(1);
		//�I��[.]��
		view = solo.getView("button_minus");
		solo.clickOnView(view);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�I���Ʀr��[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//�I��[.]��
		view = solo.getView("button_dot");
		solo.clickOnView(view);
		//�I���Ʀr��[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��ର�ť�]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
	}
	
	public void testAddCashAccountWithEmptyNameAndZeroAmount() {
		
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
		//��J���B[0]
		solo.clickOnEditText(1);
		//�I���Ʀr��[6]
		view = solo.getView("button_0");
		solo.clickOnView(view);

		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��ର�ť�]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
	}
	
	public void testAddCashAccountWithEmptyNameAndEmptyAmount() {
		
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

		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��ର�ť�]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
	}
	
	public void testAddBankAccountWithEmptyNameAndPositiveIntegerAmount() {
		
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
		//��J���B[6842]
		solo.clickOnEditText(1);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�I���Ʀr��[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//�I���Ʀr��[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��ର�ť�]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
	}	
	
	public void testAddCreditAccountWithEmptyNameAndPositiveIntegerAmount() {
		
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
		//��J���B[6842]
		solo.clickOnEditText(1);
		//�I���Ʀr��[6]
		view = solo.getView("button_6");
		solo.clickOnView(view);
		//�I���Ʀr��[8]
		view = solo.getView("button_8");
		solo.clickOnView(view);
		//�I���Ʀr��[4]
		view = solo.getView("button_4");
		solo.clickOnView(view);
		//�I���Ʀr��[2]
		view = solo.getView("button_2");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		//����X�{toast���~�T��[�b��W�٤��ର�ť�]
		
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_ADD_ACCOUNT_WITH_EMPTY_NAME));
	}	
	
	protected void tearDown() {
		super.tearDown();
	}
}
