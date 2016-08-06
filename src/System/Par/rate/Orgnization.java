package System.Par.rate;

/**
 * Orgnization entity. @author MyEclipse Persistence Tools
 */
public class Orgnization extends AbstractOrgnization implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Orgnization() {
	}

	/** full constructor */
	public Orgnization(String orgnizationname, Integer orgnizationtotalp,
			String orgnizationcharge, String orgnizationtype) {
		super(orgnizationname, orgnizationtotalp, orgnizationcharge,
				orgnizationtype);
	}

}
