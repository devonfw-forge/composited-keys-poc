package com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.pocwithidentificationcounter.general.logic.base.AbstractComponentFacade;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.Phonemanagement;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneCto;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneSearchCriteriaTo;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.usecase.UcFindPhone;

/**
 * Implementation of component interface of phonemanagement
 */
@Named
public class PhonemanagementImpl extends AbstractComponentFacade implements Phonemanagement {

	@Inject
	private UcFindPhone ucFindPhone;

	@Override
	public PhoneCto findPhoneCto(long id) {

		return ucFindPhone.findPhoneCto(id);
	}

	@Override
	public Page<PhoneCto> findPhoneCtos(PhoneSearchCriteriaTo criteria) {

		return ucFindPhone.findPhoneCtos(criteria);
	}
}
