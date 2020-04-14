import java.util.*;

public class WordFrequencyGame {

    private static final String SPACE_PATTERN = "\\s+";
    private static final String NEWLINE_DELIMITER = "\n";
    private static final String CALCULATE_ERROR = "calculate error";
    private static final String SPACE_DELIMITER = " ";

    public String getResult(String sentence) {
        try {
            List<WordInfo> wordInfoList = calculateWordFrequency(sentence);
            return formatWordFrequencyResult(wordInfoList);

        } catch (Exception exception) {
            return CALCULATE_ERROR;
        }
    }

    private String formatWordFrequencyResult(List<WordInfo> wordInfoList) {
        StringJoiner joiner = new StringJoiner(NEWLINE_DELIMITER);
        for (WordInfo wordInfo : wordInfoList) {
            String wordWithCount = wordInfo.getWord()+ SPACE_DELIMITER + wordInfo.getWordCount();
            joiner.add(wordWithCount);
        }
        return joiner.toString();
    }


    private Map<String, List<WordInfo>> getMap(List<WordInfo> wordInfoList) {
        Map<String, List<WordInfo>> map = new HashMap<>();
        for (WordInfo wordInfo : wordInfoList) {
            if (!map.containsKey(wordInfo.getWord())) {
                ArrayList arr = new ArrayList<>();
                arr.add(wordInfo);
                map.put(wordInfo.getWord(), arr);
            } else {
                map.get(wordInfo.getWord()).add(wordInfo);
            }
        }
        return map;
    }

    private List<WordInfo> calculateWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));
        List<WordInfo> wordInfoList = new ArrayList<>();
        for(String word : new HashSet<>(words)){
            int count = Collections.frequency(words, word);
            wordInfoList.add(new WordInfo(word, count));

        }
        wordInfoList.sort((firstWordInfo, secondWordInfo)->secondWordInfo.getWordCount() - firstWordInfo.getWordCount());
        return wordInfoList;
    }
}





