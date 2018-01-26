package com.ek.spring.demo12_JdbcTemplate;

public class UserInfo {
  
  private Integer uuid;
  private String userName;
  private String sex;
  private String birthday;
  public Integer getUuid() {
    return uuid;
  }
  public void setUuid(Integer uuid) {
    this.uuid = uuid;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getSex() {
    return sex;
  }
  public void setSex(String sex) {
    this.sex = sex;
  }
  public String getBirthday() {
    return birthday;
  }
  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }
  @Override
  public String toString() {
    return "UserInfo [uuid=" + uuid + ", userName=" + userName + ", sex=" + sex + ", birthday=" + birthday + "]";
  }
}
