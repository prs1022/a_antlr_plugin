package main.java.com.yh;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.vip.vma.antlr.instruction.ComplexQuery;
import com.vip.vma.antlr.instruction.InstructionBuilder;
import com.vip.vma.antlr.sqlbase.SqlBaseParser;
import com.vip.vma.antlr.util.AntlrHelper;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.util.Set;

public class TextBox extends AnAction {

    // If you register the action from Java code, this constructor is used to set the menu item name
    // (optionally, you can specify the menu description and an icon to display next to the menu item).
    // You can omit this constructor when registering the action in the plugin.xml file.
    public TextBox() {
        // Set the menu item name.
        super("Text _Boxes");
        // Set the menu item name, description and icon.
        // super("Text _Boxes","Item description",IconLoader.getIcon("/Mypackage/icon.png"));
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        JTextPane jpanel = new JTextPane();
        Messages.configureMessagePaneUi(jpanel, "====antrl语法高亮===");
        String sql = Messages.showMultilineInputDialog(project, "输入sql", "sql输入", null, null, null);
        //        String sql = Messages.showInputDialog(project, "输入DSL", "语法树高亮", Messages.getQuestionIcon());
        String dsl = Messages.showInputDialog(project, "输入DSL", "语法树高亮", Messages.getQuestionIcon());
        ComplexQuery aQuery = InstructionBuilder.build(dsl);
        SqlBaseParser parser = AntlrHelper.getParser(sql);
        Set<org.antlr.v4.runtime.tree.ParseTree> set = aQuery.query(parser.query());
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (ParseTree parseTree : set) {
            stringBuilder.append("[" + (i++) + "]:");
            stringBuilder.append(AntlrHelper.toSql(parseTree));
            stringBuilder.append("\n");
        }
        Messages.showMessageDialog(project, "the dsl=>" + dsl + "\nthe result=>" + stringBuilder.toString()
                , "解析结果", Messages.getInformationIcon());
    }
}
