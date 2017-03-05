package mao.hotel.framework;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 506898260119862526L;

	/** ID属性名称 */
	public static final String ID_PROPERTY_NAME = "id";

	/** ID字段名称 */
	public static final String ID_FIELD_NAME = "FID";
	
	private String id;
	
	public BaseObject() {
		
	}
	
	public BaseObject(String id) {
		super();
		this.id = id;
	}

	@Id
	@GenericGenerator(name = "idGenerator", strategy = 
	"mao.common.utils.AssignUUIDGenerator")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = ID_FIELD_NAME)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(this == obj){
			return true;
		}
		if(!BaseObject.class.isAssignableFrom(obj.getClass())){
			return false;
		}
		BaseObject other = (BaseObject) obj;
		return getId() != null ? getId().equals(other.getId()) : false;
	}
	
	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode += null == getId() ? 0 : getId().hashCode() * 31;
		return hashCode;
	}
}
