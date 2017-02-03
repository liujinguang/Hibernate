package xyyj.chapter09;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

public class AddressUserType implements UserType {

	public int[] sqlTypes() {
		return SQL_TYPES;
	}

	// 设置AddressUserType映射的Java类：Address
	public Class returnedClass() {
		return Address.class;
	}

	// 比较一个Address对象是否和它的快照相同
	public boolean equals(Object x, Object y) throws HibernateException {
		if (x == y) {
			return true;
		}

		if (x == null || y == null) {
			return false;
		}

		return x.equals(y);
	}

	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	// 从JDBC ResultSet中读取列属性，然后构造一个Address对象
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		if (rs.wasNull()) {
			return null;
		}

		String province = rs.getString(names[0]);
		String city = rs.getString(names[1]);
		String street = rs.getString(names[2]);
		String zipcode = rs.getString(names[3]);

		return new Address(province, city, street, zipcode);
	}

	public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.VARCHAR);
			st.setNull(index + 1, Types.VARCHAR);
			st.setNull(index + 2, Types.VARCHAR);
			st.setNull(index + 3, Types.VARCHAR);
		} else {
			Address address = (Address) value;
			st.setString(index, address.getProvince());
			st.setString(index+1, address.getCity());
			st.setString(index+2, address.getStreet());
			st.setString(index+3, address.getZipcode());
		}
	}

	// 返回对象快照，由于Address为不可变类，可以将参数代表的Address对象返回
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	// 指明Address类是不可变类
	public boolean isMutable() {
		return false;
	}

	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable)value;
	}

	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

	// 设置Address类的4个属性对应的SQL类型，均为VARCHAR类型
	private static final int[] SQL_TYPES = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
}
