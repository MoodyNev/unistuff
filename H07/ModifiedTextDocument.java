/* erweitert TextDocument
erstellt ein Textdocument
enthält den aktuellen Wert als String und auch als TextDocument
 */
public non-sealed class ModifiedTextDocument extends TextDocument
{
    public TextDocument previousContent;
    

    public ModifiedTextDocument(String content, TextDocument previous){
        super(content);
        this.previousContent = previous;
    }
    //debugger said add override idk why
    @Override
    public TextDocument undo(){
        return previousContent;
    }
}
