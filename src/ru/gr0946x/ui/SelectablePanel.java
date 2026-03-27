package ru.gr0946x.ui;

import ru.gr0946x.ui.painting.Painter;

import java.awt.*;
import java.awt.event.*;

public class SelectablePanel extends PaintPanel{
    private SelectedRect rect = null;
    private Graphics g;

    public SelectablePanel(Painter painter) {
        super(painter);
        g = getGraphics();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                rect = new SelectedRect(e.getX(), e.getY());
                paintSelectedRect();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                paintSelectedRect();
                rect = null;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                paintSelectedRect();
                if (rect != null){
                    rect.setLastPoint(e.getX(), e.getY());
                }
                paintSelectedRect();
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                g = getGraphics();
            }
        });
    }

    private void paintSelectedRect(){
        if (g != null){
            g.setXORMode(Color.WHITE);
            g.setColor(Color.BLACK);
            g.drawRect(
                    rect.getUpperLeft().x,
                    rect.getUpperLeft().y,
                    rect.getWidth(),
                    rect.getHeight()
            );
            g.setPaintMode();
        }
    }
}
