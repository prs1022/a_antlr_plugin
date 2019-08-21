package java.com.yh;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import main.java.com.yh.PluginFrame;

public class Label extends AnAction {


    @Override
    public void actionPerformed(AnActionEvent e) {
        if (e.getProject() == null) {
            System.err.println("actionPerformed no project for " + e);
            return;
        }
       /* AQueryPluginController controller = AQueryPluginController.getInstance(e.getProject());
        controller.getSqlViewWindow().show(null);//展示下方栏*/
        Application application = ApplicationManager.getApplication();
        PluginFrame myComponent = application.getComponent(PluginFrame.class);
        myComponent.drawWindow();
    }
}
