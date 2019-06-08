/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPackage;

/**
 *
 * @author MY PHU NGUYEN
 */
public class Announcement {
    private static int announcementNumber=0;
    private int announcementID;
    private String target;
    private String topic;
    private String body;
    
    public Announcement(int announcementID, String target, String topic, String body)
    {
        this.announcementID= announcementID;
        if (announcementID>announcementNumber)
        {
            announcementNumber= announcementID;
        }
        this.target= target;
        this.topic=topic;
        this.body=body;
    }
    
    public Announcement (String target, String topic, String body)
    {
        this.target=target;
        this.topic=topic;
        this.body=body;
        announcementNumber++;
        this.announcementID=announcementNumber;
    }
    
    public int getAnnouncementID() {
        return announcementID;
    }

    public void setAnnouncementID(int announcementID) {
        this.announcementID = announcementID;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    
}
