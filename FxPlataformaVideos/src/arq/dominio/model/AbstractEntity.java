package arq.dominio.model;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract long getId();
	
}
