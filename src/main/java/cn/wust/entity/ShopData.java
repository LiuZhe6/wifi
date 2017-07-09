package cn.wust.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by coder on 17-4-23.
 */
@Entity
@Table(name = "shop_data")
public class ShopData {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "shop_id")
    private int shopId;

    @Column(name = "flow_volume")
    private int flowVolume;

    @Column(name = "into_count")
    private int intoCount;

    @Column(name = "into_rate")
    private float intoRate;

    @Column(name = "new_visitor")
    private int newVisitor;

    @Column(name = "old_visitor")
    private int oldVisitor;

    @Column(name = "bounce_rate")
    private float bounceRate;

    @Column(name = "deep_rate")
    private float deepRate;

    @Column(name = "time")
    private Date time;

    @Column(name = "time_flag")
    private int timeFlag;

    @Column(name = "weather")
    private int weather;

    @Column(name = "promotion")
    private int promotion;

    public ShopData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getFlowVolume() {
        return flowVolume;
    }

    public void setFlowVolume(int flowVolume) {
        this.flowVolume = flowVolume;
    }

    public int getIntoCount() {
        return intoCount;
    }

    public void setIntoCount(int intoCount) {
        this.intoCount = intoCount;
    }

    public float getIntoRate() {
        return intoRate;
    }

    public void setIntoRate(float intoRate) {
        this.intoRate = intoRate;
    }

    public int getNewVisitor() {
        return newVisitor;
    }

    public void setNewVisitor(int newVisitor) {
        this.newVisitor = newVisitor;
    }

    public int getOldVisitor() {
        return oldVisitor;
    }

    public void setOldVisitor(int oldVisitor) {
        this.oldVisitor = oldVisitor;
    }

    public float getBounceRate() {
        return bounceRate;
    }

    public void setBounceRate(float bounceRate) {
        this.bounceRate = bounceRate;
    }

    public float getDeepRate() {
        return deepRate;
    }

    public void setDeepRate(float deepRate) {
        this.deepRate = deepRate;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
