package tokenizer;

public class DigitToken extends Token {
    private int value;
    @Override
    public boolean isSuitable(String text) {
        boolean result;
        if (text.length() > 0) {
            result = true;
        }
        else {
            result = false;     //для пустой строки возвращаем false
        }
        for (int i = 0; i < text.length(); i++) {
            if ( ! Character.isDigit(text.charAt(i)) ) {
                result = false;
            }
        }
        return result;
    }

    public DigitToken() {
    }

    public DigitToken(int begin, int end, String text, int value) {
        super(begin, end, text);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DigitToken digitToken = (DigitToken) o;

        return (begin == digitToken.begin &&
                end == digitToken.end &&
                text.equals(digitToken.text) &&
                value == digitToken.value);
    }

    @Override
    public int hashCode() {
        return value;
    }
}
