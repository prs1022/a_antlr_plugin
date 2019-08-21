package java.com.yh;

import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

public class MyPluginRegistration implements ApplicationComponent {
    public MyPluginRegistration() {
    }

    @Override
    public void initComponent() {
//        ActionManager am = ActionManager.getInstance();
//        ActionGroup actionGroup = new ProjectWindowActionGroup();
//        ActionManager.getInstance().createActionPopupMenu("antlrPop",actionGroup);
//
//        TextBox action = new TextBox();
//
//        // Passes an instance of your custom TextBoxes class to the registerAction method of the ActionManager class.
//        am.registerAction("MyPluginAction", action);
//
//        // Gets an instance of the WindowMenu action group.
//        DefaultActionGroup windowM = (DefaultActionGroup) am.getAction("WindowMenu");
//
//        // Adds a separator and a new menu command to the WindowMenu group on the main menu.
//        windowM.addSeparator();
//        windowM.add(action);
    }

    @Override
    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "MyPlugin";
    }
}
