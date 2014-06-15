package robotium.test;

import robotium.test.shared.AndroMoneyMenuTitles;
import robotium.test.shared.AvoidStartingPages;
import android.content.Context;
import android.graphics.Point;
import android.test.ActivityInstrumentationTestCase2;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.robotium.solo.Solo;

public class BaseInstrumentationTest extends ActivityInstrumentationTestCase2 {
	//待測APK的MainActivity完整名稱
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.kpmoney.android.MainActivity";
	private static Class launcherActivityClass;
	static {
		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
		}
	}
	
	public BaseInstrumentationTest() {
		super(launcherActivityClass);
	}
	
	protected Solo solo;
	protected void setUp() {
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	protected void jumpToAccountPage() {
		AvoidStartingPages.toDo(solo);
		solo.waitForText("日");
		assertTrue(solo.searchText("日"));
		View view;
		//點擊左側選單按鈕
		view = solo.getView("up");//resource id
		solo.clickOnView(view);
		//到帳戶頁面
		solo.clickOnText(AndroMoneyMenuTitles.ACCOUNT);
	}
	
	protected void clickWidgetOnDialog(String resourceId) {
		Context context = getInstrumentation().getTargetContext().getApplicationContext();
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		
		View view = solo.getView(resourceId);
		final int[] location = new int[2];  
		view.getLocationOnScreen(location); 
		int x = location[0] + width;
		int y = location[1]+view.getHeight()/2;
		assertNotNull(view);
		//For debug loagging...
		//assertEquals("Debug", "x="+x+"y="+y+",location[0]="+location[0]+"location[1]="+location[1]);
		solo.clickOnScreen(x, y);
	}
	
	protected void tearDown() {
		solo.finishOpenedActivities();
	}
}
