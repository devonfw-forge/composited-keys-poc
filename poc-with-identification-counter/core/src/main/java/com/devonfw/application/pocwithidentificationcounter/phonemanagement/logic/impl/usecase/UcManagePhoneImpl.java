package com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.Employeemanagement;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.dataaccess.api.PhoneEntity;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneEto;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.usecase.UcManagePhone;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.base.usecase.AbstractPhoneUc;

@Named
@Validated
@Transactional
public class UcManagePhoneImpl extends AbstractPhoneUc implements UcManagePhone{

	private static final Logger LOG = LoggerFactory.getLogger(UcManagePhoneImpl.class);

	@Inject
	Employeemanagement employeemanagement;
	@PersistenceContext
	private EntityManager em;
	@Override
	public PhoneEto savePhone(PhoneEto phone) {
		Objects.requireNonNull(phone, "phone");

		PhoneEntity phoneEntity = getBeanMapper().map(phone, PhoneEntity.class);

		PhoneEntity resultEntity = getPhoneRepository().save(phoneEntity);
		LOG.debug("Phone with id '{}' has been created.", resultEntity.getId());
		LOG.info("Phone entity '{}' has been created.", ReflectionToStringBuilder.toString(resultEntity));
		return getBeanMapper().map(phoneEntity, PhoneEto.class);
	}

	@Override
	public boolean deletePhone(long phoneId) {
		PhoneEntity phone = getPhoneRepository().find(phoneId);
		getPhoneRepository().delete(phone);
		LOG.debug("The phone with id '{}' has been deleted.", phoneId);
		return true;
	}

}
