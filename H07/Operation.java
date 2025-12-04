public sealed class Operation permits UndoOperation, ReplaceTextSectionOperation, AddTextAtOperation, RemoveTextSectionOperation{
   
    public Operation()
    {

    }
   
    public TextDocument apply(TextDocument current) {
        getDescription();
        return current.noop();
    }

    public String getDescription() {
        return "does not modify the document";
    }
}
