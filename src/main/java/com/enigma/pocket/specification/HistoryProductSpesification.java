package com.enigma.pocket.specification;

import com.enigma.pocket.dto.HistoryProductSearchDto;
import com.enigma.pocket.entity.HistoryProduct;
import org.springframework.data.jpa.domain.Specification;

public class HistoryProductSpesification {
    public static Specification<HistoryProduct> findHistoryProduct(HistoryProductSearchDto historyProductSearchDto){

//        return new Specification<Product>() {
//            @Override
//            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                final Collection<Predicate> predicates = new ArrayList<Predicate>();
//
//                if (!(historyProductSearchDto.getProduct_id()==null || StringUtils.hasLength(historyProductSearchDto.getProduct_id()))){
//                    final Predicate productName = criteriaBuilder.like(root.get("productId"),"%" + historyProductSearchDto.get+"%");
//                }
//
//                return criteriaBuilder.and(predicates.toArray(new  Predicate[predicates.size()]));
//            }
//        };
        return null;
    }
}
