public class TreeSetInterpolation extends Interpolator {
    private TreeSet<Point2D> data = new TreeSet<>();
    public TreeSetInterpolation(TreeSet<Point2D> data) {
        this.data = data;
    }
    public TreeSetInterpolation() {
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
        data.add(pt);
    }
    @Override
    public Point2D getPoint(int i) {
        if (i == 0) {
            return data.first();
        }
        int n = 0;
        Iterator<Point2D> it = data.iterator();
        Point2D curr = null;
        while (it.hasNext() && n <= i) {
            curr = it.next();
            n++;
        }
        return curr;
    }
    @Override
    public void setPoint(int i, Point2D pt) {
        data.add(pt);
    }
    @Override
    public void removeLastPoint() {
        data.remove(data.size() - 1);
    }
    @Override
    public void sort() {
    }
}
