package robotium.test;

//robotium-solo-4.0.jar
//import com.jayway.android.robotium.solo.Solo;
//robotium-solo-5.1.jar
import robotium.test.shared.AndroMoneyAccountNames;
import robotium.test.shared.AndroMoneyPlaceholders;
import robotium.test.shared.AndroMoneyTransactionTypes;
import robotium.test.shared.AvoidStartingPages;

public class AMAT_07 extends BaseInstrumentationTest {
	private static final String COMMENTS = "安安~我是備註";
	
	protected void setUp() {
		super.setUp();
		AvoidStartingPages.toDo(solo);
	}
	
	public void testAddExpensesInteger() {
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
		
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
		assertTrue(solo.searchText("餐飲食品 - 早餐"));		
		deleteRecord();
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText("-1,234"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
		assertTrue(solo.searchText("居家生活 - 電費"));	
		deleteRecord();
	}
	
	public void testAddExpensesFloat() {
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
		
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
		assertTrue(solo.searchText("運輸交通 - 飛機"));		
		assertTrue(solo.searchText("1 日 | 永不"));	
		deletePeriodRecord();
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText("-1,234.4"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
		assertTrue(solo.searchText("汽機車 - 罰單"));	
		assertTrue(solo.searchText("1 月 | 永不"));	
		deletePeriodRecord();
	}
	
	public void testAddExpensesEmptyNoInput() {
		solo.clickOnText(AndroMoneyPlaceholders.ADD_TRANSACTION);
		solo.clickOnText(AndroMoneyTransactionTypes.OUTGOING);
		
		addRecord5();
		solo.clickOnButton("再記一筆");
		addRecord6();
		solo.clickOnButton("存入");
		solo.waitForText(" 0");
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText("0"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_CASH));
		assertTrue(solo.searchText("人情交際 - 送禮請客"));	
		assertTrue(solo.searchText("1 週 | 永不"));	
		deletePeriodRecord();
		
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		solo.waitForText("詳細資料", 1, 5000);
		assertTrue(solo.searchText("0"));
		assertTrue(solo.searchText(AndroMoneyAccountNames.DEFAULT_BANK));
		assertTrue(solo.searchText("圖書刊物 - 漫畫"));	
		assertTrue(solo.searchText("1 年 | 永不"));	
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
		solo.clickOnText("餐飲食品");
		solo.clickOnText("早餐");
		
		solo.clickOnText("帳戶：");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		
		solo.clickOnText("專案：");
		solo.clickOnText("無");
		
		solo.clickOnText("商家：");
		solo.clickOnText("無");
		
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
		solo.clickOnText("居家生活");
		solo.clickOnText("電費");
		
		solo.clickOnText("帳戶：");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		
		solo.clickOnText("專案：");
		solo.clickOnText("商業");
		
		solo.clickOnText("商家：");
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
		solo.clickOnText("運輸交通");
		solo.clickOnText("飛機");
		
		solo.clickOnText("帳戶：");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CREDIT);
		
		solo.clickOnText("專案：");
		solo.clickOnText("個人");
		
		solo.clickOnText("商家：");
		solo.clickOnText("麥當勞");
		
		solo.clickOnText("週期：");
		solo.clickOnRadioButton(1);
		solo.clickOnText("日");
		solo.clickOnButton("確定");
		
		solo.clickOnText("備註：");
		solo.enterText(0, COMMENTS);
		solo.clickOnButton("確定");
	}
	
	protected void addRecord4() {
		//輸入金額-1234.4
		solo.clickOnButton("-");
		solo.clickOnButton("1");
		solo.clickOnButton("2");
		solo.clickOnButton("3");
		solo.clickOnButton("4");
		solo.clickOnButton("．");
		solo.clickOnButton("4");
		solo.clickOnButton("OK");
		
		solo.clickOnText("類別：");
		solo.clickOnText("汽機車");
		solo.clickOnText("罰單");
		
		solo.clickOnText("帳戶：");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		
		solo.clickOnText("專案：");
		solo.clickOnText("無");
		
		solo.clickOnText("商家：");
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
		solo.clickOnText("人情交際");
		solo.clickOnText("送禮請客");
		
		solo.clickOnText("帳戶：");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_CASH);
		
		solo.clickOnText("專案：");
		solo.clickOnText("個人");
		
		solo.clickOnText("商家：");
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
		solo.clickOnText("圖書刊物");
		solo.clickOnText("漫畫");
		
		solo.clickOnText("帳戶：");
		solo.clickOnText(AndroMoneyAccountNames.DEFAULT_BANK);
		
		solo.clickOnText("專案：");
		solo.clickOnText("無");
		
		solo.clickOnText("商家：");
		solo.clickOnText("無");
		
		solo.clickOnText("週期：");
		solo.clickOnRadioButton(1);
		solo.clickOnText("年");
		solo.clickOnButton("確定");
		
		solo.clickOnText("備註：");
		solo.enterText(0, COMMENTS);
		solo.clickOnButton("確定");
	}
	
	private void deleteRecord() {
		clickWidgetOnDialog("delet_record");
		solo.waitForText("確定要刪除？");
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
