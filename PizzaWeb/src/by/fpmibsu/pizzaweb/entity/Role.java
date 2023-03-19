package PizzaWeb.src.by.fpmibsu.pizzaweb.entity;

public class Role {
	private String role;

	public String getRole() {
		return role;
	}

	public Role(String role) {
		this.role = role;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	public String toString() {
		return "Role [role=" + role + "]";
	}
}
