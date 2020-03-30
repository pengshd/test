package learn.dao.mysql.entity;


import java.util.Date;

public class Case {

  private String name;
  private String brand;
  private double height;
  private double width;
  private double depth;
  private double hwdSum;
  private double cpuHeight;
  private double vgaLength;
  private double price;
  private String comment;
  private Date createdDate;

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }


  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }


  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }


  public double getDepth() {
    return depth;
  }

  public void setDepth(double depth) {
    this.depth = depth;
  }


  public double getHwdSum() {
    return hwdSum;
  }

  public void setHwdSum(double hwdSum) {
    this.hwdSum = hwdSum;
  }


  public double getCpuHeight() {
    return cpuHeight;
  }

  public void setCpuHeight(double cpuHeight) {
    this.cpuHeight = cpuHeight;
  }


  public double getVgaLength() {
    return vgaLength;
  }

  public void setVgaLength(double vgaLength) {
    this.vgaLength = vgaLength;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return "Case{" +
            "name='" + name + '\'' +
            ", brand='" + brand + '\'' +
            ", height=" + height +
            ", width=" + width +
            ", depth=" + depth +
            ", hwdSum=" + hwdSum +
            ", cpuHeight=" + cpuHeight +
            ", vgaLength=" + vgaLength +
            ", price=" + price +
            ", comment='" + comment + '\'' +
            '}';
  }
}
