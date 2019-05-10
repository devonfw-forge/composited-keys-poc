package com.devonfw.application.pocwithidentificationcounter.employeemanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.dataaccess.api.EmployeeEntity;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link EmployeeEntity}
 */
public interface EmployeeRepository extends DefaultRepository<EmployeeEntity> {

	/**
	 * @param criteria the {@link EmployeeSearchCriteriaTo} with the criteria to
	 *                 search.
	 * @return the {@link Page} of the {@link EmployeeEntity} objects that matched
	 *         the search. If no pageable is set, it will return a unique page with
	 *         all the objects that matched the search.
	 */
	default Page<EmployeeEntity> findByCriteria(EmployeeSearchCriteriaTo criteria) {

		EmployeeEntity alias = newDslAlias();
		JPAQuery<EmployeeEntity> query = newDslQuery(alias);

		String companyId = criteria.getCompanyId();
		if (companyId != null && !companyId.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getCompanyId()), companyId, criteria.getCompanyIdOption());
		}
		String employeeId = criteria.getEmployeeId();
		if (employeeId != null && !employeeId.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getEmployeeId()), employeeId, criteria.getEmployeeIdOption());
		}
		String name = criteria.getName();
		if (name != null && !name.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
		}
		String lastName = criteria.getLastName();
		if (lastName != null && !lastName.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getLastName()), lastName, criteria.getLastNameOption());
		}
		if (criteria.getPageable() == null) {
			criteria.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
		} else {
			addOrderBy(query, alias, criteria.getPageable().getSort());
		}

		return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
	}

	/**
	 * Add sorting to the given query on the given alias
	 * 
	 * @param query to add sorting to
	 * @param alias to retrieve columns from for sorting
	 * @param sort  specification of sorting
	 */
	public default void addOrderBy(JPAQuery<EmployeeEntity> query, EmployeeEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "companyId":
					if (next.isAscending()) {
						query.orderBy($(alias.getCompanyId()).asc());
					} else {
						query.orderBy($(alias.getCompanyId()).desc());
					}
					break;
				case "employeeId":
					if (next.isAscending()) {
						query.orderBy($(alias.getEmployeeId()).asc());
					} else {
						query.orderBy($(alias.getEmployeeId()).desc());
					}
					break;
				case "name":
					if (next.isAscending()) {
						query.orderBy($(alias.getName()).asc());
					} else {
						query.orderBy($(alias.getName()).desc());
					}
					break;
				case "lastName":
					if (next.isAscending()) {
						query.orderBy($(alias.getLastName()).asc());
					} else {
						query.orderBy($(alias.getLastName()).desc());
					}
					break;
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

}