public class WordInfo {
    private String word;
    private int count;

    public WordInfo(String sentence, int i) {
        this.word = sentence;
        this.count = i;
    }

    public String getWord() {
        return this.word;
    }

    public int getWordCount() {
        return this.count;
    }
}
