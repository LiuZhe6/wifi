package cn.wust.dao;

import cn.wust.entity.ShopData;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by coder on 17-4-23.
 */
@Transactional
public interface ShopDataDao extends JpaRepository<ShopData,Long>{

}
