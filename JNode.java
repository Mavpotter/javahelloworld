/**
 * @author Niclas Hofmann
 */
public class JNode
{
	public byte x, y;
	public byte[] values;
	
	public JNode (byte x, byte y, byte n)
	{
		this.x = x;
		this.y = y;
		values = new byte[n];
	}
}