package vo;

public class Component {
	private int componentId;
	private String name;
	private String createDate;
	private String updateDate;

	public Component() {}
	
	public Component(int componentId, String name, String createDate, String updateDate) {
		super();
		this.componentId = componentId;
		this.name = name;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public int getComponentId() {
		return componentId;
	}
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "Component [componentId=" + componentId + ", name=" + name + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}
}
