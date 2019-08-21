package java.com.yh.panel;

import com.intellij.openapi.project.Project;

import javax.swing.*;
import java.awt.*;

public class SqlPanel extends JPanel {
    private Project project;

    public SqlPanel(Project project) {
        this.project = project;
        createGUI();
    }

    private void createGUI() {
        this.setLayout(new BorderLayout());
        this.add(createPanel(), BorderLayout.CENTER);
    }

    private Component createPanel() {
        MyPanel panel = new MyPanel();
        return panel.getOutPanel();
    }

}
