package cn.wust.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by root on 17-5-9.
 */
@Entity
@Table(name = "device_status")
public class Device {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "shop_id")
    private int shopId;

    @Column(name = "identify")
    private String identify;

    @Column(name = "position")
    private String position;

    @Column(name = "latest_time")
    private Date latestTime;

    public Device() {
    }

    public Device(int shopId, String identify, String position, Date latestTime) {
        this.shopId = shopId;
        this.identify = identify;
        this.position = position;
        this.latestTime = latestTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(Date latestTime) {
        this.latestTime = latestTime;
    }
}
