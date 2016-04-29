package business;

/**
 * This class represents an application exception
 * Created to make exceptions uniform
 * 
 * @author JoaoR
 *
 */
public class ApplicationException extends Exception{

	/**
	 * exception message
	 */
	private String message;
	
	/**
	 * Constructor
	 * 
	 * @param message, exception message
	 * @param e, upper level exception
	 */
	public ApplicationException(String message, Exception e)
	{
		super(e);
		this.message = message;
	}
	
	@Override
	public String getMessage(){
		return this.message;
	}
	
}
