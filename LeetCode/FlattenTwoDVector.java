public class FlattenTwoDVector {
    private List<List<Integer>> vec2d;
    private int x;
    private int y;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        x = 0;
        y = 0;
    }

    public int next() {
        int ans = 0;
        if (y < vec2d.get(x).size()) {
            ans = vec2d.get(x).get(y);
        }
        y += 1;
        if (y == vec2d.get(x).size()) {
            y = 0;
            x += 1;
        }
        return ans;
    }

    public boolean hasNext() {
        while (x < vec2d.size() && (vec2d.get(x) == null || vec2d.get(x).isEmpty())) {
            x++;
        }
        return x < vec2d.size() && vec2d != null && !vec2d.get(x).isEmpty();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
