public final class ReplaceTextSectionOperation extends Operation {

    private final int begin;
    private final int end;
    private final String replacement;

    public ReplaceTextSectionOperation(int begin, int end, String replacement) {
        this.begin = begin;
        this.end = end;
        this.replacement = replacement;
    }

    @Override
    public TextDocument apply(TextDocument current) {
        getDescription();
        return current.replaceTextSection(begin, end, replacement);
    }

    @Override
    public String getDescription() {
        return "replaces the text section from " + begin + " to " + end + " by: " + replacement;
    }
}
