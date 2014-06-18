/**
 * 
 */
package comparator;

/**
 * ��ͨJava����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��28��
 */
public class Issue {

	private long id;
	private String severity;
	private String owner;

	public Issue(long id, String severity, String owner) {
		this.id = id;
		this.severity = severity;
		this.owner = owner;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String toString() {
		return "Issue id=" + id + ", severity=" + severity + ", owner=" + owner
				+ ".";
	}
}
