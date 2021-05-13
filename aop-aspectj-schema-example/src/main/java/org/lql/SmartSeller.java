package org.lql;

/**
 * Title: SmartSeller <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 21:10 <br>
 */
public class SmartSeller implements Seller{
    public int sell(String goods,String clientName) {
        System.out.println("SmartSeller: sell "+goods +" to "+clientName+"...");
        return 100;
    }

    public void checkBill(int billId){
        if(billId == 1) throw new IllegalArgumentException("iae Exception");
        else throw new RuntimeException("re Exception");
    }
}
