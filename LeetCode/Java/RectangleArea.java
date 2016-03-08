public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int cover;
        int leftX = Math.max(A, E);
        int leftY = Math.max(B, F);
        int rightX = Math.min(C, G);
        int rightY = Math.min(D, H);
        cover = (rightX - leftX) * (rightY - leftY);
        if (B >= H || F >= D || E >= C || A >= H) {
            cover = 0;
        }
        if (A == C && B == D || E == G && F == H) {
            cover = 0;
        }
        return (Math.abs(G - E)) * (Math.abs(H - F)) + (Math.abs(C- A)) * (Math.abs(D- B)) - cover;
    }
}
