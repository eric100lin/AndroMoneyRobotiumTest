package robotium.test;

//robotium-solo-4.0.jar
//import com.jayway.android.robotium.solo.Solo;
//robotium-solo-5.1.jar
import robotium.test.shared.AndroMoneyAccountNames;
import robotium.test.shared.AndroMoneyPlaceholders;
import robotium.test.shared.AndroMoneyTransactionTypes;
import robotium.test.shared.AvoidStartingPages;

public class AMAT_07 extends BaseInstrumentationTest {
	private static final String COMMENTS = "�w�w~�ڬO�Ƶ�";
	
	protected void setUp() {
		super.setUp();
		AvoidStartingPages.toDo(solo);
	}
	
	public void testAddExpensesInteger() {
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
		
		addRecord1();
		solo.clickOnButton("�A�O�@��");
		addRecord2();
		solo.clickOnButton("�s�J");
		solo.waitForText(" 5,533");
		solo.waitForText(" -1,234");
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("�ԲӸ��", 1, 5000);
		assertTrue(solo.searchText("5,533"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		assertTrue(solo.searchText("�\�����~ - ���\"));		
		deleteRecord();
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("�ԲӸ��", 1, 5000);
		assertTrue(solo.searchText("-1,234"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
		assertTrue(solo.searchText("�~�a�ͬ� - �q�O"));	
		deleteRecord();
	}
	
	public void testAddExpensesFloat() {
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
		
		addRecord3();
		solo.clickOnButton("�A�O�@��");
		addRecord4();
		solo.clickOnButton("�s�J");
		solo.waitForText(" 5,533.3");
		solo.waitForText(" -1,234.4");
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.waitForText("�ԲӸ��", 1, 5000);
		assertTrue(solo.searchText("5,533.3"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		assertTrue(solo.searchText("�B���q - ����"));		
		assertTrue(solo.searchText("1 �� | �ä�"));	
		deletePeriodRecord();
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("�ԲӸ��", 1, 5000);
		assertTrue(solo.searchText("-1,234.4"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
		assertTrue(solo.searchText("�T���� - �@��"));	
		assertTrue(solo.searchText("1 �� | �ä�"));	
		deletePeriodRecord();
	}
	
	public void testAddExpensesEmptyNoInput() {
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
		
		addRecord5();
		solo.clickOnButton("�A�O�@��");
		addRecord6();
		solo.clickOnButton("�s�J");
		solo.waitForText(" 0");
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("�ԲӸ��", 1, 5000);
		assertTrue(solo.searchText("0"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		assertTrue(solo.searchText("�H����� - �e§�Ы�"));	
		assertTrue(solo.searchText("1 �g | �ä�"));	
		deletePeriodRecord();
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("�ԲӸ��", 1, 5000);
		assertTrue(solo.searchText("0"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
		assertTrue(solo.searchText("�ϮѥZ�� - ���e"));	
		assertTrue(solo.searchText("1 �~ | �ä�"));	
		deletePeriodRecord();
	}
	
	protected void addRecord1() {
		//��J���B5533
		solo.clickOnButton("5");
		solo.clickOnButton("5");
		solo.clickOnButton("3");
		solo.clickOnButton("3");
		solo.clickOnButton("OK");
		
		solo.clickOnText("���O�G");
		solo.clickOnText("�\�����~");
		solo.clickOnText("���\");
		
		solo.clickOnText("�b��G");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		
		solo.clickOnText("�M�סG");
		solo.clickOnText("�L");
		
		solo.clickOnText("�Ӯa�G");
		solo.clickOnText("�L");
		
		solo.clickOnText("�g���G");
		solo.clickOnText("�@��");
		solo.clickOnButton("�T�w");
		
		solo.clickOnText("�Ƶ��G");
		solo.clickOnButton("�T�w");
	}
	
	protected void addRecord2() {
		//��J���B5533
		solo.clickOnButton("-");
		solo.clickOnButton("1");
		solo.clickOnButton("2");
		solo.clickOnButton("3");
		solo.clickOnButton("4");
		solo.clickOnButton("OK");
		
		solo.clickOnText("���O�G");
		solo.clickOnText("�~�a�ͬ�");
		solo.clickOnText("�q�O");
		
		solo.clickOnText("�b��G");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		
		solo.clickOnText("�M�סG");
		solo.clickOnText("�ӷ~");
		
		solo.clickOnText("�Ӯa�G");
		solo.clickOnText("�L");
		
		solo.clickOnText("�g���G");
		solo.clickOnText("�@��");
		solo.clickOnButton("�T�w");
		
		solo.clickOnText("�Ƶ��G");
		solo.enterText(0, COMMENTS);
		solo.clickOnButton("�T�w");
	}
	
	protected void addRecord3() {
		//��J���B5533
		solo.clickOnButton("5");
		solo.clickOnButton("5");
		solo.clickOnButton("3");
		solo.clickOnButton("3");
		solo.clickOnButton("�D");
		solo.clickOnButton("3");
		solo.clickOnButton("OK");
		
		solo.clickOnText("���O�G");
		solo.clickOnText("�B���q");
		solo.clickOnText("����");
		
		solo.clickOnText("�b��G");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		
		solo.clickOnText("�M�סG");
		solo.clickOnText("�ӤH");
		
		solo.clickOnText("�Ӯa�G");
		solo.clickOnText("�����");
		
		solo.clickOnText("�g���G");
		solo.clickOnRadioButton(1);
		solo.clickOnText("��");
		solo.clickOnButton("�T�w");
		
		solo.clickOnText("�Ƶ��G");
		solo.enterText(0, COMMENTS);
		solo.clickOnButton("�T�w");
	}
	
	protected void addRecord4() {
		//��J���B-1234.4
		solo.clickOnButton("-");
		solo.clickOnButton("1");
		solo.clickOnButton("2");
		solo.clickOnButton("3");
		solo.clickOnButton("4");
		solo.clickOnButton("�D");
		solo.clickOnButton("4");
		solo.clickOnButton("OK");
		
		solo.clickOnText("���O�G");
		solo.clickOnText("�T����");
		solo.clickOnText("�@��");
		
		solo.clickOnText("�b��G");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		
		solo.clickOnText("�M�סG");
		solo.clickOnText("�L");
		
		solo.clickOnText("�Ӯa�G");
		solo.clickOnText("�L");
		
		solo.clickOnText("�g���G");
		solo.clickOnRadioButton(1);
		solo.clickOnText("��");
		solo.clickOnButton("�T�w");
		
		solo.clickOnText("�Ƶ��G");
		solo.enterText(0, COMMENTS);
		solo.clickOnButton("�T�w");
	}
	
	protected void addRecord5() {
		//��J���B0
		solo.clickOnButton("0");
		solo.clickOnButton("OK");
		
		solo.clickOnText("���O�G");
		solo.clickOnText("�H�����");
		solo.clickOnText("�e§�Ы�");
		
		solo.clickOnText("�b��G");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		
		solo.clickOnText("�M�סG");
		solo.clickOnText("�ӤH");
		
		solo.clickOnText("�Ӯa�G");
		solo.clickOnText("�L");
		
		solo.clickOnText("�g���G");
		solo.clickOnRadioButton(1);
		solo.clickOnRadioButton(3);
		solo.clickOnButton("�T�w");
		
		solo.clickOnText("�Ƶ��G");
		solo.enterText(0, COMMENTS);
		solo.clickOnButton("�T�w");
	}
	
	protected void addRecord6() {
		//����J���B
		solo.clickOnButton("OK");
		
		solo.clickOnText("���O�G");
		solo.clickOnText("�ϮѥZ��");
		solo.clickOnText("���e");
		
		solo.clickOnText("�b��G");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		
		solo.clickOnText("�M�סG");
		solo.clickOnText("�L");
		
		solo.clickOnText("�Ӯa�G");
		solo.clickOnText("�L");
		
		solo.clickOnText("�g���G");
		solo.clickOnRadioButton(1);
		solo.clickOnText("�~");
		solo.clickOnButton("�T�w");
		
		solo.clickOnText("�Ƶ��G");
		solo.enterText(0, COMMENTS);
		solo.clickOnButton("�T�w");
	}
	
	private void deleteRecord() {
		clickWidgetOnDialog("delet_record");
		solo.waitForText("�T�w�n�R���H");
		solo.clickOnButton("�T�w");
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
	}
	
	private void deletePeriodRecord() {
		clickWidgetOnDialog("delet_record");
		solo.waitForText("�T�w�n�R���H");
		solo.clickOnButton("�T�w");
		solo.waitForText("�R���Ҧ��������g���ʬ���?",1, 500);
		solo.clickOnButton("�O");
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
	}
}
