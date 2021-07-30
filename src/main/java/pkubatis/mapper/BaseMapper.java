package pkubatis.mapper;

import org.apache.ibatis.session.RowBounds;
import pkubatis.model.Criteria;

import java.util.List;

public interface BaseMapper<T> {
    List<T> getListByCriteria(Criteria criteria);
    List<T> getListByCriteria(Criteria criteria, RowBounds rowBounds);

    int getCountByCriteria(Criteria criteria);

    T get(Object var1);

    int insert(T var1);

    int delete(Object var1);
}
