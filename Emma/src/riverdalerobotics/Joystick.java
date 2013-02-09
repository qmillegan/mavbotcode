package riverdale.robot;

/**
 * Handle input from standard Joysticks connected to the Driver Station.
 * This class handles standard input that comes from the Driver Station. Each time a value is requested
 * the most recent value is returned. There is a single class instance for each joystick and the mapping
 * of ports to hardware buttons depends on the code in the driver station.
 */
public class Joystick
{

    private javax.swing.JSlider m_xSlider;
    private javax.swing.JSlider m_ySlider;
    private final javax.swing.JToggleButton[] m_buttons;

    /**
     * Construct an instance of a joystick.
     * The joystick index is the usb port on the drivers station.
     *
     * @param port The port on the driver station that the joystick is plugged into.
     */
    public Joystick(final int port) 
    {
        m_xSlider = EmmaGui.m_emmaGui.getXSlider(port);
        m_ySlider = EmmaGui.m_emmaGui.getYSlider(port);
        m_buttons = EmmaGui.m_emmaGui.getButtons(port);
    }

    public boolean getRawButton(final int button) 
    {
        return m_buttons[button].isSelected();
    }
    

    /**
     * Get the X value of the joystick.
     * In actual joystick class this is from the base class
     */
    public final double getX() 
    {
        return ((double) (m_xSlider.getValue() - m_xSlider.getMaximum())) / m_xSlider.getMaximum() + 0.5;
    }

    public final double getY() 
    {
        return ((double) (m_ySlider.getValue() - m_xSlider.getMaximum())) / m_ySlider.getMaximum() + 0.5;
    }

}
