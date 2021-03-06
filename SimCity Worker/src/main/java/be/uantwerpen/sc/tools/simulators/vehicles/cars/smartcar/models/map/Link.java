package be.uantwerpen.sc.tools.simulators.vehicles.cars.smartcar.models.map;

/**
 * Created by Niels on 24/03/2016.
 */
public class Link
{
    private int lid;
    private Integer length;
    private String startDirection;
    private String stopDirection;
    private Point startId;
    private Point stopId;
    private int weight;
    private int pointLock;

    public int getLid()
    {
        return lid;
    }

    public void setLid(int lid)
    {
        this.lid = lid;
    }

    public Integer getLength()
    {
        return length;
    }

    public void setLength(Integer length)
    {
        this.length = length;
    }

    public String getStartDirection()
    {
        return startDirection;
    }

    public void setStartDirection(String startDirection)
    {
        this.startDirection = startDirection;
    }

    public String getStopDirection()
    {
        return stopDirection;
    }

    public void setStopDirection(String stopDirection)
    {
        this.stopDirection = stopDirection;
    }

    public Point getStartId()
    {
        return startId;
    }

    public void setStartId(Point startId)
    {
        this.startId = startId;
    }

    public Point getStopId()
    {
        return stopId;
    }

    public void setStopId(Point stopId)
    {
        this.stopId = stopId;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public int getPointLock() {
        return pointLock;
    }

    public void setPointlock(int pointlock)
    {
        this.pointLock = pointlock;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link that = (Link) o;

        if (lid != that.lid)
            return false;

        if (length != null ? !length.equals(that.length) : that.length != null)
            return false;

        if (startDirection != null ? !startDirection.equals(that.startDirection) : that.startDirection != null)
            return false;

        if (stopDirection != null ? !stopDirection.equals(that.stopDirection) : that.stopDirection != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = lid;

        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (startDirection != null ? startDirection.hashCode() : 0);
        result = 31 * result + (stopDirection != null ? stopDirection.hashCode() : 0);

        return result;
    }
}
