package test4.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user_service_info") // This tells Hibernate to make a table out of this class
public class UserService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer userInfoId;

    private Integer serviceInfoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public Integer getServiceInfoId() {
        return serviceInfoId;
    }

    public void setServiceInfoId(Integer serviceInfoId) {
        this.serviceInfoId = serviceInfoId;
    }
}
