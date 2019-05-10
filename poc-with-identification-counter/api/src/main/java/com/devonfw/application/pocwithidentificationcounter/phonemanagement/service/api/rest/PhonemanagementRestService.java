package com.devonfw.application.pocwithidentificationcounter.phonemanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.Phonemanagement;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneCto;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Phonemanagement}.
 */
@Path("/phonemanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PhonemanagementRestService {

	/**
	 * Delegates to {@link Phonemanagement#findPhoneCto}.
	 *
	 * @param id the ID of the {@link PhoneCto}
	 * @return the {@link PhoneCto}
	 */
	@GET
	@Path("/phone/cto/{id}/")
	public PhoneCto getPhoneCto(@PathParam("id") long id);

	/**
	 * Delegates to {@link Phonemanagement#findPhoneCtos}.
	 *
	 * @param searchCriteriaTo the pagination and search criteria to be used for
	 *                         finding phones.
	 * @return the {@link Page list} of matching {@link PhoneCto}s.
	 */
	@Path("/phone/cto/search")
	@POST
	public Page<PhoneCto> findPhoneCtos(PhoneSearchCriteriaTo searchCriteriaTo);

}