package org.lql.editor;

/**
 * Title: Boss <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/10 10:47 <br>
 */
public class Boss {

    private String name;
    private Car car = new Car();

    public String toString(){
        String temp ="name:"+name+"\n";
        temp += "car:"+car;
        return temp;
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
}
