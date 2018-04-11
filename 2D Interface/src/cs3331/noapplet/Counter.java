package cs3331.noapplet;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Counter extends Applet {

    private int value = 0;
    private Button incrementer = new Button("Increment");
    private Button decreneter = new Button("Decrement");
    private JLabel viewer = new JLabel("The Value is " + value);
    private Color DEFAULT_COLOR;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Game");
    private JMenuItem menuItem;

    @Override
    public void init() {
        super.init();
        menu.setMnemonic(KeyEvent.VK_G);
        menu.getAccessibleContext().setAccessibleDescription("AAAAAA");
        menuBar.add(menu);
        incrementer.addActionListener(e -> {
            value++;
            viewer.setText("The Value is " + value);
        });
        incrementer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                DEFAULT_COLOR = incrementer.getBackground();
                incrementer.setBackground(Color.GREEN);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e
             */
            @Override
            public void mouseExited(MouseEvent e) {
                incrementer.setBackground(DEFAULT_COLOR);
            }
        });
        decreneter.addActionListener(e -> {
            value--;
            viewer.setText("The Value is " + value);
        });
        decreneter.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                decreneter.setBackground(Color.RED);
            }

            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseExited(MouseEvent e) {
                decreneter.setBackground(DEFAULT_COLOR);
            }
        });
        add(viewer);
        add(incrementer);
        add(decreneter);
        add(menuBar);
    }
}
