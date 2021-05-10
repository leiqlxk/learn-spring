package org.lql.editor;

import java.beans.PropertyEditorSupport;

/**
 * Title: CustomCarEditor <br>
 * ProjectName: learn-spring <br>
 * description: 自定义属性编辑器 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/10 10:48 <br>
 */
public class CustomCarEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Object value = getValue();
        if(value == null){
            return "";
        }else{
            Car car = (Car)value;
            return car.getBrand()+","+car.getMaxSpeed()+","+car.getPrice();
        }
    }

    // 将字面值转化为属性类型对象
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || !text.contains(",")) {
            throw new IllegalArgumentException("设置的字符串格式不正确");
        }

        String[] infos = text.split(",");
        Car car = new Car();
        car.setBrand(infos[0]);
        car.setPrice(Double.parseDouble(infos[1]));
        car.setMaxSpeed(Integer.parseInt(infos[2]));

        // 调用父类的setValue方法设置转换后的属性对象
        setValue(car);
    }
}
