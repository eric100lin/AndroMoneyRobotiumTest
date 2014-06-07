package robotium.test.shared;

import android.view.View;
import com.robotium.solo.Solo;

public class KeyboardHelper {

    public static void pressOk(Solo solo) {
        View view = solo.getView("button_ok");
        solo.clickOnView(view);
    }

    public static void keyInLiteral(Solo solo, String literal) {
        String viewName;
        for (int index=0; index<literal.length(); index++) {
            char c = literal.charAt(index);
            if (c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5'
             || c=='6' || c=='7' || c=='8' || c=='9') {
                viewName = "button_" + c;
            }
            else if (c=='A')    viewName = "button_ac";
            else if (c=='D')    viewName = "button_del";
            else if (c=='+')    viewName = "button_add";
            else if (c=='-')    viewName = "button_minus";
            else if (c=='*')    viewName = "button_multiply";
            else if (c=='/')    viewName = "button_divide";
            else if (c=='.')    viewName = "button_dot";
            else continue;
            View view = solo.getView(viewName);
            solo.clickOnView(view);
        }
    }
}