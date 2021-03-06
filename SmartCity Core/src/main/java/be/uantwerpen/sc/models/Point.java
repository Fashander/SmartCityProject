package be.uantwerpen.sc.models;

import javax.persistence.*;

/**
 * Created by Niels on 24/03/2016.
 */
@Entity
@Table(name = "punt", schema = "", catalog = "smartcitydb")
public class Point
{
    private int pid;
    private String rfid;
    private String type;
    private int pointlock;

    @Id
    @Column(name = "pid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "rfid")
    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point that = (Point) o;

        if (pid != that.pid) return false;
        if (rfid != null ? !rfid.equals(that.rfid) : that.rfid != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pid;
        result = 31 * result + (rfid != null ? rfid.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "pointlock")
    public int getPointlock() {
        return pointlock;
    }

    public void setPointlock(int pointlock) {
        this.pointlock = pointlock;
    }

    @Override
    public String toString() {
        return "PointEntity{" +
                "pid=" + pid +
                ", rfid='" + rfid + '\'' +
                ", type='" + type + '\'' +
                ", pointlock=" + pointlock +
                '}';
    }
}
