package robotium.test.shared;

import com.robotium.solo.Solo;

public class AvoidStartingPages {

	public static void toDo(Solo solo) {
		if(solo.waitForText("�z�]����AndroMoney  2.7.12", 1, 5000))
		{
			solo.goBack();
			solo.clickOnButton("�T�w");
		}
		if(solo.waitForText("����", 1, 5000))
			solo.clickOnButton("�U���A��");
	}
}
