public class Launcher {

    public static void main(String[] args) {

        Operation[] ops = new Operation[] {
                new AddTextAtOperation(0, "Hello Aachen!"),
                new ReplaceTextSectionOperation(6, 12, "World"),
                new UndoOperation(),
                new ReplaceTextSectionOperation(0, 5, "Goodbye"),
                new RemoveTextSectionOperation(14, 15)
        };

        TextDocument current = new TextDocument("");

        for (Operation op : ops) {
            System.out.println(op.getDescription());
            current = op.apply(current);
            System.out.println(current.getContent());
        }
    }
}
