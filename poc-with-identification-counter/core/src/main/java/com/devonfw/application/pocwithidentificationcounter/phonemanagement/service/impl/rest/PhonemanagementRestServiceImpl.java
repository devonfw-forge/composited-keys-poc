package com.devonfw.application.pocwithidentificationcounter.phonemanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.Phonemanagement;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneCto;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneSearchCriteriaTo;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.service.api.rest.PhonemanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Phonemanagement}.
 */
@Named("PhonemanagementRestService")
public class PhonemanagementRestServiceImpl implements PhonemanagementRestService {

	@Inject
	private Phonemanagement phonemanagement;

	@Override
	public PhoneCto getPhoneCto(long id) {
		return this.phonemanagement.findPhoneCto(id);
	}

	@Override
	public Page<PhoneCto> findPhoneCtos(PhoneSearchCriteriaTo searchCriteriaTo) {
		return this.phonemanagement.findPhoneCtos(searchCriteriaTo);
	}
}