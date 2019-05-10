package com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.application.pocwithidentificationcounter.general.logic.base.AbstractUc;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.dataaccess.api.repo.PhoneRepository;

/**
 * Abstract use case for Phones, which provides access to the commonly necessary
 * data access objects.
 */
public class AbstractPhoneUc extends AbstractUc {

	/** @see #getPhoneRepository() */
	@Inject
	private PhoneRepository phoneRepository;

	/**
	 * Returns the field 'phoneRepository'.
	 * 
	 * @return the {@link PhoneRepository} instance.
	 */
	public PhoneRepository getPhoneRepository() {

		return this.phoneRepository;
	}

}
