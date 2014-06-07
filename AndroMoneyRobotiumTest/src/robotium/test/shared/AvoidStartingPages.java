package robotium.test.shared;

import com.robotium.solo.Solo;

public class AvoidStartingPages {

	public static void toDo(Solo solo) {
		if(solo.waitForText("理財幫手AndroMoney  2.7.12", 1, 5000))
		{
			solo.goBack();
			solo.clickOnButton("確定");
		}
		if(solo.waitForText("評價", 1, 5000))
			solo.clickOnButton("下次再說");
	}
}
