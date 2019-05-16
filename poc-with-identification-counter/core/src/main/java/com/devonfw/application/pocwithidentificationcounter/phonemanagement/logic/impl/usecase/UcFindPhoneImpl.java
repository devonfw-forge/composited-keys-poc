package com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.impl.usecase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeEto;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.dataaccess.api.PhoneEntity;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneCto;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneEto;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneSearchCriteriaTo;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.usecase.UcFindPhone;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.base.usecase.AbstractPhoneUc;

/**
 * Use case implementation for searching, filtering and getting Phones
 */
@Named
@Validated
@Transactional
public class UcFindPhoneImpl extends AbstractPhoneUc implements UcFindPhone {

	/**
	 * Logger instance.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindPhoneImpl.class);

	@Override
	public PhoneCto findPhoneCto(long id) {
		LOG.debug("Get PhoneCto with id {} from database.", id);
		PhoneEntity entity = getPhoneRepository().find(id);
		PhoneCto cto = new PhoneCto();
		cto.setPhone(getBeanMapper().map(entity, PhoneEto.class));
		cto.setEmployee(getBeanMapper().map(entity.getEmployee(), EmployeeEto.class));

		return cto;
	}

	@Override
	public Page<PhoneCto> findPhoneCtos(PhoneSearchCriteriaTo criteria) {

		Page<PhoneEntity> phones = getPhoneRepository().findByCriteria(criteria);
		List<PhoneCto> ctos = new ArrayList<>();
		for (PhoneEntity entity : phones.getContent()) {
			PhoneCto cto = new PhoneCto();
			cto.setPhone(getBeanMapper().map(entity, PhoneEto.class));
			cto.setEmployee(getBeanMapper().map(entity.getEmployee(), EmployeeEto.class));
			ctos.add(cto);
		}
		Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(),
				criteria.getPageable().getPageSize());

		return new PageImpl<>(ctos, pagResultTo, phones.getTotalElements());
	}

}
