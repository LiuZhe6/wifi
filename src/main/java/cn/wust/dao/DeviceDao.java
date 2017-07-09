package cn.wust.dao;

import cn.wust.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by root on 17-5-9.
 */
public interface DeviceDao extends JpaRepository<Device,Integer> {

    Device findByIdentify(String identify);
}
