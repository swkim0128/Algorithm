package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_2527 extends Solution {
    @Override
    public void solution() throws IOException {
        StringTokenizer token;

        for (int i = 0; i < 4; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            Rectangle[] rectangles = new Rectangle[2];

            for (int j = 0; j < 2; j++) {
                int x, y, p, q;
                x = Integer.parseInt(token.nextToken());
                y = Integer.parseInt(token.nextToken());
                p = Integer.parseInt(token.nextToken());
                q = Integer.parseInt(token.nextToken());

                rectangles[j] = new Rectangle(x, y, p, q);
            }

            int x, y, p, q;
            x = rectangles[1].x;
            y = rectangles[1].y;
            p = rectangles[1].p;
            q = rectangles[1].q;

            char answer = rectangles[0].findProperty(x, y, p, q);

            if (answer == ' ') {
                x = rectangles[0].x;
                y = rectangles[0].y;
                p = rectangles[0].p;
                q = rectangles[0].q;

                answer = rectangles[1].findProperty(x, y, p, q);
            }

            System.out.println(answer);
        }
    }

    class Rectangle {
        int x, y, p, q;

        Rectangle(int x, int y, int p, int q) {
            this.x = x;
            this.y = y;
            this.p = p;
            this.q = q;
        }

        public char findProperty(int x, int y, int p, int q) {
            if (isRectangle(x, y, p, q)) {
                return 'a';
            }
            else if (isLine(x, y, p, q)) {
                return 'b';
            }
            else if (isPoint(x, y, p, q)) {
                return 'c';
            }
            else if (isNone(x, y, p, q)) {
                return 'd';
            }

            return ' ';
        }

        public boolean isRectangle(int x, int y, int p, int q) {
            if (((this.x <= x && x < this.p) || (this.x < p && p <= this.p)) && ((this.y <= y && y < this.q) || (this.y < q && q <= this.q))) {
                return true;
            }
            else if ((this.x <= x && p <= this.p) && (y <= this.y && this.q <= q))
                return true;
            else if ((this.y <= y && q <= this.q) && (x <= this.x && this.p <= p))
                return true;
            else if ((x < this.x && y < this.y) && (this.p < p && this.q < q))
                return true;

            return false;
        }

        public boolean isLine(int x, int y, int p, int q) {
            if (y == this.q || q == this.y) {
                if ((this.x <= x && x < this.p) || (this.x < p && p <= this.p))
                    return true;
            }
            else if (x == this.p || p == this.x) {
                if ((this.y <= y && y < this.q) || (this.y < q && q <= this.q))
                    return true;
            }
//            if ((this.x <= x && x < this.p) || (this.x < p && p <= this.p)) {
//                if (y == this.q)
//                    return true;
//                else if (q == this.y)
//                    return true;
//            }
//            else if ((this.y <= y && y < this.q) || (this.y < q && q <= this.q)) {
//                if (p == this.x)
//                    return true;
//                else if (x == this.p)
//                    return true;
//            }
            return false;
        }

        public boolean isPoint(int x, int y, int p, int q) {
            if ((x == this.x || x == this.p || p == this.x || p == this.p) && (y == this.y || y == this.q ||  q == this.y || q == this.q))
                return true;
            return false;
        }

        public boolean isNone(int x, int y, int p, int q) {
            if (x > this.p || p < this.x || y > this.q || q < this.y)
                return true;
            return false;
        }

    }
}
