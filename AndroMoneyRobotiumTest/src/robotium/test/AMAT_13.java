package robotium.test;

import robotium.test.shared.AndroMoneyAccountClasses;
import robotium.test.shared.AndroMoneyAccountNames;
import robotium.test.shared.AndroMoneyMenuTitles;
import robotium.test.shared.AndroMoneyPlaceholders;
import robotium.test.shared.AndroMoneyTransactionTypes;
import robotium.test.shared.AvoidStartingPages;
import android.view.KeyEvent;
import android.view.View;

public class AMAT_13 extends BaseInstrumentationTest {
	
	protected void setUp() {
		super.setUp();
	}
	
	public void testExportRecordsToDevices() throws InterruptedException {
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
		solo.enterText(0, AndroMoneyAccountNames.MY_CASH);
		//��J���B[9517]
		solo.clickOnEditText(1);
		//�I���Ʀr��[9]
		view = solo.getView("button_9");
		solo.clickOnView(view);
		//�I���Ʀr��[5]
		view = solo.getView("button_5");
		solo.clickOnView(view);
		//�I���Ʀr��[1]
		view = solo.getView("button_1");
		solo.clickOnView(view);
		//�I���Ʀr��[7]
		view = solo.getView("button_7");
		solo.clickOnView(view);
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�T�w�s�W�b��
		solo.clickOnButton("�T�w");
		
		//��b��[�{��]�s�W�@�����J
		//�I���b��[�{��]
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.waitForText(AndroMoneyTransactionTypes.OUTGOING);
		//�I��tab[��X]
		solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
		//��J���B[100]
		//�I���Ʀr��[1]
		solo.clickOnButton("1");
		//�I���Ʀr��[0]�⦸
		solo.clickOnButton("0");
		solo.clickOnButton("0");
		//�T�w��J���B
		solo.clickOnButton("OK");
		solo.waitForText("�s�J");
		solo.clickOnText("�s�J");
		//��^�b��[�{��]��T����
		solo.waitForText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.DEFAULT_CASH);
		assertTrue(solo.searchText("NT\\$ -100.00"));
		
		//��^�b�᭶��
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		
		//��b��[�Ȧ�]�s�W�@�����J
		//�I���b��[�Ȧ�]
		solo.waitForText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.waitForText(AndroMoneyTransactionTypes.INCOME);
		//�I��tab[���J]
		solo.clickOnText(AndroMoneyTransactionTypes.INCOME);
		//��J���B[753]
		//�I���Ʀr��[7]
		solo.clickOnButton("7");
		//�I���Ʀr��[5]
		solo.clickOnButton("5");
		//�I���Ʀr��[3]
		solo.clickOnButton("3");
		//�T�w��J���B
		solo.clickOnButton("OK");
		solo.waitForText("�s�J");
		solo.clickOnText("�s�J");
		//��^�b��[�Ȧ�]��T����
		solo.waitForText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.DEFAULT_BANK);
		assertTrue(solo.searchText("NT\\$ 753.00"));
		
		//��^�b�᭶��
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		
		//��s���b��s�W�@����b
		//�I���s���b��
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		solo.clickOnText(AndroMoneyAccountNames.MY_CASH);
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.waitForText(AndroMoneyTransactionTypes.TRANSFER);
		//�I��tab[��b]
		solo.clickOnText(AndroMoneyTransactionTypes.TRANSFER);
		//��J���B[426]
		//�I���Ʀr��[4]
		solo.clickOnButton("4");
		//�I���Ʀr��[2]
		solo.clickOnButton("2");
		//�I���Ʀr��[6]
		solo.clickOnButton("6");
		//�T�w��J���B
		solo.clickOnButton("OK");
		//�����X�b��
		solo.clickOnText("�q�G");//clickInList reference:http://blog.denevell.org/android-instrumentation-click-list.html 
		//���ܱb��C��
		//��ܷs���b��
		solo.waitForText("�����ק�");
		solo.clickOnText(AndroMoneyAccountNames.MY_CASH);
		//�����J�b��
		solo.clickOnText("��G");
		//���ܱb��C��
		//��ܱb��[�H�Υd]
		solo.waitForText("�����ק�");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.waitForText("�s�J");
		solo.clickOnText("�s�J");
		//��^�b��[�H�Υd]��T����
		solo.waitForText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		assertTrue(solo.searchText("NT\\$ 9,091.00"));
		
		//��^�b�᭶��
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		
		//�^����
		view = solo.getView("up");
		solo.clickOnView(view);
		view = solo.getView("up");
		solo.clickOnView(view);
		
		//���[�פJ�]�X�^]
		solo.waitForText(AndroMoneyMenuTitles.IMPORT_EXPORT);
		solo.clickOnText(AndroMoneyMenuTitles.IMPORT_EXPORT);
		solo.waitForText(AndroMoneyMenuTitles.IMPORT_EXPORT);
		//���[�ƥ���Ʈw]
		solo.clickOnText("�ƥ���Ʈw");
		solo.waitForText("�ƥ���Ʈw");
		//���[�ƥ��ܤ����Ŷ�]
		solo.clickOnText("�ƥ��ܤ����Ŷ�");
		//�T�w�ƥ�
		if(solo.searchText("���ɴ���"))
			solo.clickOnButton("�T�w");
		//�^��������������
		view = solo.getView("up");
		solo.clickOnView(view);
		
		//�I���Ĥ@��
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("�ԲӸ��", 1, 5000);
		assertTrue(solo.searchText("�ԲӸ��"));
		//�I���R�����s
		solo.clickOnScreen(730, 90);//only for nexus7 portrait
		solo.waitForText("�T�w�n�R��?");
		solo.clickOnButton("�T�w");
		
		//�I���ĤG��
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("�ԲӸ��", 1, 5000);
		//�I���R�����s
		solo.clickOnScreen(730, 90);//only for nexus7 portrait
		solo.waitForText("�T�w�n�R��?");
		solo.clickOnButton("�T�w");
		//�I�����[�b��]
		view = solo.getView("up");
		solo.clickOnView(view);
		solo.waitForText(AndroMoneyMenuTitles.ACCOUNT);
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		
		//�����b��W�١A�R���s���b��
		solo.clickLongOnText(AndroMoneyAccountNames.MY_CASH);
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		solo.clickOnText("�R��");
		//�T�w�R���b��
		solo.clickOnButton("�T�w");
		//�T�w�R���b��Ҧ�����
		solo.clickOnButton("�O");
		assertFalse(solo.searchText(AndroMoneyAccountNames.MY_CASH));
		
		//�^�����������e��
		view = solo.getView("up");
		solo.clickOnView(view);
		solo.waitForText("��", 1, 5000);
		assertTrue(solo.searchText("��"));
		
		
		view = solo.getView("up");
		solo.clickOnView(view);
		//���[�פJ�]�X�^]
		solo.clickOnText(AndroMoneyMenuTitles.IMPORT_EXPORT);
		solo.waitForText(AndroMoneyMenuTitles.IMPORT_EXPORT);
		//���[�٭��Ʈw]
		solo.clickOnText("�٭��Ʈw");
		solo.waitForText("�٭��Ʈw");
		//���[�q�����Ŷ��٭�]
		solo.clickOnText("�q�����Ŷ��٭�");
		//�T�w�٭�
		if(solo.searchText("���ɴ���"))
			solo.clickOnButton("�T�w");
		
		//�^����������
		view = solo.getView("up");
		solo.clickOnView(view);
		//���ҲĤ@�����
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("�ԲӸ��", 1, 5000);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		assertTrue(solo.searchText("NT\\$ 100"));
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//���ҲĤG�����
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("�ԲӸ��", 1, 5000);
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
		assertTrue(solo.searchText("NT\\$ 753"));
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//���ҲĤT�����
		solo.clickOnText(AndroMoneyAccountNames.MY_CASH);
		solo.waitForText("�ԲӸ��", 1, 5000);
		assertTrue(solo.searchText(AndroMoneyAccountNames.MY_CASH));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		assertTrue(solo.searchText("NT\\$ 426"));
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		
		//�I�����[�b��]
		view = solo.getView("up");
		solo.clickOnView(view);
		
		solo.waitForText(AndroMoneyMenuTitles.ACCOUNT);
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.clickLongOnText(AndroMoneyAccountNames.MY_CASH);
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		assertTrue(solo.searchText(AndroMoneyAccountNames.MY_CASH));
		assertTrue(solo.searchText(AndroMoneyAccountClasses.CASH));
		
		solo.sendKey(KeyEvent.KEYCODE_BACK);
	}
	
	protected void tearDown() {
		
		
		//�����b��W�١A�R���s���b��
		solo.clickLongOnText(AndroMoneyAccountNames.MY_CASH);
		solo.waitForText(AndroMoneyAccountNames.MY_CASH);
		solo.clickOnText("�R��");
		//�T�w�R���b��
		solo.clickOnButton("�T�w");
		//�T�w�R���b��Ҧ�����
		solo.clickOnButton("�O");
		assertFalse(solo.searchText(AndroMoneyAccountNames.MY_CASH));
		
		//�^�����������e��
		View view = solo.getView("up");
		solo.clickOnView(view);
		solo.waitForText("��", 1, 5000);
		assertTrue(solo.searchText("��"));
		//�I���Ĥ@��
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("�ԲӸ��", 1, 5000);
		assertTrue(solo.searchText("�ԲӸ��"));
		//�I���R�����s
		solo.clickOnScreen(730, 90);//only for nexus7 portrait
		solo.waitForText("�T�w�n�R��?");
		solo.clickOnButton("�T�w");
		
		//�I���ĤG��
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("�ԲӸ��", 1, 5000);
		//�I���R�����s
		solo.clickOnScreen(730, 90);//only for nexus7 portrait
		solo.waitForText("�T�w�n�R��?");
		solo.clickOnButton("�T�w");
		
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		view = solo.getView("up");
		solo.clickOnView(view);
		solo.waitForText(AndroMoneyMenuTitles.ACCOUNT, 1, 5000);
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
		solo.waitForText(AndroMoneyMenuTitles.ACCOUNT, 1, 5000);
		solo.waitForText(AndroMoneyAccountNames.DEFAULT_CASH);	
		super.tearDown();
	}
}
