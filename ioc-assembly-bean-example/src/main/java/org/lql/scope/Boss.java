package org.lql.scope;

/**
 * Title: Boss <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/8 14:03 <br>
 */
public class Boss {

    private String name ;
    private Car car;
    public Boss(){
        System.out.println("init boss");
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "name:"+name+"\n car:"+car;
    }
}
