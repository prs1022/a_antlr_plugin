package java.com.yh.listener;

import com.vip.vma.antlr.instruction.ComplexQuery;
import com.vip.vma.antlr.instruction.InstructionBuilder;
import com.vip.vma.antlr.sqlbase.SqlBaseParser;
import com.vip.vma.antlr.util.AntlrHelper;
import main.java.com.yh.antlr.ParseTrees;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class MyKeyListener implements KeyListener {

    private JTextArea jta;
    private JTextField jf;

    public MyKeyListener(JTextArea jTextArea, JTextField jTextField) {
        this.jta = jTextArea;
        this.jf = jTextField;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == jf && e.getKeyCode() == 10) {//回车执行
            Highlighter highlighter = jta.getHighlighter();
            highlighter.removeAllHighlights();//每次执行取消前一次的高亮结果
            Color color = Color.CYAN;
            Highlighter.HighlightPainter higthPainter = new DefaultHighlighter.DefaultHighlightPainter(color);
            for (Interval interval : highLight(jf.getText(), jta.getText())) {
                try {
                    highlighter.addHighlight(interval.a, interval.b + 1, higthPainter);//需要高亮的区间
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * 筛选出根据dsl解析出的sql子句
     *
     * @param dsl
     * @param sql //todo 需要支持不完整的query sql
     * @return 返回文本字符间隔的区间
     */
    public List<Interval> highLight(String dsl, String sql) {
        if (dsl == null || StringUtils.isBlank(dsl) || sql == null || StringUtils.isBlank(sql)) {
            return Collections.EMPTY_LIST;
        }
        ComplexQuery aQuery = InstructionBuilder.build(dsl);
        SqlBaseParser parser = AntlrHelper.getParser(sql);
        ParseTree queryParseTree = parser.query();
        Set<ParseTree> set = aQuery.query(queryParseTree);
        List<String> rs = new ArrayList<>();
        List<Interval> intervals = new ArrayList<>();
        for (ParseTree parseTree : set) {
            intervals.add(ParseTrees.getSourceInterval(parseTree));
            rs.add(AntlrHelper.toSql(parseTree));
        }
        return intervals;
    }
}