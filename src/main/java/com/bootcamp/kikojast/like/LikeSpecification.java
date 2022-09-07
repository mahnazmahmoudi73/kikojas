package com.bootcamp.kikojast.like;

import com.bootcamp.kikojast.commen.SearchCriteria;
import com.bootcamp.kikojast.commen.SearchOperation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class LikeSpecification implements Specification<Like> {

    private List<SearchCriteria> list;
    public LikeSpecification() {
        this.list = new ArrayList<>();
    }



    public void add(SearchCriteria criteria){
        list.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<Like> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();

        for (SearchCriteria criteria:list){
            if(criteria.getOperation().equals(SearchOperation.GREATER_THAN)){
                predicates.add(builder.greaterThan(root.get(criteria.getKey()),
                        criteria.getValue().toString()));

            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN)) {
                predicates.add(builder.lessThan(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            }
            else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
                predicates.add(builder.greaterThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
                predicates.add(builder.lessThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
                predicates.add(builder.notEqual(
                        root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
            /*   var t = criteria.getValue().getClass() == Entity.class;
               if(criteria.getKey().equals("place")){
                   predicates.add(builder.equal(
                           root.get(criteria.getKey()), criteria.getValue()));
               }*/
              /*  if(criteria.getKey().equals("isLike")){
                    predicates.add(builder.equal(
                            root.get(criteria.getKey()), criteria.getValue().equals(Enum.class)));
                }*/
                predicates.add(builder.equal(
                        root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                /*if(criteria.getKey().equals("isLike")){
                    predicates.add(builder.like(
                            builder.lower(root.get(criteria.getKey())),
                            "%" + criteria.getValue().toString().toLowerCase() + "%"));
                }*/
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_END)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_START)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue().toString().toLowerCase()));
            } else if (criteria.getOperation().equals(SearchOperation.IN)) {
                predicates.add(builder.in(root.get(criteria.getKey())).value(criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.NOT_IN)) {
                predicates.add(builder.not(root.get(criteria.getKey())).in(criteria.getValue()));
            }
        }


        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
