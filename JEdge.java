/**
 * @author Niclas Hofmann
 */
public class JEdge
{
	public boolean isActive;
	public byte number;
	public JNode[] connects;
	
	public JEdge (byte number, JNode[] nodes)
	{
		isActive = true;
		this.number = number;
		connects = nodes;
	}
}