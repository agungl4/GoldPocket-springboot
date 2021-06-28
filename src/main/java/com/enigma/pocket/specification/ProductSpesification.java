package com.enigma.pocket.specification;

import com.enigma.pocket.dto.ProductSearchDto;
import com.enigma.pocket.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;

public class ProductSpesification {
    public static Specification<Product> findProduct(ProductSearchDto productSearchForm){

        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                final Collection<Predicate> predicates = new ArrayList<Predicate>();

                if (!(productSearchForm.getProduct_name()==null || StringUtils.hasLength(productSearchForm.getProduct_name()))){
                    final Predicate productName = criteriaBuilder.like(root.get("productName"),"%" + productSearchForm.getProduct_name()+"%");
                }

                return criteriaBuilder.and(predicates.toArray(new  Predicate[predicates.size()]));
            }
        };
    }
}
