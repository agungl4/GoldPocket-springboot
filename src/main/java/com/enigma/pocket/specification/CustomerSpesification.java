package com.enigma.pocket.specification;


import com.enigma.pocket.dto.CustomerSearchDto;
import com.enigma.pocket.entity.Customer;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;

public class CustomerSpesification {
    public static Specification<Customer> findCustomer(CustomerSearchDto customerSearchForm){

        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
               final Collection<Predicate> predicates = new ArrayList<Predicate>();

               if (!(customerSearchForm.getFirstName()==null || StringUtils.hasLength(customerSearchForm.getFirstName()))){
                  final Predicate firstNamePredicate = criteriaBuilder.like(root.get("firstName"),"%" + customerSearchForm.getFirstName()+"%");
               }

                if (!(customerSearchForm.getLastName()==null || StringUtils.hasLength(customerSearchForm.getLastName()))){
                    final Predicate lastNamePredicate = criteriaBuilder.like(root.get("lastName"),"%" + customerSearchForm.getLastName()+"%");
                }

                return criteriaBuilder.and(predicates.toArray(new  Predicate[predicates.size()]));
            }
        };
    }
}
