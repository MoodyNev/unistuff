public non-sealed class UndoOperation extends Operation {

    @Override
    public TextDocument apply(TextDocument current) {
        getDescription();
        return current.undo();
    }

    @Override
    public String getDescription() {
        return "reverts the previous operation";
    }
}
