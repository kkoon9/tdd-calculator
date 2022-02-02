package study;

import java.util.stream.Stream;

public class StringTdd {
    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';
    private static final String COMMA = ",";

    int[] split(String input) {
        input = cleansingBrackets(input);

        String[] inputSplitComma = input.split(COMMA);
        int[] result =
                Stream.of(inputSplitComma)
                        .mapToInt(Integer::parseInt)
                        .toArray();
        return result;
    }

    char charAt(String input, int index) throws StringIndexOutOfBoundsException {
        if(input.length() <= index) {
            throw new StringIndexOutOfBoundsException(
                    String.format("index [%d]는 벗어난 인덱스입니다.", index)
            );
        }
        return input.charAt(index);
    }

    private String cleansingBrackets(String input) {
        char firstCharacterOfInput = input.charAt(0);
        char lastCharacterOfInput = input.charAt(input.length() - 1);

        if (firstCharacterOfInput != LEFT_BRACKET || lastCharacterOfInput != RIGHT_BRACKET) {
            return input;
        }

        return input.substring(1, input.length() - 1);
    }
}
