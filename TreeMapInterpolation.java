public class TreeMapInterpolation extends Interpolator {
    private TreeMap<Double, Double> data = new TreeMap<>();
    public TreeMapInterpolation(TreeMap<Double, Double> data) {
        this.data = data;
    }
    public TreeMapInterpolation() {
    }
    @Override
    public void clear() {
        data.clear();
    }
    @Override
    public int numPoints() {
        return data.size();
    }
    @Override
    public void addPoint(Point2D pt) {
        data.put(pt.getX(), pt.getY());
    
    @Override
    public Point2D getPoint(int i) {
        if (i < 0 || data.size() <= i) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
        Map.Entry<Double, Double> e = null;
        Iterator<Map.Entry<Double, Double>> it = data.entrySet().iterator();
        while (0 <= i--) {
            e = it.next();
        }
        double x = e.getKey();
        double y = e.getValue();
        return new Point2D(x, y);
    }
    @Override
    public void setPoint(int i, Point2D pt) {
        data.put(pt.getX(), pt.getY());
    }
    @Override
    public void removeLastPoint() {
        data.remove(data.size() - 1);
    }
    @Override
    public void sort() {

    }
}
