package java.com.yh.controller;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import main.java.com.yh.panel.MyPanel;
import main.java.com.yh.panel.SqlPanel;
import org.jetbrains.annotations.NotNull;

public class AQueryPluginController implements ProjectComponent {

    public Project project;
    public ToolWindow sqlViewWindow;    // same for all grammar editor
    public SqlPanel sqlPanel;    // same for all grammar editor
    private String PLUGIN_WINDOW_ID = "antlr语法高亮插件"; //sql输入窗口

    public AQueryPluginController(Project project) {
        this.project = project;
    }

    @Override
    public void projectOpened() {
        createToolWindow();
    }

    /**
     * 创建工具窗口
     */
    private void createToolWindow() {
        ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(project);

        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(new MyPanel().getOutPanel(), "", false);

        sqlViewWindow = toolWindowManager.registerToolWindow(PLUGIN_WINDOW_ID, true, ToolWindowAnchor.BOTTOM);//设置在IDE窗口底部
        sqlViewWindow.getContentManager().addContent(content);
//        sqlViewWindow.setIcon(Icons.FILE);//通过设置IconLoader.getIcon(filePath)
    }

    @Override
    public void projectClosed() {

    }


    public static AQueryPluginController getInstance(Project project) {
        if (project == null) {
            System.err.println("getInstance: project is null");
            return null;
        }
        AQueryPluginController pc = project.getComponent(AQueryPluginController.class);
        if (pc == null) {
            System.err.println("getInstance: getComponent() for " + project.getName() + " returns null");
        }
        return pc;
    }

    public ToolWindow getSqlViewWindow() {
        return sqlViewWindow;
    }

    @Override
    public void initComponent() {

    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    @Override
    public String getComponentName() {
        return "a_antlr_plugin";
    }
}
