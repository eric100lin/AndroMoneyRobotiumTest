package robotium.test;

import android.test.ActivityInstrumentationTestCase2;

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
	
	protected void tearDown() {
		solo.finishOpenedActivities();
	}
}
