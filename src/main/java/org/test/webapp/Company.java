package org.test.webapp;

import java.io.Serializable;

public class Company implements Serializable, Cloneable {
	
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 6855107172089929460L;

		private Long id;

	    private String name = "";

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	    
	    
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (this.id == null) {
	            return false;
	        }

	        if (obj instanceof Company && obj.getClass().equals(getClass())) {
	            return this.id.equals(((Company) obj).getId());
	        }

	        return false;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 5;
	        hash = 43 * hash + (id == null ? 0 : id.hashCode());
	        return hash;
	    }

	    @Override
	    public Company clone() throws CloneNotSupportedException {
	        return (Company) super.clone();
	    }

	    @Override
	    public String toString() {
	        return name + " ";
	    }


}
