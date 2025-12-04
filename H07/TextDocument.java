/* Aufgabe a: Klasse TextDocument enthält String Attribut
aber attribut nicht veränderbar
getContent ohne Setter
Konstruktor, der den String als Parameter enthält, und den String zuweist
undo -> gibt den aktuellen TextDocument zurück
 */

/* Aufgabe b: methode -> aus einem gegebenen TextDocument ein neues ModifiedTextDocument erstellen
methode heißt noop()
 */

//MACH ÜBERALL PROTECTED
public sealed class TextDocument permits ModifiedTextDocument {
    public final String currentContent;

    public TextDocument(String current){
        this.currentContent = current;
    }

    public String getContent(){
        return this.currentContent;
    }

    public TextDocument undo(){
        return this;
    }

    //noop musste textdocument sein?
    public TextDocument noop(){
        //not sure whether i should use get content or curretnContent here, they feel the same
        return new ModifiedTextDocument(currentContent,this);
    }

    public TextDocument replaceTextSection(int beginIndex, int endIndex, String replacement){
        replacement = getContent().substring(0, beginIndex) + replacement + getContent().substring(endIndex);
        return new ModifiedTextDocument(replacement, this);
    }

    public TextDocument addTextAt(int position, String addition){
        addition = getContent().substring(0,position) + addition + getContent().substring(position); 
        return new ModifiedTextDocument(addition, this);
    }
    
    public TextDocument removeTextSection(int beginIndex, int endIndex){
        String newContent = getContent().substring(0, beginIndex) + getContent().substring(endIndex);
        return new ModifiedTextDocument(newContent, this);
    }
}
