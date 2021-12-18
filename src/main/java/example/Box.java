package example;

public class Box {

    int width;
    int height;
    int depth;

    public int volume() {
        return width * height * depth;
    }

    public Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
}
class BoxDemo extends Box {

    public BoxDemo(int width, int height, int depth) {
        super(width, height, depth);
    }

    @Override
    public int volume() {
        return super.volume();
    }

    public static void main(String[] args) {
        int vol;
        int number = 11001;
        Box box1 = new Box(10, 20, 15);
        Box box2 = new Box(3, 6, 9);
        vol = box1.volume();
        System.out.println("Обьем " + vol);
        vol = box2.volume();
        System.out.println("Обьем " + vol);
        System.out.println(Math.abs(number));

        String example = "abc2";
        String example1 = "cbc";
        example.charAt(0);
        System.out.println(100 * Math.random());
        System.out.println(example.length() == example1.length());
        System.out.println(example.equals(example1));
    }
}

