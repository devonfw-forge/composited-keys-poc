package com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneCto;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneSearchCriteriaTo;

public interface UcFindPhone {

	/**
	 * Returns a composite Phone by its id 'id'.
	 *
	 * @param id The id 'id' of the Phone.
	 * @return The {@link PhoneCto} with id 'id'
	 */
	PhoneCto findPhoneCto(long id);

	/**
	 * Returns a paginated list of composite Phones matching the search criteria.
	 *
	 * @param criteria the {@link PhoneSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link PhoneCto}s.
	 */
	Page<PhoneCto> findPhoneCtos(PhoneSearchCriteriaTo criteria);

}
