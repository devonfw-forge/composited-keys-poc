package com.devonfw.application.pocwithidentificationcounter.phonemanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.CompositeEmployeeKey;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.dataaccess.api.CompositeEmployeeKeyImpl;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.dataaccess.api.PhoneEntity;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link PhoneEntity}
 */
public interface PhoneRepository extends DefaultRepository<PhoneEntity> {

	/**
	 * @param criteria the {@link PhoneSearchCriteriaTo} with the criteria to
	 *                 search.
	 * @return the {@link Page} of the {@link PhoneEntity} objects that matched the
	 *         search. If no pageable is set, it will return a unique page with all
	 *         the objects that matched the search.
	 */
	default Page<PhoneEntity> findByCriteria(PhoneSearchCriteriaTo criteria) {

		PhoneEntity alias = newDslAlias();
		JPAQuery<PhoneEntity> query = newDslQuery(alias);

		String number = criteria.getNumber();
		if (number != null && !number.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getNumber()), number, criteria.getNumberOption());
		}
		String description = criteria.getDescription();
		if (description != null && !description.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getDescription()), description, criteria.getDescriptionOption());
		}
		CompositeEmployeeKey employee = criteria.getEmployeeId();
		if (employee != null) {
			query.where($(alias.getEmployee().getId()).eq(new CompositeEmployeeKeyImpl(employee)));
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
	public default void addOrderBy(JPAQuery<PhoneEntity> query, PhoneEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "number":
					if (next.isAscending()) {
						query.orderBy($(alias.getNumber()).asc());
					} else {
						query.orderBy($(alias.getNumber()).desc());
					}
					break;
				case "description":
					if (next.isAscending()) {
						query.orderBy($(alias.getDescription()).asc());
					} else {
						query.orderBy($(alias.getDescription()).desc());
					}
					break;
				case "employee":
					if (next.isAscending()) {
						query.orderBy($(alias.getEmployee().getId().toString()).asc());
					} else {
						query.orderBy($(alias.getEmployee().getId().toString()).desc());
					}
					break;
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

}
