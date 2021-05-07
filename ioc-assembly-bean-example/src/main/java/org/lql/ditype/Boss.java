package org.lql.ditype;

/**
 * Title: Boss <br>
 * ProjectName: learn-spring <br>
 * description: 通过自身反射匹配入参演示实例 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/7 16:22 <br>
 */
public class Boss {

    private String name;

    private Car car;

    private Office office;

    public Boss(String name, Car car, Office office) {
        this.name = name;
        this.car = car;
        this.office = office;
    }

    public Boss(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public Boss() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String toString(){
        return "name:"+name+"/car:"+car.getBrand()+"/office:"+office;
    }
}
