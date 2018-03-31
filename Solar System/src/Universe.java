import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A special panel class to provide Applet-like APIs including the life-cycle methods.
 * Define a subclass and call the {@link #run()} method to run it in a JFrame (see the
 * sample code below).
 * @author cheon
 */
@SuppressWarnings("serial")
public class Universe extends JPanel {

    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 900;
    private Map<String, String> parameters = new HashMap<>();
    private JLabel statusBar = new JLabel();
    protected Dimension dim;
    private Sun sun;
    private Timer timer;


    /** Create a new instance. */
    protected Universe() {
        this(new String[0]);
    }

    /** Create a new instance passing the given parameters.
     * The <code>params</code> parameter behaves like Applet parameters
     * and can be accessed by calling the {@link #getParameter(String)} method.
     * The <code>params</code> parameter is strings of name-value pairs, e.g.,
     * <code>{"width=300", "height=400", "color=red"}</code>.
     *
     * @param params Parameter name-value pairs. A parameter name and its value is separated
     *               by a "=" sign, e.g., "width=300".
     */
    private Universe(String[] params) {
        parseParameters(params);
    }

    /** Called after an instance is created. */
    private void init() {
        dim = getSize();
        sun = new Sun();
        sun.init(dim);
        timer = new Timer(10, e -> repaint());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        sun.draw(g);
    }

    /** Called when the start button is clicked. */
    private void start() {
        timer.start();
    }

    /** Called when the stop button is clicked. */
    public void stop() {
        timer.stop();
    }

    /** Resize this Universe. It's deprecated; use the <code>setSize</code> method.
     * This method must be called in constructors to have effect. */
    @Deprecated
    public void resize(Dimension dim) {
        setMinimumSize(dim);
        setMaximumSize(dim);
        setPreferredSize(dim);
        invalidate();
    }

    /** Resize this Universe. It's deprecated; use the <code>setSize</code> method.
     * This method must be called in constructors to have effect. */
    @Deprecated
    public void resize(int width, int height) {
        resize(new Dimension(width, height));
    }

    /** Return the value of the named parameter or null if no such
     * parameter is defined.
     *
     * @param name Parameter name.
     * @return Value of the named parameter, or null if there is no such parameter. */
    private String getParameter(String name) {
        return parameters.get(name);
    }

    /** Parse the given parameters, each of the form: <code>name=value</code>. */
    private void parseParameters(String[] params) {
        for (String param: params) {
            StringTokenizer tokens = new StringTokenizer(param, "=");
            if (tokens.hasMoreTokens()) {
                String name = tokens.nextToken().trim().toLowerCase();
                String value = tokens.hasMoreTokens() ? tokens.nextToken().trim() : null;
                parameters.put(name, value);
            }
        }
        int width = parseInt(getParameter("width"), DEFAULT_WIDTH);
        int height = parseInt(getParameter("height"), DEFAULT_HEIGHT);
        setPreferredSize(new Dimension(width, height));
    }

    /** Parse an int value and return it or the default value if the parsed value
     * is negative or a parsing error is encountered.
     */
    private static int parseInt(String value, int defaultValue) {
        try {
            int parsedValue = Integer.parseInt(value);
            return parsedValue <= 0 ? defaultValue : parsedValue;
        } catch (NumberFormatException ignored) {
        }
        return defaultValue;
    }

    /** Create a button with the given label. */

    /** Create a UI consisting of start and stop buttons. */
    private JPanel createUI() {
        JPanel control = new JPanel();
        control.setLayout(new FlowLayout());
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());
        root.add(this, BorderLayout.CENTER);
        root.add(statusBar, BorderLayout.SOUTH);
        return root;
    }

    /** Show this Universe in a Swing Jframe with control buttons. */
    private void run() {
        JFrame frame = new JFrame();
        frame.setContentPane(createUI());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(getClass().getSimpleName());
        frame.setResizable(false);
        frame.setVisible(true);
        init();
        start();
    }

    public static void main(String[] args) {
        new Universe(args).run();
    }
}