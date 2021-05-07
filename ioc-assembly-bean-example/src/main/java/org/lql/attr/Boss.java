package org.lql.attr;

import java.util.*;

/**
 * Title: Boss <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/7 17:14 <br>
 */
public class Boss {

    private Car car = new Car();
    private List favorites = new ArrayList();
    private Map jobs = new HashMap();
    private Properties mails = new Properties();
    private Map<String, Integer> jobTime = new HashMap<>();

    public Map<String, Integer> getJobTime() {
        return jobTime;
    }

    public void setJobTime(Map<String, Integer> jobTime) {
        this.jobTime = jobTime;
    }

    public Properties getMails() {
        return mails;
    }

    public void setMails(Properties mails) {
        this.mails = mails;
    }

    public Map getJobs() {
        return jobs;
    }

    public void setJobs(Map jobs) {
        this.jobs = jobs;
    }

    public List getFavorites() {
        return favorites;
    }

    public void setFavorites(List favorites) {
        this.favorites = favorites;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
