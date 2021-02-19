package POJO;

import java.io.Serializable;

public class TimePK implements Serializable {
		protected Integer orderID;
	    protected Integer productID;

	    public TimePK() {}

	    public TimePK(Integer orderID, Integer productID) {
	        this.orderID = orderID;
	        this.productID = productID;
	    }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
			result = prime * result + ((productID == null) ? 0 : productID.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TimePK other = (TimePK) obj;
			if (orderID == null) {
				if (other.orderID != null)
					return false;
			} else if (!orderID.equals(other.orderID))
				return false;
			if (productID == null) {
				if (other.productID != null)
					return false;
			} else if (!productID.equals(other.productID))
				return false;
			return true;
		}
	     
	}
    
 