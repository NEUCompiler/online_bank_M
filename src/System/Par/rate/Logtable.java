package System.Par.rate;

/**
 * Logtable entity. @author MyEclipse Persistence Tools
 */
public class Logtable extends AbstractLogtable implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Logtable() {
	}

	/** minimal constructor */
	public Logtable(String cdate) {
		super(cdate);
	}

	/** full constructor */
	public Logtable(String cdate, String message) {
		super(cdate, message);
	}

}
