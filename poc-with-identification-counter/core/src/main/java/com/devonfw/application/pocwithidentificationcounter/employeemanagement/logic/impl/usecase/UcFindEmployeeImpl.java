package com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.impl.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.CompositeEmployeeKey;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.dataaccess.api.CompositeEmployeeKeyImpl;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.dataaccess.api.EmployeeEntity;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeCto;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeEto;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeSearchCriteriaTo;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.usecase.UcFindEmployee;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.base.usecase.AbstractEmployeeUc;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneEto;

/**
 * Use case implementation for searching, filtering and getting Employees
 */
@Named
@Validated
@Transactional
public class UcFindEmployeeImpl extends AbstractEmployeeUc implements UcFindEmployee {

	/**
	 * Logger instance.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindEmployeeImpl.class);

	@Override
	public EmployeeEto findEmployee(CompositeEmployeeKey id) {
		LOG.debug("Get Employee with id {} from database.", id);
		Optional<EmployeeEntity> foundEntity = getEmployeeRepository().findById(new CompositeEmployeeKeyImpl(id));
		if (foundEntity.isPresent())
			return getBeanMapper().map(foundEntity.get(), EmployeeEto.class);
		else
			return null;
	}

	@Override
	public Page<EmployeeEto> findEmployees(EmployeeSearchCriteriaTo criteria) {
		Page<EmployeeEntity> employees = getEmployeeRepository().findByCriteria(criteria);
		return mapPaginatedEntityList(employees, EmployeeEto.class);
	}

	@Override
	public EmployeeCto findEmployeeCto(CompositeEmployeeKey id) {
		LOG.debug("Get EmployeeCto with id {} from database.", id);

		EmployeeEntity entity = getEmployeeRepository().find(new CompositeEmployeeKeyImpl(id));
		EmployeeCto cto = new EmployeeCto();
		cto.setEmployee(getBeanMapper().map(entity, EmployeeEto.class));
		cto.setPhones(getBeanMapper().mapList(entity.getPhones(), PhoneEto.class));

		return cto;
	}

	@Override
	public Page<EmployeeCto> findEmployeeCtos(EmployeeSearchCriteriaTo criteria) {

		Page<EmployeeEntity> employees = getEmployeeRepository().findByCriteria(criteria);
		List<EmployeeCto> ctos = new ArrayList<>();
		for (EmployeeEntity entity : employees.getContent()) {
			EmployeeCto cto = new EmployeeCto();
			cto.setEmployee(getBeanMapper().map(entity, EmployeeEto.class));
			cto.setPhones(getBeanMapper().mapList(entity.getPhones(), PhoneEto.class));
			ctos.add(cto);
		}
		Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(),
				criteria.getPageable().getPageSize());

		return new PageImpl<>(ctos, pagResultTo, employees.getTotalElements());
	}

}
