package System.Par.rate;

/**
 * AbstractLogtable entity provides the base persistence definition of the
 * Logtable entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLogtable implements java.io.Serializable {

	// Fields

	private String cdate;
	private String message;

	// Constructors

	/** default constructor */
	public AbstractLogtable() {
	}

	/** minimal constructor */
	public AbstractLogtable(String cdate) {
		this.cdate = cdate;
	}

	/** full constructor */
	public AbstractLogtable(String cdate, String message) {
		this.cdate = cdate;
		this.message = message;
	}

	// Property accessors

	public String getCdate() {
		return this.cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}