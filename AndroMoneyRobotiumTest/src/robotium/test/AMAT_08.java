package robotium.test;

import robotium.test.shared.AndroMoneyAccountNames;
import robotium.test.shared.AndroMoneyPlaceholders;
import robotium.test.shared.AndroMoneyTransactionTypes;
import robotium.test.shared.AvoidStartingPages;

public class AMAT_08 extends BaseInstrumentationTest {
	private static final String COMMENTS = "安安~我是備註";
	
	protected void setUp() {
		super.setUp();
		AvoidStartingPages.toDo(solo);
	}
	
	public void testAddIncomeInteger() {
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyTransactionTypes.INCOME);
		
		addRecord1();
		solo.clickOnButton("再記一筆");
		addRecord2();
		solo.clickOnButton("存入");
		solo.waitForText(" 5,533");
		solo.waitForText(" -1,234");
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText("5,533"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		assertTrue(solo.searchText("一般收入 - 打工"));		
		deleteRecord();
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText("-1,234"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
		assertTrue(solo.searchText("投資收入 - 基金"));	
		deleteRecord();
	}
	
	public void testAddIncomeFloat() {
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyTransactionTypes.INCOME);
		
		addRecord3();
		solo.clickOnButton("再記一筆");
		addRecord4();
		solo.clickOnButton("存入");
		solo.waitForText(" 5,533.3");
		solo.waitForText(" -1,234.4");
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText("5,533.3"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		assertTrue(solo.searchText("一般收入 - 零用錢"));	
		assertTrue(solo.searchText("1 年 | 永不"));	
		deletePeriodRecord();
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText("-1,234.4"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
		assertTrue(solo.searchText("投資收入 - 基金"));	
		assertTrue(solo.searchText("1 月 | 永不"));	
		deletePeriodRecord();
	}
	
	public void testAddIncomeEmptyNoInput() {
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyTransactionTypes.INCOME);
		
		addRecord5();
		solo.clickOnButton("再記一筆");
		addRecord6();
		solo.clickOnButton("存入");
		solo.waitForText(" 0");
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText("0"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
		assertTrue(solo.searchText("一般收入 - 其他"));		
		assertTrue(solo.searchText("1 週 | 永不"));	
		deletePeriodRecord();
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText("0"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CREDIT));
		assertTrue(solo.searchText("投資收入 - 定存"));	
		assertTrue(solo.searchText("1 日 | 永不"));	
		deletePeriodRecord();
	}
	
	protected void addRecord1() {
		//輸入金額5533
		solo.clickOnButton("5");
		solo.clickOnButton("5");
		solo.clickOnButton("3");
		solo.clickOnButton("3");
		solo.clickOnButton("OK");
		
		solo.clickOnText("類別：");
		solo.clickOnText("一般收入");
		solo.clickOnText("打工");
		
		solo.clickOnText("帳戶：");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		
		solo.clickOnText("專案：");
		solo.clickOnText("個人");
		
		solo.clickOnText("公司：");
		solo.clickOnText("麥當勞");
		
		solo.clickOnText("週期：");
		solo.clickOnText("一次");
		solo.clickOnButton("確定");
		
		solo.clickOnText("備註：");
		solo.clickOnButton("確定");
	}
	
	protected void addRecord2() {
		//輸入金額5533
		solo.clickOnButton("-");
		solo.clickOnButton("1");
		solo.clickOnButton("2");
		solo.clickOnButton("3");
		solo.clickOnButton("4");
		solo.clickOnButton("OK");
		
		solo.clickOnText("類別：");
		solo.clickOnText("投資收入");
		solo.clickOnText("基金");
		
		solo.clickOnText("帳戶：");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		
		solo.clickOnText("專案：");
		solo.clickOnText("無");
		
		solo.clickOnText("公司：");
		solo.clickOnText("無");
		
		solo.clickOnText("週期：");
		solo.clickOnText("一次");
		solo.clickOnButton("確定");
		
		solo.clickOnText("備註：");
		solo.enterText(0, COMMENTS);
		solo.clickOnButton("確定");
	}
	
	protected void addRecord3() {
		//輸入金額5533
		solo.clickOnButton("5");
		solo.clickOnButton("5");
		solo.clickOnButton("3");
		solo.clickOnButton("3");
		solo.clickOnButton("．");
		solo.clickOnButton("3");
		solo.clickOnButton("OK");
		
		solo.clickOnText("類別：");
		solo.clickOnText("一般收入");
		solo.clickOnText("零用錢");
		
		solo.clickOnText("帳戶：");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		
		solo.clickOnText("專案：");
		solo.clickOnText("旅遊");
		
		solo.clickOnText("公司：");
		solo.clickOnText("蘋果公司");
		
		solo.clickOnText("週期：");
		solo.clickOnRadioButton(1);
		solo.clickOnText("年");
		solo.clickOnButton("確定");
		
		solo.clickOnText("備註：");
		solo.clickOnButton("確定");
	}
	
	protected void addRecord4() {
		//輸入金額5533
		solo.clickOnButton("-");
		solo.clickOnButton("1");
		solo.clickOnButton("2");
		solo.clickOnButton("3");
		solo.clickOnButton("4");
		solo.clickOnButton("．");
		solo.clickOnButton("4");
		solo.clickOnButton("OK");
		
		solo.clickOnText("類別：");
		solo.clickOnText("投資收入");
		solo.clickOnText("基金");
		
		solo.clickOnText("帳戶：");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		
		solo.clickOnText("專案：");
		solo.clickOnText("無");
		
		solo.clickOnText("公司：");
		solo.clickOnText("無");
		
		solo.clickOnText("週期：");
		solo.clickOnRadioButton(1);
		solo.clickOnText("月");
		solo.clickOnButton("確定");
		
		solo.clickOnText("備註：");
		solo.enterText(0, COMMENTS);
		solo.clickOnButton("確定");
	}
	
	protected void addRecord5() {
		//輸入金額0
		solo.clickOnButton("0");
		solo.clickOnButton("OK");
		
		solo.clickOnText("類別：");
		solo.clickOnText("一般收入");
		solo.clickOnText("其他");
		
		solo.clickOnText("帳戶：");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		
		solo.clickOnText("專案：");
		solo.clickOnText("無");
		
		solo.clickOnText("公司：");
		solo.clickOnText("無");
		
		solo.clickOnText("週期：");
		solo.clickOnRadioButton(1);
		solo.clickOnRadioButton(3);
		solo.clickOnButton("確定");
		
		solo.clickOnText("備註：");
		solo.enterText(0, COMMENTS);
		solo.clickOnButton("確定");
	}
	
	protected void addRecord6() {
		//不輸入金額
		solo.clickOnButton("OK");
		
		solo.clickOnText("類別：");
		solo.clickOnText("投資收入");
		solo.clickOnText("定存");
		
		solo.clickOnText("帳戶：");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		
		solo.clickOnText("專案：");
		solo.clickOnText("旅遊");
		
		solo.clickOnText("公司：");
		solo.clickOnText("星巴克");
		
		solo.clickOnText("週期：");
		solo.clickOnRadioButton(1);
		solo.clickOnText("日");
		solo.clickOnButton("確定");
		
		solo.clickOnText("備註：");
		solo.enterText(0, COMMENTS);
		solo.clickOnButton("確定");
	}
	
	private void deleteRecord() {
		clickWidgetOnDialog("delet_record");
		solo.clickOnButton("確定");
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
	}

	private void deletePeriodRecord() {
		clickWidgetOnDialog("delet_record");
		solo.waitForText("確定要刪除？");
		solo.clickOnButton("確定");
		solo.waitForText("刪除所有對應的週期性紀錄?",1, 500);
		solo.clickOnButton("是");
		solo.waitForText(AndroMoneyPlaceholders.ADD_TRANSACTION);
	}
}
