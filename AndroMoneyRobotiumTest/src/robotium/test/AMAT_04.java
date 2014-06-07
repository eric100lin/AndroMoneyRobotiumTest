package robotium.test;

import robotium.test.shared.AndroMoneyAccountClasses;
import robotium.test.shared.AndroMoneyAccountNames;
import robotium.test.shared.AndroMoneyMenuTitles;
import robotium.test.shared.AndroMoneyPlaceholders;
import robotium.test.shared.AndroMoneyToastMessages;
import robotium.test.shared.AndroMoneyTransactionTypes;
import robotium.test.shared.AvoidStartingPages;
import android.view.KeyEvent;
import android.view.View;

public final class AMAT_04 extends BaseInstrumentationTest {

	protected void setUp() {
		super.setUp();
	}
	
	public void testDeleteLastAccountAndItsTransactions() {
		
		AvoidStartingPages.toDo(solo);
		solo.waitForText("��");
		assertTrue(solo.searchText("��"));
		
		View view;
		//�I�����������s
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//�i�J�b��C��
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		assertTrue(solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		assertTrue(solo.searchText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		
		//�R���b��[�Ȧ�]
		assertTrue(solo.waitForText(AndroMoneyAccountNames.DEFAULT_BANK));
		solo.clickLongOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		//�u�X�ק�/�R������
		assertTrue(solo.waitForText("\\[" + AndroMoneyAccountClasses.BANK + "\\]"
										+ AndroMoneyAccountNames.DEFAULT_BANK));
		assertTrue(solo.searchText("\\[" + AndroMoneyAccountClasses.BANK + "\\]"
										+ AndroMoneyAccountNames.DEFAULT_BANK));
		//�I��R��
		solo.clickOnText("�R��");
		assertTrue(solo.waitForText("�O�_�T�w�R��"));
		assertTrue(solo.searchText("�O�_�T�w�R��"));
		solo.clickOnButton("�T�w");
		assertTrue(solo.waitForText("�N�b�᤺�Ҧ������R��"));
		assertTrue(solo.searchText("�N�b�᤺�Ҧ������R��"));
		solo.clickOnButton("�O");
		assertFalse(solo.waitForText(AndroMoneyAccountNames.DEFAULT_BANK));
		
		//�R���b��[�H�Υd]
		assertTrue(solo.waitForText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		solo.clickLongOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		//�u�X�ק�/�R������
		assertTrue(solo.waitForText("\\[" + AndroMoneyAccountClasses.CREDIT + "\\]"
										+ AndroMoneyAccountNames.DEFAULT_CREDIT));
		assertTrue(solo.searchText("\\[" + AndroMoneyAccountClasses.CREDIT + "\\]"
										+ AndroMoneyAccountNames.DEFAULT_CREDIT));
		
		//�I��R��
		solo.clickOnText("�R��");
		assertTrue(solo.waitForText("�O�_�T�w�R��"));
		assertTrue(solo.searchText("�O�_�T�w�R��"));
		solo.clickOnButton("�T�w");
		assertTrue(solo.waitForText("�N�b�᤺�Ҧ������R��"));
		assertTrue(solo.searchText("�N�b�᤺�Ҧ������R��"));
		solo.clickOnButton("�O");
		assertFalse(solo.waitForText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		
		
		//�i�J[�{��]�b���T����
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		assertTrue(solo.waitForText(AndroMoneyAccountNames.DEFAULT_CASH) & 
					solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION));
		//[�{��]�b��ثe���B��0.00
		assertTrue(solo.searchText("NT\\$ 0.00"));
		//�s�W�@�������ƨ�[�{��]�b��
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		//�i�J�s�W�����ƭ���
		assertTrue(solo.waitForText(AndroMoneyTransactionTypes.OUTGOING) &
					solo.waitForText(AndroMoneyTransactionTypes.INCOME) &
					solo.waitForText(AndroMoneyTransactionTypes.TRANSFER));
		assertTrue(solo.searchText(AndroMoneyTransactionTypes.OUTGOING) &
					solo.searchText(AndroMoneyTransactionTypes.INCOME) &
					solo.searchText(AndroMoneyTransactionTypes.TRANSFER));
		//�s�W�@��[��X]
		solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
		//��J������B[643]
		solo.clickOnButton("6");
		solo.clickOnButton("4");
		solo.clickOnButton("3");
		//�T�w��J���B
		solo.clickOnButton("OK");
		solo.waitForText("�s�J");
		solo.clickOnText("�s�J");
		//�^��[�{��]�b���T����
		assertTrue(solo.waitForText(AndroMoneyAccountNames.DEFAULT_CASH) & 
					solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION));
		//[�{��]�b��ثe���B��-643
		assertTrue(solo.searchText("NT\\$ -643.00"));
		
		//��^�b��C��
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		assertTrue(solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		assertTrue(solo.searchText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		solo.clickLongOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		//�u�X�ק�/�R������
		assertTrue(solo.waitForText("\\[" + AndroMoneyAccountClasses.CASH + "\\]"
										+ AndroMoneyAccountNames.DEFAULT_CASH));
		assertTrue(solo.searchText("\\[" + AndroMoneyAccountClasses.CASH + "\\]"
										+ AndroMoneyAccountNames.DEFAULT_CASH));
		//�I��R��
		solo.clickOnText("�R��");
		assertTrue(solo.waitForText("�O�_�T�w�R��"));
		assertTrue(solo.searchText("�O�_�T�w�R��"));
		solo.clickOnButton("�T�w");
		assertTrue(solo.waitForText("�N�b�᤺�Ҧ������R��"));
		assertTrue(solo.searchText("�N�b�᤺�Ҧ������R��"));
		solo.clickOnButton("�O");
		//�T�{toast�T��[�ȳѤ@���L�k�R��]
		assertTrue(solo.searchText(AndroMoneyToastMessages.ERROR_DELETE_THE_LAST_ACCOUNT));
		
		
		//�b�ᤴ�b
		assertTrue(solo.waitForText(AndroMoneyAccountNames.DEFAULT_CASH));
		//����������b
		//�^��������������
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		assertTrue(solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION));
		assertTrue(solo.searchText(AndroMoneyPlaceholders.ADD_TRANSACTION));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		assertTrue(solo.searchText("NT\\$ 643"));
	}
	
	protected void tearDown() {
		
		//recovery
		//�I�����������s
		View view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//�i�J�b��C��
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		assertTrue(solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		assertTrue(solo.searchText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		//�s�W�b��[�Ȧ�]
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//�N������L����
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//��ܱb�����O
		solo.waitForText("���O");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.BANK);
		//��J�b��W��
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_BANK);
		solo.clickOnButton("�T�w");
		//�T�{Toast�T��
		assertTrue(solo.searchText(AndroMoneyToastMessages.SUCCES_ADD_ACCOUNT_HEADING));
		
		//�s�W�b��[�H�Υd]
		assertTrue(solo.waitForText(AndroMoneyPlaceholders.ADD_ACCOUNT));
		solo.clickOnText(AndroMoneyPlaceholders.ADD_ACCOUNT);
		//�N������L����
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//��ܱb�����O
		solo.waitForText("���O");
		solo.clickOnText(AndroMoneyAccountClasses.CASH);
		solo.clickOnText(AndroMoneyAccountClasses.CREDIT);
		//��J�b��W��
		solo.enterText(0, AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.clickOnButton("�T�w");
		//�T�{Toast�T��
		assertTrue(solo.searchText(AndroMoneyToastMessages.SUCCES_ADD_ACCOUNT_HEADING));
		
		//�^��������
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//�R���s�W���������
		assertTrue(solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION));
		assertTrue(solo.searchText(AndroMoneyPlaceholders.ADD_TRANSACTION));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		assertTrue(solo.searchText("NT\\$ 643"));
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("�ԲӸ��", 1, 5000);
		assertTrue(solo.searchText("�ԲӸ��"));
		//�I���R�����s
		solo.clickOnScreen(730, 90);//only for nexus7 portrait
		solo.waitForText("�T�w�n�R��?");
		solo.clickOnButton("�T�w");
		
		super.tearDown();
	}
}
