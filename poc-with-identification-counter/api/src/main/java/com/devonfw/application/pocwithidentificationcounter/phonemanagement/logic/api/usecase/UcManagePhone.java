package com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.usecase;

import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneEto;

public interface UcManagePhone {

	PhoneEto savePhone(PhoneEto phoneEto);
	boolean deletePhone(long id);
}
