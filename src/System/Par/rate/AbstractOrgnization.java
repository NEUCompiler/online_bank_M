package System.Par.rate;

/**
 * AbstractOrgnization entity provides the base persistence definition of the
 * Orgnization entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOrgnization implements java.io.Serializable {

	// Fields

	private Integer orgnizationid;
	private String orgnizationname;
	private Integer orgnizationtotalp;
	private String orgnizationcharge;
	private String orgnizationtype;

	// Constructors

	/** default constructor */
	public AbstractOrgnization() {
	}

	/** full constructor */
	public AbstractOrgnization(String orgnizationname,
			Integer orgnizationtotalp, String orgnizationcharge,
			String orgnizationtype) {
		this.orgnizationname = orgnizationname;
		this.orgnizationtotalp = orgnizationtotalp;
		this.orgnizationcharge = orgnizationcharge;
		this.orgnizationtype = orgnizationtype;
	}

	// Property accessors

	public Integer getOrgnizationid() {
		return this.orgnizationid;
	}

	public void setOrgnizationid(Integer orgnizationid) {
		this.orgnizationid = orgnizationid;
	}

	public String getOrgnizationname() {
		return this.orgnizationname;
	}

	public void setOrgnizationname(String orgnizationname) {
		this.orgnizationname = orgnizationname;
	}

	public Integer getOrgnizationtotalp() {
		return this.orgnizationtotalp;
	}

	public void setOrgnizationtotalp(Integer orgnizationtotalp) {
		this.orgnizationtotalp = orgnizationtotalp;
	}

	public String getOrgnizationcharge() {
		return this.orgnizationcharge;
	}

	public void setOrgnizationcharge(String orgnizationcharge) {
		this.orgnizationcharge = orgnizationcharge;
	}

	public String getOrgnizationtype() {
		return this.orgnizationtype;
	}

	public void setOrgnizationtype(String orgnizationtype) {
		this.orgnizationtype = orgnizationtype;
	}

}