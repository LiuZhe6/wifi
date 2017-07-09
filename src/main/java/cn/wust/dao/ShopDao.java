package cn.wust.dao;

import cn.wust.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by coder on 17-4-20.
 */
@Transactional
public interface ShopDao extends JpaRepository<Shop,Integer>{

}
