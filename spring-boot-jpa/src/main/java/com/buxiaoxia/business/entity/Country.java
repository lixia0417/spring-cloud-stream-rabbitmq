package com.buxiaoxia.business.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 *
 * country（国家）  1:1 president（总统）
 * country（国家）  1:n province（省份）
 * country（国家）  n:n company（跨国公司）
 *
 * Created by xw on 2017/2/22.
 * 2017-02-22 18:34
 */
@Data
@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToOne(mappedBy = "country")
	private President president;
	@OneToMany(mappedBy = "country")
	private List<Province> provinces;
	@ManyToMany(mappedBy = "countries")
	private List<BigCompany> companies;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Country country = (Country) o;

		if (id != country.id) return false;
		if (name != null ? !name.equals(country.name) : country.name != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}


}
