public final class RemoveTextSectionOperation extends Operation {

    private final int begin;
    private final int end;

    public RemoveTextSectionOperation(int begin, int end) {
        super();
        this.begin = begin;
        this.end = end;
    }

    @Override
    public TextDocument apply(TextDocument current) {
        return current.removeTextSection(begin, end);
    }

    @Override
    public String getDescription() {
        return "removes the text section from " + begin + " to " + end;
    }
}
